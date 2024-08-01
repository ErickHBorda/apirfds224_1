package com.iis.app.bussiness.general.person;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iis.app.bussiness.general.person.request.SoInsert;
import com.iis.app.bussiness.general.person.request.SoUpdate;
import com.iis.app.bussiness.general.person.response.SoGetAll;
import com.iis.app.dto.DtoPerson;
import com.iis.app.service.PersonService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("person")
public class PersonController {
	@Autowired
	private PersonService personService;

	@PostMapping(path = "insert", consumes = { "multipart/form-data" })
    public ResponseEntity<Boolean> actionInsert(@Valid @ModelAttribute SoInsert soInsert) {
        try {
            DtoPerson dtoPerson = new DtoPerson();
            dtoPerson.setFirstName(soInsert.getFirstName());
            dtoPerson.setSurName(soInsert.getSurName());
            dtoPerson.setDni(soInsert.getDni());
            dtoPerson.setGender(soInsert.getGender());
            dtoPerson.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse(soInsert.getBirthDate()));

            personService.insert(dtoPerson);
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }*/

	@GetMapping(path = "getall")
	public ResponseEntity<List<SoGetAll>> actionGetAll() {
		List<DtoPerson> listDtoPerson = personService.getAll();

		List<SoGetAll> listSoPersonGet = new ArrayList<>();

		for (DtoPerson dtoPerson : listDtoPerson) {
			listSoPersonGet.add(new SoGetAll(
				dtoPerson.getIdPerson(),
				dtoPerson.getFirstName(),
				dtoPerson.getSurName(),
				dtoPerson.getDni(),
				dtoPerson.getGender(),
				dtoPerson.getBirthDate()
			));
		}

		return new ResponseEntity<>(listSoPersonGet, HttpStatus.OK);
	}

	@DeleteMapping(value="delete/{idPerson}")
	public ResponseEntity<Boolean> actionDelete(@PathVariable String idPerson){
		personService.delete(idPerson);
		return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
	}

	@PostMapping(path = "update",consumes = {"multipart/form-data"})
	public ResponseEntity<Boolean> actionUpdate(@Valid @ModelAttribute SoUpdate soUpdate) {
		
		try {
			DtoPerson dtoPerson = new DtoPerson();
			dtoPerson.setIdPerson(soUpdate.getIdPerson());
			dtoPerson.setFirstName(soUpdate.getFirstName());
			dtoPerson.setSurName(soUpdate.getSurName());
			dtoPerson.setDni(soUpdate.getDni());
			dtoPerson.setGender(soUpdate.getGender());
			dtoPerson.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse(soUpdate.getBirthDate()));

			personService.update(dtoPerson);
			return new ResponseEntity<>(true, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
}