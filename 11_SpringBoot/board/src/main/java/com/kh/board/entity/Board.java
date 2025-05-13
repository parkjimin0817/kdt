package com.kh.board.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity //이 클래스가 JPA 엔티티다 (DB 테이블이랑 맵핑됨)
public class Board {

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK값 자동생성(AUTO_INCREMENT 방식)
    @Column(name = "board_id") //DB 컬럼명 지정
    private Long boardId;

    @Column(nullable = false) //NOT NULL 제약조건
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT") //데이터 타입을 TEXT로 저장
    private String contents;

    @Column(name = "file_name")
    private String fileName;

//  private String memberEmail;
    @ManyToOne(fetch = FetchType.LAZY)
    //Board : Member = N : 1 관계 (다수의 게시글은 하나의 회원에 속함)
    //LAZY : 실제 member 정보가 필요할 때까지 조회를 지연 (지연로딩)
    @JoinColumn(name = "member_email", nullable = false)
    //Board 테이블에 member_email 이라는 컬럼을 만들어서 Member 테이블의 PK 컬럼을 참조하겠다.
    private Member member;

    @CreationTimestamp //엔티티가 처음 저장될 때 자동으로 현재 시간 저장
    @Column(name = "created_at", updatable = false) //최초 생성 시간은 변경이 불가하도록
    private LocalDateTime createdAt;

    @UpdateTimestamp //엔티티가 수정될 때 마다 자동으로 업데이트 시간을 넣어줌
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
