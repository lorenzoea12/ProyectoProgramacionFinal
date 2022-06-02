package InterfacesGráficas;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import Clases.Usuario;
import Componentes.BotonAzul;
import Componentes.BotonRojo;
import Componentes.BotonVerde;
import Excepciones.ContraseñaIncorrectaException;
import Excepciones.ContraseñaInvalida;
import Excepciones.NombreInvalidoException;
import Excepciones.UsuarioNoExisteException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class PantallaLogin extends JPanel {
	
private	Ventana ventana;
	
	private JTextField campoEmail;
	private JPasswordField campoContraseña;
	
	
	public PantallaLogin(Ventana v) {
		
		
		this.ventana=v;
		setLayout(null);
		
		JButton botonLogin = new BotonRojo("Login");
		botonLogin.setForeground(Color.WHITE);
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			
		});
		botonLogin.setToolTipText("Pincha aqu\u00ED para iniciar sesi\u00F3n");
		botonLogin.setBounds(258, 362, 160, 44);
		this.add(botonLogin);
		
		JButton botonRegistro = new BotonAzul("Registrarse");
		botonRegistro.setForeground(Color.WHITE);
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("registro");
			}
		});
		botonRegistro.setBounds(452, 361, 143, 46);
		add(botonRegistro);
		
		JLabel etiquetaTitulo = new JLabel("Iniciar Sesi\u00F3n");
		etiquetaTitulo.setForeground(Color.WHITE);
		etiquetaTitulo.setBackground(Color.WHITE);
		etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaTitulo.setFont(new Font("Miriam Libre", Font.ITALIC, 27));
		etiquetaTitulo.setBounds(175, 10, 480, 44);
		add(etiquetaTitulo);
		
		JLabel EtiquetaEmail = new JLabel("Email");
		EtiquetaEmail.setForeground(Color.WHITE);
		EtiquetaEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		EtiquetaEmail.setBounds(270, 118, 46, 14);
		add(EtiquetaEmail);
		
		JLabel EtiquetaPass = new JLabel("Contrase\u00F1a");
		EtiquetaPass.setForeground(Color.WHITE);
		EtiquetaPass.setBounds(270, 177, 85, 14);
		add(EtiquetaPass);
		
		campoEmail = new JTextField();
		campoEmail.setBounds(395, 116, 175, 20);
		add(campoEmail);
		campoEmail.setColumns(10);
		
		campoContraseña = new JPasswordField();
		campoContraseña.setBounds(395, 175, 175, 20);
		add(campoContraseña);
		
		JButton botonLoguearse = new JButton("Loguearse");
		botonLoguearse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonLoguearse.setBounds(510, 223, 85, 21);
		add(botonLoguearse);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(PantallaLogin.class.getResource("/imagenes/F1_Unveil_Images_Final-1000-1200x900.jpg")));
		lblNewLabel.setBounds(0, 0, 810, 620);
		add(lblNewLabel);
		
		JButton btnNewButton_1 = new BotonVerde("Salir ");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBounds(376, 417, 116, 45);
		add(btnNewButton_1);
		
		
		botonLoguearse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String email = campoEmail.getText();
				String contraseña = new String(campoContraseña.getPassword());
				
				try {
					ventana.usuarioLogado=new Usuario(email,contraseña);
					JOptionPane.showMessageDialog(ventana,
							"Bienvenido"+ventana.usuarioLogado.getNombre(),
							"Inicio de sesión con éxito", JOptionPane.INFORMATION_MESSAGE);
					ventana.cambiarPanel("menu");
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ContraseñaInvalida e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UsuarioNoExisteException e1) {
					// TODO Auto-generated catch block
				
					JOptionPane.showMessageDialog(ventana,e1.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
				} catch (ContraseñaIncorrectaException e1) {
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

	


