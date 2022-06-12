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

/**
 * Clase que contiene los métodos necesarios para tratar con un usuario y con la
 * base de datos.
 * 
 * @author Lorenzo Escobar Arroyo
 *
 */

public class Usuario  {
	private String email;
	private String nombre;
	private String contraseña;
	
	
	/**
	 * Constructor que nos inicializa las variables internas con las variables
	 * recibidas por parámetros
	 * 
	 * @param email   Email del usuario en la aplicación para poderse registrar
	 * @param nombre     Nombre del usuario para iniciar sesión
	 * @param contraseña    contraseña con la cual utilizo para poderme registrar y iniciar sesion     
	 * @throws IOException
	 */
	
	/**
	 * Este metodo es un constructor que realizo que esta vacio 
	 * para poder utilizarlo en cualquier momento 
	 */
private Usuario() {
		
	}
	

/**
 * Metodo que utilizo para poder realizar los inserts en la base de datos y poder hacer el registro  de la persona
 * @param email Variable que utilizo para el Usuario
 * @param nombre Variable que utilizo para el Usuario
 * @param contraseña Variable que utilizo en el Usuario
 * @throws SQLException Excepcion que me lanza para la base de datos 
 * @throws ContraseñaInvalida Exception para que la contraseña no tenga menos de tres caracteres 
 * @throws NombreInvalidoException Exception para que el nombre no pueda estar blanco 
 */

	public Usuario(String email, String nombre,String contraseña) throws SQLException, ContraseñaInvalida, NombreInvalidoException {
		super();
		
		if(!nombreValido(nombre)) {
			throw new NombreInvalidoException("El nombre no puede estar vacio");
		}
		
		if(!contraseñaValida(contraseña)) {
			throw new ContraseñaInvalida (" La contraseña no puede tener menos de 3 caracteres ");
		}
		
		Statement smt=ConexionBD.conectar();
		
		if(smt.executeUpdate("insert into usuario values('"
				+email+"','"+nombre+"','"+contraseña+"')")>0) {
			this.email=email;
			this.nombre = nombre;
			this.contraseña = contraseña;
		
		
			
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se ha podido insertar ");
		}
		
	}
	
	
	/**
	 * Metodo que utilizo para el inicio de sesion de mi programa en el cual solo empleo el email y la contraseña debido 
	 * a que el email es mi clave primaria 
	 * @param email Variable que utilizo para el inicio de sesion y para el registro 
	 * @param contraseña variable que utilizo para el usuario
	 * @throws SQLException Exception que utilizo para que no me proteste la base de datos 
	 * @throws ContraseñaInvalida Excepcion que utilizo para que la contraseña no tenga menso de tres caracteres
	 
	 */
	
	public Usuario(String email,String contraseña) throws SQLException, ContraseñaIncorrectaException, UsuarioNoExisteException, ContraseñaInvalida, NombreInvalidoException {
		
		
		if(!contraseñaValida(contraseña)) {
			throw new ContraseñaInvalida (" La contraseña no puede tener menos de 3 caracteres ");
		}
		Statement smt=ConexionBD.conectar();
ResultSet cursor=smt.executeQuery(" select * from usuario where email='"+email+"'");

		if(cursor.next()) {
			this.contraseña=cursor.getString("contraseña");
			if(!this.contraseña.equals(contraseña)){
				ConexionBD.desconectar();
				throw new  ContraseñaIncorrectaException (" La contraseña no es correcta ");
				
			}
		 this.email=cursor.getString("email");
		 this.nombre=cursor.getString("nombre");
		 this.contraseña=cursor.getString("contraseña");
		
		 
	
			
			
		}else {
			ConexionBD.desconectar();
			throw new UsuarioNoExisteException(" No existe el nombre en la base de datos ");
		}
		ConexionBD.desconectar();

	}
	
	/**
	 * Metodo que realizo para que el nombre no este vacio y mas tarde llamarlo en los constructores que tengan 
	 * dicha variable
	 * @param nombre nombre que empleo para el usurio 
	 * @return Me devuelve el nombre para que no este vacio 
	 */
	
	private static boolean nombreValido(String nombre) {
		return !nombre.isBlank();
	}
	
	
	/**
	 * Metodo que nos devuelve el email del usuario
	 * @return Email del usuario
	 */
	
	public String getEmail() {
		return email;
	}

	
	
