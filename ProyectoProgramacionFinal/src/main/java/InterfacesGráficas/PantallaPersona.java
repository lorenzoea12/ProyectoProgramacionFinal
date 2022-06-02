package InterfacesGráficas;

import javax.swing.JPanel;

public class PantallaPersona extends JPanel {
	
	private Ventana ventana;

	public PantallaPersona(Ventana v) {
		this.ventana=v;
		setLayout(null);

	}
}
