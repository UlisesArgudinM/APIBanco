package com.ibm.academia.respi.banco.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.respi.banco.modelo.entidades.Tarjeta;
import com.ibm.academia.respi.banco.repositorio.TarjetaRepository;



@Service
public class TarjetaDAOImpl extends GenericoDAOImpl<Tarjeta, TarjetaRepository> implements TarjetaDAO
{
	@Autowired
	public TarjetaDAOImpl(@Qualifier("repositorioTarjeta")TarjetaRepository repository) {
		super(repository);
		
	}

	@Override
	@Transactional
	public Iterable<Tarjeta> findAll() {
		
		return repository.findAll();
	}

	@Override
	@Transactional (readOnly = true)
	public List<Tarjeta> findByTuPasion(String tuPasion) {
		
		return repository.findByTuPasion(tuPasion);
	}

	@Override
	@Transactional
	public void delete(long id) {
		
		
	}

	@Override
	@Transactional
	public boolean existsById(long id) {
		
		return repository.existsById(id);
	}

	@Override
	@Transactional
	public boolean existsByTuPasion(String tuPasion) {
		
		return repository.existsByTuPasion(tuPasion);
	}

	@Override
	public Tarjeta save(Tarjeta tarjeta) {
		// TODO Auto-generated method stub
		return null;
	}

	
	}

	

	

	
	