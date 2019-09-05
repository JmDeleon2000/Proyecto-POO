import java.awt.EventQueue;

public class Administrador {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JSpinner habitantes;
	private Archivos datos;

	
	

	/**
	 * Create the application.
	 */
	public Administrador() {
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 246, 270);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 208, 127);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 13, 56, 16);
		panel.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(82, 10, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblArea = new JLabel("\u00C1rea");
		lblArea.setBounds(12, 48, 65, 16);
		panel.add(lblArea);
		
		textField_1 = new JTextField();
		textField_1.setBounds(82, 45, 116, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblHabitantes = new JLabel("Habitantes");
		lblHabitantes.setBounds(12, 77, 77, 16);
		panel.add(lblHabitantes);
		
		habitantes = new JSpinner();
		habitantes.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(500)));
		habitantes.setBounds(82, 74, 116, 22);
		panel.add(habitantes);
		
		JButton btnNuevoVolcn = new JButton("Nuevo volc\u00E1n");
		btnNuevoVolcn.setBounds(12, 147, 208, 25);
		frame.getContentPane().add(btnNuevoVolcn);
		
		JButton btnModificarVolcn = new JButton("Modificar volc\u00E1n");
		btnModificarVolcn.setBounds(12, 185, 208, 25);
		frame.getContentPane().add(btnModificarVolcn);
		
		btnNuevoVolcn.addActionListener(new boton1());
		btnModificarVolcn.addActionListener(new boton2());
		datos = new Archivos();
	}
	
	
	/**
	 * Crea un volcan nuevo
	 * @param nombre
	 * @param area
	 * @param habitantes
	 */
	public void agregarVolcan(String nombre, String area, int habitantes) {
		datos.agregar(nombre, area, habitantes);
	}
	
	
	/**
	 * Modifica un volcan
	 * @param nombre
	 * @param area
	 * @param habitantes
	 */
	public void modificarVolcan(String nombre, String area, int habitantes) {
		datos.modificar(nombre, area, habitantes);
	}
	
	
	/**
	 * 
	 * @author ASUS
	 *
	 */
	private class boton1 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			agregarVolcan(textField.getText().trim().toLowerCase(), textField_1.getText().trim().toLowerCase(), (int)habitantes.getValue());
		}
		
	}
	
	/**
	 * 
	 * @author ASUS
	 *
	 */
	private class boton2 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			modificarVolcan(textField.getText().trim().toLowerCase(), textField_1.getText().trim().toLowerCase(), (int)habitantes.getValue());
		}
		
	}
}
