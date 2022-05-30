package Clases;

public class ElementoConNombre {
	public String nombre;
	
	
	
	public ElementoConNombre(){
		
	}



	public ElementoConNombre(String nombre) {
		super();
		this.nombre = nombre;
	}



	public String getNombre() {
		return nombre;
	}
	
	

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "ElementoConNombre [nombre=" + nombre + "]";
	}



}
