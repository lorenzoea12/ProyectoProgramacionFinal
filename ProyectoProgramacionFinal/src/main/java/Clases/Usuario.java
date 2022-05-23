package Clases;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Excepciones.Contrase�aIncorrectaException;
import Excepciones.UsuarioNoExisteException;
import Utils.ConexionBD;

public class Usuario {
	
	private String nombre;
	private String contrase�a;
	private Partida partida;
	
	
	
	
	

	public Usuario(String nombre, String contrase�a, Partida partida) throws SQLException {
		super();
		
		Statement smt=ConexionBD.conectar();
		
		if(smt.executeUpdate("insert into usuario values('"
				+nombre+"','"+contrase�a+"','"+partida+"')")>0) {
			this.nombre = nombre;
			this.contrase�a = contrase�a;
			this.partida = partida;
			
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se ha podido insertar ");
		}
		
	}
	
	
	public Usuario(String nombre,String contrase�a) throws SQLException, Contrase�aIncorrectaException, UsuarioNoExisteException {
		Statement smt=ConexionBD.conectar();
ResultSet cursor=smt.executeQuery(" select * from usuario where nombre='"+nombre+"'");

		if(cursor.next()) {
			this.contrase�a=cursor.getString("contrase�a");
			if(!this.contrase�a.equals(contrase�a)){
				ConexionBD.desconectar();
				throw new  Contrase�aIncorrectaException (" La contrase�a no es correcta ");
				
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
	
	
	
	public String getContrase�a() {
		return contrase�a;
	}
	
	
	
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	
	
	
	public Partida getPartida() {
		return partida;
	}
	
	
	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	
	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", contrase�a=" + contrase�a + ", partida=" + partida + "]";
	}


}
