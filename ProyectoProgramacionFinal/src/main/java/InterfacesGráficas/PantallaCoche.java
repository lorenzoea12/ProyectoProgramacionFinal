package InterfacesGráficas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class PantallaCoche extends JPanel {
	private Ventana ventana;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	public PantallaCoche (Ventana v ) {
		this.ventana=v;
		setLayout(null);
		
		JLabel campoNombre = new JLabel("Nombre");
		campoNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoNombre.setForeground(Color.WHITE);
		campoNombre.setHorizontalAlignment(SwingConstants.CENTER);
		campoNombre.setBounds(261, 69, 64, 13);
		add(campoNombre);
		
		JLabel lblNewLabel = new JLabel("Coche");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(335, 0, 73, 33);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(335, 66, 96, 19);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(335, 95, 96, 19);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(335, 124, 96, 19);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(335, 153, 96, 19);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(335, 186, 96, 19);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(335, 215, 96, 19);
		add(textField_5);
		textField_5.setColumns(10);
		
		JLabel campoEquipo = new JLabel("Equipo");
		campoEquipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoEquipo.setForeground(Color.WHITE);
		campoEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		campoEquipo.setBounds(261, 98, 45, 13);
		add(campoEquipo);
		
		JLabel campoColor = new JLabel("Color");
		campoColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoColor.setForeground(Color.WHITE);
		campoColor.setHorizontalAlignment(SwingConstants.CENTER);
		campoColor.setBounds(241, 127, 65, 13);
		add(campoColor);
		
		JLabel campoCaballos = new JLabel("Caballos");
		campoCaballos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoCaballos.setForeground(Color.WHITE);
		campoCaballos.setHorizontalAlignment(SwingConstants.CENTER);
		campoCaballos.setBounds(241, 156, 65, 13);
		add(campoCaballos);
		
		JLabel campoPiloto = new JLabel("Piloto");
		campoPiloto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoPiloto.setForeground(Color.WHITE);
		campoPiloto.setHorizontalAlignment(SwingConstants.CENTER);
		campoPiloto.setBounds(241, 189, 65, 13);
		add(campoPiloto);
		
		JLabel lblNewLabel_6 = new JLabel("Maniobralidad");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(229, 218, 96, 13);
		add(lblNewLabel_6);
		
		JButton botonAtras = new JButton("Atras");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPanel("menu");
			}
		});
		botonAtras.setBackground(Color.WHITE);
		botonAtras.setBounds(10, 374, 85, 21);
		add(botonAtras);
		
		JButton botonRegistrarse = new JButton("Registrar");
		botonRegistrarse.setBackground(Color.WHITE);
		botonRegistrarse.setBounds(405, 260, 116, 33);
		add(botonRegistrarse);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(PantallaCoche.class.getResource("/imagenes/videojuego-f1-2020-ps4-analisis-codemasters-3.jpg")));
		lblNewLabel_1.setBounds(0, 0, 810, 620);
		add(lblNewLabel_1);
	}

}
