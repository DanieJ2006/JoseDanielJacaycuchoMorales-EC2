package com.idat.ec2.Jose.Jacaycucho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec2.Jose.Jacaycucho.model.Bodega;
import com.idat.ec2.Jose.Jacaycucho.repository.BodegaRepository;

@Service
public class BodegaServiceImp implements BodegaService {
	
	@Autowired
	private BodegaRepository bodegaRepository;

	

	@Override
	public void guardar(Bodega bodega) {
		bodegaRepository.save(bodega);

	}

	@Override
	public void actualizar(Bodega bodega) {
		bodegaRepository.saveAndFlush(bodega);

	}

	@Override
	public void eliminar(Integer id) {
		bodegaRepository.deleteById(id);

	}

	@Override
	public List<Bodega> listar() {
		return bodegaRepository.findAll();
	}

	@Override
	public Bodega obtener(Integer id) {
		return bodegaRepository.findById(id).orElse(null);
	}

}
