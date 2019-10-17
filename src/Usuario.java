import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class Usuario {

	private JFrame frame;

	Archivos volcanes;
	Archivos alertas;
	Grafica habitantes;
	Grafica areas;
	private JTextField textField;
	private JTextField textField_1;
	private JSpinner spinner;
	

	/**
	 * Create the application.
	 */
	public Usuario() {
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 258, 259);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(12, 13, 208, 127);
		frame.getContentPane().add(panel);
		
		JLabel label = new JLabel("Nombre");
		label.setBounds(12, 13, 56, 16);
		panel.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(82, 10, 116, 22);
		panel.add(textField);
		
		JLabel label_1 = new JLabel("\u00C1rea");
		label_1.setBounds(12, 48, 65, 16);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(82, 45, 116, 22);
		panel.add(textField_1);
		
		JLabel label_2 = new JLabel("Habitantes");
		label_2.setBounds(12, 77, 77, 16);
		panel.add(label_2);
		
		spinner = new JSpinner();
		spinner.setBounds(82, 74, 116, 22);
		panel.add(spinner);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(12, 145, 97, 25);
		btnConsultar.addActionListener(new ManejadorConsulta());
		frame.getContentPane().add(btnConsultar);
		
		JButton btnGraficar = new JButton("Graficar");
		btnGraficar.setBounds(123, 145, 97, 25);
		frame.getContentPane().add(btnGraficar);
		
		JButton btnAgregarAlerta = new JButton("Agregar alerta");
		btnAgregarAlerta.setBounds(12, 179, 208, 25);
		frame.getContentPane().add(btnAgregarAlerta);
	}

	
	
	public void consultar() {
		if (textField.getText().trim().toLowerCase() !=""){
			
		Volcan consulta = Archivos.leer(textField.getText().trim().toLowerCase());
		textField_1.setText(consulta.getArea());
		spinner.setValue(consulta.getHabitantes());
		}else{
			JOptionPane.showMessageDialog(null, "Ingrese el nombre de un volcan en el sistema","Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	// Terminar en otra ocasion
	public void graficarHabitantes(double[] puntos) 
	{
		
	}
	public void graficarAreas1() 
	{
		volcanes=new Archivos();
		habitantes=new Grafica(volcanes.Area(),volcanes.Habitantes());
	}
	//Terminar en otra ocasion
	public void agregarAlerta() 
	{
		consultar();
		Volcan alerta = new Volcan();
		alerta.setNombre(textField.getText());
		alerta.setArea(textField_1.getText());
		alerta.setHabitantes((int)spinner.getValue());
		try {
			Archivos.nuevaAlerta(alerta);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	private class ManejadorAlerta implements ActionListener{
		public void actionPerformed(ActionEvent e){
			agregarAlerta();
		}
	}
	private class ManejadorConsulta implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			consultar();	
		}
		
	}
}
