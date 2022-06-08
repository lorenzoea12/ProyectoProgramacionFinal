package Clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Enums.Neumaticos;
import Utils.ConexionBD;

public class Coche  {
	private String nombre;
	private Equipo escuderia;
	private String color;
	private Enum neumaticos;
	private byte caballos;
	private Piloto piloto;
	private byte maniobrabilidad;

	
	//retocar escuderia el get y el get de pilotos 
	public Coche( String nombre,Equipo escuderia, String color, Enum neumaticos, byte caballos, Piloto piloto, byte maniobrabilidad) throws SQLException {
		super();

		Statement smt=ConexionBD.conectar();
		
		if(smt.executeUpdate("insert into coche (nombre,nombreEscuderia,color,caballos,neumaticos,nombrePiloto,maniobralidad values('"
				+nombre+"','"+escuderia.getNombre()+"','"+color+"','"+caballos+"','"+neumaticos.toString()+"','"+piloto.getNombre()+"','"+maniobrabilidad+"')")>0) {
			this.nombre=nombre;
			this.escuderia = escuderia;
			this.color = color;
			this.neumaticos = neumaticos;
			this.caballos = caballos;
			this.piloto = piloto;
			this.maniobrabilidad = maniobrabilidad;
		
		
			
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se ha podido insertar ");
		}
		
	}
	
	public Coche(String nombre) {
		Statement smt = ConexionBD.conectar();
		try {
			ResultSet cursor = smt.executeQuery("SELECT * FROM coche WHERE nombre =" + nombre +";");
			
			if (cursor.next() ) {
				
				this.escuderia=cursor.getEquipo("escuderia")
				this.rectas = cursor.getByte("rectas");
				this.curvas = cursor.getByte("curvas");
				this.dificultad=cursor.getString("dificultad");
				this.longitud=cursor.getFloat("longitud");
			
			}	
		} finally {
			ConexionBD.desconectar();
		}
	}
	
	}
		

	
	
	

	


	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public Equipo getEscuderia() {
		return escuderia;
	}




	public void setEscuderia(Equipo escuderia) {
		this.escuderia = escuderia;
	}




	public String getColor() {
		return color;
	}




	public void setColor(String color) {
		this.color = color;
	}




	public Enum getNeumaticos() {
		return neumaticos;
	}




	public void setNeumaticos(Enum neumaticos) {
		this.neumaticos = neumaticos;
	}




	public byte getCaballos() {
		return caballos;
	}




	public void setCaballos(byte caballos) {
		this.caballos = caballos;
	}




	public Piloto getPiloto() {
		return piloto;
	}




	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}




	public byte getManiobrabilidad() {
		return maniobrabilidad;
	}




	public void setManiobrabilidad(byte maniobrabilidad) {
		this.maniobrabilidad = maniobrabilidad;
	}





	
	@Override
	public String toString() {
		return "Coche [nombre=" + nombre + ", escuderia=" + escuderia + ", color=" + color + ", neumaticos="
				+ neumaticos + ", caballos=" + caballos + ", piloto=" + piloto + ", maniobrabilidad=" + maniobrabilidad
				+ "]";
	}


	
	
}
