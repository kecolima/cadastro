package com.keeggo;

<<<<<<< HEAD
public class ClienteControllerTest {	
	
	
=======
import org.springframework.beans.factory.annotation.Autowired;

import com.keeggo.model.v1.Cliente;
import com.keeggo.service.v1.ClienteService;

public class ClienteControllerTest {	
	
	@Autowired	
	ClienteService clienteService;
	public void createTest()  {		    
		Cliente cliente = new Cliente();
		cliente.setBairro("Centro");
		cliente.setId((long) 10);
		cliente.setCep("19901-230");
		cliente.setCidade("Ourinhos");
		cliente.setCpf("81978936591");
		cliente.setEndereco("Rua Ribeirão Claro");
		cliente.setNome("Alex");
		cliente.setNumero("34");
		cliente.setEstado("Bahia");
		cliente.setEmail("kecolima@hotmail.com");
		//System.out.println(cliente);
		clienteService.create(cliente);
	}//Fim do Método testarInserir
>>>>>>> be2bcd8fbdeae42d680effe67ba26b036f027297
}

