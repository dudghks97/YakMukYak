package com.skuniv.ymy.dtos.medication;

import com.skuniv.ymy.domain.MedicationInfo;
import lombok.Getter;

@Getter
public class MedicationInfoResponseDto {
    private Long id;
    private String itemSeq;
    private String itemName;
    private String enterpriseName;
    private String permitDate;
    private String classCode;
    private String chart;
    private String materialName;
    private String efficacy;
    private String useMethod;
    private String professionalPrecaution;
    private String generalPrecaution;
    private String storageMethod;
    private String validTerm;
    private String permitKindName;
    private String categoryType;
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
        this.classCode = entity.getClassCode();
        this.chart = entity.getChart();
        this.materialName = entity.getMaterialName();
        this.efficacy = entity.getEfficacy();
        this.useMethod = entity.getUseMethod();
        this.professionalPrecaution = entity.getProfessionalPrecaution();
        this.generalPrecaution = entity.getGeneralPrecaution();
        this.storageMethod = entity.getStorageMethod();
        this.validTerm = entity.getValidTerm();
        this.permitKindName = entity.getPermitKindName();
        this.categoryType = entity.getCategoryType();
        this.cancelName = entity.getCancelName();
        this.cancelDate = entity.getCancelDate();
        this.changeDate = entity.getChangeDate();
        this.totalContent = entity.getTotalContent();
        this.mainIngredient = entity.getMainIngredient();
        this.ingredientName = entity.getIngredientName();
    }
}
