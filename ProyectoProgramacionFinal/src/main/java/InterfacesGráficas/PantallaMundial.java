package InterfacesGráficas;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;

public class PantallaMundial extends JPanel {
	private Ventana ventana;
	
	public PantallaMundial (Ventana v) {
		this.ventana=v;
		
		JButton botonAtras = new JButton("Atras");
		botonAtras.setBounds(654, 537, 71, 27);
		botonAtras.setBackground(Color.WHITE);
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
				ventana.cambiarPanel("menu");
			}
		});
		setLayout(null);
		add(botonAtras);
		
		JLabel lblNewLabel = new JLabel("Mundial");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(-29, 10, 811, 32);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(PantallaMundial.class.getResource("/imagenes/1593444778_786143_1593445056_noticia_normal_recorte1.jpg")));
		lblNewLabel_1.setBounds(0, 0, 811, 620);
		add(lblNewLabel_1);
		
	}
}
