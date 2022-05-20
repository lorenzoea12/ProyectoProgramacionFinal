package Clases;

public class Coche {
	
	private Equipo escuderia;
	private String color;
	private Enum neumaticos;
	private byte caballos;
	private Piloto piloto;
	private byte maniobrabilidad;
	
	
	

	public Coche(Equipo escuderia, String color, Enum neumaticos, byte caballos, Piloto piloto, byte maniobrabilidad) {
		super();
		this.escuderia = escuderia;
		this.color = color;
		this.neumaticos = neumaticos;
		this.caballos = caballos;
		this.piloto = piloto;
		this.maniobrabilidad = maniobrabilidad;
	}


	public Equipo getEscuderia() {
		return escuderia;
	}
	
	
	public void setEscuderia(Equipo escuderia) {
		this.escuderia = escuderia;
	}
	
	
	public String getColor() {
		return color;
	}
	
	
	public void setColor(String color) {
		this.color = color;
	}
	
	
	public Enum getNeumaticos() {
		return neumaticos;
	}
	
	
	public void setNeumaticos(Enum neumaticos) {
		this.neumaticos = neumaticos;
	}
	
	
	public byte getCaballos() {
		return caballos;
	}
	
	
	public void setCaballos(byte caballos) {
		this.caballos = caballos;
	}
	
	
	public Piloto getPiloto() {
		return piloto;
	}
	
	
	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}
	
	
	public byte getManiobrabilidad() {
		return maniobrabilidad;
	}
	
	
	
	public void setManiobrabilidad(byte maniobrabilidad) {
		this.maniobrabilidad = maniobrabilidad;
	}
	
	
	@Override
	public String toString() {
		return "Coche [escuderia=" + escuderia + ", color=" + color + ", neumaticos=" + neumaticos + ", caballos="
				+ caballos + ", piloto=" + piloto + ", maniobrabilidad=" + maniobrabilidad + "]";
	}


}
