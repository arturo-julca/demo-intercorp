package com.arturo.demointercorp.service;

import java.util.List;

import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arturo.demointercorp.model.Cliente;
import com.arturo.demointercorp.model.ResponseKPI;
import com.arturo.demointercorp.repository.ClienteRepository;

@Component
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente add(Cliente client){
		return clienteRepository.save(client);
	}
	
	public ResponseKPI getKPI(){
		List<Cliente> allClients = findAll();
		double[] arrayEdades = allClients.stream().mapToDouble(i -> (double)i.getEdad()).toArray();
		double averageAge = StatUtils.mean(arrayEdades);
		double standardDeviationAge = new StandardDeviation().evaluate(arrayEdades);
		return new ResponseKPI(averageAge, standardDeviationAge);
	}
	
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}
}
