package Clases;

public class Usuario {
	
	private String nombre;
	private String contraseña;
	private Partida partida;
	
	
	
	
	

	public Usuario(String nombre, String contraseña, Partida partida) {
		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.partida = partida;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	public String getContraseña() {
		return contraseña;
	}
	
	
	
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
	
	public Partida getPartida() {
		return partida;
	}
	
	
	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	
	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", contraseña=" + contraseña + ", partida=" + partida + "]";
	}


}
