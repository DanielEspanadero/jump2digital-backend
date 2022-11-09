package com.nuwe.hackathonjump2digital.repositories;

import com.nuwe.hackathonjump2digital.models.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICompanyRepository extends JpaRepository<CompanyModel, Long> {
}
