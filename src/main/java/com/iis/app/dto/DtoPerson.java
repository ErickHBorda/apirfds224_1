package com.iis.app.dto;

import java.util.Date;

import lombok.Data;

@Data
public class DtoPerson {
    private String idPerson;
    private String firstName;
    private String surName;
    private String dni;
    private Boolean gender;
    private Date birthDate;
    private Date createdAt;
    private Date updatedAt;
}
