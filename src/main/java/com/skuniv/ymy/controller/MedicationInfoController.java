package com.skuniv.ymy.controller;

import com.skuniv.ymy.dto.MedicationInfoListResponseDto;
import com.skuniv.ymy.dto.MedicationInfoResponseDto;
import com.skuniv.ymy.service.MedicationInfoService;
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
public class MedicationInfoController {
    private final MedicationInfoService medicationInfoService;

    /* 의약품 목록보기 */
    @GetMapping("info/medication")
    public String medicationInfoAll(Model model,
                                   @PageableDefault(sort = "id", size = 20, direction = Sort.Direction.ASC) Pageable pageable,
                                   @RequestParam(name="searchFilter", defaultValue = "") String searchFilter,
                                   @RequestParam(name="searchValue", defaultValue = "") String searchValue) {
        Page<MedicationInfoListResponseDto> responseDtoList;
        if (searchValue != null) {
            switch (searchFilter) {
                case "itemName":
                    responseDtoList = this.medicationInfoService.findAllByItemName(searchValue, pageable);
                    break;
                case "enterpriseName":
                    responseDtoList = this.medicationInfoService.findAllByEnterPriseName(searchValue, pageable);
                    break;
                default:
                    responseDtoList = this.medicationInfoService.findAll(pageable);
            }
        }
        else responseDtoList = this.medicationInfoService.findAll(pageable);

        /* 의약품 목록 추가 */
        model.addAttribute("medicationInfo", responseDtoList);
        /* 검색 속성 추가 */
        model.addAttribute("searchValue", searchValue);
        model.addAttribute("searchFilter", searchFilter);
        /* 페이지네이션 속성 추가 */
        model.addAttribute("totalPages", responseDtoList.getTotalPages());           // 전체 페이지
        model.addAttribute("pageNumber", responseDtoList.getNumber());               // 현재 페이지 번호
        model.addAttribute("maxPage", 10);                               // 최대 페이지 개수

        return "medication_info_all";
    }

    /* 의약품 상세 보기 */
    @GetMapping("info/medication/{id}")
    public String medicationInfoDetail(@PathVariable Long id, Model model) {
        MedicationInfoResponseDto responseDto = this.medicationInfoService.findById(id);
        /* 의약품 상세 정보 추가 */
        model.addAttribute("medicationInfo", responseDto);
        return "medication_info_detail";
    }
}
