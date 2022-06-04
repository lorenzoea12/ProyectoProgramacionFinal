package InterfacesGráficas;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaMenu extends JPanel {
	private Ventana ventana;
	
	
	
	public PantallaMenu(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JButton btnNewButton = new JButton("Atras");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPanel("login");
			}
		});
		btnNewButton.setBounds(585, 438, 85, 21);
		add(btnNewButton);
		
		JButton botonCarrera = new JButton("Carrera");
		botonCarrera.setBackground(Color.WHITE);
		botonCarrera.setBounds(125, 303, 105, 41);
		add(botonCarrera);
		
		JButton botonCircuito = new JButton("Circuito");
		botonCircuito.setBackground(Color.WHITE);
		botonCircuito.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPanel("circuito");
			}
		});
		botonCircuito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonCircuito.setBounds(518, 302, 116, 43);
		add(botonCircuito);
		
		JButton botonPiloto = new JButton("Piloto");
		botonPiloto.setBorderPainted(false);
		botonPiloto.setBackground(Color.WHITE);
		botonPiloto.setForeground(Color.BLACK);
		botonPiloto.setBounds(378, 305, 116, 41);
		add(botonPiloto);
		
		JButton botonEquipo = new JButton("Equipo");
		botonEquipo.setBorderPainted(false);
		botonEquipo.setBackground(Color.WHITE);
		botonEquipo.setForeground(Color.BLACK);
		botonEquipo.setBounds(250, 303, 105, 41);
		add(botonEquipo);
		
		JButton botonPersona = new JButton("Persona");
		botonPersona.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPanel("persona");
				
			}
		});
		botonPersona.setBorderPainted(false);
		botonPersona.setForeground(Color.BLACK);
		botonPersona.setBackground(Color.WHITE);
		botonPersona.setBounds(10, 303, 105, 41);
		add(botonPersona);
		
		JLabel tituloMenu = new JLabel("Men\u00FA Principal");
		tituloMenu.setForeground(Color.WHITE);
		tituloMenu.setBounds(306, 13, 313, 41);
		tituloMenu.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 36));
		add(tituloMenu);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PantallaMenu.class.getResource("/imagenes/F1-2022-requisitos-2.jpg")));
		lblNewLabel.setBounds(-25, 13, 810, 620);
		add(lblNewLabel);
		
		

		
		
		
	}
}
