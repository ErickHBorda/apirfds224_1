package com.iis.app.bussiness.general.person.request;

import lombok.Data;

@Data
public class SoUpdate {
    private String idPerson;
    private String firstName;
	private String surName;
	private String dni;
	private boolean gender;
	private String birthDate;
}
