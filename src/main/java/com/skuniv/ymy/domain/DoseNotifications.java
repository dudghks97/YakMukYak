package com.skuniv.ymy.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class DoseNotifications extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String itemName;
    private String nickName;
    // private LocalDateTime alertPeriod;   // 알람 주기로 사용될 컬럼. enum 클래스를 만들어서 따로 사용하는 것이 적절해보임
    private Boolean alertOk;

    @ManyToOne
    private User user;
    
    @Builder
    public DoseNotifications(String itemName, String nickName,
                             Boolean alertOk, User user) {
        this.itemName = itemName;
        this.nickName = nickName;
        this.alertOk = alertOk;
        this.user = user;
    }
    
    public void update(String itemName, String nickName, Boolean alertOk) {
        this.itemName = itemName;
        this.nickName = nickName;
        this.alertOk = alertOk;
    }
}
