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

import com.idat.ec2.Jose.Jacaycucho.model.Producto;
import com.idat.ec2.Jose.Jacaycucho.service.ProductoService;


@Controller
@RequestMapping("/producto/ec2")
public class ProductoController {
	
	
	@Autowired
	private ProductoService productoService;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Producto>> listar(){
		return new ResponseEntity<List<Producto>>(productoService.listar(), HttpStatus.OK) ;
	}
	
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Producto producto){
		productoService.guardar(producto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(path = "/listar/{id}",method = RequestMethod.GET)
	public ResponseEntity<Producto> obtenerPorId(@PathVariable Integer id){
		
		Producto productoexistente = productoService.obtener(id);
		if(productoexistente !=null) {
			return new ResponseEntity<Producto>(productoexistente,HttpStatus.OK);
		}else {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}
		
	}
	

	@RequestMapping(path = "/editar",method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Producto producto){
		
		Producto productoexistente = productoService.obtener(producto.getIdProducto());
		
		if(productoexistente != null) {
			productoService.actualizar(producto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Producto productoexistente = productoService.obtener(id);
		if(productoexistente != null) {
			productoService.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}

}
