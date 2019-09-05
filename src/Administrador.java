import java.awt.EventQueue;

import javax.swing.JFrame;

public class Administrador {
	private Archivos datos;
	public Administrador(){
	datos= new Archivos();
	
	
	}

	private JFrame frame;

	public Administrador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
