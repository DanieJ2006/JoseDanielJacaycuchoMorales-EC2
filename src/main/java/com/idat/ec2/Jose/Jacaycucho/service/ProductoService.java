package com.idat.ec2.Jose.Jacaycucho.service;

import java.util.List;

import com.idat.ec2.Jose.Jacaycucho.model.Producto;

public interface ProductoService {
	
	void guardar(Producto producto);
	void actualizar(Producto producto);
	void eliminar(Integer id);
	List<Producto> listar();
	Producto obtener(Integer id);

}
