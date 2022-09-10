package com.skuniv.ymy.dto;

import com.skuniv.ymy.domain.MedicationInfo;
import lombok.Getter;

@Getter
public class MedicationInfoListResponseDto {
    private Long id;
    private String itemSeq;
    private String itemName;
    private String enterpriseName;
    private String permitDate;
    private String materialName;
    private String efficacy;
    private String permitKindName;
    private String cancelName;
    private String cancelDate;
    private String changeDate;

    public MedicationInfoListResponseDto(MedicationInfo entity) {
        this.id = entity.getId();
        this.itemSeq = entity.getItemSeq();
        this.itemName = entity.getItemName();
        this.enterpriseName = entity.getEnterpriseName();
        this.permitDate = entity.getPermitDate();
        this.materialName = entity.getMaterialName();
        this.efficacy = entity.getEfficacy();
        this.permitKindName = entity.getPermitKindName();
        this.cancelName = entity.getCancelName();
        this.cancelDate = entity.getCancelDate();
        this.changeDate = entity.getChangeDate();
    }
}
