package com.algaworks.crm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.algaworks.crm.model.Cliente;
import com.algaworks.crm.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;	

	public Cliente create(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> retrieve() {
		return clienteRepository.findAll();
	}
	
	public Cliente retrieveById(long id) {
		return clienteRepository.findById(id).get();
	}	
	
	public Cliente update(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public void delete(Cliente cliente) {
		clienteRepository.delete(cliente);
	}		

}
