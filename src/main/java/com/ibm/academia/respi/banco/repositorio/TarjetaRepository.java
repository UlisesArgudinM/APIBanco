package com.ibm.academia.respi.banco.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.respi.banco.modelo.entidades.Tarjeta;

@Repository("repositorioTarjeta")
public interface TarjetaRepository extends CrudRepository<Tarjeta, Long> 
{
	public Iterable<Tarjeta>findAll();
	public List<Tarjeta> findByTuPasion(String tuPasion);
	public void delete(long id);
	public boolean existsById(long id);
	public boolean existsByTuPasion(String tuPasion);
}
