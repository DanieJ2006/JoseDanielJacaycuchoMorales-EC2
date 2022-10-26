package com.idat.ec2.Jose.Jacaycucho.service;

import java.util.List;

import com.idat.ec2.Jose.Jacaycucho.model.Bodega;

public interface BodegaService {
	
	void guardar(Bodega bodega);
	void actualizar(Bodega bodega);
	void eliminar(Integer id);
	List<Bodega> listar();
	Bodega obtener(Integer id);

}
