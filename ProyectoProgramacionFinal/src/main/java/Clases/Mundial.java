package Clases;

import java.util.ArrayList;

public class Mundial {
	private ArrayList<Carrera>carrera;
	private ArrayList<Equipo>equipo;
	
	

	public Mundial(ArrayList<Carrera> carrera, ArrayList<Equipo> equipo) {
		super();
		this.carrera = carrera;
		this.equipo = equipo;
	}


	public ArrayList<Carrera> getCarrera() {
		return carrera;
	}
	
	
	public void setCarrera(ArrayList<Carrera> carrera) {
		this.carrera = carrera;
	}
	
	
	public ArrayList<Equipo> getEquipo() {
		return equipo;
	}
	
	
	
	public void setEquipo(ArrayList<Equipo> equipo) {
		this.equipo = equipo;
	}
	
	
	@Override
	public String toString() {
		return "Mundial [carrera=" + carrera + ", equipo=" + equipo + "]";
	}


}
