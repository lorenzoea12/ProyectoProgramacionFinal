package Clases;

import java.sql.Array;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;

import Utils.ConexionBD;

public class Equipo {
	private String nombre;
	private String manager;
	/*private Piloto piloto1;
	private Piloto piloto2;
	private Coche coche1;
	private Coche coche2;
	*/
	private String nombrePiloto1;
	private String nombrePiloto2;
	private String nombreCoche1;
	private String nombreCoche2;
	

	/*public Equipo(String nombre, String manager, Piloto piloto1, Piloto piloto2, Coche coche1, Coche coche2) throws SQLException {
		super();
		Statement smt=ConexionBD.conectar();
		
		if(smt.executeUpdate("insert into coche (nombre,manager,piloto1,piloto2,coche1,coche2,) values('"
				+nombre+"','"+manager+"','"+piloto1+"','"+piloto2+"','"+coche1.getNombre()+"','"+coche2.getNombre()+"')")>0) {
			this.nombre = nombre;
			this.manager = manager;
			this.piloto1 = piloto1;
			this.piloto2 = piloto2;
			this.coche1 = coche1;
			this.coche2 = coche2;
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se ha podido insertar lo datos ");
		}
	}
	*/
	
	
	public Equipo() {
		
	}



	public Equipo(String nombre, String manager, String nombrePiloto1, String nombrePiloto2, String nombreCoche1, String nombreCoche2) throws SQLException {
		super();
		Statement smt=ConexionBD.conectar();
		
		if(smt.executeUpdate("insert into equipo (nombre,manager,nombrePiloto1,nombrePiloto2,nombreCoche1,nombreCoche2) values('"
				+nombre+"','"+manager+"','"+nombrePiloto1+"','"+nombrePiloto2+"','"+nombreCoche1+"','"+nombreCoche2+"')")>0) {
			this.nombre = nombre;
			this.manager = manager;
			this.nombrePiloto1=nombrePiloto1 ;
			this.nombrePiloto2 = nombrePiloto2 ;
			this.nombreCoche1 = nombreCoche1;
			this.nombreCoche2 = nombreCoche2;
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se ha podido insertar lo datos ");
		}
	}
	
	
	
	

	public Equipo(String nombre) throws SQLException {
		Statement smt = ConexionBD.conectar();
		try {
			ResultSet cursor= smt.executeQuery(" SELECT * FROM equipo WHERE nombre="+nombre+";");
			if (cursor.next() ) {
				this.manager = cursor.getString("manager");
				this.nombrePiloto1=cursor.getString("nombrePiloto1");
				this.nombrePiloto2=cursor.getString("nombrePiloto2");
				this.nombreCoche1=cursor.getString("nombreCoche1");
				this.nombreCoche2=cursor.getString("nombreCoche2");
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
		if(smt.executeUpdate("Update equipo set nombre="+nombre+" where nombre="+this.nombre+"")>0) {
			this.nombre=nombre;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el nombre del equipo ");
		}
}	
	
	
	public String getManager() {
		return manager;
	}

	
	
	public void setManager(String manager) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update equipo set manager="+manager+" where nombre="+this.nombre+"")>0) {
			this.manager=manager;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el manager del equipo");
		}
}	
	
	
	
	
	public String getnombrePiloto1() {
		return nombrePiloto1;
	}
	
	
	public void setPiloto1(String nombrePiloto1) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update equipo set nombrePiloto1="+nombrePiloto1+" where nombre="+this.nombre+"")>0) {
			this.nombrePiloto1=nombrePiloto1;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el nombre del primer piloto ");
		}
}	
	
	
	
	
	public String getnombrePiloto2() {
		
		return nombrePiloto2;
	}
	
	
	
	
	public void setPiloto2(String nombrePiloto2) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update equipo set nombrePiloto2="+nombrePiloto2+" where nombre="+this.nombre+"")>0) {
			this.nombrePiloto2=nombrePiloto2;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el nombre del piloto2");
		}
}	
		
		
	
	
	
	
	public String getnombreCoche1() {
		return nombreCoche1;
	}
	
	
	
	
	
	public void setCoche1(String  nombreCoche1) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update equipo set nombreCoche1="+nombreCoche1+" where nombre="+this.nombre+"")>0) {
			this.nombreCoche1=nombreCoche1;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el dni o ya estaba asiganado ");
		}
}	
		
		
		
	
	
	
	
	public String getNombreCoche2() {
		return nombreCoche2;
	}
	
	
	
	
	public void setCoche2(String  nombreCoche2) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update equipo set nombreCoche2="+nombreCoche2+" where nombre="+this.nombre+"")>0) {
			this.nombreCoche2=nombreCoche2;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el dni o ya estaba asiganado ");
		}
}	
	
	
	public static ArrayList<Equipo> getTodos() {
		ArrayList<Equipo> ret=new ArrayList<Equipo>();
		
		Statement smt=ConexionBD.conectar();
		
		try {
			ResultSet cursor=smt.executeQuery("select * from Equipo");
			while(cursor.next()) {
				Equipo e=new Equipo();
				e.nombre=cursor.getString("nombre");
				e.manager=cursor.getString("manager");
				e.nombrePiloto1=cursor.getString("nombrePiloto1");
				e.nombrePiloto2=cursor.getString("nombrePiloto2");
				e.nombreCoche1=cursor.getString("nombreCoche1");
				e.nombreCoche2=cursor.getString("nombreCoche2");
				
				
			}
			
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		ConexionBD.desconectar();
		
		return ret;
	}

	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", manager=" + manager + ", nombrePiloto1=" + nombrePiloto1
				+ ", nombrePiloto2=" + nombrePiloto2 + ", nombreCoche1=" + nombreCoche1 + ", nombreCoche2="
				+ nombreCoche2 + "]";
	}

}
		
		
	
	
	
	

	