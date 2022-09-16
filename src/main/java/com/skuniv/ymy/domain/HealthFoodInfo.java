package com.skuniv.ymy.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class HealthFoodInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String enterpriseName;  // 업체명
    private String itemName;        // 제품명
    private String itemSeq;         // 품목제조관리번호
    private String registeredDate;  // 등록일
    private String validDate;       // 보존 및 유통기한
    @Column(columnDefinition = "TEXT")
    private String chart;           // 성상

    @Column(columnDefinition = "TEXT")
    private String useMethod;      // 용도용법, 섭취량, 섭취방법
    @Column(columnDefinition = "TEXT")
    private String precaution;      // 섭취시 주의사항
    @Column(columnDefinition = "TEXT")
    private String mainFunction;    // 주된기능성
    @Column(columnDefinition = "TEXT")
    private String baseStandard;    // 기준규격

    @Builder
    public HealthFoodInfo(String enterpriseName, String itemName, String itemSeq, String registeredDate,
                          String validDate, String chart, String useMethod, String precaution,
                          String mainFunction, String baseStandard) {
        this.enterpriseName = enterpriseName;
        this.itemName = itemName;
        this.itemSeq = itemSeq;
        this.registeredDate = registeredDate;
        this.validDate = validDate;
        this.chart = chart;
        this.useMethod = useMethod;
        this.precaution = precaution;
        this.mainFunction = mainFunction;
        this.baseStandard = baseStandard;
    }
}
