package com.skuniv.ymy.dtos.medication;

import com.skuniv.ymy.domain.MedicationInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MedicationInfoSaveRequestDto {
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

    @Builder
    public MedicationInfoSaveRequestDto(String itemSeq, String itemName, String enterpriseName, String permitDate, String classCode,
                                        String chart, String materialName, String efficacy, String useMethod, String professionalPrecaution,
                                        String generalPrecaution, String  storageMethod, String validTerm, String permitKindName, String categoryType,
                                        String cancelName, String cancelDate, String changeDate, String totalContent, String mainIngredient, String ingredientName) {
        this.itemSeq = itemSeq;
        this.itemName = itemName;
        this.enterpriseName = enterpriseName;
        this.permitDate = permitDate;
        this.classCode = classCode;
        this.chart = chart;
        this.materialName = materialName;
        this.efficacy = efficacy;
        this.useMethod = useMethod;
        this.professionalPrecaution = professionalPrecaution;
        this.generalPrecaution = generalPrecaution;
        this.storageMethod = storageMethod;
        this.validTerm = validTerm;
        this.permitKindName = permitKindName;
        this.categoryType = categoryType;
        this.cancelName = cancelName;
        this.cancelDate = cancelDate;
        this.changeDate = changeDate;
        this.totalContent = totalContent;
        this.mainIngredient = mainIngredient;
        this.ingredientName = ingredientName;
    }

    public MedicationInfo toEntity() {
        return MedicationInfo.builder()
                .itemSeq(itemSeq)
                .itemName(itemName)
                .enterpriseName(enterpriseName)
                .permitDate(permitDate)
                .classCode(classCode)
                .chart(chart)
                .materialName(materialName)
                .efficacy(efficacy)
                .useMethod(useMethod)
                .professionalPrecaution(professionalPrecaution)
                .generalPrecaution(generalPrecaution)
                .storageMethod(storageMethod)
                .validTerm(validTerm)
                .permitKindName(permitKindName)
                .categoryType(categoryType)
                .cancelName(cancelName)
                .cancelDate(cancelDate)
                .changeDate(changeDate)
                .totalContent(totalContent)
                .mainIngredient(mainIngredient)
                .ingredientName(ingredientName)
                .build();
    }
}
