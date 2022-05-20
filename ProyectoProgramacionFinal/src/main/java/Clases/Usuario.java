package Clases;

public class Usuario {
	
	private String nombre;
	private String contrase�a;
	private Partida partida;
	
	
	
	
	

	public Usuario(String nombre, String contrase�a, Partida partida) {
		super();
		this.nombre = nombre;
		this.contrase�a = contrase�a;
		this.partida = partida;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	public String getContrase�a() {
		return contrase�a;
	}
	
	
	
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	
	
	
	public Partida getPartida() {
		return partida;
	}
	
	
	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	
	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", contrase�a=" + contrase�a + ", partida=" + partida + "]";
	}


}
