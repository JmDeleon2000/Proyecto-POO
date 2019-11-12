import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;


	public login() {
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 310, 153);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre de usuario");
		lblNombre.setBounds(12, 16, 109, 16);
		frame.getContentPane().add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(124, 13, 157, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(12, 45, 82, 16);
		frame.getContentPane().add(lblContrasea);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(12, 68, 97, 25);
		frame.getContentPane().add(btnIngresar);
		btnIngresar.addActionListener(new ingresar());
		
		JButton btnNuevoUsuario = new JButton("Nuevo usuario");
		btnNuevoUsuario.setBounds(160, 68, 120, 25);
		frame.getContentPane().add(btnNuevoUsuario);
		btnNuevoUsuario.addActionListener(new nUsuario());
		
		passwordField = new JPasswordField();
		passwordField.setBounds(124, 42, 157, 21);
		frame.getContentPane().add(passwordField);
	}
	
	private class nUsuario implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			Archivos arch = new Archivos();
			try {
				arch.nuevoAdmin(textField.getText(), String.valueOf(passwordField.getPassword()));
				validar();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}
	
	private void abrirAdmin() 
	{
		Administrador admin = new Administrador();
	}
	
	private void validar()
	{
		Archivos arch = new Archivos();
		try {
			if (arch.validarUsuario(textField.getText(), String.valueOf(passwordField.getPassword())))
				abrirAdmin();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private class ingresar implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			validar();
		}
		
		
	}
}
