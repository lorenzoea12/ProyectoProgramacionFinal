package InterfacesGráficas;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import Clases.Persona;
import Clases.Usuario;
import Excepciones.ApellidoInvalido;
import Excepciones.EdadInvalida;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import java.awt.Color;

public class PantallaPersona extends JPanel {
	
	private Ventana ventana;
	private JTextField campoNacionalidad;
	private JTextField campoEdad;
	private JTextField campoNombre;
	private JTextField campoDni;
	private JTextField campoApellido;

	public PantallaPersona(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JLabel tituloPersona = new JLabel("Persona");
		tituloPersona.setForeground(Color.WHITE);
		tituloPersona.setVerticalAlignment(SwingConstants.TOP);
		tituloPersona.setHorizontalAlignment(SwingConstants.CENTER);
		tituloPersona.setFont(new Font("Tahoma", Font.PLAIN, 33));
		tituloPersona.setBounds(10, 10, 819, 40);
		add(tituloPersona);
		
		JLabel Dni = new JLabel("DNI");
		Dni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Dni.setForeground(Color.WHITE);
		Dni.setHorizontalAlignment(SwingConstants.CENTER);
		Dni.setBounds(49, 114, 45, 13);
		add(Dni);
		
		campoNacionalidad = new JTextField();
		campoNacionalidad.setBounds(136, 277, 174, 19);
		add(campoNacionalidad);
		campoNacionalidad.setColumns(10);
		
		JLabel Edad = new JLabel("Edad");
		Edad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Edad.setForeground(Color.WHITE);
		Edad.setHorizontalAlignment(SwingConstants.CENTER);
		Edad.setBounds(49, 205, 45, 13);
		add(Edad);
		
		campoEdad = new JTextField();
		campoEdad.setBounds(136, 204, 174, 19);
		add(campoEdad);
		campoEdad.setColumns(10);
		
		JLabel Nombre = new JLabel("Nombre");
		Nombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Nombre.setForeground(Color.WHITE);
		Nombre.setHorizontalAlignment(SwingConstants.CENTER);
		Nombre.setBounds(49, 161, 64, 13);
		add(Nombre);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(136, 160, 174, 19);
		add(campoNombre);
		campoNombre.setColumns(10);
		
		campoDni = new JTextField();
		campoDni.setBounds(136, 113, 174, 19);
		add(campoDni);
		campoDni.setColumns(10);
		
		JLabel Apellido = new JLabel("Apellido");
		Apellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Apellido.setForeground(Color.WHITE);
		Apellido.setHorizontalAlignment(SwingConstants.CENTER);
		Apellido.setBounds(49, 244, 64, 13);
		add(Apellido);
		
		JLabel Nacionalidad = new JLabel("Nacionalidad");
		Nacionalidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Nacionalidad.setForeground(Color.WHITE);
		Nacionalidad.setBounds(43, 278, 83, 13);
		add(Nacionalidad);
		
		JButton btnNewButton = new JButton("Atras");
		btnNewButton.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPanel("menu");
			}
		});
		btnNewButton.setBounds(10, 321, 85, 21);
		add(btnNewButton);
		
		campoApellido = new JTextField();
		campoApellido.setBounds(136, 243, 174, 19);
		add(campoApellido);
		campoApellido.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Registrar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				String dni=campoDni.getText();
				String nombre=campoNombre.getText();
				String edadSTR=campoEdad.getText();
				int edad = Integer.parseInt(edadSTR);
				String apellido=campoApellido.getText();
				String nacionalidad=campoNacionalidad.getText();
				
				JOptionPane.showMessageDialog(ventana,"Registro Completo","Registro",JOptionPane.PLAIN_MESSAGE );
				ventana.cambiarPanel("menu");
			
				try {
					new Persona(dni,nombre,edad,apellido,nacionalidad);
				} catch (SQLException | ApellidoInvalido | EdadInvalida e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(216, 315, 94, 32);
		add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PantallaPersona.class.getResource("/imagenes/pic0.jpg")));
		lblNewLabel.setBounds(-14, 10, 807, 573);
		add(lblNewLabel);
		
		
	}
}
