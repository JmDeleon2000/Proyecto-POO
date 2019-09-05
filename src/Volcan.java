/**
 * 
 */

/**
 * @author ASUS
 *
 */
public class Volcan {

	private String nombre, area;
	private int habitantes;
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * @return the habitantes
	 */
	public int getHabitantes() {
		return habitantes;
	}
	/**
	 * @param habitantes the habitantes to set
	 */
	public void setHabitantes(int habitantes) {
		this.habitantes = habitantes;
	}
	
	@Override
	public String toString() {
		return "Volcan [nombre=" + nombre + ", area=" + area + ", habitantes=" + habitantes + "]";
	}
	/**
	 * @param nombre
	 * @param area
	 * @param habitantes
	 */
	public Volcan(String nombre, String area, int habitantes) {
		this.nombre = nombre;
		this.area = area;
		this.habitantes = habitantes;
	}
	
	
	/**
	 * 
	 */
	public Volcan() 
	{
		
	}
}
