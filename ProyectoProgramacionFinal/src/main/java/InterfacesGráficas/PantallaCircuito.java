package InterfacesGráficas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import Clases.Circuito;
import Clases.Persona;
import Excepciones.ApellidoInvalido;
import Excepciones.CurvaInvalida;
import Excepciones.EdadInvalida;
import Excepciones.LugarInvalido;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaCircuito extends JPanel {
private Ventana ventana;	
private JTextField campoNombre;
private JTextField campoNumeroCircuito;
private JTextField campoLugar;
private JTextField campoRectas;
private JTextField campoCurvas;
private JTextField campoDificultad;
private JTextField campoLongitud;
	
	public PantallaCircuito(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Registrar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Circuito=campoNumeroCircuito.getText();
				byte numeroCircuito=Byte.parseByte(Circuito);
				String nombre = campoNombre.getText();
				String lugar=campoLugar.getText();
				String rectas1=campoRectas.getText();
				byte rectas=Byte.parseByte(rectas1);
				String curvas1=campoCurvas.getText();
				byte curvas=Byte.parseByte(curvas1);
				String dificultad=campoDificultad.getText();
				String longitud1=campoLongitud.getText();
				float longitud=Float.parseFloat(longitud1);
				JOptionPane.showMessageDialog(ventana,"Registro Completo","Registro",JOptionPane.PLAIN_MESSAGE );
				ventana.irAPantalla("menu");
			
				try {
					new Circuito(numeroCircuito,nombre,lugar,rectas,curvas,dificultad,longitud);
				} catch (SQLException |  LugarInvalido | CurvaInvalida e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(579, 308, 111, 21);
		add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Circuito");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(252, 0, 111, 40);
		add(lblNewLabel);
		
		JLabel Nombre = new JLabel("Nombre");
		Nombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Nombre.setForeground(Color.WHITE);
		Nombre.setBounds(363, 117, 65, 13);
		add(Nombre);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(438, 116, 96, 19);
		add(campoNombre);
		campoNombre.setColumns(10);
		
		JLabel circuito = new JLabel("NumeroCircuito");
		circuito.setFont(new Font("Tahoma", Font.PLAIN, 14));
		circuito.setForeground(Color.WHITE);
		circuito.setHorizontalAlignment(SwingConstants.CENTER);
		circuito.setBounds(332, 73, 115, 13);
		add(circuito);
		
		campoNumeroCircuito = new JTextField();
		campoNumeroCircuito.setBounds(446, 72, 96, 19);
		add(campoNumeroCircuito);
		campoNumeroCircuito.setColumns(10);
		
		JLabel Lugar = new JLabel("Lugar");
		Lugar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Lugar.setForeground(Color.WHITE);
		Lugar.setHorizontalAlignment(SwingConstants.CENTER);
		Lugar.setBounds(364, 164, 45, 13);
		add(Lugar);
		
		campoLugar = new JTextField();
		campoLugar.setBounds(438, 163, 96, 19);
		add(campoLugar);
		campoLugar.setColumns(10);
		
		JLabel Rectas = new JLabel("Rectas");
		Rectas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Rectas.setForeground(Color.WHITE);
		Rectas.setHorizontalAlignment(SwingConstants.CENTER);
		Rectas.setBounds(364, 214, 45, 13);
		add(Rectas);
		
		campoRectas = new JTextField();
		campoRectas.setBounds(438, 213, 96, 19);
		add(campoRectas);
		campoRectas.setColumns(10);
		
		JLabel Curvas = new JLabel("Curvas");
		Curvas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Curvas.setForeground(Color.WHITE);
		Curvas.setHorizontalAlignment(SwingConstants.CENTER);
		Curvas.setBounds(364, 261, 45, 13);
		add(Curvas);
		
		campoCurvas = new JTextField();
		campoCurvas.setBounds(438, 260, 96, 19);
		add(campoCurvas);
		campoCurvas.setColumns(10);
		
		JLabel Dificultad = new JLabel("Dificultad");
		Dificultad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Dificultad.setForeground(Color.WHITE);
		Dificultad.setBounds(363, 310, 65, 13);
		add(Dificultad);
		
		campoDificultad = new JTextField();
		campoDificultad.setBounds(438, 309, 96, 19);
		add(campoDificultad);
		campoDificultad.setColumns(10);
		
		JLabel Longitud = new JLabel("Longitud");
		Longitud.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Longitud.setForeground(Color.WHITE);
		Longitud.setBounds(364, 364, 64, 13);
		add(Longitud);
		
		campoLongitud = new JTextField();
		campoLongitud.setBounds(438, 363, 96, 19);
		add(campoLongitud);
		campoLongitud.setColumns(10);
		
		JButton btnNewButton = new JButton("Atras");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPanel("menu");
			}
		});
		btnNewButton.setBounds(10, 71, 85, 21);
		add(btnNewButton);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setIcon(new ImageIcon(PantallaCircuito.class.getResource("/imagenes/15955996113077.jpg")));
		lblNewLabel_8.setBounds(0, 0, 810, 620);
		add(lblNewLabel_8);
	}
}
