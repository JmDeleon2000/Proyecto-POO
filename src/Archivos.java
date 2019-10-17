import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import javax.swing.JOptionPane;
/**
 * 
 */

/**
 * @author ASUS
 *
 */
public class Archivos {
	Volcan[] volcanes;
	
	/**
	 * 
	 */
	public Archivos() 
	{
		File volcanes = new File("volcanes.dat");
		if (!volcanes.exists())
			try {
				volcanes.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		File alertas = new File("alertas.dat");
		if (!alertas.exists())
			try {
				alertas.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		File usuarios = new File("usuarios.dat");
		if (!usuarios.exists())
			try {
				usuarios.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * 
	 * @param us
	 * @param pw
	 * @throws Exception
	 */
	public void nuevoAdmin(String us, String pw) throws Exception 
	{
		CharSequence prob = "-";
		if (pw.contains(prob) || us.contains(prob))
			throw new Exception("El nombre de usuario o la contraseña usan caracteres inválidos");
		File archivo = new File("usuarios.dat");
		Scanner lector = new Scanner(archivo);
		ArrayList<String> datos = new ArrayList<String>();
		while(lector.hasNextLine()) 
		{
			String linea = lector.nextLine();
			if (linea.split("-")[0].equals(us)) 
				throw new Exception("El nombre de usuario ya está en uso.");
			datos.add(linea);
		}	
		lector.close();
		int i =0;
		String s = "";
		while (i<datos.size())
		{
			s+= datos.get(i) + "\n";
			i++;
		}
		s+= us + "-" + pw;
		FileWriter escritor = new FileWriter(archivo);
		escritor.write(s);
		escritor.close();
	}
	
	/**
	 * 
	 * @param us
	 * @param pw
	 * @return
	 * @throws Exception 
	 */
	public Boolean validarUsuario(String us, String pw) throws Exception 
	{
		
		File archivo = new File("usuarios.dat");
		Scanner lector = new Scanner(archivo);
		String linea = "";
		boolean encontrado = false;
		while(lector.hasNextLine() && !encontrado) 
		{
			linea = lector.nextLine();
			if (linea.split("-")[0].equals(us))
				encontrado = true;
		}	
		lector.close();
		if (!encontrado) throw new Exception("Nombre de usuario incorrecto");
		if (linea.split("-")[1].equals(pw))
			return true;
		return false;
	}
	
	
	/**
	 * 
	 * @param nombre
	 * @param area
	 * @param habitantes
	 * @throws Exception 
	 */
	public void agregar(String nombre, String area, int habitantes) throws Exception {
		CharSequence prob = "-";
		if (nombre.contains(prob) || area.contains(prob))
			throw new Exception("No se permite el uso de \"-\" dentro los nombres.");
		try {
			File archivo = new File("volcanes.dat");
			Scanner lector = new Scanner(archivo);
			ArrayList<String> datos = new ArrayList<String>();
			while(lector.hasNextLine()) 
			{
				String linea = lector.nextLine();
				if (linea.split("-")[0].equals(nombre))
					throw new Exception("El volcán ya está registrado.");
				datos.add(linea);
				
			}	
			lector.close();
			int i =0;
			String s = "";
			while (i<datos.size())
			{
				s+= datos.get(i) + "\n";
				i++;
			}
			s+= nombre + "-" + area + "-" + String.valueOf(habitantes);

			FileWriter escritor = new FileWriter(archivo);
			escritor.write(s);
			escritor.close();
		} catch (IOException e) {
			throw new Exception("No se pudo escribir en el archivo.");
		}
	}
	
	
	/**
	 * 
	 * @param nombre
	 * @param area
	 * @param habitantes
	 * @throws Exception 
	 */
	public void modificar(String nombre, String area, int habitantes) throws Exception {
		CharSequence prob = "-";
		if (nombre.contains(prob) || area.contains(prob))
			throw new Exception("No se permite el uso de \"-\" dentro los nombres.");
		try {
			File archivo = new File("volcanes.dat");
			Scanner lector = new Scanner(archivo);
			ArrayList<String> datos = new ArrayList<String>();
			while(lector.hasNextLine()) 
			{
				datos.add(lector.nextLine());
			}
			lector.close();
			boolean encontrado = false;
			int i =0;
			while (i<datos.size()) 
			{
				String linea = datos.get(i);
				if (linea.split("-")[0].equals(nombre)) 
				{
					datos.set(i, nombre + "-" + area + "-" + String.valueOf(habitantes));
					encontrado = true;
					break;
				}
				i++;
			}
			if(!encontrado) 
			{
				throw new Exception("El volcán que busca no existe.");
			}
			
			i=0;
			String s = "";
			while (i<datos.size())
			{
				s+= datos.get(i) + "\n";
				i++;
			}
			
			FileWriter escritor = new FileWriter(archivo);
			escritor.write(s);
			escritor.close();
		} catch (IOException e) {
			throw new Exception("No se pudo escribir en el archivo");
		}
	}
	
	public static Volcan leer(String nombre) throws Exception 
	{
		Volcan v = new Volcan();
		try {
			File archivo = new File("volcanes.dat");
			Scanner lector = new Scanner(archivo);
			ArrayList<String> datos = new ArrayList<String>();
			while(lector.hasNextLine()) 
			{
				datos.add(lector.nextLine());
			}
			
			lector.close();
			
			boolean encontrado = false;
			int i =0;
			while (i<datos.size()) 
			{
				String linea = datos.get(i);
				if (linea.split("-")[0].equals(nombre)) 
				{
					String area = linea.split("-")[1];
					int habitantes = Integer.valueOf(linea.split("-")[2]);
					v = new Volcan(nombre, area, habitantes);
					encontrado = true;
					break;
				}
				i++;
			}
			
			if(!encontrado) 
			{
				throw new Exception("El volcán que busca no existe.");
			}
		} catch (IOException e) {
			throw new Exception("No se pudo escribir en el archivo");
		}
		return v;
	}
	
	public static void nuevaAlerta(Volcan volcan) throws Exception 
	{
		CharSequence prob = "-";
		if (volcan.getNombre().contains(prob) || volcan.getArea().contains(prob))
			throw new Exception("No se permite el uso de \"-\" dentro los nombres.");
		try {
			File archivo = new File("alertas.dat");
			Scanner lector = new Scanner(archivo);
			ArrayList<String> datos = new ArrayList<String>();
			while(lector.hasNextLine()) 
			{
				String linea = lector.nextLine();
				if (linea.split("-")[0].equals(volcan.getNombre())) 
					throw new Exception("El volcán ya tiene una alerta registrada.");
				datos.add(linea);
				
			}	
			lector.close();
			int i =0;
			String s = "";
			while (i<datos.size())
			{
				s+= datos.get(i) + "\n";
				i++;
			}
			s+= volcan.getNombre() + "-" + volcan.getArea() + "-" + String.valueOf(volcan.getHabitantes());

			FileWriter escritor = new FileWriter(archivo);
			escritor.write(s);
			escritor.close();
		} catch (IOException e) {
			throw new Exception("No se pudo escribir en el archivo.");
		}
	}
}
