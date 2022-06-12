package InterfacesGráficas;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

import Clases.Circuito;
import Clases.Coche;
import Clases.Equipo;
import Clases.Piloto;
import Excepciones.CurvaInvalida;
import Excepciones.LugarInvalido;

import java.awt.Font;
import javax.swing.JTextField;

public class PantallaEquipo extends JPanel {
private Ventana ventana;
private JTextField campoNombre;
private JTextField campoManager;
private JTextField campoPiloto1;
private JTextField campoPiloto2;
private JTextField campoCoche1;
private JTextField campoCoche2;
	
	public PantallaEquipo (Ventana v) {
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
	     		String nombre=campoNombre.getText();
	     		String manager=campoManager.getText();
	     		String nombrePiloto1=campoPiloto1.getText();
	     		String nombrePiloto2=campoPiloto2.getText();
	     		String nombreCoche1=campoCoche1.getText();
	     		String nombreCoche2=campoCoche2.getText();
	     		
	     		JOptionPane.showMessageDialog(ventana,"Registro Completo","Registro",JOptionPane.PLAIN_MESSAGE );
				ventana.irAPantalla("menu");
				
					try {
						new Equipo(nombre,manager,nombrePiloto1,nombrePiloto2,nombreCoche1,nombreCoche2);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	     	}	
	     });
	     btnNewButton.setBounds(701, 488, 85, 21);
	     add(btnNewButton);
	     
	     campoCoche2 = new JTextField();
	     campoCoche2.setBounds(629, 443, 96, 19);
	     add(campoCoche2);
	     campoCoche2.setColumns(10);
	     
	     campoCoche1 = new JTextField();
	     campoCoche1.setBounds(629, 399, 96, 19);
	     add(campoCoche1);
	     campoCoche1.setColumns(10);
	     
	     campoPiloto2 = new JTextField();
	     campoPiloto2.setBounds(629, 359, 96, 19);
	     add(campoPiloto2);
	     campoPiloto2.setColumns(10);
	     
	     campoPiloto1 = new JTextField();
	     campoPiloto1.setBounds(629, 321, 96, 19);
	     add(campoPiloto1);
	     campoPiloto1.setColumns(10);
	     
	     campoManager = new JTextField();
	     campoManager.setBounds(629, 285, 96, 19);
	     add(campoManager);
	     campoManager.setColumns(10);
	     
	     JLabel Coche2 = new JLabel("Coche2");
	     Coche2.setForeground(Color.WHITE);
	     Coche2.setHorizontalAlignment(SwingConstants.CENTER);
	     Coche2.setBounds(550, 446, 45, 13);
	     add(Coche2);
	     
	     JLabel Coche1 = new JLabel("Coche1");
	     Coche1.setForeground(Color.WHITE);
	     Coche1.setHorizontalAlignment(SwingConstants.CENTER);
	     Coche1.setBounds(550, 402, 45, 13);
	     add(Coche1);
	     
	     JLabel Piloto2 = new JLabel("Piloto2");
	     Piloto2.setForeground(Color.WHITE);
	     Piloto2.setHorizontalAlignment(SwingConstants.CENTER);
	     Piloto2.setBounds(550, 362, 45, 13);
	     add(Piloto2);
	     
	     JLabel Piloto1 = new JLabel("Piloto1");
	     Piloto1.setForeground(Color.WHITE);
	     Piloto1.setHorizontalAlignment(SwingConstants.CENTER);
	     Piloto1.setBounds(550, 324, 45, 13);
	     add(Piloto1);
	     
	     JLabel Manager = new JLabel("Manager");
	     Manager.setForeground(Color.WHITE);
	     Manager.setHorizontalAlignment(SwingConstants.CENTER);
	     Manager.setBounds(550, 288, 45, 13);
	     add(Manager);
	     
	     campoNombre = new JTextField();
	     campoNombre.setBounds(629, 249, 96, 19);
	     add(campoNombre);
	     campoNombre.setColumns(10);
	     
	     JLabel Nombre = new JLabel("Nombre");
	     Nombre.setForeground(Color.WHITE);
	     Nombre.setHorizontalAlignment(SwingConstants.CENTER);
	     Nombre.setBounds(550, 252, 45, 13);
	     add(Nombre);
	     
	     JLabel lblNewLabel_1 = new JLabel("Equipo");
	     lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
	     lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	     lblNewLabel_1.setForeground(Color.WHITE);
	     lblNewLabel_1.setBounds(533, 194, 95, 29);
	     add(lblNewLabel_1);
	     botonAtras.setBounds(683, 537, 85, 29);
	     add(botonAtras);
	     
	     JLabel lblNewLabel = new JLabel("New label");
	     lblNewLabel.setIcon(new ImageIcon(PantallaEquipo.class.getResource("/imagenes/60e70c86ab1d5.jpg")));
	     lblNewLabel.setBounds(0, 0, 810, 620);
	     add(lblNewLabel);
		

	}
}
