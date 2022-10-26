package com.idat.ec2.Jose.Jacaycucho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec2.Jose.Jacaycucho.model.Cliente;
import com.idat.ec2.Jose.Jacaycucho.repository.ClienteRepository;

@Service
public class ClienteServiceImp implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public void guardar(Cliente cliente) {
		clienteRepository.save(cliente);

	}

	@Override
	public void actualizar(Cliente cliente) {
		clienteRepository.saveAndFlush(cliente);

	}

	@Override
	public void eliminar(Integer id) {
		clienteRepository.deleteById(id);

	}

	@Override
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente obtener(Integer id) {
		return clienteRepository.findById(id).orElse(null);
	}

}
