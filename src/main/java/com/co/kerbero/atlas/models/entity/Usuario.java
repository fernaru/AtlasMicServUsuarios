package com.co.kerbero.atlas.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {
	
	@Id
	private Long numIdenti;
	
	private String tipoIdenti;
	
	
	@Size(min=3, max=35)
	@Column(nullable=false)
	private String nombre;
	
	private String segundoNombre;
	
	
	@Size(min=3, max=35)
	@Column(nullable=false)
	private String apellido;
	
	private String segundoApellido;
	
	
	@Size(min=8, max=18)
	@Column(nullable=false, unique=true)
	private String username;
	
	
	@Size(min=8, max=18)
	@Column(nullable=false, unique=false)
	private String password;
	
	
	@Size(max=1)
	@Column(nullable=false, unique=false)
	private String estadoUser;
	
	
	@Email
	@Column(nullable=false, unique=true)
	private String email;
	
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@Column(name="modife_at")
	@Temporal(TemporalType.DATE)
	private Date modifeAt;
	
	@Temporal(TemporalType.DATE)
	private Date fechaExpeDocumento;
	
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@Temporal(TemporalType.DATE)
	private Date fechaConforEmpresa;
	
	
	@Column(nullable=false)
	private String telefono;
	
	
	private String celular;
	
	private String direccion;
	private String nombreEmpresa;
	private String direcEmpresa;
	private String telefEmpresa;
	
	
	private String nitEmpresa;
	
	@PrePersist
	public void prePersist(){
		createAt = new Date();
	}

	public Long getNumIdenti() {
		return numIdenti;
	}

	public void setNumIdenti(Long numIdenti) {
		this.numIdenti = numIdenti;
	}

	public String getTipoIdenti() {
		return tipoIdenti;
	}

	public void setTipoIdenti(String tipoIdenti) {
		this.tipoIdenti = tipoIdenti;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
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

	public String getEstadoUser() {
		return estadoUser;
	}

	public void setEstadoUser(String estadoUser) {
		this.estadoUser = estadoUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getModifeAt() {
		return modifeAt;
	}

	public void setModifeAt(Date modifeAt) {
		this.modifeAt = modifeAt;
	}

	public Date getFechaExpeDocumento() {
		return fechaExpeDocumento;
	}

	public void setFechaExpeDocumento(Date fechaExpeDocumento) {
		this.fechaExpeDocumento = fechaExpeDocumento;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaConforEmpresa() {
		return fechaConforEmpresa;
	}

	public void setFechaConforEmpresa(Date fechaConforEmpresa) {
		this.fechaConforEmpresa = fechaConforEmpresa;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getDirecEmpresa() {
		return direcEmpresa;
	}

	public void setDirecEmpresa(String direcEmpresa) {
		this.direcEmpresa = direcEmpresa;
	}

	public String getTelefEmpresa() {
		return telefEmpresa;
	}

	public void setTelefEmpresa(String telefEmpresa) {
		this.telefEmpresa = telefEmpresa;
	}

	public String getNitEmpresa() {
		return nitEmpresa;
	}

	public void setNitEmpresa(String nitEmpresa) {
		this.nitEmpresa = nitEmpresa;
	}
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7135653536416679743L;
}
