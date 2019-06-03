package com.co.kerbero.atlas.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="producto")
public class Product implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=3, max=35)
	@Column(nullable=false)
	private String nomProdu;
	
	@Size(min=3, max=35)
	@Column(nullable=false)
	private String marca;
	
	@Size(min=3, max=35)
	@Column(nullable=false)
	private String precio;
	
	@Size(min=3, max=35)
	@Column(nullable=false)
	private String tipoProduct;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNomProdu() {
		return nomProdu;
	}

	public void setNomProdu(String nomProdu) {
		this.nomProdu = nomProdu;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getTipoProduct() {
		return tipoProduct;
	}

	public void setTipoProduct(String tipoProduct) {
		this.tipoProduct = tipoProduct;
	}





	/**
	 * 
	 */
	private static final long serialVersionUID = 7985047951520867387L;
}
