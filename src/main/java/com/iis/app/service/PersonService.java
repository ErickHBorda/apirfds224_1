package com.iis.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iis.app.dto.DtoPerson;
import com.iis.app.entity.TPerson;
import com.iis.app.repository.PersonRepository;

//CAPA de NEGOCIO

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;

	public boolean insert(DtoPerson dtoPerson) {
		dtoPerson.setIdPerson(UUID.randomUUID().toString());
		dtoPerson.setCreatedAt(new Date());
		dtoPerson.setUpdatedAt(new Date());

		TPerson tPerson = new TPerson();

		tPerson.setIdPerson(dtoPerson.getIdPerson());
		tPerson.setFirstName(dtoPerson.getFirstName());
		tPerson.setSurName(dtoPerson.getSurName());
		tPerson.setDni(dtoPerson.getDni());
		tPerson.setGender(dtoPerson.getGender());
		tPerson.setBirthDate(dtoPerson.getBirthDate());
		tPerson.setCreatedAt(dtoPerson.getCreatedAt());
		tPerson.setUpdatedAt(dtoPerson.getUpdatedAt());

		personRepository.save(tPerson);

		return true;
	}

	public List<DtoPerson> getAll() {
		List<TPerson> listTPerson = personRepository.findAll();

		List<DtoPerson> listDtoPerson = new ArrayList<>();

		for (TPerson tPerson : listTPerson) {
			DtoPerson dtoPerson = new DtoPerson();

			dtoPerson.setIdPerson(tPerson.getIdPerson());
			dtoPerson.setFirstName(tPerson.getFirstName());
			dtoPerson.setSurName(tPerson.getSurName());
			dtoPerson.setDni(tPerson.getDni());
			dtoPerson.setGender(tPerson.getGender());
			dtoPerson.setBirthDate(tPerson.getBirthDate());
			dtoPerson.setCreatedAt(tPerson.getCreatedAt());
			dtoPerson.setUpdatedAt(tPerson.getUpdatedAt());

			listDtoPerson.add(dtoPerson);
		}
		
		return listDtoPerson;
	}
}
