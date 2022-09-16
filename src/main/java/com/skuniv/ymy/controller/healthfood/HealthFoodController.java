package com.skuniv.ymy.controller.healthfood;

import com.skuniv.ymy.dtos.healthfood.HealthFoodInfoListResponseDto;
import com.skuniv.ymy.dtos.healthfood.HealthFoodInfoResponseDto;
import com.skuniv.ymy.dtos.medication.MedicationInfoListResponseDto;
import com.skuniv.ymy.dtos.medication.MedicationInfoResponseDto;
import com.skuniv.ymy.service.HealthFoodInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class HealthFoodController {
    private final HealthFoodInfoService healthFoodInfoService;

    /* 건강기능식품 목록 보기 */
    @GetMapping("info/healthFood")
    public String healthFoodInfoAll(Model model,
                                    @PageableDefault(sort = "id", size = 20, direction = Sort.Direction.ASC)Pageable pageable,
                                    @RequestParam(name = "searchFilter", defaultValue = "") String searchFilter,
                                    @RequestParam(name = "searchValue", defaultValue = "") String searchValue) {

        Page<HealthFoodInfoListResponseDto> responseDtoList;
        if (searchValue != null) {
            switch (searchFilter) {
                case "itemName":
                    responseDtoList = this.healthFoodInfoService.findAllByItemNameContains(searchValue, pageable);
                    break;
                case "enterpriseName":
                    responseDtoList = this.healthFoodInfoService.findAllByEnterPriseNameContains(searchValue, pageable);
                    break;
                default:
                    responseDtoList = this.healthFoodInfoService.findAll(pageable);
            }
        }
        else responseDtoList = this.healthFoodInfoService.findAll(pageable);

        /* 의약품 목록 추가 */
        model.addAttribute("healthFoodInfo", responseDtoList);
        /* 검색 속성 추가 */
        model.addAttribute("searchValue", searchValue);
        model.addAttribute("searchFilter", searchFilter);
        /* 페이지네이션 속성 추가 */
        model.addAttribute("totalPages", responseDtoList.getTotalPages());           // 전체 페이지
        model.addAttribute("pageNumber", responseDtoList.getNumber());               // 현재 페이지 번호
        model.addAttribute("maxPage", 5);                               // 최대 페이지 개수

        return "health_food_info_all";
    }

    /* 건강기능식품 상세 보기 */
    @GetMapping("info/healthFood/{id}")
    public String medicationInfoDetail(@PathVariable Long id, Model model) {
        HealthFoodInfoResponseDto responseDto = this.healthFoodInfoService.findById(id);
        /* 의약품 상세 정보 추가 */
        model.addAttribute("healthFoodInfo", responseDto);
        return "health_food_info_detail";
    }
}
