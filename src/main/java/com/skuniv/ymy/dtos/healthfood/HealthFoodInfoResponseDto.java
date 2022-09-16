package com.skuniv.ymy.dtos.healthfood;

import com.skuniv.ymy.domain.HealthFoodInfo;
import lombok.Getter;

@Getter
public class HealthFoodInfoResponseDto {
    private Long id;
    private String enterpriseName;  // 업체명
    private String itemName;        // 제품명
    private String itemSeq;         // 품목제조관리번호
    private String registeredDate;  // 등록일
    private String validDate;       // 보존 및 유통기한
    private String chart;           // 성상
    private String useMethod;      // 용도용법, 섭취량, 섭취방법
    private String precaution;      // 섭취시 주의사항
    private String mainFunction;    // 주된기능성
    private String baseStandard;    // 기준규격

    public HealthFoodInfoResponseDto(HealthFoodInfo entity) {
        this.id = entity.getId();
        this.enterpriseName = entity.getEnterpriseName();
        this.itemName = entity.getItemName();
        this.itemSeq = entity.getItemSeq();
        this.registeredDate = entity.getRegisteredDate();
        this.validDate = entity.getValidDate();
        this.chart = entity.getChart();
        this.useMethod = entity.getUseMethod();
        this.precaution = entity.getPrecaution();
        this.mainFunction = entity.getMainFunction();
        this.baseStandard = entity.getBaseStandard();
    }
}
