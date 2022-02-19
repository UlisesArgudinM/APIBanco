package com.ibm.academia.respi.banco.servicios;

import com.ibm.academia.respi.banco.modelo.entidades.Tarjeta;

public interface TarjetaDAO extends GenericoDAO<Tarjeta>
{
	public Iterable<Tarjeta>findAll();
	public Iterable<Tarjeta>buscarTuTarjeta(String tuPasion,double monthlySalaryMin,double monthlySalaryMax,double ageMin,double ageMax);
	public Tarjeta actualizar(Long tarjetaId, Tarjeta tarjeta);
}
