package com.skuniv.ymy.dtos.healthfood;

import com.skuniv.ymy.domain.HealthFoodInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HealthFoodInfoSaveRequestDto {
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

    @Builder
    public HealthFoodInfoSaveRequestDto(String enterpriseName, String itemName, String itemSeq, String registeredDate,
                                        String validDate, String chart, String userMethod, String precaution,
                                        String mainFunction, String baseStandard) {
        this.enterpriseName = enterpriseName;
        this.itemName = itemName;
        this.itemSeq = itemSeq;
        this.registeredDate = registeredDate;
        this.validDate = validDate;
        this.chart = chart;
        this.useMethod = userMethod;
        this.precaution = precaution;
        this.mainFunction = mainFunction;
        this.baseStandard = baseStandard;
    }

    public HealthFoodInfo toEntity() {
        return HealthFoodInfo.builder()
                .enterpriseName(enterpriseName)
                .itemName(itemName)
                .itemSeq(itemSeq)
                .registeredDate(registeredDate)
                .validDate(validDate)
                .chart(chart)
                .useMethod(useMethod)
                .precaution(precaution)
                .mainFunction(mainFunction)
                .baseStandard(baseStandard)
                .build();
    }
}
