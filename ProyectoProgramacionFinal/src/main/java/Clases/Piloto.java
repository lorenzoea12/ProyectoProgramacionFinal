package Clases;

import java.sql.ResultSet;


import java.sql.SQLException;
import java.sql.Statement;

import Excepciones.ApellidoInvalido;
import Excepciones.EdadInvalida;
import Utils.ConexionBD;

public  class Piloto extends Persona implements Comparable{
	private byte id;
	private String nombreEquipo;
	private String nombreCoche;
	private byte resistencia;
	private byte esperiencia;
	private short puntos;



	

	public Piloto(String dni, String nombre, int edad, String apellido, String nacionalidad, byte id, String  nombreEquipo,
			String nombreCoche, byte resistencia, byte esperiencia,short puntos) throws SQLException, ApellidoInvalido, EdadInvalida {
		super(dni, nombre, edad, apellido, nacionalidad);
			Statement smt=ConexionBD.conectar();
		
		if(smt.executeUpdate("insert into piloto (dni,nombre,edad,apellido,nacionalidad,id,nombreEquipo,nombreCoche,resistencia,esperiencia,puntos) values('"
				+dni+"','"+nombre+"','"+edad+"','"+apellido+"','"+nacionalidad+"','"+id+"','"+nombreEquipo+"','"+nombreEquipo+"','"+resistencia+"','"+esperiencia+"','"+puntos+"')")>0) {
			
			this.id = id;
			this.nombreEquipo = nombreEquipo;
			this.nombreCoche = nombreCoche;
			this.resistencia = resistencia;
			this.esperiencia = esperiencia;
			this.puntos=puntos;
			
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se ha podido insertar los datos ");
		}
	}
	
	
		
	
	public Piloto (byte id) throws SQLException   {
		Statement smt = ConexionBD.conectar();
		try {
			ResultSet cursor= smt.executeQuery(" SELECT * FROM piloto WHERE id="+id+";");
			if (cursor.next() ) {
				this.setNombre(cursor.getString("nombre")); 
				this.setEdad(cursor.getInt("edad"));
				this.setApellido(cursor.getString("apellido"));
				this.setNacionalidad(cursor.getString("nacionalidad"));
				this.setDni(cursor.getString("id"));
				this.nombreEquipo= cursor.getString("nombre");
				this.nombreCoche=cursor.getString("nombreCoche");
				this.resistencia=cursor.getByte("resistencia");
				this.esperiencia = cursor.getByte("experiencia");
				this.puntos=cursor.getShort("puntos");
			}	
		} catch (ApellidoInvalido e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EdadInvalida e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConexionBD.desconectar();
		}

	}
			
	

	
	
	public byte getId() {
		return id;
	}


	public void setId(byte id) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update piloto set id ="+id+" where id="+this.id+"")>0) {
			this.id=id;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar  el id del piloto ");
		}
}	
		
		
		
	

	public String getnombreEquipo() {
		return nombreEquipo;
	}


	public void setEquipo(String nombreEquipo) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update piloto set nombreEquipo ="+nombreEquipo+" where id="+this.id+"")>0) {
			this.nombreEquipo=nombreEquipo;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el equipo del piloto ");
		}
}	
	


	public String getnombreCoche() {
		return nombreCoche;
	}


	public void setCoche(String nombreCoche) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update piloto set coche="+nombreCoche+" where id="+this.id+"")>0) {
			this.nombreCoche=nombreCoche;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el nombre del coche  ");
		}
}	
		
	

	public byte getResistencia() {
		return resistencia;
	}


	public void setResistencia(byte resistencia) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update circuito set resistencia ="+resistencia+" where id="+this.id+"")>0) {
			this.resistencia=resistencia;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar la resistencia del piloto ");
		}
}	
		

	public byte getExperiencia() {
		return esperiencia;
	}


	public void setExperiencia(byte esperiencia) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update circuito set experiencia ="+esperiencia+" where id ="+this.id+"")>0) {
			this.esperiencia=esperiencia;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar  el lugar del circuito ");
			
		
		}
}	
	
	
	public short getPuntos() {
		return puntos;
	}




	public void setPuntos(short puntos) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update piloto set puntos ="+puntos+" where id ="+this.id+"")>0) {
			this.puntos=puntos;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar los puntos del piloto ");
			
		
		}
}	
		

	
	@Override
	public String toString() {
		return "Piloto [id=" + id + ", nombreEquipo=" + nombreEquipo + ", nombreCoche=" + nombreCoche + ", resistencia="
				+ resistencia + ", experiencia=" + esperiencia + ", puntos=" + puntos + "]";
	}

	

	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
	
