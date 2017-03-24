package com.ipartek.formacion.perrera.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gato")
public class Gato {

	@Id
	@GeneratedValue
	private long id;

	@Basic
	@Column(name = "nombre")
	private String nombre;

	@Basic
	@Column(name = "raza")
	private String raza;

	public Gato() {
		super();
		this.id = 0;
		this.nombre = "";
		this.raza = "";
	}

	/**
	 * 
	 * @param nombre
	 * @param raza
	 */
	public Gato(String nombre, String raza) {
		super();
		this.nombre = nombre;
		this.raza = raza;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	/**
	 * Si id = 0 es nuevo gato que no se ha persistido en una BBDD, cualquier id
	 * superior a 0 es gato persistido
	 * 
	 * @return true si es nuevo, false si es existente
	 */
	public boolean isNew() {
		return this.id > 0 ? true : false;
	}

	@Override
	public String toString() {
		return "Gato [id=" + this.id + ", nombre=" + this.nombre + ", raza=" + this.raza + "]";
	}

}
