package Utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
	
		private final static String cadenaConexion="jdbc:mysql://localhost:3306/proyectoprogramacionfinal";
		private final static String usuarioBD="root";
		private final static String passwordBD="admin";
		private static Connection conexion;
		
		public static Statement conectar() {
			try {
				if(conexion==null) {
				conexion=DriverManager.getConnection(cadenaConexion,usuarioBD,passwordBD);
				}
				return conexion.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		
		public static void desconectar() {
			if(conexion!=null) {
				try {
					conexion.close();
					conexion=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
}


