package Clases;

import java.sql.Date;
import java.util.ArrayList;

public class Carrera {
	private Date fecha;
	private ArrayList<Circuito>circuito;
	private ArrayList<Piloto>piloto;
	
	
	
	

	public Carrera(Date fecha, ArrayList<Circuito> circuito, ArrayList<Piloto> piloto) {
		super();
		this.fecha = fecha;
		this.circuito = circuito;
		this.piloto = piloto;
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
