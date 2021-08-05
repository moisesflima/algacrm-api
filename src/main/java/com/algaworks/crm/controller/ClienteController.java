package com.algaworks.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.crm.model.Cliente;
import com.algaworks.crm.services.ClienteService;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
		return clienteService.create(cliente);
	}	
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Cliente> listarTodos() {		
		return clienteService.retrieve();
	}
	
	@GetMapping("/{id}")	
	public ResponseEntity listarPorId(@PathVariable(name = "id") long id) {		
		return clienteService.retrieveById(id);
	}	
	
	@PutMapping	
	public ResponseEntity atualizar(@RequestBody Cliente cliente) {
		return clienteService.update(cliente);
	}	
	
	@DeleteMapping	
	public void excluir(@RequestBody Cliente cliente) {
		clienteService.delete(cliente);
	}

}
