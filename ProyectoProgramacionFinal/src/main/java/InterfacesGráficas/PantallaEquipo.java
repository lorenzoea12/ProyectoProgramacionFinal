package InterfacesGráficas;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PantallaEquipo extends JPanel {
private Ventana ventana;
	
	public PantallaEquipo (Ventana v) {
	     this.ventana=v;
	     setLayout(null);
	     
	     JButton botonAtras = new JButton("Atras");
	     botonAtras.addMouseListener(new MouseAdapter() {
	     	@Override
	     	public void mouseClicked(MouseEvent e) {
	     		ventana.cambiarPanel("menu");
	     	}
	     });
	     botonAtras.setBounds(673, 574, 85, 21);
	     add(botonAtras);
	     
	     JLabel lblNewLabel = new JLabel("New label");
	     lblNewLabel.setIcon(new ImageIcon(PantallaEquipo.class.getResource("/imagenes/60e70c86ab1d5.jpg")));
	     lblNewLabel.setBounds(0, 0, 810, 620);
	     add(lblNewLabel);
		

	}
}
