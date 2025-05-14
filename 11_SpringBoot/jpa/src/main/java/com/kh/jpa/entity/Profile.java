package com.kh.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Profile {

    @Id
    @Column(name = "user_id")
    private String userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private Member member;

    @Column(length = 100)
    private String profileImage;

    @Column(length = 300)
    private String intro;

}
