package InterfacesGráficas;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;

public class PantallaMenu extends JPanel {
	private Ventana ventana;
	
	
	
	public PantallaMenu(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JLabel tituloMenu = new JLabel("Men\u00FA Principal");
		tituloMenu.setForeground(Color.WHITE);
		tituloMenu.setBounds(348, 10, 313, 41);
		tituloMenu.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 36));
		add(tituloMenu);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PantallaMenu.class.getResource("/imagenes/F1-2022-requisitos-2.jpg")));
		lblNewLabel.setBounds(10, 10, 810, 620);
		add(lblNewLabel);
		
		JButton botonPersona = new JButton("Persona");
		botonPersona.setBorderPainted(false);
		botonPersona.setForeground(Color.BLACK);
		botonPersona.setBackground(Color.WHITE);
		botonPersona.setBounds(67, 300, 105, 41);
		add(botonPersona);
		
		JButton botonEquipo = new JButton("Equipo");
		botonEquipo.setBorderPainted(false);
		botonEquipo.setBackground(Color.WHITE);
		botonEquipo.setForeground(Color.BLACK);
		botonEquipo.setBounds(230, 300, 105, 41);
		add(botonEquipo);
		
		JButton botonPiloto = new JButton("Piloto");
		botonPiloto.setBorderPainted(false);
		botonPiloto.setBackground(Color.WHITE);
		botonPiloto.setForeground(Color.BLACK);
		botonPiloto.setBounds(416, 297, 116, 46);
		add(botonPiloto);
		
		

		
		
		
	}
}
