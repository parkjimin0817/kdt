package com.kh.login.service;

import com.kh.login.domain.ChatMessage;
import com.kh.login.domain.ChatParticipant;
import com.kh.login.domain.ChatRoom;
import com.kh.login.domain.Member;
import com.kh.login.domain.ReadStatus;
import com.kh.login.dto.chat.ChatMessageDto;
import com.kh.login.repository.ChatMessageRepository;
import com.kh.login.repository.ChatParticipantRepository;
import com.kh.login.repository.ChatRoomRepository;
import com.kh.login.repository.MemberRepository;
import com.kh.login.repository.ReadStatusRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Transactional
@Service
public class ChatService {

    private final MemberRepository memberRepository;
    private final ChatParticipantRepository chatParticipantRepository;
    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;
    private final ReadStatusRepository readStatusRepository;

    //1:1채팅방 생성 또는 조회
    public Long getOrCreatePrivateRoom(@RequestParam("other_member_id") Long otherMemberId) {
        //현재 로그인한 사용자와 상대방 사용자 조회
        Member member = memberRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(() -> new EntityNotFoundException("Member not found"));

        Member otherMember = memberRepository.findById(otherMemberId)
                .orElseThrow(() -> new EntityNotFoundException("Member not found"));

        Optional<ChatRoom> chatRoom = chatParticipantRepository.findExistingPrivateRoom(member.getId(), otherMember.getId());
        if(chatRoom.isPresent()) {
            return chatRoom.get().getId();
        }

        ChatRoom newRoom = ChatRoom.builder()
                .isGroupChat("N")
                .name(member.getName() + "_" + otherMember.getName()) //채팅방 이름
                .build();

        chatRoomRepository.save(newRoom);

        addParticipantToRoom(newRoom, member);
        addParticipantToRoom(newRoom, otherMember);

        return newRoom.getId();
    }

    //채팅방 참여자 추가
    //해당 사용자가 이미 참여중인지 확인 후 참여하지 않은 경우에만 새로운 참여자 추가
    public void addParticipantToRoom(ChatRoom chatRoom, Member member) {
        if(chatParticipantRepository.findByChatRoomAndMember(chatRoom, member).isPresent()){
            return;
        }

        //새로운 참가자 생성
        ChatParticipant chatParticipant = ChatParticipant.builder()
                .chatRoom(chatRoom)
                .member(member)
                .build();

        chatParticipantRepository.save(chatParticipant);
    }

    /*
    * 채팅내역조회
    * 1. 채팅방 존재여부 체크
    * 2. 현재 사용자가 해당 채팅방의 참여자인지
    * 3. 채팅방의 모든 메세지를 시간순으로 조회
    * 4. 메세지정보를 DTO로 변환해서 반환
    *
    * @param roomId 조회할 채팅방 ID
    * @return 채팅 메세지 목록 (발신자 이메일, 메세지 내용)
    * */
    public List<ChatMessageDto> getChatHistory(Long roomId) {
        ChatRoom chatRoom = chatRoomRepository.findById(roomId)
                .orElseThrow(() -> new EntityNotFoundException("Room not found"));

        Member member = memberRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(() -> new EntityNotFoundException("Member not found"));

        boolean isParticipant = chatParticipantRepository.findByChatRoom(chatRoom)
                .stream().anyMatch(cp -> cp.getMember().getId() == member.getId());

        if(!isParticipant){
            throw new IllegalArgumentException("본인이 속한 채팅방이 아닙니다.");
        }

        // 메세지 조회 (시간순 정렬)
        List<ChatMessage> chatMessageList = chatMessageRepository.findByChatRoomOrderByCreatedTimeAsc(chatRoom);

        List<ChatMessageDto> chatMessageDtos = chatMessageList.stream().map(c -> ChatMessageDto.builder()
                .message(c.getContent())
                .senderEmail(c.getMember().getEmail())
                .build())
                .collect(Collectors.toList());

        return chatMessageDtos;
    }

        /*
        채팅 메세지 저장
        1. 채팅방존재여부와 발신자정보 검증
        2. 메세지를 데이터베이스 저장
        3. 해당 채팅방의 모든 참여자에 대해 읽음 상태를 생성
        - 발신자는 자동으로 읽음 처리
        - 다른참여자들은 모두 읽음x

     */

    public void saveMessage(ChatMessageDto chatMessageDto) {
        ChatRoom chatRoom = chatRoomRepository.findById(chatMessageDto.getRoomId())
                .orElseThrow(() -> new EntityNotFoundException("Room not found"));

        Member sender = memberRepository.findByEmail(chatMessageDto.getSenderEmail())
                .orElseThrow(() -> new EntityNotFoundException("Member not found"));

        //메세지 생성
        ChatMessage chatMessage = ChatMessage.builder()
                .chatRoom(chatRoom)
                .member(sender)
                .content(chatMessageDto.getMessage())
                .build();

        chatMessageRepository.save(chatMessage);

        List<ChatParticipant> participants = chatParticipantRepository.findByChatRoom(chatRoom);
        List<ReadStatus> readStatuses = participants.stream()
                .map(c -> ReadStatus.builder()
                        .chatRoom(chatRoom)
                        .member(c.getMember())
                        .chatMessage(chatMessage)
                        .isRead(c.getMember().equals(sender))
                        .build())
                .toList();

        readStatusRepository.saveAll(readStatuses);
    }
}
