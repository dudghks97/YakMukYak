package com.skuniv.ymy.domain;

import com.mysql.cj.protocol.ColumnDefinition;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class MedicationInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String itemSeq;
    @Column(columnDefinition = "TEXT")
    private String itemName;
    @Column
    private String enterpriseName;
    @Column
    private String permitDate;
    @Column(columnDefinition = "TEXT")
    private String materialName;
    @Column(columnDefinition = "TEXT")
    private String efficacy;
    @Column(columnDefinition = "TEXT")
    private String useMethod;
    @Column(columnDefinition = "TEXT")
    private String precaution;
    @Column(columnDefinition = "TEXT")
    private String storageMethod;
    @Column(columnDefinition = "TEXT")
    private String validTerm;
    @Column(columnDefinition = "TEXT")
    private String permitKindName;
    @Column
    private String cancelName;
    @Column
    private String cancelDate;
    @Column
    private String changeDate;
    @Column(columnDefinition = "TEXT")
    private String totalContent;
    @Column(columnDefinition = "TEXt")
    private String mainIngredient;
    @Column(columnDefinition = "TEXT")
    private String ingredientName;

    @Builder
    public MedicationInfo(String itemSeq, String itemName, String enterpriseName, String permitDate,
                          String materialName, String efficacy, String useMethod, String precaution,
                          String storageMethod, String validTerm, String permitKindName, String cancelName,
                          String cancelDate, String changeDate, String totalContent, String mainIngredient,
                          String ingredientName) {
        this.itemSeq = itemSeq;
        this.itemName = itemName;
        this.enterpriseName = enterpriseName;
        this.permitDate = permitDate;
        this.materialName = materialName;
        this.efficacy = efficacy;
        this.useMethod = useMethod;
        this.precaution = precaution;
        this.storageMethod = storageMethod;
        this.validTerm = validTerm;
        this.permitKindName = permitKindName;
        this.cancelName = cancelName;
        this.cancelDate = cancelDate;
        this.changeDate = changeDate;
        this.totalContent = totalContent;
        this.mainIngredient = mainIngredient;
        this.ingredientName = ingredientName;
    }
}
