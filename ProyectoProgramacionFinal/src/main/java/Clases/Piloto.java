package Clases;

import java.sql.SQLException;
import java.sql.Statement;

import Excepciones.ApellidoInvalido;
import Excepciones.EdadInvalida;
import Utils.ConexionBD;

public class Piloto extends Persona {
	private Equipo equipo;
	private Coche coche;
	private byte resistencia;
	private byte experiencia;
	


	public Piloto(String nombre, int edad, String apellido, String nacionalidad, String dni, Equipo equipo, Coche coche,
			byte resistencia, byte experiencia) throws SQLException, ApellidoInvalido, EdadInvalida {
		super(nombre, edad, apellido, nacionalidad, dni);
		
		Statement smt = ConexionBD.conectar();
		if(smt.executeUpdate("insert into persona (equipo,n,edad,apellido,nacionalidad) values  ('"
				+equipo.getNombre()+"','"+coche.getNombre()+"','"+resistencia+"','"+experiencia+"')")>0) {
			this.equipo = equipo;
			this.coche = coche;
			this.resistencia = resistencia;
			this.experiencia = experiencia;
			ConexionBD.desconectar();
			
		}
	
	
		
		
	
		
		
		
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
