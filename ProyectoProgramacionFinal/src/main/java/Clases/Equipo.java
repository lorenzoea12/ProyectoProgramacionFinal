package Clases;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;

import Utils.ConexionBD;

public class Equipo extends ElementoConNombre {
	private String manager;

	public Equipo(String nombre, String manager, ArrayList<Piloto> piloto, ArrayList<Coche> coche) throws SQLException {
		super(nombre);
		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate("insert into persona (nombre,manager,piloto1,piloto2,coche1,coche2) values  ('" + nombre
				+ "','" + manager + "''" + piloto.get(0).getNombre() + "','" + piloto.get(1).getNombre() + "','"
				+ coche.get(0).getNombre() + "','" + coche.get(1).getNombre() + "')") > 0) {

			this.manager = manager;
		
			this.coche = coche;
			ConexionBD.desconectar();

		} else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido crear el equipo correctamente");

		}
	}

	public Equipo(String nombre) throws SQLException {

		Statement smt = ConexionBD.conectar();

		ResultSet cursor = smt.executeQuery("SELECT * FROM equipo  WHERE e.nombre ='" + nombre + "' ");

		if (cursor.next()) {
			this.manager = cursor.getString("manager");
			this.nombre = nombre;
		}
		ConexionBD.desconectar();
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) throws SQLException {
		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate("Update equipo set manager=" + manager + " where nombre=" + this.nombre + "") > 0) {
			this.manager = manager;
			ConexionBD.desconectar();
		} else {
			ConexionBD.desconectar();
			throw new SQLException(" No se pudo cambiar el  manager");
		}
	}

	@Override
	public String toString() {
		return "Equipo [manager=" + manager + ", piloto=" + piloto + ", coche=" + coche + "]";
	}

	public ArrayList<Coche> getCoches() {
		ArrayList<Coche> coches = new ArrayList<Coche>();
		Statement smt = ConexionBD.conectar();

		ResultSet cursor;
		try {
			cursor = smt.executeQuery("SELECT coche1,coche2 FROM equipo  WHERE escuderia ='" + this.nombre +"' ");
			if (cursor.next() ) {
				coches.add(new Coche("coche1"));
				coches.add(new Coche("coche2"));
				}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return coches;
	}

}
