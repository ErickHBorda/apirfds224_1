package com.iis.app.bussiness.general.person.response;

import java.util.Date;

public class SoGetAll {
    public String idPerson;
    public String firstName;
    public String surName;
    public String dni;
    public Boolean gender;
    public Date birthDate;

    public SoGetAll(
        String idPerson,
        String firstName,
        String surName,
        String dni,
        Boolean gender,
        Date birthDate
    ){
        this.idPerson=idPerson;
        this.firstName=firstName;
        this.surName=surName;
        this.dni=dni;
        this.gender=gender;
        this.birthDate=birthDate;
    }    
}
