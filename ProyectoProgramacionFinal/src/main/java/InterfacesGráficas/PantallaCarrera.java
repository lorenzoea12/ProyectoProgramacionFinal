package InterfacesGráficas;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PantallaCarrera extends JPanel {
	private Ventana ventana;
	
	public PantallaCarrera (Ventana v) {
	     this.ventana=v;
		setLayout(null);
		
		JButton botonAtras = new JButton("Atras");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPanel("menu");
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Carrera");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_1.setBounds(342, 0, 136, 40);
		add(lblNewLabel_1);
		botonAtras.setBounds(671, 506, 85, 30);
		add(botonAtras);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PantallaCarrera.class.getResource("/imagenes/16519205255661.jpg")));
		lblNewLabel.setBounds(0, 0, 810, 620);
		add(lblNewLabel);
		
	}
}
