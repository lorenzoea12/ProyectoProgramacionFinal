package InterfacesGráficas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Clases.Persona;
import Clases.Piloto;
import Excepciones.ApellidoInvalido;
import Excepciones.EdadInvalida;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class PantallaPiloto extends JPanel {
	private Ventana ventana;
	private JTextField campoEquipo;
	private JTextField campoCoche;
	private JTextField campoResistencia;
	private JTextField campoExperiencia;
	private JTextField campoDni;
	private JTextField campoNombre;
	private JTextField campoEdad;
	private JTextField campoApellido;
	private JTextField campoNacionalidad;
	private JTextField campoId;
	private JTextField campoPuntos;
	
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
		
		campoPuntos = new JTextField();
		campoPuntos.setBounds(309, 512, 96, 19);
		add(campoPuntos);
		campoPuntos.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Puntos");
		lblNewLabel_9.setBounds(232, 515, 45, 13);
		add(lblNewLabel_9);
		
		campoId = new JTextField();
		campoId.setBounds(309, 289, 96, 19);
		add(campoId);
		campoId.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Id");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(220, 289, 45, 13);
		add(lblNewLabel_8);
		
		campoNacionalidad = new JTextField();
		campoNacionalidad.setBounds(309, 245, 96, 19);
		add(campoNacionalidad);
		campoNacionalidad.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Nacionalidad");
		lblNewLabel_7.setBounds(220, 248, 67, 13);
		add(lblNewLabel_7);
		
		campoApellido = new JTextField();
		campoApellido.setBounds(309, 211, 96, 19);
		add(campoApellido);
		campoApellido.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Apellido");
		lblNewLabel_6.setBounds(232, 214, 45, 13);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre");
		lblNewLabel_4.setBounds(232, 122, 45, 13);
		add(lblNewLabel_4);
		
		campoEdad = new JTextField();
		campoEdad.setBounds(309, 165, 96, 19);
		add(campoEdad);
		campoEdad.setColumns(10);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(309, 119, 96, 19);
		add(campoNombre);
		campoNombre.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Edad");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(232, 168, 45, 13);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_3 = new JLabel("dni");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(232, 75, 45, 13);
		add(lblNewLabel_3);
		
		campoDni = new JTextField();
		campoDni.setBounds(309, 72, 96, 19);
		add(campoDni);
		campoDni.setColumns(10);
		botonAtras.setBackground(Color.WHITE);
		botonAtras.setBounds(702, 539, 85, 34);
		add(botonAtras);
		
		JButton botonRegistro = new JButton("Registrar");
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String dni=campoDni.getText();
				String nombre=campoNombre.getText();
				String edadSTR=campoEdad.getText();
				int edad = Integer.parseInt(edadSTR);
				String apellido=campoApellido.getText();
				String nacionalidad=campoNacionalidad.getText();
				String  idSTR=campoId.getText();
				byte id=Byte.parseByte(idSTR);
				String nombreEquipo=campoEquipo.getText();
				String nombreCoche=campoEquipo.getText();
				String resistenciaSTR=campoResistencia.getText();
				byte resistencia=Byte.parseByte(resistenciaSTR);                
				String experienciaSTR=campoExperiencia.getText();
				byte experiencia=Byte.parseByte(experienciaSTR);
				String puntosSTR = campoPuntos.getText();
				short puntos=Short.parseShort(puntosSTR);
				JOptionPane.showMessageDialog(ventana,"Registro Completo","Registro",JOptionPane.PLAIN_MESSAGE );
				ventana.irAPantalla("menu");
				
				try {
					new Piloto(dni,nombre,edad,apellido,nacionalidad,id,nombreEquipo,nombreCoche,resistencia,experiencia,puntos);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ApellidoInvalido e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (EdadInvalida e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		botonRegistro.setBackground(Color.WHITE);
		botonRegistro.setBounds(459, 542, 111, 28);
		add(botonRegistro);
		
		JLabel lblNewLabel = new JLabel("Piloto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(280, 0, 146, 28);
		add(lblNewLabel);
		
		JLabel Equipo = new JLabel("Equipo");
		Equipo.setHorizontalAlignment(SwingConstants.CENTER);
		Equipo.setBounds(220, 328, 67, 13);
		add(Equipo);
		
		campoEquipo = new JTextField();
		campoEquipo.setBounds(309, 325, 96, 19);
		add(campoEquipo);
		campoEquipo.setColumns(10);
		
		campoCoche = new JTextField();
		campoCoche.setBounds(309, 354, 96, 19);
		add(campoCoche);
		campoCoche.setColumns(10);
		
		JLabel Coche = new JLabel("Coche");
		Coche.setHorizontalAlignment(SwingConstants.CENTER);
		Coche.setBounds(220, 357, 67, 13);
		add(Coche);
		
		campoResistencia = new JTextField();
		campoResistencia.setBounds(309, 394, 96, 19);
		add(campoResistencia);
		campoResistencia.setColumns(10);
		
		JLabel Resistencia = new JLabel("Resistencia");
		Resistencia.setHorizontalAlignment(SwingConstants.CENTER);
		Resistencia.setBounds(220, 397, 79, 13);
		add(Resistencia);
		
		JLabel Experiencia = new JLabel("Experiencia");
		Experiencia.setHorizontalAlignment(SwingConstants.CENTER);
		Experiencia.setBounds(220, 443, 79, 13);
		add(Experiencia);
		
		campoExperiencia = new JTextField();
		campoExperiencia.setBounds(309, 440, 96, 19);
		add(campoExperiencia);
		campoExperiencia.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(PantallaPiloto.class.getResource("/imagenes/conductores-de-F1-Manager.jpg")));
		lblNewLabel_1.setBounds(0, -4, 810, 620);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(257, 75, 45, 13);
		add(lblNewLabel_2);
		
		JLabel label = new JLabel("New label");
		label.setBounds(0, 0, 45, 13);
		add(label);
	}
}
