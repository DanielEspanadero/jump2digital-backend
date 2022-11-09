package com.nuwe.hackathonjump2digital.services.bussinesslogic.interfaces;

import com.nuwe.hackathonjump2digital.dto.GeneralCompanyInformationDTO;
import com.nuwe.hackathonjump2digital.models.CompanyModel;

import java.util.ArrayList;

public interface ICompany {

    void saveCompany(CompanyModel company);

    void saveAllCompanies(ArrayList<CompanyModel> company);

    ArrayList<CompanyModel> getAllCompanies();

    ArrayList<CompanyModel> sortBySize();

    ArrayList<CompanyModel> sortByFounded();

    GeneralCompanyInformationDTO generalCompanyInformation();
}
