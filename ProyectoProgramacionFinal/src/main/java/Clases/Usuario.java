package Clases;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Excepciones.ContraseñaIncorrectaException;
import Excepciones.UsuarioNoExisteException;
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
		
	}
	
	
	public Usuario(String nombre,String contraseña) throws SQLException, ContraseñaIncorrectaException, UsuarioNoExisteException {
		Statement smt=ConexionBD.conectar();
ResultSet cursor=smt.executeQuery(" select * from usuario where nombre='"+nombre+"'");

		if(cursor.next()) {
			this.contraseña=cursor.getString("contraseña");
			if(!this.contraseña.equals(contraseña)){
				ConexionBD.desconectar();
				throw new  ContraseñaIncorrectaException (" La contraseña no es correcta ");
				
			}
			
		 this.nombre=cursor.getString("nombre");
	
			
			
		}else {
			ConexionBD.desconectar();
			throw new UsuarioNoExisteException(" No existe el nombre en la base de datos ");
		}
		ConexionBD.desconectar();

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
