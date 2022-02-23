package com.ibm.academia.respi.banco.modelo.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TarjetaDTO implements Serializable 
{
	
	private Long tarjetaId;
	private String tarjetaCredito;
	
	private static final long serialVersionUID = -1434956835503150508L;

}
