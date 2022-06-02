package InterfacesGráficas;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class PantallaPersona extends JPanel {
	
	private Ventana ventana;

	public PantallaPersona(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JLabel botonPersona = new JLabel("Persona");
		botonPersona.setBounds(161, 24, 64, 13);
		add(botonPersona);

	}
}
