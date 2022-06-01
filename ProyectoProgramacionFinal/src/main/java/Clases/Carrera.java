package Clases;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Utils.ConexionBD;

public class Carrera {
	private Date fecha;
	private ArrayList<Circuito>circuito;
	private ArrayList<Piloto>piloto;
	
	
	
	

	public Carrera(Date fecha, ArrayList<Circuito> circuito, ArrayList<Piloto> piloto) {
		super();
		
			Statement smt = ConexionBD.conectar();
		
		if (smt.executeUpdate("insert into carrera (fecha,ArrayList<Circuito>circuito,ArrayList<Piloto>piloto = " + numChip + " WHERE humano = '" + this.numChip + "';")
				> 0
		) 
		{
			this.numChip = numChip;
		} else {
			ConexionBD.desconectar();
			throw new SQLException("Numero de chip incorrecto o duplicado.");
		}
		
		ConexionBD.desconectar();
	}

		


	public Date getFecha() {
		return fecha;
	}
	
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	public ArrayList<Circuito> getCircuito() {
		return circuito;
	}
	
	
	public void setCircuito(ArrayList<Circuito> circuito) {
		this.circuito = circuito;
	}
	
	
	public ArrayList<Piloto> getPiloto() {
		return piloto;
	}
	
	
	public void setPiloto(ArrayList<Piloto> piloto) {
		this.piloto = piloto;
	}
	
	
	@Override
	public String toString() {
		return "Carrera [fecha=" + fecha + ", circuito=" + circuito + ", piloto=" + piloto + "]";
	}

	
	
	

}
