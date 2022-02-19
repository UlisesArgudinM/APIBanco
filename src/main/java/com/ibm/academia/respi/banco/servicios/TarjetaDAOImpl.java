package com.ibm.academia.respi.banco.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.respi.banco.modelo.entidades.Tarjeta;
import com.ibm.academia.respi.banco.repositorio.TarjetaRepository;
import com.ibm.academia.respi.banco.excepciones.NotFoundException;



@Service
public class TarjetaDAOImpl extends GenericoDAOImpl<Tarjeta, TarjetaRepository> implements TarjetaDAO
{
	@Autowired
	public TarjetaDAOImpl(@Qualifier("repositorioTarjeta")TarjetaRepository repository) {
		super(repository);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Tarjeta> findAll() {
		
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Tarjeta> buscarTuTarjeta(String tuPasion, double monthlySalaryMin, double monthlySalaryMax,
			double ageMin, double ageMax) {
		return repository.buscarTuTarjeta(tuPasion, monthlySalaryMin, monthlySalaryMax, ageMin, ageMax);
	}

	@Override
	@Transactional
	public Tarjeta actualizar(Long tarjetaId, Tarjeta tarjeta) 
	{
		Optional<Tarjeta> oTarjeta = repository.findById(tarjetaId);
		
		if(!oTarjeta.isPresent())
			throw new NotFoundException(String.format("El plan de tarjetas con ID %d no existe", tarjetaId)); 
		
		Tarjeta tarjetaActualizada = null;
		oTarjeta.get().setTuPasion(tarjeta.getCreditCard());
		oTarjeta.get().setAgeMin(tarjeta.getAgeMin());
		oTarjeta.get().setAgeMax(tarjeta.getAgeMax());
		oTarjeta.get().setMonthlySalaryMin(tarjeta.getMonthlySalaryMin());
		oTarjeta.get().setMonthlySalaryMax(tarjeta.getMonthlySalaryMax());
		oTarjeta.get().setCreditCard(tarjeta.getCreditCard());
		tarjetaActualizada = repository.save(oTarjeta.get());
		return tarjetaActualizada;
	}
	
	}

	

	

	
	