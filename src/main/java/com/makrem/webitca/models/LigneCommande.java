package com.makrem.webitca.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="lignescommandes")
public class LigneCommande {
	
	
	

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@NotNull
@Min(0)
private Integer quantity;

//@NotNull
//@Min(0)
private Double price;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "cod_article")
private Article article;

//
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "num_commande")
private Commande commande;



//Constructor 

public LigneCommande () {}




public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Integer getQuantity() {
	return quantity;
}

public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}

public Double getPrice() {
	return price;
}

public void setPrice(Double price) {
	this.price = price;
}

public Article getArticle() {
	return article;
}

public void setArticle(Article article) {
	this.article = article;
}

public Commande getCommande() {
	return commande;
}

public void setCommande(Commande commande) {
	this.commande = commande;
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




@Column(updatable=false)
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date createdAt;

@DateTimeFormat(pattern="yyyy-MM-dd")
private Date updatedAt;


}
