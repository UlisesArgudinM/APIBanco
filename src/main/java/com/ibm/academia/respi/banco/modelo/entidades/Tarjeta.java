package com.ibm.academia.respi.banco.modelo.entidades;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
@Entity
@Table(name="tarjetas",schema="banco")
public class Tarjeta {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "tuPasion", nullable = false, length = 150)
	private String tuPasion;
	
	@Column(name = "salarioMensualMin", nullable = false)
	private double salarioMensualMin;
	
	@Column(name = "salarioMensualMax", nullable = false)
	private double salarioMensualMax;
	
	@Column(name = "anioMin", nullable = false)
	private double anioMin;
	
	@Column(name = "anioMax", nullable = false)
	private double anioMax;
	
	@Column(name = "tarjetaCredito", nullable = false, length = 150)
	private String tarjetaCredito;

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tarjeta [id=");
		builder.append(id);
		builder.append(", tuPasion=");
		builder.append(tuPasion);
		builder.append(", salarioMensualMin=");
		builder.append(salarioMensualMin);
		builder.append(", salarioMensualMax=");
		builder.append(salarioMensualMax);
		builder.append(", anioMin=");
		builder.append(anioMin);
		builder.append(", anioMax=");
		builder.append(anioMax);
		builder.append(", tarjetaCredito=");
		builder.append(tarjetaCredito);
		builder.append("]");
		return builder.toString();
	}
	
	public Tarjeta(long id, String tuPasion, double salarioMensualMin, double salarioMensualMax, double anioMin,
			double anioMax, String tarjetaCredito) {
		this.id = id;
		this.tuPasion = tuPasion;
		this.salarioMensualMin = salarioMensualMin;
		this.salarioMensualMax = salarioMensualMax;
		this.anioMin = anioMin;
		this.anioMax = anioMax;
		this.tarjetaCredito = tarjetaCredito;
	}
	


	@Override
	public int hashCode() {
		return Objects.hash(id, tuPasion);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Tarjeta))
			return false;
		Tarjeta other = (Tarjeta) obj;
		return id == other.id && Objects.equals(tuPasion, other.tuPasion);
	}





	



	



	
	
}