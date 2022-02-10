package com.ibm.academia.respi.banco.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
@Entity
@Table(name="tarjetas",schema="banco")
@AllArgsConstructor
public class Tarjeta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
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

	
	
}