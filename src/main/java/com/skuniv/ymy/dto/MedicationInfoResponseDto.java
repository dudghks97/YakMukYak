package com.skuniv.ymy.dto;

import com.skuniv.ymy.domain.MedicationInfo;
import lombok.Getter;

@Getter
public class MedicationInfoResponseDto {
    private Long id;
    private String itemSeq;
    private String itemName;
    private String enterpriseName;
    private String permitDate;
    private String materialName;
    private String efficacy;
    private String useMethod;
    private String precaution;
    private String storageMethod;
    private String validTerm;
    private String permitKindName;
    private String cancelName;
    private String cancelDate;
    private String changeDate;
    private String totalContent;
    private String mainIngredient;
    private String ingredientName;

    public MedicationInfoResponseDto(MedicationInfo entity) {
        this.id = entity.getId();
        this.itemSeq = entity.getItemSeq();
        this.itemName = entity.getItemName();
        this.enterpriseName = entity.getEnterpriseName();
        this.permitDate = entity.getPermitDate();
        this.materialName = entity.getMaterialName();
        this.efficacy = entity.getEfficacy();
        this.useMethod = entity.getUseMethod();
        this.precaution = entity.getPrecaution();
        this.storageMethod = entity.getStorageMethod();
        this.validTerm = entity.getValidTerm();
        this.permitKindName = entity.getPermitKindName();
        this.cancelName = entity.getCancelName();
        this.cancelDate = entity.getCancelDate();
        this.changeDate = entity.getChangeDate();
        this.totalContent = entity.getTotalContent();
        this.mainIngredient = entity.getMainIngredient();
        this.ingredientName = entity.getIngredientName();
    }
}
