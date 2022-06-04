package InterfacesGráficas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		
		JLabel lblNewLabel = new JLabel("Circuito");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(252, 0, 111, 40);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(214, 73, 45, 13);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(302, 70, 96, 19);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("NumeroCircuito");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(189, 119, 96, 13);
		add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(302, 116, 96, 19);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Lugar");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(214, 164, 45, 13);
		add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(302, 161, 96, 19);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Rectas");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(214, 214, 45, 13);
		add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(302, 211, 96, 19);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Curvas");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(214, 261, 45, 13);
		add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(302, 258, 96, 19);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Dificultad");
		lblNewLabel_6.setBounds(214, 312, 45, 13);
		add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(302, 309, 96, 19);
		add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Longitud");
		lblNewLabel_7.setBounds(214, 364, 45, 13);
		add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		textField_6.setBounds(302, 361, 96, 19);
		add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("Atras");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPanel("menu");
			}
		});
		btnNewButton.setBounds(501, 360, 85, 21);
		add(btnNewButton);
	}
}
