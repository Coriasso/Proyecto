package com.iesvirgendelcarmen.ejercicios.Proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.BindException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Vista extends JFrame {

	private JPanel contentPane;
	public static JTextField userText;
	public static JPasswordField passwordText;
	private JButton btnAceptar;
	private JButton btnSalir;
	private JTextPane panelDeTexto;
	final datosUsuario data = new datosUsuario();
	


	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(204, 87, 46, 14);
		contentPane.add(lblUsuario);
		
		userText = new JTextField();
		userText.setBounds(319, 84, 86, 20);
		contentPane.add(userText);
		userText.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(204, 112, 69, 14);
		contentPane.add(lblContrasea);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(319, 109, 86, 20);
		contentPane.add(passwordText);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(data.probarPass() == 1){
					JOptionPane.showMessageDialog(null, "Bienvenido al sistema");
					ArrayList<String> personas = ConsultorBaseDatos.sacarListaNombres();
					panelDeTexto.setText(personas.toString());
					//dispose();
				}else{
					JOptionPane.showMessageDialog(null,"Usuario o contraseña correcto");
				}
				
			}
		});
		
		panelDeTexto = new JTextPane();
		panelDeTexto.setBounds(218, 186, 400, 250);
		contentPane.add(panelDeTexto);
		btnAceptar.setBounds(127, 223, 89, 23);
		contentPane.add(btnAceptar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				System.exit(0);
			}
		});
		btnSalir.setBounds(640, 223, 89, 23);
		contentPane.add(btnSalir);
	}
}
