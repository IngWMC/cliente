package com.pichincha.cliente.services.impl;

import com.pichincha.cliente.exceptions.BadRequestException;
import com.pichincha.cliente.exceptions.ModelNotFoundException;
import com.pichincha.cliente.models.Cliente;
import com.pichincha.cliente.repositories.IClienteRepository;
import com.pichincha.cliente.services.IClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService {
	private static final Logger logger = LoggerFactory.getLogger(ClienteServiceImpl.class);

	@Autowired
	private IClienteRepository repo;
	
	@Override
	public Cliente insert(Cliente obj) {
		return repo.save(obj);
	}

	@Override
	public Cliente update(Cliente obj) {
		validarExisteCliente(obj.getClienteId());
		return repo.save(obj);
	}

	@Override
	public List<Cliente> findAll() {
		return repo.findAll();
	}

	@Override
	public Cliente fintById(Integer id) {
		Optional<Cliente> op = repo.findById(id);
		if (op.isPresent()) {
			return op.get();
		}else {
			throw new ModelNotFoundException("Cliente no encontrado.");
		}
	}

	@Override
	public void delete(Integer id) {
		Optional<Cliente> op = repo.findById(id);
		if (op.isPresent())
			throw new ModelNotFoundException("Cliente no encontrado.");

		repo.deleteById(id);
	}

	private void validarExisteCliente(Integer id) {
		Optional<Cliente> op = repo.findById(id);
		if (!op.isPresent())
			throw new BadRequestException("El campo clienteId es requerido.");
	}
}
