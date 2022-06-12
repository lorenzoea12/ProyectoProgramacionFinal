package Clases;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Utils.ConexionBD;

public class Carrera {
	private  byte numeroCarrera;
	private  byte numeroCircuito;
	private  String nombreEquipo;
	
	
	
	
	
	
	

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
	
	

	public byte getNumeroCarrera() {
		return numeroCarrera;
	}
	
	
	public void setNumeroCarrera(byte numeroCarrera) {
		this.numeroCarrera = numeroCarrera;

	}
	
	
	public byte getNumeroCircuito() {
		return numeroCircuito;
	}
	
	
	public void setNumeroCircuito(byte numeroCircuito) {
		this.numeroCircuito = numeroCircuito;
	}
	
	
	public String getNombreEquipo() {
		return nombreEquipo;
	}
	
	
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Carrera [numeroCarrera=" + numeroCarrera + ", numeroCircuito=" + numeroCircuito + ", nombreEquipo="
				+ nombreEquipo + "]";
	}

	
	
	
	

}
