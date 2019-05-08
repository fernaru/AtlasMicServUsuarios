package com.co.kerbero.atlas.models.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="menu_item")
public class Menu {

	@NotNull
	private long id_menu;
	@NotNull
	private long id_menu_parent;
	@NotEmpty
	private String descripcion;
	@NotEmpty
	private String link;
	
	
	
	public long getId_menu() {
		return id_menu;
	}
	public void setId_menu(long id_menu) {
		this.id_menu = id_menu;
	}
	public long getId_menu_parent() {
		return id_menu_parent;
	}
	public void setId_menu_parent(long id_menu_parent) {
		this.id_menu_parent = id_menu_parent;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
	
}
