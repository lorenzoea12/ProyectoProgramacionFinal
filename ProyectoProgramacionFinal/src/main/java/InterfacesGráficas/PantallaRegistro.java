package InterfacesGráficas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;

import Clases.Usuario;
import Excepciones.ContraseñaInvalida;
import Excepciones.NombreInvalidoException;

import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.ImageIcon;

public class PantallaRegistro extends JPanel {
	private Ventana ventana;
	private JTextField campoNombre;
	private JPasswordField campoPass;
	private JTextField campoEmail;
		
	public PantallaRegistro(Ventana v) {
		setLayout(null);
		
		JLabel tituloRegistro = new JLabel("Registro ");
		tituloRegistro.setBounds(351, 2, 170, 41);
		tituloRegistro.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 36));
		add(tituloRegistro);
		
		JLabel etiquetaNombre = new JLabel("Email");
		etiquetaNombre.setBounds(287, 87, 36, 16);
		add(etiquetaNombre);
		
		campoEmail = new JTextField();
		campoEmail.setBounds(364, 86, 222, 19);
		campoEmail.setColumns(10);
		add(campoEmail);
		
		JLabel etiquetaEmail = new JLabel("Nombre:");
		etiquetaEmail.setBounds(287, 154, 40, 13);
		add(etiquetaEmail);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(364, 151, 222, 19);
		add(campoNombre);
		campoNombre.setColumns(10);
		
		JLabel etiquetaPass = new JLabel("Contrase\u00F1a: ");
		etiquetaPass.setBounds(287, 231, 59, 13);
		add(etiquetaPass);
		
		campoPass = new JPasswordField();
		campoPass.setBounds(364, 228, 222, 19);
		add(campoPass);
		
	
		
		JButton botonRegistrarse = new JButton("Registrarse");
		botonRegistrarse.setBounds(524, 313, 85, 21);
		
		botonRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(botonRegistrarse);
		
		JButton botonAtras = new JButton("Atras");
		botonAtras.setBounds(542, 382, 95, 41);
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("login");
			}
		});
		add(botonAtras);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(33, 67, 450, 241);
		add(lblNewLabel);
		ventana=v;
		
	
		botonRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre = campoNombre.getText();
				String email = campoEmail.getText();
				String pass = new String(campoPass.getPassword());
		
				JOptionPane.showMessageDialog(ventana,"Registro Completo","Registro",JOptionPane.PLAIN_MESSAGE );
				ventana.irAPantalla("login");
			
				try {
					new Usuario( email,nombre, pass);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ContraseñaInvalida e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NombreInvalidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}
}