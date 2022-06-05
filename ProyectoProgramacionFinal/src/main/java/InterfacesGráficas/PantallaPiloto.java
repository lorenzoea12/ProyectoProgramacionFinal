package InterfacesGráficas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaPiloto extends JPanel {
	private Ventana ventana;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	public PantallaPiloto(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JButton botonAtras = new JButton("Atras");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPanel("menu");
			}
		});
		botonAtras.setBackground(Color.WHITE);
		botonAtras.setBounds(0, 289, 85, 34);
		add(botonAtras);
		
		JButton botonRegistro = new JButton("Registrar");
		botonRegistro.setBackground(Color.WHITE);
		botonRegistro.setBounds(409, 226, 111, 28);
		add(botonRegistro);
		
		JLabel lblNewLabel = new JLabel("Piloto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(280, 0, 146, 28);
		add(lblNewLabel);
		
		JLabel campoEquipo = new JLabel("Equipo");
		campoEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		campoEquipo.setBounds(232, 61, 67, 13);
		add(campoEquipo);
		
		textField = new JTextField();
		textField.setBounds(309, 58, 96, 19);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(309, 101, 96, 19);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel campoCoche = new JLabel("Coche");
		campoCoche.setHorizontalAlignment(SwingConstants.CENTER);
		campoCoche.setBounds(232, 104, 67, 13);
		add(campoCoche);
		
		textField_2 = new JTextField();
		textField_2.setBounds(309, 144, 96, 19);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel campoResistencia = new JLabel("Resistencia");
		campoResistencia.setHorizontalAlignment(SwingConstants.CENTER);
		campoResistencia.setBounds(220, 147, 79, 13);
		add(campoResistencia);
		
		JLabel campoExperiencia = new JLabel("Experiencia");
		campoExperiencia.setHorizontalAlignment(SwingConstants.CENTER);
		campoExperiencia.setBounds(220, 190, 79, 13);
		add(campoExperiencia);
		
		textField_3 = new JTextField();
		textField_3.setBounds(309, 187, 96, 19);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(PantallaPiloto.class.getResource("/imagenes/conductores-de-F1-Manager.jpg")));
		lblNewLabel_1.setBounds(0, 0, 810, 620);
		add(lblNewLabel_1);
	}
}
