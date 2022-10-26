package com.idat.ec2.Jose.Jacaycucho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.idat.ec2.Jose.Jacaycucho.model.Cliente;
import com.idat.ec2.Jose.Jacaycucho.service.ClienteService;

@Controller
@RequestMapping("/cliente/ec2")
public class ClienteController {
	
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> listar(){
		return new ResponseEntity<List<Cliente>>(clienteService.listar(), HttpStatus.OK) ;
	}
	
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Cliente cliente){
		clienteService.guardar(cliente);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(path = "/listar/{id}",method = RequestMethod.GET)
	public ResponseEntity<Cliente> obtenerPorId(@PathVariable Integer id){
		
		Cliente clienteexistente = clienteService.obtener(id);
		if(clienteexistente !=null) {
			return new ResponseEntity<Cliente>(clienteexistente,HttpStatus.OK);
		}else {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
		
	}
	

	@RequestMapping(path = "/editar",method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Cliente cliente){
		
		Cliente clienteexistente = clienteService.obtener(cliente.getIdCliente());
		
		if(clienteexistente != null) {
			clienteService.actualizar(cliente);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Cliente clienteexistente  = clienteService.obtener(id);
		if(clienteexistente != null) {
			clienteService.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}

}
