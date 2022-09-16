package com.skuniv.ymy.repository;

import com.skuniv.ymy.domain.HealthFoodInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthFoodInfoRepository extends JpaRepository<HealthFoodInfo, Long> {

    /* 전체 검색 */
    Page<HealthFoodInfo> findAll(Pageable pageable);

    /* 업체명으로 검색 */
    Page<HealthFoodInfo> findAllByEnterpriseNameContains(String enterpriseName, Pageable pageable);

    /* 제품명으로 검색 */
    Page<HealthFoodInfo> findAllByItemNameContains(String itemName, Pageable pageable);
}
