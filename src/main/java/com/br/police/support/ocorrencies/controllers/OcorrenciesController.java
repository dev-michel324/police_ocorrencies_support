package com.br.police.support.ocorrencies.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.police.support.ocorrencies.entitys.Ocorrencies;
import com.br.police.support.ocorrencies.repositorys.OcorrenciesRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1")
public class OcorrenciesController {

	@Autowired
	private OcorrenciesRepository ocorrencieRepository;

	@RequestMapping(value = "/ocorrencies", method = RequestMethod.GET)
	public Iterable<Ocorrencies> getAll() {
		return ocorrencieRepository.findAll();
	}

	@RequestMapping(value = "/ocorrencies/{id}", method = RequestMethod.GET)
	public ResponseEntity<Ocorrencies> getById(@PathVariable(value = "id") long id) {
		Optional<Ocorrencies> ocorrencie = ocorrencieRepository.findById(id);
		if (ocorrencie.isPresent())
			return new ResponseEntity<Ocorrencies>(ocorrencie.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/ocorrencies", method = RequestMethod.POST)
	public Ocorrencies create(@Valid @RequestBody Ocorrencies ocorrencie) {
		return ocorrencieRepository.save(ocorrencie);
	}

	@RequestMapping(value = "/ocorrencies/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Ocorrencies> update(@PathVariable(value = "id") long id,
			@Valid @RequestBody Ocorrencies newOcorrencie) {
		Optional<Ocorrencies> oldOcorrencie = ocorrencieRepository.findById(id);
		if (oldOcorrencie.isPresent()) {
			Ocorrencies ocorrencie = oldOcorrencie.get();
			ocorrencie.setDescription(newOcorrencie.getDescription());
			ocorrencie.setLatitude(newOcorrencie.getLatitude());
			ocorrencie.setLongitude(newOcorrencie.getLongitude());
			ocorrencieRepository.save(ocorrencie);
			return new ResponseEntity<Ocorrencies>(ocorrencie, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/ocorrencies/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Ocorrencies> delete(@PathVariable(value = "id") long id) {
		Optional<Ocorrencies> oldOcorrencie = ocorrencieRepository.findById(id);
		if (oldOcorrencie.isPresent()) {
			Ocorrencies ocorrencie = oldOcorrencie.get();
			ocorrencieRepository.deleteById(id);
			return new ResponseEntity<Ocorrencies>(ocorrencie, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
