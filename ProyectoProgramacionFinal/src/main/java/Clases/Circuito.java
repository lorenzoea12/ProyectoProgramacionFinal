package Clases;

public class Circuito extends ElementoConNombre{

	private String lugar;
	private byte rectas;
	private byte curvas;
	private String dificultad;
	private float longitud;
	
	
	



	public Circuito(String nombre, String lugar, byte rectas, byte curvas, String dificultad, float longitud) {
		super(nombre);
		this.lugar = lugar;
		this.rectas = rectas;
		this.curvas = curvas;
		this.dificultad = dificultad;
		this.longitud = longitud;
	}


	public String getLugar() {
		return lugar;
	}
	
	
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	
	public byte getRectas() {
		return rectas;
	}
	
	
	public void setRectas(byte rectas) {
		this.rectas = rectas;
	}
	
	
	
	public byte getCurvas() {
		return curvas;
	}
	
	
	
	public void setCurvas(byte curvas) {
		this.curvas = curvas;
	}
	
	
	
	public String getDificultad() {
		return dificultad;
	}
	
	
	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}
	
	
	public float getLongitud() {
		return longitud;
	}
	
	
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	
	
	@Override
	public String toString() {
		return "Circuito [lugar=" + lugar + ", rectas=" + rectas + ", curvas=" + curvas + ", dificultad=" + dificultad
				+ ", longitud=" + longitud + "]";
	}

	
}
