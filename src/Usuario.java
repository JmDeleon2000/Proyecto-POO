import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		frame.setBounds(100, 100, 340, 259);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(12, 13, 302, 127);
		frame.getContentPane().add(panel);
		
		JLabel lblNombreDelVolcn = new JLabel("Nombre del volc\u00E1n");
		lblNombreDelVolcn.setBounds(12, 13, 106, 16);
		panel.add(lblNombreDelVolcn);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(130, 10, 160, 22);
		panel.add(textField);
		
		JLabel label_1 = new JLabel("\u00C1rea");
		label_1.setBounds(12, 66, 65, 16);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(100, 66, 190, 22);
		panel.add(textField_1);
		
		JLabel label_2 = new JLabel("Habitantes");
		label_2.setBounds(12, 95, 77, 16);
		panel.add(label_2);
		
		spinner = new JSpinner();
		spinner.setEnabled(false);
		spinner.setBounds(100, 95, 190, 22);
		panel.add(spinner);
		
		JButton btnConsultar = new JButton("Completar");
		btnConsultar.setBounds(12, 35, 278, 25);
		panel.add(btnConsultar);
		btnConsultar.addActionListener(new ManejadorConsulta());
		
		JButton btnGraficar = new JButton("Graficar");
		btnGraficar.setBounds(12, 145, 302, 25);
		frame.getContentPane().add(btnGraficar);
		
		JButton btnAgregarAlerta = new JButton("Agregar alerta");
		btnAgregarAlerta.setBounds(12, 179, 302, 25);
		btnAgregarAlerta.addActionListener(new ManejadorAlerta());
		frame.getContentPane().add(btnAgregarAlerta);
	}

	
	public void graficarAreas(double[] puntos) 
	{
		
	}
	
	public void consultar() 
	{
		if (textField.getText().trim().toLowerCase() != "") {
			Volcan consulta;
			try {
				consulta = Archivos.leer(textField.getText().trim().toLowerCase());
				textField_1.setText(consulta.getArea());
				spinner.setValue(consulta.getHabitantes());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Ingrese el nombre de un volcán en el sistema", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void graficarHabitantes(double[] puntos) 
	{
		
	}
	
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
	
	
	private class ManejadorAlerta implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			agregarAlerta();	
		}
		
	}
	private class ManejadorConsulta implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			consultar();	
		}
		
	}
}
