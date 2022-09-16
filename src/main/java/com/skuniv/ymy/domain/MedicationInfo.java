package com.skuniv.ymy.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class MedicationInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String itemSeq;             // 품목기준코드
    @Column(columnDefinition = "TEXT")
    private String itemName;            // 제품명

    @Column
    private String enterpriseName;      // 업체명
    private String permitDate;          // 허가일
    @Column(columnDefinition = "TEXT")
    private String chart;               // 성상
    private String materialName;        // 원료성분
    private String efficacy;            // 효능효과
    private String useMethod;           // 용법용량
    private String precaution;          // 주의사항
    private String storageMethod;       // 저장방법
    private String validTerm;           // 유효기간
    private String permitKindName;      // 허가/신고구분

    @Column
    private String cancelName;          // 상태
    private String cancelDate;          // 취소일자
    private String changeDate;          // 변경일자

    @Column(columnDefinition = "TEXT")
    private String totalContent;        // 총량
    @Column(columnDefinition = "TEXT")
    private String mainIngredient;      // 유효성분
    @Column(columnDefinition = "TEXT")
    private String ingredientName;      // 첨가제

    @Builder
    public MedicationInfo(String itemSeq, String itemName, String enterpriseName, String permitDate,
                          String chart, String materialName, String efficacy, String useMethod, String precaution,
                          String storageMethod, String validTerm, String permitKindName, String cancelName,
                          String cancelDate, String changeDate, String totalContent, String mainIngredient, String ingredientName) {
        this.itemSeq = itemSeq;
        this.itemName = itemName;
        this.enterpriseName = enterpriseName;
        this.permitDate = permitDate;
        this.chart = chart;
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
