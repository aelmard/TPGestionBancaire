package com.tpIntergiciel.model;

import javax.persistence.*;

import java.util.List;

/**
 * Created by abdel on 18/12/2016.
 */
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idClient;
	private String nom;
	private String prenom;
	private String username;
	private String password;

	@OneToMany()
	private List<Compte> listComptes;

	public User() {
	}

	public User(User user) {
		this.idClient = user.idClient;
		this.nom = user.nom;
		this.prenom = user.prenom;
		this.username = user.username;
		this.password = user.password;
		this.listComptes = user.listComptes;
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

	public List<Compte> getListComptes() {
		return listComptes;
	}

	public void setListComptes(List<Compte> listComptes) {
		this.listComptes = listComptes;
	}
}
