package Clases;

import java.sql.SQLException;

import Excepciones.ApellidoInvalido;
import Excepciones.EdadInvalida;

public class Piloto extends Persona {
	private Equipo equipo;
	private Coche coche;
	private byte resistencia;
	private byte experiencia;
	
	

	


	public Piloto(String nombre, byte edad, String apellido, String nacionalidad, String dni, Equipo equipo,
			Coche coche, byte resistencia, byte experiencia) throws SQLException, ApellidoInvalido, EdadInvalida {
		super(nombre, edad, apellido, nacionalidad, dni);
		this.equipo = equipo;
		this.coche = coche;
		this.resistencia = resistencia;
		this.experiencia = experiencia;
	}


	public Equipo getEquipo() {
		return equipo;
	}
	
	
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	
	public Coche getCoche() {
		return coche;
	}
	
	
	public void setCoche(Coche coche) {
		this.coche = coche;
	}
	
	
	public byte getResistencia() {
		return resistencia;
	}
	
	
	public void setResistencia(byte resistencia) {
		this.resistencia = resistencia;
	}
	
	
	public byte getExperiencia() {
		return experiencia;
	}
	
	
	public void setExperiencia(byte experiencia) {
		this.experiencia = experiencia;
	}
	
	
	@Override
	public String toString() {
		return "Piloto [equipo=" + equipo + ", coche=" + coche + ", resistencia=" + resistencia + ", experiencia="
				+ experiencia + "]";
	}

	

}
