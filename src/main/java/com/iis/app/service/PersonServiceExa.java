package com.iis.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iis.app.dto.DtoPersonExa;
import com.iis.app.entity.TOficina;
import com.iis.app.repository.PersonRepositoryExa;

@Service
public class PersonServiceExa {
	@Autowired
	private PersonRepositoryExa personRepository;

	public boolean insert(DtoPersonExa dtoPerson) {
		dtoPerson.setCodigoOficina(UUID.randomUUID().toString());
		dtoPerson.setCreated_at(new Date());
		dtoPerson.setUpdated_at(new Date());

		TOficina tPerson = new TOficina();

		tPerson.setCodigoOficina(dtoPerson.getCodigoOficina());
		tPerson.setDescripcion(dtoPerson.getDescripcion());
		tPerson.setPais(dtoPerson.getPais());
		tPerson.setFechaCreacion(dtoPerson.getFechaCreacion());
		tPerson.setEstado(dtoPerson.isEstado());
		tPerson.setCreated_at(dtoPerson.getCreated_at());
		tPerson.setUpdated_at(dtoPerson.getUpdated_at());

		personRepository.save(tPerson);

		return true;
	}

	public List<DtoPersonExa> getAll() {
		List<TOficina> listTOficina = personRepository.findAll();
		List<DtoPersonExa> listDtoPerson = new ArrayList<>();

		for (TOficina tPerson : listTOficina) {
			DtoPersonExa dtoPerson = new DtoPersonExa();

			dtoPerson.setCodigoOficina(tPerson.getCodigoOficina());
			dtoPerson.setDescripcion(tPerson.getDescripcion());
			dtoPerson.setPais(tPerson.getPais());
			dtoPerson.setFechaCreacion(tPerson.getFechaCreacion());
			dtoPerson.setEstado(tPerson.isEstado());
			dtoPerson.setCreated_at(tPerson.getCreated_at());
			dtoPerson.setUpdated_at(tPerson.getUpdated_at());

			listDtoPerson.add(dtoPerson);
		}

		return listDtoPerson;
	}

	public Boolean delete(String codigoOficina) {
		personRepository.deleteById(codigoOficina);
		return true;
	}

	public Boolean update(DtoPersonExa dtoPerson) {
		dtoPerson.setUpdated_at(new Date());

		Optional<TOficina> optionTOficina = personRepository.findById(dtoPerson.getCodigoOficina());

		if (!optionTOficina.isPresent()) {
			return false;
		}

		TOficina tOficina = optionTOficina.get();
		tOficina.setDescripcion(dtoPerson.getDescripcion());
		tOficina.setPais(dtoPerson.getPais());
		tOficina.setFechaCreacion(dtoPerson.getFechaCreacion());
		tOficina.setEstado(dtoPerson.isEstado());
		tOficina.setUpdated_at(dtoPerson.getUpdated_at());

		personRepository.save(tOficina);

		return true;
	}

	public List<TOficina> findByDescription(String description) {
		return personRepository.findByDescripcion(description);
	}	
}