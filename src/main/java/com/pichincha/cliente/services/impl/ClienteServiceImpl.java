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
		List<Cliente> clientes = repo.findAll();
		Long total = clientes.stream().filter(c->c.getDni().equals(obj.getDni())).count();
		if (total>0)
			throw new ModelNotFoundException("El dni ya se encuentra registrado.");

		return repo.save(obj);
	}

	@Override
	public Cliente update(Cliente obj) {
		if (obj.getClienteId() == null)
			throw new BadRequestException("El campo clienteId es requerido.");

		validarYObtenerCliente(obj.getClienteId());
		return repo.save(obj);
	}

	@Override
	public List<Cliente> findAll() {
		return repo.findAll();
	}

	@Override
	public Cliente fintById(Integer id) {
		return validarYObtenerCliente(id);
	}

	@Override
	public void delete(Integer id) {
		Cliente cliente = validarYObtenerCliente(id);
		cliente.setEstado("false");
		update(cliente);
	}

	private Cliente validarYObtenerCliente(Integer id) {
		Optional<Cliente> op = repo.findById(id);
		if (op.isPresent())
			return op.get();

		throw new BadRequestException("Cliente no encontrado.");
	}
}
