package Clases;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Utils.ConexionBD;

public class Equipo extends ElementoConNombre {
	private String manager;
	private ArrayList<Piloto>piloto;
	private ArrayList<Coche>coche;
	
	



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


	public String getManager() {
		return manager;
	}
	
	
	public void setManager(String manager) {
		this.manager = manager;
	}
	
	
	public ArrayList<Piloto> getPiloto() {
		return piloto;
	}
	
	
	public void setPiloto(ArrayList<Piloto> piloto) {
		this.piloto = piloto;
	}
	
	
	public ArrayList<Coche> getCoche() {
		return coche;
	}
	
	
	public void setCoche(ArrayList<Coche> coche) {
		this.coche = coche;
	}
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Equipo [manager=" + manager + ", piloto=" + piloto + ", coche=" + coche +  "]";
	}


}
