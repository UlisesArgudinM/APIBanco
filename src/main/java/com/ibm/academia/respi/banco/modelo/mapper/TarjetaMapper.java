package com.ibm.academia.respi.banco.modelo.mapper;

import com.ibm.academia.respi.banco.modelo.dto.TarjetaDTO;
import com.ibm.academia.respi.banco.modelo.entidades.Tarjeta;

public class TarjetaMapper 
{
	public static TarjetaDTO mapTarjeta(Tarjeta tarjeta)
	{
		TarjetaDTO tarjetaDTO = new TarjetaDTO();
		tarjetaDTO.setTuPasion(tarjeta.getTuPasion());
		tarjetaDTO.setAgeMin(tarjeta.getAgeMin());
		tarjetaDTO.setAgeMax(tarjeta.getAgeMax());
		tarjetaDTO.setMonthlySalaryMin(tarjeta.getMonthlySalaryMin());
		tarjetaDTO.setMonthlySalaryMax(tarjeta.getMonthlySalaryMax());
		tarjetaDTO.setCreditCard(tarjeta.getCreditCard());
		return tarjetaDTO;
	}
}
