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
	private double monthlySalaryMin;
	
	@Column(name = "salarioMensualMax", nullable = false)
	private double monthlySalaryMax;
	
	@Column(name = "anioMin", nullable = false)
	private double ageMin;
	
	@Column(name = "anioMax", nullable = false)
	private double ageMax;
	
	@Column(name = "tarjetaCredito", nullable = false, length = 150)
	private String creditCard;

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tarjeta [id=");
		builder.append(id);
		builder.append(", tuPasion=");
		builder.append(tuPasion);
		builder.append(", monthlySalaryMin=");
		builder.append(monthlySalaryMin);
		builder.append(", monthlySalaryMax=");
		builder.append(monthlySalaryMax);
		builder.append(", ageMin=");
		builder.append(ageMin);
		builder.append(", ageMax=");
		builder.append(ageMax);
		builder.append(", creditCard=");
		builder.append(creditCard);
		builder.append("]");
		return builder.toString();
	}
	
	public Tarjeta(long id, String tuPasion, double monthlySalaryMin, double monthlySalaryMax, double ageMin,
			double ageMax, String creditCard) {
		this.id = id;
		this.tuPasion = tuPasion;
		this.monthlySalaryMin = monthlySalaryMin;
		this.monthlySalaryMax = monthlySalaryMax;
		this.ageMin = ageMin;
		this.ageMax = ageMax;
		this.creditCard = creditCard;
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