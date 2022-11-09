package com.nuwe.hackathonjump2digital.models;

import javax.persistence.*;


//    Tarea 1: Crear un base de datos (PostgreSQL, MySQL, Mongo, Firebase,etc) y guardar toda la lista de compañías utilizado siguiendo el esquema del JSON
@Entity
@Table(name = "company")
public class CompanyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_;

    @Column
    private String website;

    @Column(unique = true)
    private String name;

    @Column
    private int founded;

    @Column
    private String size;

    @Column
    private String locality;

    @Column
    private String region;

    @Column
    private String industry;

    @Column(name = "linkedin_url")
    private String linkedinUrl;

    public Long getId_() {
        return id_;
    }

    public void setId_(Long id_) {
        this.id_ = id_;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFounded() {
        return founded;
    }

    public void setFounded(int founded) {
        this.founded = founded;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }
}