package InterfacesGráficas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Clases.Coche;
import Clases.Piloto;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;

public class PantallaCoche extends JPanel {
	private Ventana ventana;
	private JTextField campoNombre;
	private JTextField campoEquipo;
	private JTextField campoColor;
	private JTextField campoCaballos;
	private JTextField campoPiloto;
	private JTextField campoManiobrabilidad;
	private JTextField campoNeumaticos;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	
	public PantallaCoche (Ventana v ) {
		this.ventana=v;
		setLayout(null);
		
		lblNewLabel_8 = new JLabel("Maniobrabilidad");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(247, 321, 45, 13);
		add(lblNewLabel_8);
		
		lblNewLabel_6 = new JLabel("Caballos");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(247, 263, 45, 13);
		add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Piloto");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(247, 292, 45, 13);
		add(lblNewLabel_7);
		
		lblNewLabel_5 = new JLabel("Neumaticos");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(247, 225, 45, 13);
		add(lblNewLabel_5);
		
		lblNewLabel_4 = new JLabel("Color");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(247, 196, 45, 13);
		add(lblNewLabel_4);
		
		lblNewLabel_3 = new JLabel("Equipo");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(247, 167, 45, 13);
		add(lblNewLabel_3);
		
		lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(247, 127, 45, 13);
		add(lblNewLabel_2);
		
		campoNeumaticos = new JTextField();
		campoNeumaticos.setBackground(Color.WHITE);
		campoNeumaticos.setBounds(335, 222, 96, 19);
		add(campoNeumaticos);
		campoNeumaticos.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Coche");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(335, 0, 73, 33);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		add(lblNewLabel);
		
		campoNombre = new JTextField();
		campoNombre.setBackground(Color.WHITE);
		campoNombre.setBounds(335, 124, 96, 19);
		add(campoNombre);
		campoNombre.setColumns(10);
		
		campoEquipo = new JTextField();
		campoEquipo.setBackground(Color.WHITE);
		campoEquipo.setBounds(335, 164, 96, 19);
		add(campoEquipo);
		campoEquipo.setColumns(10);
		
		campoColor = new JTextField();
		campoColor.setBackground(Color.WHITE);
		campoColor.setBounds(335, 193, 96, 19);
		add(campoColor);
		campoColor.setColumns(10);
		
		campoCaballos = new JTextField();
		campoCaballos.setBackground(Color.WHITE);
		campoCaballos.setBounds(335, 260, 96, 19);
		add(campoCaballos);
		campoCaballos.setColumns(10);
		
		campoPiloto = new JTextField();
		campoPiloto.setBackground(Color.WHITE);
		campoPiloto.setBounds(335, 289, 96, 19);
		add(campoPiloto);
		campoPiloto.setColumns(10);
		
		campoManiobrabilidad = new JTextField();
		campoManiobrabilidad.setBackground(Color.WHITE);
		campoManiobrabilidad.setBounds(335, 318, 96, 19);
		add(campoManiobrabilidad);
		campoManiobrabilidad.setColumns(10);
		
		JButton botonAtras = new JButton("Atras");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPanel("menu");
			}
		});
		botonAtras.setBounds(640, 546, 85, 21);
		add(botonAtras);
		
		JButton botonRegistrarse = new JButton("Registrar");
		botonRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre=campoNombre.getText();
				String nombreEquipo=campoEquipo.getText();
				String color=campoColor.getText();
				String neumaticos=campoNeumaticos.getText();
				String caballosSTR=campoCaballos.getText();
				byte caballos=Byte.parseByte(caballosSTR);
				String nombrePiloto=campoPiloto.getText();
				String maniobrabilidadSTR=campoManiobrabilidad.getText();
				byte maniobrabilidad=Byte.parseByte(maniobrabilidadSTR);
				
				JOptionPane.showMessageDialog(ventana,"Registro Completo","Registro",JOptionPane.PLAIN_MESSAGE );
				ventana.irAPantalla("menu");
			
				
				try {
					new Coche(nombre,nombreEquipo,color,neumaticos,caballos,nombrePiloto,maniobrabilidad);
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}
			}
		});
		botonRegistrarse.setBounds(475, 410, 116, 33);
		add(botonRegistrarse);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(PantallaCoche.class.getResource("/imagenes/videojuego-f1-2020-ps4-analisis-codemasters-3.jpg")));
		lblNewLabel_1.setBounds(0, 0, 810, 620);
		add(lblNewLabel_1);
	}
}
