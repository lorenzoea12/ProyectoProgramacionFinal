package Clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Utils.ConexionBD;

public class Persona extends ElementoConNombre {
	private String dni;
	private byte edad;
	private String apellido;
	private String nacionalidad;
	
	


	public Persona(String nombre, byte edad, String apellido, String nacionalidad) throws SQLException {
		super(nombre);
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("insert into persona (dni,nombre,edad,apellido,nacionalidad)alues  ('"
				+nombre+"','"+edad+"','"+apellido+"','"+nacionalidad+"')")>0) {
			
			this.edad = edad;
			this.apellido = apellido;
			this.nacionalidad = nacionalidad;
		ConexionBD.desconectar();
			
			
		}else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido crear la persona");
			
		}
		

	}
	
	
	
	public String getDni() {
		return dni;
	}
	
	
	public void setDni(String dni) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update persona set dni="+dni+" where NumeroChip="+this.dni+"")>0) {
			this.dni=dni;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el dni o ya estaba asiganado ");
		}
}	
		
	
		
	


	public byte getEdad() {
		return edad;
	}
	
	
	public void setEdad(byte edad) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update mascota set raza='"+edad+"' where numeroChip = "+this.dni+"")>0) {
			this.edad=edad;
			ConexionBD.desconectar();
		}
		else {
			ConexionBD.desconectar();
			throw new SQLException("No se pudo cambiar la edad");
		}
	
}


	
	
	
	
	public String getApellido() {
	
	
		return apellido;
	}
	
	
	public void setApellido(String apellido) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update persona set apellido='"+apellido+"' where id="+this.dni+"")>0) {
		
			this.apellido = apellido;
			
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException("No se pudo cambiar el apellido");
		}
			
		
		this.apellido = apellido;
		
		ConexionBD.desconectar();
	}
	
	
	public String getNacionalidad() {
		return nacionalidad;
	}
	
	
	public void setNacionalidad(String nacionalidad) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update persona set nacionalidad='"+nacionalidad+"'where id="+dni+"")>0) {
		this.nacionalidad = nacionalidad;
		ConexionBD.desconectar();
		
	}else {
		ConexionBD.desconectar();
		throw new SQLException("No se pudo cambiar el usuario");

	}
		
}
		
	
	




	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", edad=" + edad + ", apellido=" + apellido + ", nacionalidad=" + nacionalidad
				+ "]";
	}
	
	
}
