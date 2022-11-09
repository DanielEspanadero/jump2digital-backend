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

//    Tarea Extra: Obtener todas las compañías sin ningún tipo de orden
    @GetMapping
    public ArrayList<CompanyModel> getCompanies(){
        return this.companyService.getAllCompanies();
    }

//    Tarea 2: Crear un endpoint que devuelva las compañías ordenadas por tamaño
    @GetMapping("/sort-size")
    public ArrayList<CompanyModel> orderCompaniesBySize(){
        return this.companyService.sortBySize();
    }

//    Tarea 3: Crear un endpoint que devuelva las compañías ordenadas por fecha de creación
    @GetMapping("/sort-founded")
    public ArrayList<CompanyModel> orderCompaniesByFounded(){
        return this.companyService.sortByFounded();
    }

//    Tarea 4: Crear un endpoint que devuelva los siguientes datos: Número de empresas que hay en cada industria, Número de empresas que hay por cada rango de tamaños, Número de empresas que hay en cada año de creación
    @GetMapping("/general-information")
    public GeneralCompanyInformationDTO companyInformation(){
        return this.companyService.generalCompanyInformation();
    }

//   Tarea Extra: Añadir una sola compañia a la base de datos
    @PostMapping
    public ResponseEntity<String> saveCompany(@RequestBody CompanyModel company){
            this.companyService.saveCompany(company);
            return ResponseEntity.status(200).body("User added successfully! 🙂");

    }

//    Tarea 1: Crear un base de datos (PostgreSQL, MySQL, Mongo, Firebase,etc) y guardar toda la lista de compañías utilizado siguiendo el esquema del JSON
    @PostMapping("/all")
    public ResponseEntity<String> saveAllCompanies(@RequestBody ArrayList<CompanyModel> companies){
            this.companyService.saveAllCompanies(companies);
            return ResponseEntity.status(200).body("All Users added successfully! 🙂");
    }
}
