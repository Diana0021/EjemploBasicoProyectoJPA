package com.maven.jpa;

import javax.persistence.*;

//realizamos el respectivo mapeo...
@Entity
@Table(name="alumno")
public class Alumno {
	//declaramos sus atributos
	//Generamos la  llave primaria auto incrementable
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idalumno")
	private int idalumno;
	@Column (name="nombre")
	private String nombre;
	@Column (name="apellido")
	private String apellido;
	@Column (name="dni")
	private String dni;
	@Column (name="sexo")
	private String sexo;
	@Column (name="email")
	private String email;
	
	
	
	
	public Alumno() {
		//super();
	}//fin del constructor vacio
	
	
	public int getIdalumno() {
		return idalumno;
	}
	public Alumno(String nombre, String apellido, String dni, String sexo, String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.sexo = sexo;
		this.email = email;
	}//fin del constructor con parametros


	
	//metodos getter y setter
	public void setIdalumno(int idalumno) {
		this.idalumno = idalumno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
}// fin de la clase alumno
