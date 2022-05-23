package Clases;



import java.sql.SQLException;
import java.sql.Statement;

import Utils.ConexionBD;

public class Usuario {
	
	private String nombre;
	private String contraseña;
	private Partida partida;
	
	
	
	
	

	public Usuario(String nombre, String contraseña, Partida partida) throws SQLException {
		super();
		
		Statement smt=ConexionBD.conectar();
		
		if(smt.executeUpdate("insert into usuario values('"
				+nombre+"','"+contraseña+"','"+partida+"')")>0) {
			this.nombre = nombre;
			this.contraseña = contraseña;
			this.partida = partida;
			
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se ha podido insertar ");
			
		}
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.partida = partida;
	}
	
	
	
	
	public String getNombre() {
		return nombre;
	}
	
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	public String getContraseña() {
		return contraseña;
	}
	
	
	
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
	
	public Partida getPartida() {
		return partida;
	}
	
	
	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	
	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", contraseña=" + contraseña + ", partida=" + partida + "]";
	}


}
