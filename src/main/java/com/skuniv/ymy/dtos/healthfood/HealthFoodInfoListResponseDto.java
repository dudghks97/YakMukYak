package com.skuniv.ymy.dtos.healthfood;

import com.skuniv.ymy.domain.HealthFoodInfo;
import lombok.Getter;

@Getter
public class HealthFoodInfoListResponseDto {
    private Long id;
    private String enterpriseName;  // 업체명
    private String itemName;        // 제품명
    private String itemSeq;         // 품목제조관리번호
    private String registeredDate;  // 등록일

    public HealthFoodInfoListResponseDto(HealthFoodInfo entity) {
        this.id = entity.getId();
        this.enterpriseName = entity.getEnterpriseName();
        this.itemName = entity.getItemName();
        this.itemSeq = entity.getItemSeq();
        this.registeredDate = entity.getRegisteredDate();
    }
}
