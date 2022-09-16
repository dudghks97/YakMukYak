package com.skuniv.ymy.service;

import com.skuniv.ymy.domain.HealthFoodInfo;
import com.skuniv.ymy.dtos.healthfood.HealthFoodInfoListResponseDto;
import com.skuniv.ymy.dtos.healthfood.HealthFoodInfoResponseDto;
import com.skuniv.ymy.dtos.healthfood.HealthFoodInfoSaveRequestDto;
import com.skuniv.ymy.repository.HealthFoodInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class HealthFoodInfoService {
    private final HealthFoodInfoRepository healthFoodInfoRepository;

    /* 전체 목록 보기 */
    public Page<HealthFoodInfoListResponseDto> findAll(Pageable pageable) {
        Page<HealthFoodInfo> HealthFoodInfoList = this.healthFoodInfoRepository.findAll(pageable);
        return HealthFoodInfoList.map(HealthFoodInfoListResponseDto::new);
    }

    /* 제품명별 검색 목록 보기 */
    @Transactional
    public Page<HealthFoodInfoListResponseDto> findAllByItemNameContains(String itemName, Pageable pageable) {
        Page<HealthFoodInfo> HealthFoodInfoList = this.healthFoodInfoRepository.findAllByItemNameContains(itemName, pageable);
        return HealthFoodInfoList.map(HealthFoodInfoListResponseDto::new);
    }

    /* 업체명별 검색 목록 보기 */
    @Transactional
    public Page<HealthFoodInfoListResponseDto> findAllByEnterPriseNameContains(String enterpriseName, Pageable pageable) {
        Page<HealthFoodInfo> HealthFoodInfoList = this.healthFoodInfoRepository.findAllByEnterpriseNameContains(enterpriseName, pageable);
        return HealthFoodInfoList.map(HealthFoodInfoListResponseDto::new);
    }

    /* 의약품 정보 상세 조회 */
    @Transactional
    public HealthFoodInfoResponseDto findById(final Long id) {
        HealthFoodInfo entity = this.healthFoodInfoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 의약품이 존재하지 않습니다. id=" + id)
        );
        return new HealthFoodInfoResponseDto(entity);
    }

    /* 건강기능식품 정보 저장 */
    @Transactional
    public Long save(final HealthFoodInfoSaveRequestDto requestDto) {
        return this.healthFoodInfoRepository.save(requestDto.toEntity()).getId();
    }
}
