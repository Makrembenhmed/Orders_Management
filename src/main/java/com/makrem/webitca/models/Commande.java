package com.makrem.webitca.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="commandes")
public class Commande {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotBlank(message="description obligatoire")
@Size(min=4 , max=100 )
private String description;

@NotNull(message="null interdit introduire date liv souhaiter")
@DateTimeFormat(pattern="yyyy-MM-dd")
private  Date datecommande;
// M:1
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="client_id")

private Client acheteur;

//


@OneToMany(mappedBy = "commande", fetch = FetchType.LAZY)
private List<LigneCommande> lignecommande;


//Constructor 

public Commande () {}



public List<LigneCommande> getLignecommande() {
	return lignecommande;
}

public void setLignecommande(List<LigneCommande> lignecommande) {
	this.lignecommande = lignecommande;
}



@Column(updatable=false)
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date createdAt;

@DateTimeFormat(pattern="yyyy-MM-dd")
private Date updatedAt;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}



public Date getDatecommande() {
	return datecommande;
}

public void setDatecommande(Date datecommande) {
	this.datecommande = datecommande;
}

public Client getAcheteur() {
	return acheteur;
}

public void setAcheteur(Client acheteur) {
	this.acheteur = acheteur;
}

public Date getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

public Date getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}


}
