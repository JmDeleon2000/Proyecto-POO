import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
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
		frame.getContentPane().add(btnAdministrador);
		
		JButton btnUsuario = new JButton("Usuario");
		btnUsuario.setBounds(245, 137, 175, 69);
		frame.getContentPane().add(btnUsuario);
	}

}
