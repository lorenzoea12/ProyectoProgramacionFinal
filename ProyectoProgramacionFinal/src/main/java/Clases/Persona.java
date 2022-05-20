package Clases;

public class Persona extends ElementoConNombre {
	private byte edad;
	private String apellido;
	private String nacionalidad;
	
	


	public Persona(String nombre, byte edad, String apellido, String nacionalidad) {
		super(nombre);
		this.edad = edad;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
	}


	public byte getEdad() {
		return edad;
	}
	
	
	public void setEdad(byte edad) {
		this.edad = edad;
	}
	
	
	public String getApellido() {
		return apellido;
	}
	
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
	public String getNacionalidad() {
		return nacionalidad;
	}
	
	
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	@Override
	public String toString() {
		return "Persona [edad=" + edad + ", apellido=" + apellido + ", nacionalidad=" + nacionalidad + "]";
	}


}
