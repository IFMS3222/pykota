package br.edu.ifms.pykota.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */

@Entity
public class Users {
	@Id
	@GeneratedValue
	int id;
	
	@Column(length=255,unique=true,nullable=false)
	private String username;
	
	@Column
	private String email;
	
	@Column(nullable=true)
	private Float balance;
	
	@Column(nullable=true)
	private Float lifetimepaid;
	
	@Column(length = 30)
	private String limitby;
	
	@Column
	private String description;
	
	@Transient
	private Float overcharge;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public Float getLifetimepaid() {
		return lifetimepaid;
	}

	public void setLifetimepaid(Float lifetimepaid) {
		this.lifetimepaid = lifetimepaid;
	}

	public String getLimitby() {
		return limitby;
	}

	public void setLimitby(String limitby) {
		this.limitby = limitby;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getOvercharge() {
		return overcharge;
	}

	public void setOvercharge(Float overcharge) {
		this.overcharge = overcharge;
	}
	
}