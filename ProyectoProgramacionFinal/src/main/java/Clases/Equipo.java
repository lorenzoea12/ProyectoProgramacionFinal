package Clases;

import java.sql.Array;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;

import Utils.ConexionBD;

public class Equipo  {
	private String nombre;
	private String manager;
	private String piloto1;
	private String piloto2;
	private String coche1;
	private String coche2;
	
	

	public Equipo(String nombre, String manager, String piloto1, String piloto2, String coche1, String coche2) throws SQLException {
		super();
		Statement smt=ConexionBD.conectar();
		
		if(smt.executeUpdate("insert into coche (nombre,manager,piloto1,piloto2,coche1,coche2,) values('"
				+nombre+"','"+manager+"','"+piloto1+"','"+piloto2+"','"+coche1+"','"+coche2+"')")>0) {
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
	
	
	
	public Equipo(String nombre) throws SQLException {
		Statement smt = ConexionBD.conectar();
		try {
			ResultSet cursor= smt.executeQuery(" SELECT * FROM equipo WHERE nombre="+nombre+";");
			if (cursor.next() ) {
				this.manager = cursor.getString("manager");
				this.piloto1 = cursor.getString("piloto1");
				this.piloto2 = cursor.getString("piloto2");
				this.coche1 = cursor.getString("coche1");
				this.coche2 = cursor.getString("coche2");
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
			throw new SQLException(" No se pudo cambiar el dni o ya estaba asiganado ");
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
			throw new SQLException(" No se pudo cambiar el dni o ya estaba asiganado ");
		}
}	
	
	
	
	
	public String getPiloto1() {
		return piloto1;
	}
	
	
	public void setPiloto1(String piloto1) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update equipo set piloto1="+piloto1+" where nombre="+this.nombre+"")>0) {
			this.piloto1=piloto1;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el dni o ya estaba asiganado ");
		}
}	
	
	
	
	
	public String getPiloto2() {
		
		return piloto2;
	}
	
	
	
	
	public void setPiloto2(String piloto2) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update equipo set piloto2="+piloto2+" where nombre="+this.nombre+"")>0) {
			this.piloto2=piloto2;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el dni o ya estaba asiganado ");
		}
}	
		
		
	
	
	
	
	public String getCoche1() {
		return coche1;
	}
	
	
	
	
	
	public void setCoche1(String coche1) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update equipo set coche1="+coche1+" where nombre="+this.nombre+"")>0) {
			this.coche1=coche1;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el dni o ya estaba asiganado ");
		}
}	
		
		
		
	
	
	
	
	public String getCoche2() {
		return coche2;
	}
	
	
	
	
	public void setCoche2(String coche2) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update equipo set coche2="+coche2+" where nombre="+this.nombre+"")>0) {
			this.coche2=coche2;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el dni o ya estaba asiganado ");
		}
}	
		
		
	
	
	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", manager=" + manager + ", piloto1=" + piloto1 + ", piloto2=" + piloto2
				+ ", coche1=" + coche1 + ", coche2=" + coche2 + "]";
	}


}
	

	