import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class Grafica extends JFrame {

  private static final long serialVersionUID = 1L;

  public Grafica(String title,String descripcion, String titX, String titY, ArrayList<Double> a1) {
	  
  }

  /**
 * @param a1
 * @return el conjunto de datos dictado por los datos de la gradica
 */
private DefaultCategoryDataset createDataset(ArrayList<Double> a1, String descripcion) {


    return dataset;
  }
}
