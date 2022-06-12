package Clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import Utils.ConexionBD;

public class Coche  {
	private String nombre;
	private String nombreEquipo;
	private String color;
	private String neumaticos;
	private byte caballos;
	private String nombrePiloto;
	private byte maniobrabilidad;

	
	

	public Coche( String nombre,String nombreEquipo, String color, String neumaticos, byte caballos, String  nombrePiloto, byte maniobrabilidad) throws SQLException {
		super();

		Statement smt=ConexionBD.conectar();
		
		if(smt.executeUpdate("insert into coche (nombre,nombreEquipo,color,neumaticos,caballos,nombrePiloto,maniobrabilidad) values('"
				+nombre+"','"+nombreEquipo+"','"+color+"','"+neumaticos+"','"+caballos+"','"+nombrePiloto+"','"+maniobrabilidad+"')")>0) {
			this.nombre=nombre;
			this.nombreEquipo = nombreEquipo;
			this.color = color;
			this.neumaticos = neumaticos;
			this.caballos = caballos;
			this.nombrePiloto = nombrePiloto;
			this.maniobrabilidad = maniobrabilidad;
		
		
			
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se ha podido insertar ");
		}
		
	}
	
	public Coche(String nombre) throws SQLException {
		Statement smt = ConexionBD.conectar();
		try {
			ResultSet cursor = smt.executeQuery("SELECT * FROM coche WHERE nombre =" + nombre +";");
			
			if (cursor.next() ) {
			this.nombreEquipo=cursor.getString("nombreEquipo");
			this.color=cursor.getString("color");
			this.neumaticos= cursor.getString("neumaticos");
			this.caballos=cursor.getByte("caballos");
			this.nombrePiloto=cursor.getString("nombrePiloto");
			this.maniobrabilidad=cursor.getByte("maniobrabilidad");
			}	
		} finally {
			ConexionBD.desconectar();
		}
	}
	
	


	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update coche set nombre="+nombre+" where  nombre="+this.nombre+"")>0) {
			this.nombre=nombre;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el nombre del coche  ");
		}
}	
	



	public String getnombreEquipo() {
		return nombreEquipo;
	}




	public void setEscuderia(String nombreEquipo) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update coche set nombreEquipo="+nombreEquipo+" where  nombre="+this.nombre+"")>0) {
			this.nombreEquipo=nombreEquipo;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar la escuderia del coche  ");
		}
}	
		



	public String getColor() {
		return color;
	}




	public void setColor(String color) throws SQLException {
		Statement smt=ConexionBD.conectar();
	if(smt.executeUpdate("Update coche set color="+color+" where  nombre="+this.nombre+"")>0) {
		this.color=color;
		ConexionBD.desconectar();
	}else {
		ConexionBD.desconectar();
		throw new SQLException(" No se pudo cambiar el color del coche ");
	}
}	
	




	public String getNeumaticos() {
		return neumaticos;
	}




	public void setNeumaticos(String neumaticos) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update coche set neumaticos="+neumaticos+" where  nombre="+this.nombre+"")>0) {
			this.neumaticos=neumaticos;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar los neumaticos del coche  ");
		}
}	
		



	public byte getCaballos() {
		return caballos;
	}




	public void setCaballos(byte caballos) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update coche set caballos="+caballos+" where  nombre="+this.nombre+"")>0) {
			this.caballos=caballos;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar los caballos del coche  ");
		}
}	
		


	public String getnombrePiloto() {
		return nombrePiloto;
	}




	public void setPiloto(String  nombrePiloto) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update coche set nombrePiloto="+nombrePiloto+" where  nombre="+this.nombre+"")>0) {
			this.nombrePiloto=nombrePiloto;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el piloto del coche ");
		}
}	
		



	public byte getManiobrabilidad() {
		return maniobrabilidad;
	}




	public void setManiobrabilidad(byte maniobrabilidad) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update coche set maniobrabilidad="+maniobrabilidad+" where  nombre="+this.nombre+"")>0) {
			this.maniobrabilidad=maniobrabilidad;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se puedo el lugar del circuito ");
		}
}	
		

	@Override
	public String toString() {
		return "Coche [nombre=" + nombre + ", nombreEquipo=" + nombreEquipo + ", color=" + color + ", neumaticos="
				+ neumaticos + ", caballos=" + caballos + ", nombrePiloto=" + nombrePiloto + ", maniobrabilidad="
				+ maniobrabilidad + "]";
	}

	
	


	
	
}
