import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class Principal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}
	
	Administrador admin;
	Usuario user;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setBounds(12, 0, 482, 101);
		lblBienvenido.setFont(new Font("Arial Black", Font.PLAIN, 71));
		frame.getContentPane().add(lblBienvenido);
		
		JButton btnAdministrador = new JButton("Administrador");
		btnAdministrador.setBounds(65, 137, 140, 69);
		btnAdministrador.addActionListener(new ManejadorAdmin());
		frame.getContentPane().add(btnAdministrador);
		
		JButton btnUsuario = new JButton("Usuario");
		btnUsuario.setBounds(245, 137, 175, 69);
		btnUsuario.addActionListener(new ManejadorUsuarios());
		frame.getContentPane().add(btnUsuario);
	}

	private class ManejadorAdmin implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			login log = new login();
	
		}
		
	}
	
	
	private class ManejadorUsuarios implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			user = new Usuario();
			
		}
		
	}
}
