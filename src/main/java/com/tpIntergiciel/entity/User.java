package com.tpIntergiciel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.tpIntergiciel.entity.User;

/**
 * Created by abdel on 18/12/2016.
 */
@Entity
public class User {
	@Id
	@GeneratedValue
	private long idClient;
	private String nom;
	private String prenom;
	private String username;
	private String password;

	public User() {
	}

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User{" +
				"idClient=" + idClient +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
