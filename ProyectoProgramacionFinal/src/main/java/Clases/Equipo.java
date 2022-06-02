package Clases;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.Statement;
import java.util.ArrayList;

import Utils.ConexionBD;

public class Equipo extends ElementoConNombre {
	private String manager;
	private ArrayList<Piloto>piloto;
	private ArrayList<Coche> coche;
	
	



	public Equipo(String nombre, String manager, ArrayList<Piloto> piloto, ArrayList<Coche> coche) throws SQLException {
		super(nombre);
		Statement smt = ConexionBD.conectar();
		if(smt.executeUpdate("insert into persona (nombre,manager,piloto1,piloto2,coche1,coche2) values  ('"
				+nombre+"','"+manager+"''"+piloto.get(0).getNombre()+"','"+piloto.get(1).getNombre()+"','"+coche.get(0).getNombre()+"','"+coche.get(1).getNombre()+"')")>0) {
	
		this.manager = manager;
		this.piloto = piloto;
		this.coche = coche;
		ConexionBD.desconectar();
		
	}else {
		ConexionBD.desconectar();
		throw new SQLException("No se ha podido crear el equipo correctamente");
		
	}
}
	
public Equipo(int nombre) throws SQLException {
		
		Statement smt = ConexionBD.conectar();

			ResultSet cursor = smt.executeQuery("SELECT * FROM equipo WHERE nombre =" + nombre +";");
			
			if (cursor.next() ) {
				this.manager=cursor.getString("manager");
				this.piloto = (ArrayList<Piloto>) cursor.getArray("piloto");
				this.coche = (ArrayList<Coche>) cursor.getArray("coche");
				ConexionBD.desconectar();
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
			throw new SQLException(" No se pudo cambiar el  manager");
		}
}	
	
	
	
	
	public ArrayList<Piloto> getPiloto() {
		return piloto;
	}
	
	
	public void setPiloto(ArrayList<Piloto> piloto) throws SQLException {
		
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update equipo set piloto="+piloto+" where nombre="+this.nombre+"")>0) {
			this.piloto=piloto;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo actualizar los pilotos del equipo ");
		}
}	
		
	
	
	public ArrayList<Coche> getCoche() {
		return coche;
	}
	
	
	public void setCoche(ArrayList<Coche> coche) throws SQLException {
		Statement smt=ConexionBD.conectar();
		if(smt.executeUpdate("Update equipo set coche="+coche+" where NumeroChip="+this.nombre+"")>0) {
			this.coche=coche;
			ConexionBD.desconectar();
		}else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo actualizar los coches del equipo  ");
		}
}	
		
	
	
	
	
	
	@Override
	public String toString() {
		return "Equipo [manager=" + manager + ", piloto=" + piloto + ", coche=" + coche +  "]";
	}


}
