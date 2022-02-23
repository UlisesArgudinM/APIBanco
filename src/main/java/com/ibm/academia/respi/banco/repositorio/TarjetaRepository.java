package com.ibm.academia.respi.banco.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.respi.banco.modelo.entidades.Tarjeta;

@Repository("repositorioTarjeta")
public interface TarjetaRepository extends CrudRepository<Tarjeta, Long> 
{
	public Iterable<Tarjeta>findAll();
	
	@Query("select t from banco t where t.tuPasion=1? and t.salarioMensualMin=?2 and t.salarioMensualMax=?3 and t.anioMin=?4 and t.anioMax=?5")
	public Iterable<Tarjeta>buscarTuTarjeta(String tuPasion,double salarioMensualMin,double salarioMensualMax,double anioMin,double anioMax);
	public Tarjeta actualizar(Long tarjetaId, Tarjeta tarjeta);
}
