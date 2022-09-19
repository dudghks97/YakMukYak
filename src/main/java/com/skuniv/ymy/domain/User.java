package com.skuniv.ymy.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<DoseNotifications> doseNotificationsList;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<DoseDetails> doseDetailsList;

    @Builder
    public User(String name, String email,
                List<DoseNotifications> doseNotificationsList,
                List<DoseDetails> doseDetailsList) {
        this.name = name;
        this.email = email;
        this.doseNotificationsList = doseNotificationsList;
        this.doseDetailsList = doseDetailsList;
    }
}
