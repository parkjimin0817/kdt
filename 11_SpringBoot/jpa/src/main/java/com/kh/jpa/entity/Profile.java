package com.kh.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA 스펙 상 필수 + 외부 생성 방지
@AllArgsConstructor
@Builder
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROFILE_ID")
    private Long profileId;

    @Column(name = "PROFILE_IMAGE", length = 100)
    private String profileImage;

    @Column(length = 300)
    private String intro;

    @OneToOne(mappedBy = "profile", cascade = CascadeType.ALL)
    private Member member;

}
