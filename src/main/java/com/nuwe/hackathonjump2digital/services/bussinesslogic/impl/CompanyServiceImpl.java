package com.nuwe.hackathonjump2digital.services.bussinesslogic.impl;

import com.nuwe.hackathonjump2digital.dto.GeneralCompanyInformationDTO;
import com.nuwe.hackathonjump2digital.models.CompanyModel;
import com.nuwe.hackathonjump2digital.repositories.ICompanyRepository;
import com.nuwe.hackathonjump2digital.services.bussinesslogic.interfaces.ICompany;
import com.nuwe.hackathonjump2digital.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements ICompany {

    @Autowired
    ICompanyRepository companyRepository;


    @Override
    public void saveCompany(CompanyModel company){
        companyRepository.save(company);
    }

    @Override
    public void saveAllCompanies(ArrayList<CompanyModel> company){
        List<CompanyModel> add = new ArrayList<>();
        add.addAll(company);
        companyRepository.saveAll(add);
    }

    @Override
    public ArrayList<CompanyModel> getAllCompanies(){
        return(ArrayList<CompanyModel>) companyRepository.findAll();
    }

    @Override
    public ArrayList<CompanyModel> sortBySize(){
        ArrayList<CompanyModel> companies = (ArrayList<CompanyModel>) companyRepository.findAll();

        return ascendingCompaniesBySize(companies);
    }

    @Override
    public ArrayList<CompanyModel> sortByFounded(){
        ArrayList<CompanyModel> companies = (ArrayList<CompanyModel>) companyRepository.findAll();
        return descendingCompaniesByFounded(companies);
    }

    @Override
    public GeneralCompanyInformationDTO generalCompanyInformation(){
        ArrayList<CompanyModel> companies = (ArrayList<CompanyModel>) companyRepository.findAll();
        GeneralCompanyInformationDTO dto = new GeneralCompanyInformationDTO();

        calculateTypesNumbers(companies, dto.getIndustryTypes());
        calculateSizeRanges(companies, dto.getSizeRanges());
        calculateYearsFounded(companies, dto.getYearFoundeds());

        return dto;
    }

    private int toNumber(String size){ // 10001+2
        if(size.contains("+")){
            String[] splitedSize = size.split("\\+"); // ["10001", "2"]
            int number = Integer.parseInt(splitedSize[0]);
            return number;
        }

        String[] splitedSize = size.split("-"); // ["10001", "2"]
        int number = Integer.parseInt(splitedSize[0]);
        return number;
    }


    private ArrayList<CompanyModel> ascendingCompaniesBySize(ArrayList<CompanyModel> companies){
        Map<CompanyModel, Integer> dict = new HashMap();

        for( CompanyModel c : companies){ // Por cada (Entidad : conjunto de entidades)
            dict.put(c, toNumber(c.getSize()));
        }

        Map<CompanyModel, Integer> sortedBySize = dict.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        ArrayList<CompanyModel> orderedCompanies = new ArrayList<>(sortedBySize.keySet());

        return orderedCompanies;
    }


    private ArrayList<CompanyModel> descendingCompaniesByFounded(ArrayList<CompanyModel> companies) {

        Map<CompanyModel, Integer> dict = new HashMap();

        for( CompanyModel c : companies){ // Por cada (Entidad : conjunto de entidades)
            dict.put(c, c.getFounded());
        }

        Map<CompanyModel, Integer> sortedBySize = dict.entrySet()
                .stream()
                .sorted(Map.Entry.<CompanyModel, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        ArrayList<CompanyModel> orderedCompanies = new ArrayList<>(sortedBySize.keySet());

        return orderedCompanies;
    }

    private void calculateTypesNumbers(ArrayList<CompanyModel> companies, HashMap<String, Integer> industryTypesMap){
        ArrayList<String> industries = new ArrayList<>();



        for(CompanyModel company: companies){
            if(company.getIndustry() == null){
                industries.add(Constants.WITHOUT_TYPE);
                continue;
            }
            industries.add(company.getIndustry());
        }

        for (String industry: industries){
            if(!industryTypesMap.containsKey(industry)) {
                industryTypesMap.put(industry, 0);
            }
            industryTypesMap.put(industry, industryTypesMap.get(industry) + 1);
        }
    }

    private void calculateSizeRanges(ArrayList<CompanyModel> companies, HashMap<String, Integer> sizeTypesMap){
        ArrayList<String> sizes = new ArrayList<>();



        for(CompanyModel company: companies){
            if(company.getSize() == null){
                sizes.add(Constants.WITHOUT_SIZE);
            }
            sizes.add(company.getSize());
        }

        for(String size: sizes){
            if(!sizeTypesMap.containsKey(size)){
                sizeTypesMap.put(size, 0);
            }
            sizeTypesMap.put(size, sizeTypesMap.get(size) +1);
        }
    }

    private void calculateYearsFounded(ArrayList<CompanyModel> companies, HashMap<Integer, Integer> yearsCreated){
        ArrayList<Integer> years = new ArrayList<>();

        for(CompanyModel company: companies){
            years.add(company.getFounded());
        }

        for (Integer year : years){
            if(!yearsCreated.containsKey(year)){
                yearsCreated.put(year, 0);
            }
            yearsCreated.put(year, yearsCreated.get(year) + 1);
        }
    }
}