package InterfacesGráficas;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

import Clases.Carrera;

import javax.swing.JTextField;

public class PantallaCarrera extends JPanel {
	private Ventana ventana;
	private JTextField campoCarrera;
	private JTextField campoCircuito;
	private JTextField campoEquipo;
	
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
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String numeroCarreraSTR=campoCarrera.getText();
				byte numeroCarrera=Byte.parseByte(numeroCarreraSTR);
				String numeroCircuitoSTR=campoCircuito.getText();
				byte numeroCircuito=Byte.parseByte(numeroCircuitoSTR);
				String nombreEquipo=campoEquipo.getText();
				
				JOptionPane.showMessageDialog(ventana,"Registro Completo","Registro",JOptionPane.PLAIN_MESSAGE );
				ventana.irAPantalla("menu");
				
				try {
					new Carrera(numeroCarrera,numeroCircuito,nombreEquipo);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(416, 198, 85, 21);
		add(btnNewButton);
		
		campoEquipo = new JTextField();
		campoEquipo.setBounds(326, 169, 96, 19);
		add(campoEquipo);
		campoEquipo.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("NombreEquipo");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(231, 172, 85, 13);
		add(lblNewLabel_4);
		
		campoCircuito = new JTextField();
		campoCircuito.setBounds(326, 127, 96, 19);
		add(campoCircuito);
		campoCircuito.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("NumeroCircuito");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(231, 130, 85, 13);
		add(lblNewLabel_3);
		
		campoCarrera = new JTextField();
		campoCarrera.setBounds(326, 86, 96, 19);
		add(campoCarrera);
		campoCarrera.setColumns(10);
		
		JLabel Carrera = new JLabel("NumeroCarrera");
		Carrera.setHorizontalAlignment(SwingConstants.CENTER);
		Carrera.setBounds(231, 89, 85, 13);
		add(Carrera);
		
		JLabel lblNewLabel_1 = new JLabel("Carrera");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_1.setBounds(342, 0, 136, 40);
		add(lblNewLabel_1);
		botonAtras.setBounds(671, 506, 85, 30);
		add(botonAtras);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PantallaCarrera.class.getResource("/imagenes/16519205255661.jpg")));
		lblNewLabel.setBounds(10, 0, 810, 620);
		add(lblNewLabel);
		
	}
}
