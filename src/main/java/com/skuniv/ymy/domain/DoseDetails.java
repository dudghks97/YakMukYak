package com.skuniv.ymy.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class DoseDetails extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String itemName;
    private String nickName;

    @ManyToOne
    private User user;

    @Builder
    public DoseDetails(String itemName, String nickName, User user) {
        this.itemName = itemName;
        this.nickName = nickName;
        this.user = user;
    }
}
