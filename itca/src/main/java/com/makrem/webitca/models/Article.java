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
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "articles")

public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "designation is required!")
	@Size(min = 3, max = 30, message = "designation must be between 3 and 30 characters")
	private String designation;

	@NotNull
	@Min(0)
	private Integer quantity;

	@NotNull
	@Min(0)
	private Double price;
	

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	// M:1

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_famille")
	private Famillearticle famillearticle;
	
	@OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
	private List<LigneCommande> lignecommande;

	// constructor

	public Article() {
	
	
	}
	




	public List<LigneCommande> getLignecommande() {
		return lignecommande;
	}





	public void setLignecommande(List<LigneCommande> lignecommande) {
		this.lignecommande = lignecommande;
	}





	public void setPrice(Double price) {
		this.price = price;
	}


	public Long getId() {
		return id;
	}


@PrePersist
protected void onCreate(){
    this.createdAt = new Date();
}
@PreUpdate
protected void onUpdate(){
    this.updatedAt = new Date();
}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
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

	public Famillearticle getFamillearticle() {
		return famillearticle;
	}

	public void setFamillearticle(Famillearticle famillearticle) {
		this.famillearticle = famillearticle;
	}

}
