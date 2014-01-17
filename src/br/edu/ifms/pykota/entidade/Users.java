package br.edu.ifms.pykota.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



//import javax.persistence.*;
//@Entity
//@Table(name = "billingcodes")

@Entity
public class Users {
	
	@Id
	@GeneratedValue
	int id;
	
	@Column
	String Username;
	
	public String getUsername() {
		return Username;
	}

	public void setUsername(String Username) {
		this.Username = Username;
	}
}
