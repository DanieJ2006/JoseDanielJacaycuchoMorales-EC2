package com.idat.ec2.Jose.Jacaycucho.service;

import java.util.List;

import com.idat.ec2.Jose.Jacaycucho.model.Cliente;

public interface ClienteService {
	
	void guardar(Cliente cliente);
	void actualizar(Cliente cliente);
	void eliminar(Integer id);
	List<Cliente> listar();
	Cliente obtener(Integer id);
}
