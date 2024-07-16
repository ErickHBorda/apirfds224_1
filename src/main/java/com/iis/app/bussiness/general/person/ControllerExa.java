package com.iis.app.bussiness.general.person;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.iis.app.bussiness.general.person.request.SoInsertExa;

import com.iis.app.bussiness.general.person.request.SoUpdateExa;

import com.iis.app.bussiness.general.person.response.SoGetAllExa;
import com.iis.app.dto.DtoPersonExa;
import com.iis.app.entity.TOficina;
import com.iis.app.service.PersonServiceExa;

@RestController
@RequestMapping("pais")
public class ControllerExa {
	@Autowired
	private PersonServiceExa personService;

	@PostMapping(path = "insert", consumes = { "multipart/form-data" })
	public ResponseEntity<Boolean> actionInsert(@ModelAttribute SoInsertExa soInsert) {
		
		try {
			DtoPersonExa dtoPerson = new DtoPersonExa();

			dtoPerson.setDescripcion(soInsert.getDescripcion());
			dtoPerson.setPais(soInsert.getPais());
            dtoPerson.setFechaCreacion(soInsert.getFechaCreacion());
			dtoPerson.setEstado(soInsert.isEstado());
			

			personService.insert(dtoPerson);
		} catch (Exception e) {}
		
		return new ResponseEntity<>(true, HttpStatus.CREATED);
	}

	@GetMapping(path = "getall")
	public ResponseEntity<List<SoGetAllExa>> actionGetAll() {
		List<DtoPersonExa> listDtoPerson = personService.getAll();

		List<SoGetAllExa> listSoPersonGet = new ArrayList<>();

		for (DtoPersonExa dtoPerson : listDtoPerson) {
			listSoPersonGet.add(new SoGetAllExa(
				dtoPerson.getCodigoOficina(),
				dtoPerson.getDescripcion(),
				dtoPerson.getPais(),
				dtoPerson.getFechaCreacion(),
				dtoPerson.isEstado()
			));
		}

		return new ResponseEntity<>(listSoPersonGet, HttpStatus.OK);
	}

	@DeleteMapping(value="delete/{codigoOficina}")
	public ResponseEntity<Boolean> actionDelete(@PathVariable String codigoOficina){
		personService.delete(codigoOficina);
		return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
	}

	@PutMapping(path = "update",consumes = {"multipart/form-data"})
	public ResponseEntity<Boolean> actionUpdate(@ModelAttribute SoUpdateExa soUpdate) {
		
		try {
			DtoPersonExa dtoPerson = new DtoPersonExa();
			dtoPerson.setCodigoOficina(soUpdate.getCodigoOficina());
			dtoPerson.setDescripcion(soUpdate.getDescripcion());
			dtoPerson.setPais(soUpdate.getPais());
			dtoPerson.setFechaCreacion(soUpdate.getFechaCreacion());
			dtoPerson.setEstado(soUpdate.isEstado());

			personService.update(dtoPerson);
		} catch (Exception e) {}
		
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@GetMapping("search")
    public List<TOficina> getOficinasByDescripcion(@RequestParam String descripcion) {
        return personService.findByDescription(descripcion);
    }
}