	/**
	 * Metodo el cual utilizo para poder actualizar la variable email mientras la clave primaria
	 * de la base de datos sea email
	 * @param email Es la variable que utilizo para el incio de sesion tanto como apra el registro 
	 * @throws SQLException Excepcion que viene por defecto para la conexion a la base de datos 
	 */
	public void setEmail(String email) throws SQLException {
				Statement smt=ConexionBD.conectar();
				if(smt.executeUpdate("update usuario set email='"
				+email+"' where email='"+this.email+"'")>0) {
					this.email = email;
				}else {
					ConexionBD.desconectar();
					throw new SQLException("No se ha podido cambiar el email");
				}
				ConexionBD.desconectar();
	}
	
 /**
  * Metodo que nos devuelve el nombre del usuario 
  * @return Nombre del usuario
  */
	public String getNombre() {
		return nombre;
	}
	
	
	/**
	 * Metodo el cual utilizo para poder actualizar la variable nombre mientras la clave primaria
	 * de la base de datos sea email
	 * @param nombre Variable que empleo para el usuario
	 * @throws SQLException Excepcion que viene por defecto para la conexion a la base de datos 
	 * @throws NombreInvalidoException Excepcion que uso para que el nombre no pueda estar vacio 
	 */
		public void setNombre(String nombre) throws SQLException, NombreInvalidoException {
			//Lo primero siempre actualizar el valor en BD, por si falla para no hacerlo
			//en java.
			if(!nombreValido(nombre)) {
				throw new NombreInvalidoException("El nombre no puede estar vacio");
			}
			Statement smt=ConexionBD.conectar();
			if(smt.executeUpdate("update usuario set nombre='"
			+nombre+"' where email='"+this.email+"'")>0) {
				//Solo modificamos si todo ha ido bien actualizando
				this.nombre = nombre;
			}else {
				ConexionBD.desconectar();
				throw new SQLException("No se ha podido cambiar el nombre");
			}
			ConexionBD.desconectar();
			
		}
	
	
		
		/**
		 * Metodo que realizo para que la contraseña no tenga menos de tres caracteres que mas tarde 
		 * lo aplicare en los contructores que contenga dicha variable 
		 * @param contraseña Variable que utilizo para el usuario
		 * @return Me devuelve que la contraseña no tenga menos de tres caracteres
		 */
	private static boolean contraseñaValida (String contraseña) {
		return !(contraseña.length()<3);
	}
	
	
	
	/**
	 * Metodo el cual nos devuelve la contraseña 
	 * @return contraseña del usuario
	 */
	public String getContraseña() {
		return contraseña;
	}
	
	
	/**
	 * Metodo el cual utilizo para poder actualizar la variable contraseña mientras la clave primaria
	 * de la base de datos sea email
	 * @param contraseña Variable que empleo para el usuario
	 * @throws ContraseñaInvalida excepcion que utilizo para que la contraseña no tenga menos de tres caracteres
	 * @throws SQLException exception que empleo para la base de datos 
	 */
	public void setContraseña(String contraseña) throws ContraseñaInvalida, SQLException {
		if(!contraseñaValida(contraseña)) {
			throw new ContraseñaInvalida (" La contraseña no puede tener menos de 3 caracteres ");
		}
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("update usuario set contraseña='"
		+contraseña+"' where email='"+this.email+"'")>0) {
			this.contraseña = contraseña;
		}else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido cambiar el password");
		}
		ConexionBD.desconectar();
	}
		
		
		
	
	
	
	
	
	/**
	 * Metodo el cual no sirve para poder eleminar todas la variables 
	 * que se encuentran en nuestra base de datos 
	 */
	
	public void eliminar() {
	
		Statement smt=ConexionBD.conectar();
		try {
	
			smt.executeUpdate("delete from usuario where email='"+this.email+"'");
			this.email=null;
			this.nombre=null;
			this.contraseña=null;
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		ConexionBD.desconectar();
	}
	
	/**
	 * Metodo el cual realizo un arraylist del usuario para realizar una consulta
	 * de la base de datos de la tabla de usuario y mirando cada una de la variables empleadas
	 * @return Me devuelve el arraylist de Usuario
	 */
	
	public static ArrayList<Usuario> getTodos() {
		ArrayList<Usuario> ret=new ArrayList<Usuario>();
		
		Statement smt=ConexionBD.conectar();
		
		try {
			ResultSet cursor=smt.executeQuery("select * from usuario");
			while(cursor.next()) {
				Usuario u=new Usuario();
				u.email=cursor.getString("email");
				u.nombre=cursor.getString("nombre");
				u.contraseña=cursor.getString("contraseña");
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		ConexionBD.desconectar();
		
		return ret;
	}


	@Override
	public String toString() {
		return "Usuario [email=" + email + ", nombre=" + nombre + ", contraseña=" + contraseña + 
				"]";
	}
	

	
	
	
	
	
	
	
	
		
		
	


}
