package com.arturo.demointercorp.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.arturo.demointercorp.model.Cliente;
import com.arturo.demointercorp.model.ResponseKPI;
import com.arturo.demointercorp.repository.ClienteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteServiceTest {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	ClienteService clienteService;
	
	@Before
	public void setData(){
		clienteRepository.save(new Cliente("Juan", "Perez", 25));
		clienteRepository.save(new Cliente("Pablo", "Perez", 27));
		clienteRepository.save(new Cliente("Pedro", "Perez", 30));
		clienteRepository.save(new Cliente("Luis", "Perez", 34));	
	}
	
	@Test
	public void testGetKPI(){
		//valores esperados en base a la data setteada
		double EXPECTED_PROMEDIOEDADES = 29;
		double EXPECTED_DESVIACIONESTANDAREDADCLIENTES = 3.9157800414902435;		
		ResponseKPI responseKPI = clienteService.getKPI();		
		Assert.assertTrue(responseKPI.getPromedioEdadClientes()==EXPECTED_PROMEDIOEDADES);
		Assert.assertTrue(responseKPI.getDesviacionEstandarEdadClientes()==EXPECTED_DESVIACIONESTANDAREDADCLIENTES);
	}
}
