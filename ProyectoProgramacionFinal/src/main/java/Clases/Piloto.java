package Clases;

import java.sql.ResultSet;
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
		if(smt.executeUpdate("insert into persona (nombre,edad,apellido,nacionalidad,dni,equipo,coche,edad,apellido,nacionalidad) values  ('"
				+nombre+"','"+edad+"','"+apellido+"','"+nacionalidad+"','"+dni+"','"+equipo.getNombre()+"','"+coche.getNombre()+"','"+resistencia+"','"+experiencia+"')")>0) {
			this.equipo = equipo;
			this.coche = coche;
			this.resistencia = resistencia;
			this.experiencia = experiencia;
		
			
		}else {
			ConexionBD.desconectar();
			throw new SQLException("Error al insertar datos.");
			
		}
	
	}	
	public Piloto(String nombre) {
		
	
	Statement smt = ConexionBD.conectar();
	
	
		ResultSet cursor = smt.executeQuery("SELECT * FROM piloto WHERE nombre =" + nombre+";");
		
		if (cursor.next() ) {
			
		}
			this.resistencia = cursor.getByte(resistencia);
			this.experiencia = cursor.getByte(experiencia);
			
	

}

		
	
		
		
		
	


	public Equipo getEquipo() {
		return equipo;
	}
	
	
	public void setEquipo(Equipo equipo) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update piloto set equipo='"+equipo+"' where nombre = "+this.nombre+"")>0) {
			this.equipo=equipo;
		
		}
		else {
			ConexionBD.desconectar();
			throw new SQLException("No se pudo cambiar el equipo del piloto");
		}
		ConexionBD.desconectar();
}
		
	
	
	
	public Coche getCoche() {
		return coche;
	}
	
	
	public void setCoche(Coche coche) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update piloto set coche='"+coche+"' where nombre = "+this.nombre+"")>0) {
			this.coche=coche;
		
		}
		else {
			ConexionBD.desconectar();
			throw new SQLException("No se pudo cambiar el coche del piloto");
		}
		ConexionBD.desconectar();
}
		
	
	
	
	public byte getResistencia() {
		return resistencia;
	}
	
	
	public void setResistencia(byte resistencia) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update piloto set resistencia='"+resistencia+"' where nombre = "+this.nombre+"")>0) {
			this.resistencia=resistencia;
		
		}
		else {
			ConexionBD.desconectar();
			throw new SQLException("No se pudo cambiar la resistencia del piloto");
		}
		ConexionBD.desconectar();
}
	
	
	
	
	public byte getExperiencia() {
		return experiencia;
	}
	
	
	public void setExperiencia(byte experiencia) throws SQLException {
		this.experiencia = experiencia;
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update piloto set experiencia='"+experiencia+"' where nombre = "+this.nombre+"")>0) {
			this.experiencia=experiencia;
		
		}
		else {
			ConexionBD.desconectar();
			throw new SQLException("No se pudo cambiar el coche del piloto");
		}
		ConexionBD.desconectar();
}
	
	
	
	@Override
	public String toString() {
		return "Piloto [equipo=" + equipo + ", coche=" + coche + ", resistencia=" + resistencia + ", experiencia="
				+ experiencia + "]";
	}

	

}
