package com.ibm.academia.respi.banco.servicios;

import static com.ibm.academia.respi.banco.datos.DatosDummy.tarjeta01;
import static com.ibm.academia.respi.banco.datos.DatosDummy.tarjeta02;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ibm.academia.respi.banco.modelo.entidades.Tarjeta;
import com.ibm.academia.respi.banco.repositorio.TarjetaRepository;

public class TarjetaDAOImplTest 
{
	TarjetaDAO tarjetaDao;
	TarjetaRepository tarjetaRepository;
	
	@BeforeEach
	void setUp()
	{
		tarjetaRepository = mock(TarjetaRepository.class);
		tarjetaDao = new TarjetaDAOImpl(tarjetaRepository);
	}
	
	@Test
	@DisplayName("Test para buscar todos los planes de tarjeta")
	void findAll()
	{
		//Given
		when(tarjetaRepository.findAll())
		.thenReturn(Arrays.asList(tarjeta01(),tarjeta02()));
		
		//When
		List<Tarjeta>expected = (List<Tarjeta>)tarjetaDao.findAll();
		
		//Then
		assertThat(expected.get(0)).isEqualTo(tarjeta01());
		assertThat(expected.get(1)).isEqualTo(tarjeta02());
		
		verify(tarjetaRepository.findAll());
	}
	
	@Test
	@DisplayName("Test: Buscar tu plan de tarjetas")
	void buscarTuTarjeta()
	{
		//Given
				when(tarjetaRepository.buscarTuTarjeta("Shopping", 7000, 14999, 18, 23))
				.thenReturn(Arrays.asList(tarjeta01()));
				
				//When
				List<Tarjeta>expected = (List<Tarjeta>)tarjetaDao.buscarTuTarjeta("Shopping", 7000, 14999, 18, 23);
				
				//Then
				assertThat(expected.get(0)).isEqualTo(tarjeta01());
				
				verify(tarjetaRepository.buscarTuTarjeta("Shopping", 7000, 14999, 18, 23));
	}
}
