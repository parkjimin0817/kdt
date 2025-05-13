package com.kh.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MEMBER")
@Getter
public class Member {

    @Id //PK
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 100) //최대길이 100자
    private String nickname;

    @CreationTimestamp //엔티티가 처음 저장될 때 자동으로 현재 시간 저장
    @Column(name = "created_at", updatable = false) //최초 생성 시간은 변경이 불가하도록
    private LocalDateTime createdAt;

    @UpdateTimestamp //엔티티가 수정될 때 마다 자동으로 업데이트 시간을 넣어줌
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    //Member : Board = 1 : N 관계 (한 명의 회원은 여러 게시글을 작성할 수 있음)
    //mappedBy = "member" ->Board 엔티티의 'member' 필드가 외래키 주인임을 의미
    //cascade = CascadeType.ALL -> 회원 삭제 시 관련 게시글 모두 삭제
    private List<Board> boards = new ArrayList<>();
}
