package ProyectoProgramacionFinal;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import Clases.Usuario;
import Excepciones.ContraseñaIncorrectaException;
import Excepciones.ContraseñaInvalida;
import Excepciones.NombreInvalidoException;
import Excepciones.UsuarioNoExisteException;
import InterfacesGráficas.Ventana;

public class Principal {

	public static void main(String[] args) {
		Scanner lector=new Scanner(System.in);
		byte menu1=0;
	String email;
	String contraseña;
		Usuario usuario=null;
		
		
		
		
		
		do {
			System.out.println("(1)\tRegistrarme\n(2)\tIniciar sesion");
			menu1=Byte.parseByte(lector.nextLine());
			if(menu1>2&&menu1<1) {
				System.err.println("Opcion no correcta");
			}
		}while(menu1>2&&menu1<1);
		
		if(menu1==1) {
			System.out.println("**REGISTRO**");
		System.out.println("Dime tu nombre");	
		String nombre=lector.nextLine();
		System.out.println("Dime tu gmail");
		email=lector.nextLine();
		System.out.println("Dime una contraseña");
		contraseña=lector.nextLine();
		
		LocalDate fechalorenzo= LocalDate.of(2002,1,12);
		try {
			
			Usuario user=new Usuario("campillos214@gmall.com","lorenzo","12345");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NombreInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ContraseñaInvalida e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		while(menu1!=0) {
			menu1=0;
			System.out.println("**INICIO DE SESION**");
			System.out.println("Dime un email");
			email = lector.nextLine();
			System.out.println("Dime una contraseña");
			contraseña=lector.nextLine();
			try {
				usuario=new Usuario(email,contraseña);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println("NO es correcto caballero");
				menu1=5;
			} catch (ContraseñaIncorrectaException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				menu1=5;
			} catch (UsuarioNoExisteException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
				menu1=5;
			} catch (ContraseñaInvalida e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NombreInvalidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while(true) {
			System.out.println("(1)\tDatos de usuario\n(2)\tAñadir mascota\n(3)\tListar mascotas\n(4)\tSalir\n(5)\tEliminar usuarios y mascotas\n(6)\tMostrar todos los usuarios");		
			menu1=Byte.parseByte(lector.nextLine());
		switch(menu1) {
		case 1:
			System.out.println(usuario);
			break;
		case 2:
			System.out.println("Dime su numero para poder identificarlo");
			int numeroID=Integer.parseInt(lector.nextLine());
			System.out.println("Dime su raza");
			String raza=lector.nextLine();
			System.out.println("Digame su apodo");
			String nomMascota=lector.nextLine();
		}
		}
	}
}
			
