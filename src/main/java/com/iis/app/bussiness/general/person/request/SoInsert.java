package com.iis.app.bussiness.general.person.request;

import lombok.Data;

//import java.util.Date;
@Data
public class SoInsert {
    private String firstName;
	private String surName;
	private String dni;
	private boolean gender;
	private String birthDate;
}
