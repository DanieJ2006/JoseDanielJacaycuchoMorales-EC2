package com.idat.ec2.Jose.Jacaycucho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec2.Jose.Jacaycucho.model.Producto;
import com.idat.ec2.Jose.Jacaycucho.repository.ProductoRepository;
@Service
public class ProductoServiceImp implements ProductoService{
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public void guardar(Producto producto) {
		productoRepository.save(producto);
		
	}

	@Override
	public void actualizar(Producto producto) {
		productoRepository.saveAndFlush(producto);
		
	}

	@Override
	public void eliminar(Integer id) {
		productoRepository.deleteById(id);
		
	}

	@Override
	public List<Producto> listar() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	@Override
	public Producto obtener(Integer id) {
		// TODO Auto-generated method stub
		return productoRepository.findById(id).orElse(null);
	}

}
