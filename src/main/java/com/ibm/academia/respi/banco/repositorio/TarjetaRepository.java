package com.ibm.academia.respi.banco.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.respi.banco.modelo.entidades.Tarjeta;

@Repository("repositorioTarjeta")
public interface TarjetaRepository extends CrudRepository<Tarjeta, Long> 
{
	public Iterable<Tarjeta>findAll();
	public Iterable<Tarjeta>buscarTuTarjeta(String tuPasion,double monthlySalaryMin,double monthlySalaryMax,double ageMin,double ageMax);
	public Tarjeta actualizar(Long tarjetaId, Tarjeta tarjeta);
}
