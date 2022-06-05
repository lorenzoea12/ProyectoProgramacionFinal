package InterfacesGráficas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaCircuito extends JPanel {
private Ventana ventana;	
private JTextField textField;
private JTextField textField_1;
private JTextField textField_2;
private JTextField textField_3;
private JTextField textField_4;
private JTextField textField_5;
private JTextField textField_6;
	
	public PantallaCircuito(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Registrar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
				
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
		
		JLabel campoNombre = new JLabel("Nombre");
		campoNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		campoNombre.setForeground(Color.WHITE);
		campoNombre.setBounds(363, 73, 65, 13);
		add(campoNombre);
		
		textField = new JTextField();
		textField.setBounds(457, 72, 96, 19);
		add(textField);
		textField.setColumns(10);
		
		JLabel campoNumeroCircuito = new JLabel("NumeroCircuito");
		campoNumeroCircuito.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoNumeroCircuito.setForeground(Color.WHITE);
		campoNumeroCircuito.setHorizontalAlignment(SwingConstants.CENTER);
		campoNumeroCircuito.setBounds(332, 119, 115, 13);
		add(campoNumeroCircuito);
		
		textField_1 = new JTextField();
		textField_1.setBounds(457, 116, 96, 19);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel campoLugar = new JLabel("Lugar");
		campoLugar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoLugar.setForeground(Color.WHITE);
		campoLugar.setHorizontalAlignment(SwingConstants.CENTER);
		campoLugar.setBounds(364, 164, 45, 13);
		add(campoLugar);
		
		textField_2 = new JTextField();
		textField_2.setBounds(457, 161, 96, 19);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel campoRectas = new JLabel("Rectas");
		campoRectas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoRectas.setForeground(Color.WHITE);
		campoRectas.setHorizontalAlignment(SwingConstants.CENTER);
		campoRectas.setBounds(364, 214, 45, 13);
		add(campoRectas);
		
		textField_3 = new JTextField();
		textField_3.setBounds(457, 211, 96, 19);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel campoCurvas = new JLabel("Curvas");
		campoCurvas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoCurvas.setForeground(Color.WHITE);
		campoCurvas.setHorizontalAlignment(SwingConstants.CENTER);
		campoCurvas.setBounds(364, 261, 45, 13);
		add(campoCurvas);
		
		textField_4 = new JTextField();
		textField_4.setBounds(457, 258, 96, 19);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel campoDificultad = new JLabel("Dificultad");
		campoDificultad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoDificultad.setForeground(Color.WHITE);
		campoDificultad.setBounds(363, 310, 65, 13);
		add(campoDificultad);
		
		textField_5 = new JTextField();
		textField_5.setBounds(457, 309, 96, 19);
		add(textField_5);
		textField_5.setColumns(10);
		
		JLabel campoLongitud = new JLabel("Longitud");
		campoLongitud.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoLongitud.setForeground(Color.WHITE);
		campoLongitud.setBounds(364, 364, 64, 13);
		add(campoLongitud);
		
		textField_6 = new JTextField();
		textField_6.setBounds(457, 361, 96, 19);
		add(textField_6);
		textField_6.setColumns(10);
		
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
