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
	}
	
	/**
	 * 
	 * @param nombre
	 * @param area
	 * @param habitantes
	 * @throws Exception 
	 */
	public void agregar(String nombre, String area, int habitantes) throws Exception {
		try {
			File archivo = new File("volcanes.dat");
			Scanner lector = new Scanner(archivo);
			ArrayList<String> datos = new ArrayList<String>();
			while(lector.hasNextLine()) 
			{
				String linea = lector.nextLine();
				if (linea.split("-")[0] == nombre) 
					throw new Exception("El volcán ya está registrado.");
				datos.add(linea);
				
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
		try {
			File archivo = new File("volcanes.dat");
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
		try {
			File archivo = new File("alertas.dat");
			Scanner lector = new Scanner(archivo);
			ArrayList<String> datos = new ArrayList<String>();
			while(lector.hasNextLine()) 
			{
				String linea = lector.nextLine();
				if (linea.split("-")[0] == volcan.getNombre()) 
					throw new Exception("El volcán ya tiene una alerta registrada.");
				datos.add(linea);
				
			}	
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
	
	public static ArrayList<Integer> Habitantes() throws Exception 
	{
		ArratList<Integer> habitantes= new ArrayList<Integer>();
		try {
			File archivo = new File("volcanes.dat");
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
				habitantes.add(Integer.ParseInt(linea.split("-")[2]));
				
				i++;
			}
			
			
		} catch (IOException e) {
			throw new Exception("No se pudo escribir en el archivo");
		}
		return habitantes;
	}
	public static ArrayList<String> Area() throws Exception 
	{
		ArratList<String> area= new ArrayList<String>();
		try {
			File archivo = new File("volcanes.dat");
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
				area.add(linea.split("-")[1]) ;
				
				i++;
			}
			
			
		} catch (IOException e) {
			throw new Exception("No se pudo escribir en el archivo");
		}
		return area;
	}
	
  
}
