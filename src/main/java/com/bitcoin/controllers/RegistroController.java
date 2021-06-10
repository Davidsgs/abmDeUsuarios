package com.bitcoin.controllers;

import java.util.List;

import com.bitcoin.services.RegistroService;
import com.bitcoin.models.Registro;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistroController {

	private Logger logger = LoggerFactory.getLogger(RegistroController.class);

	@Autowired
	RegistroService registroService;

	@GetMapping(value = "/")
	public List<Registro> getAllRegistro() {
		logger.info("Getting all registro.");
		return registroService.getAllRegistro();
	}

	@GetMapping(value = "/{registroId}")
	public Registro getRegistroById(@PathVariable String registroId) {
		logger.info("Getting registro with ID: {" + registroId + "}");
		return registroService.getRegistroById(registroId);
	}

	@PostMapping(value = "/create")
	public Registro addRegistro(@RequestBody Registro registro) {
		logger.info("Saving registro.");
		return registroService.addRegistro(registro);
	}

	@PutMapping(value = "/update/{registroId}")
	public Registro updateRegistro(@PathVariable String registroId, @RequestBody Registro registro) {
		logger.info("Updating registro with ID: {" + registroId + "}");
		return registroService.updateRegistro(registroId, registro);
	}

	@DeleteMapping(value = "/delete/{registroId}")
	public String deleteRegistro(@PathVariable String registroId) {
		String aux = null;
		if(registroService.deleteRegistro(registroId)){
			aux = "The Register with ID: " + registroId + " has been deleted.";
		}else{
			aux = "Te Register with ID: " + registroId + " doesn't exist.";
		}
		return aux;
	}
}
