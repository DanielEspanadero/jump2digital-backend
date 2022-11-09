package com.nuwe.hackathonjump2digital.dto;

import java.util.HashMap;

public class GeneralCompanyInformationDTO {

        private HashMap<String, Integer> industryTypes = new HashMap<>();

        private HashMap<String, Integer> sizeRanges = new HashMap<>();

        private HashMap<Integer, Integer> yearFoundeds  = new HashMap<>();

    public HashMap<String, Integer> getIndustryTypes() {
        return industryTypes;
    }

    public void setIndustryTypes(HashMap<String, Integer> industryTypes) {
        this.industryTypes = industryTypes;
    }

    public HashMap<String, Integer> getSizeRanges() {
        return sizeRanges;
    }

    public void setSizeRanges(HashMap<String, Integer> sizeRanges) {
        this.sizeRanges = sizeRanges;
    }

    public HashMap<Integer, Integer> getYearFoundeds() {
        return yearFoundeds;
    }

    public void setYearFoundeds(HashMap<Integer, Integer> yearFoundeds) {
        this.yearFoundeds = yearFoundeds;
    }
}
