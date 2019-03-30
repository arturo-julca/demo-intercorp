package com.arturo.demointercorp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arturo.demointercorp.model.Cliente;
import com.arturo.demointercorp.model.ResponseKPI;
import com.arturo.demointercorp.service.ClienteService;

@RestController
@RequestMapping({"/"})
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@PostMapping(path = {"/creacliente"})
    public Cliente create(@RequestBody Cliente client){
        return clienteService.add(client);
    }
	
	@GetMapping(path = {"/kpideclientes"})
    public ResponseKPI getKPI(){
        return clienteService.getKPI();
    }
	
	@GetMapping(path = {"/listclientes"})
    public List<Cliente> findAll(){
        return clienteService.findAll();
    }
}