package com.skuniv.ymy.service;

import com.skuniv.ymy.domain.MedicationInfo;
import com.skuniv.ymy.dtos.medication.MedicationInfoListResponseDto;
import com.skuniv.ymy.dtos.medication.MedicationInfoSaveRequestDto;
import com.skuniv.ymy.dtos.medication.MedicationInfoResponseDto;
import com.skuniv.ymy.repository.MedicationInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MedicationInfoService {
    private final MedicationInfoRepository medicationInfoRepository;

    /* 전체 목록 보기 */
    public Page<MedicationInfoListResponseDto> findAll(Pageable pageable) {
        Page<MedicationInfo> medicationInfoList = this.medicationInfoRepository.findAll(pageable);
        return medicationInfoList.map(MedicationInfoListResponseDto::new);
    }

    /* 제품명별 검색 목록 보기 */
    @Transactional
    public Page<MedicationInfoListResponseDto> findAllByItemNameContains(String itemName, Pageable pageable) {
        Page<MedicationInfo> medicationInfoList = this.medicationInfoRepository.findAllByItemNameContains(itemName, pageable);
        return medicationInfoList.map(MedicationInfoListResponseDto::new);
    }

    /* 업체명별 검색 목록 보기 */
    @Transactional
    public Page<MedicationInfoListResponseDto> findAllByEnterPriseNameContains(String enterpriseName, Pageable pageable) {
        Page<MedicationInfo> medicationInfoList = this.medicationInfoRepository.findAllByEnterpriseNameContains(enterpriseName, pageable);
        return medicationInfoList.map(MedicationInfoListResponseDto::new);
    }

    /* 의약품 정보 상세 조회 */
    @Transactional
    public MedicationInfoResponseDto findById(final Long id) {
        MedicationInfo entity = this.medicationInfoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 의약품이 존재하지 않습니다. id=" + id)
        );
        return new MedicationInfoResponseDto(entity);
    }

    /* 의약품 정보 저장 */
    @Transactional
    public Long save(final MedicationInfoSaveRequestDto requestDto) {
        return this.medicationInfoRepository.save(requestDto.toEntity()).getId();
    }
}
