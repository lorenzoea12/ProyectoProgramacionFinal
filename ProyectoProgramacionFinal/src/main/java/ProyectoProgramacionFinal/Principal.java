package ProyectoProgramacionFinal;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import Clases.Usuario;
import Excepciones.Contrase�aIncorrectaException;
import Excepciones.Contrase�aInvalida;
import Excepciones.NombreInvalidoException;
import Excepciones.UsuarioNoExisteException;
import InterfacesGr�ficas.Ventana;

public class Principal {

	public static void main(String[] args) {
		Scanner lector=new Scanner(System.in);
		String contrase�aDefault=null;
		String emailDefault=null;
		
		for(byte i=0;i<args.length;i++) {
			if(args[i].equals("-email")) {//por ejemplo si le paso -nombre
				emailDefault=args[i+1]; //indico que me coja lo siguiente, es decir el nombre
			}
			if(args[i].equals("-contrase�a")) {
				contrase�aDefault=args[i+1];
		}
			if(args[i].equals("-h")|| args[i].equals("-help")|| args[i].equals("-!")) {
				System.out.println("Programa para dibujar un texto con un pero"
						+"/nArgumentos posibles"
						+"/n/t-email establece el email del usuario"
						+"/n/t-contrase�a establece la contrase�a usuario");
				System.out.println(0);
			}
	
		}
		if(emailDefault!=null) { // si hay email
			System.out.println("Recibido por argumentos "+ emailDefault);
		}
		if(contrase�aDefault!=null) {//si hay contrase�a 
			System.out.println(" Recibido por argumentos");
		}
		
		
	
		
		Ventana v= new Ventana();
	}
	
}