package Clases;

import java.util.ArrayList;

public class Equipo {
	private String manager;
	private ArrayList<Piloto>piloto;
	private ArrayList<Coche>coche;
	private Partida partida;
	


	public Equipo(String manager, ArrayList<Piloto> piloto, ArrayList<Coche> coche, Partida partida) {
		super();
		this.manager = manager;
		this.piloto = piloto;
		this.coche = coche;
		this.partida = partida;
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
	
	
	
	public Partida getPartida() {
		return partida;
	}
	
	
	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	
	
	@Override
	public String toString() {
		return "Equipo [manager=" + manager + ", piloto=" + piloto + ", coche=" + coche + ", partida=" + partida + "]";
	}


}
