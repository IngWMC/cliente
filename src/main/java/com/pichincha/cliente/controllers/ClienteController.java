package com.pichincha.cliente.controllers;

import com.pichincha.cliente.models.Cliente;
import com.pichincha.cliente.services.IClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController {
	private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);
	@Autowired
	private IClienteService service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){
		logger.info("Inicio ClienteController ::: findAll");
		List<Cliente> clientes = service.findAll();
		logger.info("Fin ClienteController ::: findAll");
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(clientes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable("id") Integer id){
		logger.info("Inicio ClienteController ::: findById ::: " + id);
		Cliente cliente = service.fintById(id);
		logger.info("Fin ClienteController ::: findById");
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(cliente);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> insert(@Valid @RequestBody Cliente obj){
		logger.info("Inicio ClienteController ::: insert ::: " + obj);
		Cliente cliente = service.insert(obj);
		logger.info("Fin ClienteController ::: insert");
		return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Cliente> update(@Valid @RequestBody Cliente obj){
		logger.info("Inicio ClienteController ::: update ::: " + obj);
		Cliente cliente = service.update(obj);
		logger.info("Fin ClienteController ::: update");
		return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		logger.info("Inicio ClienteController ::: delete ::: " + id);
		service.fintById(id);
		logger.info("Fin ClienteController ::: delete");
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
