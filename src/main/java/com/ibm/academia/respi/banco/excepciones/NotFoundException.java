package com.ibm.academia.respi.banco.excepciones;

public class NotFoundException extends RuntimeException 
{
	
	

	public NotFoundException(String mensaje)
	{
		super(mensaje);
	}
	private static final long serialVersionUID = 6345305208150483726L;
	
}