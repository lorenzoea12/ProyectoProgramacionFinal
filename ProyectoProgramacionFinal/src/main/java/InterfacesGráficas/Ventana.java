package InterfacesGráficas;

import java.awt.Cursor;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Clases.Usuario;

public class Ventana extends JFrame {
	/**
	 * la clave va a ser un nombre que le ponemos a la pantalla y el valor la
	 * pantalla con ese nombre
	 */
	private HashMap<String, JPanel> pantallas;
	protected Usuario usuarioLogado;
	
	public  void romperVentanas() {
		pantallas.clear();
	}

	public Ventana() {
		this.pantallas = new HashMap<String, JPanel>();
		this.pantallas.put("login", new PantallaLogin(this));
		this.pantallas.put("registro", new PantallaRegistro(this));

		this.setSize(810, 620);
		this.setIconImage(new ImageIcon("./imagen/iconoF1.jpg").getImage());
		this.setTitle("Manager Formula 1");
		this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		this.setAlwaysOnTop(true);// superpone siempre la ventana
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);// importante para que se salga al cerrar la ventana
		this.setResizable(false);
		// this.setEnabled(false); te bloquea la ventana no se puede cerrar
		this.setLocationRelativeTo(null);// centra la ventana

		// this.setExtendedState(JFrame.MAXIMIZED_BOTH);estas dos lineas es para ponerlo
		// en pantalla
		// this.setUndecorated(true); completa

		this.setContentPane(this.pantallas.get("login"));
		this.setVisible(true);

		String s = "";
		s.isBlank();

	}

	public void irAPantalla(String nombrePantalla) {
		Iterator it = this.pantallas.values().iterator();

		while (it.hasNext()) {
			JPanel actual = (JPanel) it.next();
			actual.setVisible(false);
		}
		this.pantallas.get(nombrePantalla).setVisible(true);
		this.setContentPane(this.pantallas.get(nombrePantalla));
	}

	
	
	public void cambiarPanel(String panel) {

        Iterator it = pantallas.keySet().iterator();
        while (it.hasNext()) {
            String ventana = (String) it.next();
            pantallas.get(ventana).setVisible(false);
        }

        if(panel.equals("login")) {
            romperVentanas();
            pantallas.put(panel, new PantallaLogin(this));
        }

        if(pantallas.get(panel)==null) {
            switch(panel) {
            case "login":
                pantallas.put(panel, new PantallaLogin(this));
                break;
           
            case "registro":
                pantallas.put(panel, new PantallaRegistro(this));
                break;
                
            case "menu":
            	pantallas.put(panel, new PantallaMenu(this));
            	break;
            	
            case"persona":
            	pantallas.put(panel, new PantallaPersona(this));
            	break;
            	
            case"circuito":
            	pantallas.put(panel, new PantallaCircuito(this));
            	break;
            	
            case"piloto":
            	pantallas.put(panel, new PantallaPiloto(this));
            	break;
            case"coche":
            	pantallas.put(panel,new PantallaCoche(this));
            	break;
            

            }
        }
        JPanel panelActual=pantallas.get(panel);
        panelActual.setVisible(true);
        this.setContentPane(panelActual);


	}
}