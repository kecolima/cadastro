package com.keeggo.service.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keeggo.exception.v1.ResourceNotFoundException;
import com.keeggo.model.v1.Cliente;
import com.keeggo.repository.v1.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository repository;
		
	public Cliente create(Cliente Cliente) {
		return repository.save(Cliente);
	}
	
	public List<Cliente> findAll() {
		return repository.findAll();
	}	
	
	public Cliente findById(Long id) {

		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}
		
	public Cliente update(Cliente Cliente) {
		Cliente entity = repository.findById(Cliente.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setNome(Cliente.getNome());
		entity.setEmail(Cliente.getEmail());
		entity.setCpf(Cliente.getCpf());
		entity.setEndereco(Cliente.getEndereco());
		entity.setCep(Cliente.getCep());
		entity.setCidade(Cliente.getCidade());
		entity.setEstado(Cliente.getEstado());
		entity.setBairro(Cliente.getBairro());
		
		return repository.save(entity);
	}	
	
	public void delete(Long id) {
		Cliente entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}

}
