package com.ibm.academia.respi.banco.modelo.mapper;

import com.ibm.academia.respi.banco.modelo.dto.TarjetaDTO;
import com.ibm.academia.respi.banco.modelo.entidades.Tarjeta;

public class TarjetaMapper 
{
	public static TarjetaDTO mapTarjeta(Tarjeta tarjeta)
	{
		TarjetaDTO tarjetaDTO = new TarjetaDTO();
		tarjetaDTO.setTarjetaCredito(tarjeta.getTarjetaCredito());
		return tarjetaDTO;
	}
}
