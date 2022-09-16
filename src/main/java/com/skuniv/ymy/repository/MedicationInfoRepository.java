package com.skuniv.ymy.repository;

import com.skuniv.ymy.domain.MedicationInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationInfoRepository extends JpaRepository<MedicationInfo, Long> {

    /* 전체 검색 */
    Page<MedicationInfo> findAll(Pageable pageable);

    /* 업체명으로 검색 */
    Page<MedicationInfo> findAllByEnterpriseNameContains(String enterpriseName, Pageable pageable);

    /* 제품명으로 검색 */
    Page<MedicationInfo> findAllByItemNameContains(String itemName, Pageable pageable);
}
