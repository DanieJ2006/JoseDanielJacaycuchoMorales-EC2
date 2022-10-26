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

import com.idat.ec2.Jose.Jacaycucho.model.Bodega;
import com.idat.ec2.Jose.Jacaycucho.service.BodegaService;


@Controller
@RequestMapping("/bodega/ec2")
public class BodegaController {
	
	
	@Autowired
	private BodegaService bodegaService;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Bodega>> listar(){
		return new ResponseEntity<List<Bodega>>(bodegaService.listar(), HttpStatus.OK) ;
	}
	
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Bodega bodega){
		bodegaService.guardar(bodega);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(path = "/listar/{id}",method = RequestMethod.GET)
	public ResponseEntity<Bodega> obtenerPorId(@PathVariable Integer id){
		
		Bodega bodegaexistente = bodegaService.obtener(id);
		if(bodegaexistente !=null) {
			return new ResponseEntity<Bodega>(bodegaexistente,HttpStatus.OK);
		}else {
			return new ResponseEntity<Bodega>(HttpStatus.NOT_FOUND);
		}
		
	}
	

	@RequestMapping(path = "/editar",method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Bodega bodega){
		
		Bodega bodegaexistente = bodegaService.obtener(bodega.getIdBodega());
		
		if(bodegaexistente != null) {
			bodegaService.actualizar(bodega);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Bodega bodegaexistente = bodegaService.obtener(id);
		if(bodegaexistente != null) {
			bodegaService.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
}
