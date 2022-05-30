package Clases;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

import Excepciones.ApellidoInvalido;
import Excepciones.EdadInvalida;
import Excepciones.NombreInvalidoException;
import Utils.ConexionBD;

public class Persona extends ElementoConNombre {
	private String dni;
	private byte edad;
	private String apellido;
	private String nacionalidad;
	
	


	public Persona(String nombre, byte edad, String apellido, String nacionalidad, String dni) throws SQLException, ApellidoInvalido, EdadInvalida {
		super(nombre);
		
		if(!edadValida(edad)) {
			throw new EdadInvalida("La edad no puede ser menos a 12 años ");
		}
		if(!apellidoValido(apellido)) {
			throw new ApellidoInvalido("El apellido no puede estar vacio");
		}
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("insert into persona (dni,nombre,edad,apellido,nacionalidad) values  ('"
				+dni+"','"+nombre+"''"+edad+"','"+apellido+"','"+nacionalidad+"')")>0) {
			this.dni=dni;
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
		
	
	private static boolean edadValida (byte edad) {
		return !(edad<12);
	}
	
	
	


	public byte getEdad() {
		return edad;
	}
	
	
	public void setEdad(byte edad) throws SQLException, EdadInvalida {
		if(!edadValida(edad)) {
			throw new EdadInvalida("La edad no puede ser menos a 12 años ");
		}
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


	
	private static boolean apellidoValido(String apellido) {
		return !apellido.isBlank();
	}
	
	
	public String getApellido() {
	
	
		return apellido;
	}
	
	
	public void setApellido(String apellido) throws SQLException, ApellidoInvalido {
		if(!apellidoValido(apellido)) {
			throw new ApellidoInvalido("El apellido no puede estar vacio");
		}
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
		throw new SQLException("No se pudo cambiar la nacionalidad");

	}
		
}
		
	
		public void eliminar() {
			Statement smt = ConexionBD.conectar();
			
			try {
				if (smt.executeUpdate("DELETE FROM persona WHERE dni =" + dni) > 0) {
					this.dni = null;
					this.nombre = null;
					this.edad = 0;
					this.apellido = null;
					this.nacionalidad=null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConexionBD.desconectar();
			}
	}



		@Override
		public String toString() {
			return "Persona [dni=" + dni + ", edad=" + edad + ", apellido=" + apellido + ", nacionalidad="
					+ nacionalidad + "]";
		}
	




	
	
}
