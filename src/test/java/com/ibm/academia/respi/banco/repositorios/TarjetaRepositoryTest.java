package com.ibm.academia.respi.banco.repositorios;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ibm.academia.respi.banco.datos.DatosDummy;
import com.ibm.academia.respi.banco.modelo.entidades.Tarjeta;
import com.ibm.academia.respi.banco.repositorio.TarjetaRepository;

@DataJpaTest
public class TarjetaRepositoryTest
{
	@Autowired
	private TarjetaRepository tarjetarRepository;
	
	@BeforeEach
	void setUp()
	{
		//Given
				tarjetarRepository.save(DatosDummy.tarjeta01());
				tarjetarRepository.save(DatosDummy.tarjeta02());
	}
	@AfterEach
	void tearDown()
	{
		tarjetarRepository.deleteAll();
	}
	
	@Test
	@DisplayName("Test: Busca todos los planes de tarjetas")
	void findAll() 
	{
		
		
		//When
		List<Tarjeta>expected = (List<Tarjeta>)tarjetarRepository.findAll();
		
		//Then
		assertThat(expected.size() == 2).isTrue();
		
	}
	
	void buscarTuTarjeta()
	{
		//When
		List<Tarjeta>expected = (List<Tarjeta>)tarjetarRepository.buscarTuTarjeta("Shopping", 7000, 14999, 18, 23);
		//Then
		assertThat(expected.size() == 1).isTrue();
	}
	
}
