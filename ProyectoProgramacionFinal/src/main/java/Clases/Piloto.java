package Clases;

import java.sql.ResultSet;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Excepciones.ApellidoInvalido;
import Excepciones.ContraseñaInvalida;
import Excepciones.EdadInvalida;
import Excepciones.NombreInvalidoException;
import Utils.ConexionBD;


/**
 * Clase que contiene los métodos necesarios para tratar con un piloto y con la
 * base de datos.
 * 
 * @author Lorenzo Escobar Arroyo
 *
 */


public  class Piloto extends Persona {
	private byte id;
	private String nombreEquipo;
	private String nombreCoche;
	private byte resistencia;
	private byte esperiencia;
	private short puntos;
	
	/**
	 * Constructor que nos inicializa las variables internas con las variables
	 * recibidas por parámetros
	 * 
	 * @param id   			Variable que utilizo para el id del piloto
	 * @param nombreEquipo  Variable que utilizo para el nombre del equipo del piloto
	 *@param nombreCoche    Variable que utilizo para el nombre del coche del piloto
	 * @param resistencia  Variable que utilizo para la resistencia para el piloto
	 * @throws IOException 
	 */
	
	
	
	
public Piloto() {
	
}
/**
 * Este metodo es un constructor que realizo que esta vacio 
 * para poder utilizarlo en cualquier momento 
 */



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
				this.setDni(cursor.getString("Dni"));
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
			
	


	/**
	 * Metodo que nos devuelve el id del piloto
	 * @return id del piloto
	 */
	
	public byte getId() {
		return id;
	}
	/**
	 * Metodo el cual utilizo para poder actualizar la variable id mientras la clave primaria
	 * de la base de datos sea id
	 * @param id Variable que empleo para el piloto
	 * @throws SQLException exception que empleo para la base de datos 
	 */

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
		
		
		
	
	/**
	 * Metodo que nos devuelve el nombreEquipo del piloto
	 * @return  nombreEquipo del piloto
	 */
	public String getnombreEquipo() {
		return nombreEquipo;
	}

	/**
	 * Metodo el cual utilizo para poder actualizar la variable nombreEquipo mientras la clave primaria
	 * de la base de datos sea id
	 * @param nombreEquipo Variable que empleo para el piloto
	 * @throws SQLException exception que empleo para la base de datos 
	 */

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
	

	/**
	 * Metodo que nos devuelve el nombreCoche del piloto
	 * @return nombreCoche del piloto
	 */
	public String getnombreCoche() {
		return nombreCoche;
	}
	/**
	 * Metodo el cual utilizo para poder actualizar la variable nombreCoche mientras la clave primaria
	 * de la base de datos sea id
	 * @param nombreCoche Variable que empleo para el piloto
	 * @throws SQLException exception que empleo para la base de datos 
	 */

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
		
	/**
	 * Metodo que nos devuelve la restencia  del piloto
	 * @return resistencia  del piloto
	 */

	public byte getResistencia() {
		return resistencia;
	}
	/**
	 * Metodo el cual utilizo para poder actualizar la variable resistencia mientras la clave primaria
	 * de la base de datos sea id
	 * @param resistencia Variable que empleo para el piloto
	 * @throws SQLException exception que empleo para la base de datos 
	 */

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
		
	/**
	 * Metodo que nos devuelve el experiencia del piloto
	 * @return experiencia del piloto
	 */
	public byte getExperiencia() {
		return esperiencia;
	}


	/**
	 * Metodo el cual utilizo para poder actualizar la variable Experiencia mientras la clave primaria
	 * de la base de datos sea id
	 * @param  esperiencia Variable que empleo para el piloto
	 * @throws SQLException exception que empleo para la base de datos 
	 */
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
	/**
	 * Metodo que nos devuelve el puntos del piloto
	 * @return puntos del piloto
	 */
	
	public short getPuntos() {
		return puntos;
	}


	/**
	 * Metodo el cual utilizo para poder actualizar la variable puntos mientras la clave primaria
	 * de la base de datos sea id
	 * @param puntos Variable que empleo para el piloto
	 * @throws SQLException exception que empleo para la base de datos 
	 */

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

	

	

	
	
	
	
	
	
	
	
	
	
	
	
}
	
