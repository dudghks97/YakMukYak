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

    @Builder
    public MedicationInfoSaveRequestDto(String itemSeq, String itemName, String enterpriseName, String permitDate,
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

    public MedicationInfo toEntity() {
        return MedicationInfo.builder()
                .itemSeq(itemSeq)
                .itemName(itemName)
                .enterpriseName(enterpriseName)
                .permitDate(permitDate)
                .materialName(materialName)
                .efficacy(efficacy)
                .useMethod(useMethod)
                .precaution(precaution)
                .storageMethod(storageMethod)
                .validTerm(validTerm)
                .permitKindName(permitKindName)
                .cancelName(cancelName)
                .cancelDate(cancelDate)
                .changeDate(changeDate)
                .totalContent(totalContent)
                .mainIngredient(mainIngredient)
                .ingredientName(ingredientName)
                .build();
    }
}
