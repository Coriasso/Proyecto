package com.iesvirgendelcarmen.ejercicios.Proyecto;

public class Persona {
	private String nombre;
	private String apellido;
	private String dni;
	private String email;
	
	
	
	
	
	
	public Persona(String nombre, String apellido, String dni, String email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
	}
	
	




	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", DNI=" + dni + ", email=" + email + "]";
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
	public String getdni() {
		return dni;
	}
	public void setDNI(String dNI) {
		dni = dNI;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
