package com.nuwe.hackathonjump2digital.controllers;

import com.nuwe.hackathonjump2digital.dto.GeneralCompanyInformationDTO;
import com.nuwe.hackathonjump2digital.models.CompanyModel;
import com.nuwe.hackathonjump2digital.services.bussinesslogic.impl.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    CompanyServiceImpl companyService;

    @GetMapping
    public ArrayList<CompanyModel> getCompanies(){
        return this.companyService.getAllCompanies();
    }

    @GetMapping("/sort-size")
    public ArrayList<CompanyModel> orderCompaniesBySize(){
        return this.companyService.sortBySize();
    }

    @GetMapping("/sort-founded")
    public ArrayList<CompanyModel> orderCompaniesByFounded(){
        return this.companyService.sortByFounded();
    }

    @GetMapping("/general-information")
    public GeneralCompanyInformationDTO companyInformation(){
        return this.companyService.generalCompanyInformation();
    }

    @PostMapping
    public ResponseEntity<String> saveCompany(@RequestBody CompanyModel company){
            this.companyService.saveCompany(company);
            return ResponseEntity.status(200).body("User added successfully! 🙂");

    }

    @PostMapping("/all")
    public ResponseEntity<String> saveAllCompanies(@RequestBody ArrayList<CompanyModel> companies){
            this.companyService.saveAllCompanies(companies);
            return ResponseEntity.status(200).body("All Users added successfully! 🙂");
    }
}
