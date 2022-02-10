package com.ibm.academia.respi.banco.servicios;

import java.util.List;

import com.ibm.academia.respi.banco.modelo.entidades.Tarjeta;

public interface TarjetaDAO extends GenericoDAO<Tarjeta>
{
	public Iterable<Tarjeta>findAll();
	public List<Tarjeta> findByTuPasion(String tuPasion);
	public void delete(long id);
	public boolean existsById(long id);
	public boolean existsByTuPasion(String tuPasion);
	public Tarjeta save(Tarjeta tarjeta);
}
