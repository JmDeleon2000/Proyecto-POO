import java.io.File;
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
		File archivo = new File("volcanes.txt");
		if (!archivo.exists())
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * 
	 * @param nombre
	 * @param area
	 * @param habitantes
	 */
	public void agregar(String nombre, String area, int habitantes) {
		try {
			File archivo = new File("volcanes.txt");
			Scanner lector = new Scanner(archivo);
			ArrayList<String> datos = new ArrayList<String>();
			while(lector.hasNextLine()) 
			{
				datos.add(lector.nextLine());
			}	
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
			JOptionPane.showMessageDialog(null, "No se pudo escribir en el archivo.", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	/**
	 * 
	 * @param nombre
	 * @param area
	 * @param habitantes
	 */
	public void modificar(String nombre, String area, int habitantes) {
		try {
			File archivo = new File("volcanes.txt");
			Scanner lector = new Scanner(archivo);
			ArrayList<String> datos = new ArrayList<String>();
			while(lector.hasNextLine()) 
			{
				datos.add(lector.nextLine());
			}
			
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
				JOptionPane.showMessageDialog(null, "El volcán que busca no existe", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
				return;
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
			JOptionPane.showMessageDialog(null, "No se pudo escribir en el archivo.", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static Volcan leer(String nombre) 
	{
		Volcan v = new Volcan();
		try {
			File archivo = new File("volcanes.txt");
			Scanner lector = new Scanner(archivo);
			ArrayList<String> datos = new ArrayList<String>();
			while(lector.hasNextLine()) 
			{
				datos.add(lector.nextLine());
			}
			
			
			
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
				JOptionPane.showMessageDialog(null, "El volcán que busca no existe"  + nombre, "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
				return v;
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No se pudo escribir en el archivo.", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		return v;
	}
}
