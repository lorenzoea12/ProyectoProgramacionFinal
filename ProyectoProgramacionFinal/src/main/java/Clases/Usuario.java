package Clases;



import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Excepciones.ContraseñaIncorrectaException;
import Excepciones.ContraseñaInvalida;
import Excepciones.NombreInvalidoException;
import Excepciones.UsuarioNoExisteException;
import Utils.ConexionBD;

public class Usuario {
	
	private String nombre;
	private String contraseña;
	private Partida partida;
	
	
	
	
	

	public Usuario(String nombre, String contraseña, Partida partida) throws SQLException, ContraseñaInvalida, NombreInvalidoException {
		super();
		
		if(!nombreValido(nombre)) {
			throw new NombreInvalidoException("El nombre no puede estar vacio");
		}
		
		if(!contraseñaValida(contraseña)) {
			throw new ContraseñaInvalida (" La contraseña no puede tener menos de 3 caracteres ");
		}
		
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
	
	
	public Usuario(String nombre,String contraseña) throws SQLException, ContraseñaIncorrectaException, UsuarioNoExisteException, ContraseñaInvalida, NombreInvalidoException {
		
		if(!nombreValido(nombre)) {
			throw new NombreInvalidoException("El nombre no puede estar vacio");
		}
		
		if(!contraseñaValida(contraseña)) {
			throw new ContraseñaInvalida (" La contraseña no puede tener menos de 3 caracteres ");
		}
		Statement smt=ConexionBD.conectar();
ResultSet cursor=smt.executeQuery(" select * from usuario where nombre='"+nombre+"'");

		if(cursor.next()) {
			this.contraseña=cursor.getString("contraseña");
			if(!this.contraseña.equals(contraseña)){
				ConexionBD.desconectar();
				throw new  ContraseñaIncorrectaException (" La contraseña no es correcta ");
				
			}
			
		 this.nombre=cursor.getString("nombre");
		 this.contraseña=cursor.getString("contraseña");
		 this.partida=(Partida) cursor.getRowId("partida");
		 
	
			
			
		}else {
			ConexionBD.desconectar();
			throw new UsuarioNoExisteException(" No existe el nombre en la base de datos ");
		}
		ConexionBD.desconectar();

	}
	
	
	
	private static boolean nombreValido(String nombre) {
		return !nombre.isBlank();
	}
	
	
	
	public String getNombre() {
		return nombre;
	}
	
	
	
	
		public void setNombre(String nombre) throws SQLException, NombreInvalidoException {
			//Lo primero siempre actualizar el valor en BD, por si falla para no hacerlo
			//en java.
			if(!nombreValido(nombre)) {
				throw new NombreInvalidoException("El nombre no puede estar vacio");
			}
			Statement smt=ConexionBD.conectar();
			if(smt.executeUpdate("update usuario set nombre='"
			+nombre+"' where nombre='"+this.nombre+"'")>0) {
				//Solo modificamos si todo ha ido bien actualizando
				this.nombre = nombre;
			}else {
				ConexionBD.desconectar();
				throw new SQLException("No se ha podido cambiar el nombre");
			}
			ConexionBD.desconectar();
			
		}
	
	
	private static boolean contraseñaValida (String contraseña) {
		return !(contraseña.length()<3);
	}
	
	
	public String getContraseña() {
		return contraseña;
	}
	
	
	
	public void setContraseña(String contraseña) throws ContraseñaInvalida, SQLException {
		if(!contraseñaValida(contraseña)) {
			throw new ContraseñaInvalida (" La contraseña no puede tener menos de 3 caracteres ");
		}
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("update usuario set contraseña='"
		+contraseña+"' where nombre='"+this.nombre+"'")>0) {
			this.contraseña = contraseña;
		}else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido cambiar el password");
		}
		ConexionBD.desconectar();
	}
		
		
		
	
	
	
	
	public Partida getPartida() {
		return partida;
	}
	
	
	public void setPartida(Partida partida) throws SQLException {
		
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("update usuario set partida="
		+partida+" where nombre='"+this.nombre+"'")>0) {
			this.partida = partida;
		}else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido iniciar el valor partida ");
		}
		ConexionBD.desconectar();
	}
	
	
	public void eliminar() {
	
		Statement smt=ConexionBD.conectar();
		try {
	
			smt.executeUpdate("delete from usuario where nombre='"+this.nombre+"'");
			this.partida=null;
			this.nombre=null;
			this.contraseña=null;
		} catch (SQLException e) {
			// OJO, SI HEMOS HECHO EL DAO BIEN, NUNCA VA A ENTRAR EN ESTE CATCH
			//PORQUE EL EMAIL SIEMPRE VA A EXISTIR
			e.printStackTrace();
		}
		
		ConexionBD.desconectar();
	}
	
	
	
	public static ArrayList<Usuario> getTodos() {
		ArrayList<Usuario> ret=new ArrayList<Usuario>();
		
		Statement smt=ConexionBD.conectar();
		
		try {
			ResultSet cursor=smt.executeQuery("select * from usuario");
			while(cursor.next()) {
				Usuario u=new Usuario(nombre, contraseña, partida);
				u.nombre=cursor.getString("nombre");
				u.contraseña=cursor.getString("pass");
				u.partida=(Partida) cursor.getRowId("partida");
			
			}
			
		} catch (SQLException e) {
			// AQU� NO DEBER�A ENTRAR NUNCA PORQUE LA CONSULTA SIEMPRE VA A SER CORRECTA
			e.printStackTrace();
		}
		
		ConexionBD.desconectar();
		
		return ret;
	}


	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", contraseña=" + contraseña + ", partida=" + partida + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
		
		
	


}
