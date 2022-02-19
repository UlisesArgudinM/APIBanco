package com.ibm.academia.respi.banco.excepciones;

public class BadRequestException extends RuntimeException
{
	
	

	public BadRequestException(String mensaje)
	{
		super(mensaje);
	}
	
	private static final long serialVersionUID = -5333073487731041745L;

}
