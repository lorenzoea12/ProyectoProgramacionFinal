package Clases;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Excepciones.ContraseñaInvalida;
import Utils.ConexionBD;

public class Carrera {
	private  byte numeroCarrera;
	private  byte numeroCircuito;
	private  String nombreEquipo;
	
	
	
	public Carrera() {
		
	}
	
	

	public Carrera(byte numeroCarrera, byte numeroCircuito, String nombreEquipo) throws SQLException {
		super();
		
			Statement smt=ConexionBD.conectar();
		
		if(smt.executeUpdate("insert into carrera (numeroCarrera,numeroCircuito,nombreEquipo) values('"
				+numeroCarrera+"','"+numeroCircuito+"','"+nombreEquipo+"')")>0) {
			this.numeroCarrera = numeroCarrera;
			this.numeroCircuito = numeroCircuito;
			this.nombreEquipo = nombreEquipo;
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se ha podido insertar lo datos ");
		}
	}
	
	public Carrera(String numeroCarrera) throws SQLException {
		Statement smt = ConexionBD.conectar();
		try {
			ResultSet cursor = smt.executeQuery("SELECT * FROM carrera WHERE  numeroCarrera ='" + numeroCarrera +"' ;");
			
			if (cursor.next() ) {
			this.numeroCircuito=cursor.getByte("numeroCircuito");
			this.nombreEquipo=cursor.getString("nombreEquipo");
			
			}	
		} finally {
			ConexionBD.desconectar();
		}
	}
	
	
	/**
	 * Metodo que nos devuelve el NumeroCarrera de Carrera
	 * @return numeroCarrera variable de carrera
	 * 
	 */
	

	public byte getNumeroCarrera() {
		return numeroCarrera;
	}
	
	
	public void setNumeroCarrera(byte numeroCarrera) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update carrera set numeroCarrera="+numeroCarrera+" where numeroCarrera="+this.numeroCarrera+"")>0) {
			this.numeroCarrera=numeroCarrera;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el numero de la  carrera ");
		}
}	
	/**
	 * Metodo que nos devuelve el NumeroCircuito de Carrera
	 * @return numeroCircuito variable de carrera
	 * 
	 */
	public byte getNumeroCircuito() {
		return numeroCircuito;
	}
	
	
	public void setNumeroCircuito(byte numeroCircuito) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update carrera set numeroCircuito="+numeroCircuito+" where numeroCarrera="+this.numeroCarrera+"")>0) {
			this.numeroCircuito=numeroCircuito;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el numero del circuito de  la  carrera ");
		}
}	
		
	
	/**
	 * Metodo que nos devuelve el NombreEquipo de Carrera
	 * @return nombreEquipo variable de carrera
	 * 
	 */
	public String getNombreEquipo() {
		return nombreEquipo;
	}
	
	/**
	 * Metodo el cual utilizo para poder actualizar la variable NombreEquipo mientras la clave primaria
	 * de la base de datos sea numeoCarrera
	 * @param contraseña Variable que empleo para el usuario
	 * @throws ContraseñaInvalida excepcion que utilizo para que la contraseña no tenga menos de tres caracteres
	 * @throws SQLException exception que empleo para la base de datos 
	 */
	public void setNombreEquipo(String nombreEquipo) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update carrera set nombreEquipo="+nombreEquipo+" where numeroCarrera="+this.numeroCarrera+"")>0) {
			this.nombreEquipo=nombreEquipo;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el numero de la  carrera ");
		}
}	
	
	
	
	public static ArrayList<Carrera> getTodos() {
		ArrayList<Carrera> ret=new ArrayList<Carrera>();
		
		Statement smt=ConexionBD.conectar();
		
		try {
			ResultSet cursor=smt.executeQuery("select * from Carrera");
			while(cursor.next()) {
				Carrera e=new Carrera();
				e.numeroCarrera=cursor.getByte("numeroCarrera");
				e.numeroCircuito=cursor.getByte("numeroCircuito");
				e.nombreEquipo=cursor.getString("nombreEquipo");
			
				
			}
			
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		ConexionBD.desconectar();
		
		return ret;
	}

	
	
	
	
	@Override
	public String toString() {
		return "Carrera [numeroCarrera=" + numeroCarrera + ", numeroCircuito=" + numeroCircuito + ", nombreEquipo="
				+ nombreEquipo + "]";
	}

	
	
	
	

}
