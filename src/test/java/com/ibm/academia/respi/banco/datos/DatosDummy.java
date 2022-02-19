package com.ibm.academia.respi.banco.datos;

import com.ibm.academia.respi.banco.modelo.entidades.Tarjeta;

public class DatosDummy 
{
	public static Tarjeta tarjeta01() 
	{
		return new Tarjeta(1, "Shopping", 7000, 14999, 18, 23, "B.smart,AfinityCard");
	}
	public static Tarjeta tarjeta02() 
	{
		return new Tarjeta(2, "Shopping", 7000, 14999, 24, 32, "B.smart,ClasicaAfinityCard,Office Deapot,Costco,BestBuy,Banamex,The Home Deapot");
	}
}
