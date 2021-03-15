package com.keeggo.controller.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keeggo.model.v1.Cliente;
import com.keeggo.service.v1.ClienteService;
import com.keeggo.util.v1.ClienteApiUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="API REST Clientes")
@RestController
@RequestMapping("/v1/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
	public List<Cliente> findAll() {
		return service.findAll();
	}	
	
	@GetMapping("/{id}")
	public Cliente findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@ApiOperation(value="Salvar Cliente")
	@PostMapping
	public Cliente create(@RequestHeader(value=ClienteApiUtil.HEADER_TRAVELS_API_VERSION, defaultValue="${api.version}") String apiVersion, 
			@RequestHeader(value=ClienteApiUtil.HEADER_API_KEY, defaultValue="${api.key}") String apiKey,@RequestBody Cliente Cliente) {
		return service.create(Cliente);
	}
	
	@PutMapping
	public Cliente update(@RequestBody Cliente Cliente) {
		return service.update(Cliente);
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}	

}
