package com.iis.app.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tperson")
public class TPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="idPerson")
    private String idPerson;

    @Column(name="firstName")
    private String firstName;

    @Column(name="surName")
    private String surName;

    @Column(name="dni")
    private String dni;

    @Column(name="gender")
    private Boolean gender;

    @Column(name="birthDate")
    private Date birthDate;

    @Column(name="createdAT")
    private Date createdAT;

    @Column(name="updateAt")
    private Date updateAt;

    public String getIdPerson(){
        return this.idPerson;
    }   

    public void setIdPerson(String idPerson){
        this.idPerson=idPerson;
    }

    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String surName){
        this.surName=surName;
    }
    public String getSurName(){
        return this.surName;
    }
    public void setSurName(String surName){
        this.surName=surName;
    }

    public String getDni(){
        return this.dni;
    }
    public void setDni(String dni){
        this.dni=dni;
    }
    public Boolean getGender(){
        return this.gender;
    }
    public void setGender(Boolean gender){
        this.gender=gender;
    }
    public Date getBirthDate(){
        return this.birthDate;
    }
    public void setBirthDate(Date birthDate){
        this.birthDate=birthDate;
    }
    public Date getCreatedAT(){
        return this.createdAT;
    }
    public void setCreatedAT(Date createdAT){
        this.createdAT=createdAT;
    }
    public Date getUpdateAt(){
        return this.updateAt;
    }
    public void setUpdateAt(Date updateAt){
        this.updateAt=updateAt;
    }
}
