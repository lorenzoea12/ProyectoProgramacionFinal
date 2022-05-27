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

public class PantallaRegistro extends JPanel {
	private Ventana ventana;
	private JTextField campoNombre;
	private JPasswordField campoPass;
	private JTextField campoEmail;
		
	public PantallaRegistro(Ventana v) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 148, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel tituloRegistro = new JLabel("Registro ");
		tituloRegistro.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 36));
		GridBagConstraints gbc_tituloRegistro = new GridBagConstraints();
		gbc_tituloRegistro.anchor = GridBagConstraints.WEST;
		gbc_tituloRegistro.gridwidth = 2;
		gbc_tituloRegistro.insets = new Insets(0, 0, 5, 5);
		gbc_tituloRegistro.gridx = 1;
		gbc_tituloRegistro.gridy = 1;
		add(tituloRegistro, gbc_tituloRegistro);
		
		JLabel etiquetaNombre = new JLabel("Email");
		GridBagConstraints gbc_etiquetaNombre = new GridBagConstraints();
		gbc_etiquetaNombre.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaNombre.gridx = 1;
		gbc_etiquetaNombre.gridy = 2;
		add(etiquetaNombre, gbc_etiquetaNombre);
		
		campoEmail = new JTextField();
		campoEmail.setColumns(10);
		GridBagConstraints gbc_campoEmail = new GridBagConstraints();
		gbc_campoEmail.insets = new Insets(0, 0, 5, 5);
		gbc_campoEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoEmail.gridx = 2;
		gbc_campoEmail.gridy = 2;
		add(campoEmail, gbc_campoEmail);
		
		JLabel etiquetaEmail = new JLabel("Nombre:");
		GridBagConstraints gbc_etiquetaEmail = new GridBagConstraints();
		gbc_etiquetaEmail.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaEmail.gridx = 1;
		gbc_etiquetaEmail.gridy = 3;
		add(etiquetaEmail, gbc_etiquetaEmail);
		
		campoNombre = new JTextField();
		GridBagConstraints gbc_campoNombre = new GridBagConstraints();
		gbc_campoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_campoNombre.gridx = 2;
		gbc_campoNombre.gridy = 3;
		add(campoNombre, gbc_campoNombre);
		campoNombre.setColumns(10);
		
		JLabel etiquetaPass = new JLabel("Contrase\u00F1a: ");
		GridBagConstraints gbc_etiquetaPass = new GridBagConstraints();
		gbc_etiquetaPass.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaPass.gridx = 1;
		gbc_etiquetaPass.gridy = 4;
		add(etiquetaPass, gbc_etiquetaPass);
		
		campoPass = new JPasswordField();
		GridBagConstraints gbc_campoPass = new GridBagConstraints();
		gbc_campoPass.insets = new Insets(0, 0, 5, 5);
		gbc_campoPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoPass.gridx = 2;
		gbc_campoPass.gridy = 4;
		add(campoPass, gbc_campoPass);
		
	
		
		JButton botonRegistrarse = new JButton("Registrarse");
		
		botonRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_botonRegistrarse = new GridBagConstraints();
		gbc_botonRegistrarse.gridwidth = 2;
		gbc_botonRegistrarse.insets = new Insets(0, 0, 5, 0);
		gbc_botonRegistrarse.gridx = 2;
		gbc_botonRegistrarse.gridy = 6;
		add(botonRegistrarse, gbc_botonRegistrarse);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 8;
		add(comboBox, gbc_comboBox);
		
		JButton botonAtras = new JButton("Atras");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("login");
			}
		});
		GridBagConstraints gbc_botonAtras = new GridBagConstraints();
		gbc_botonAtras.anchor = GridBagConstraints.EAST;
		gbc_botonAtras.insets = new Insets(0, 0, 5, 5);
		gbc_botonAtras.gridx = 2;
		gbc_botonAtras.gridy = 12;
		add(botonAtras, gbc_botonAtras);
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