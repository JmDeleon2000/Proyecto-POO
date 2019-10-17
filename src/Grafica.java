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
    super(title);
    // Create dataset
    DefaultCategoryDataset dataset = createDataset(a1);
    // Create chart
    JFreeChart chart = ChartFactory.createLineChart(
        descripcion, // Chart title
        titX, // X-Axis Label
        titY, // Y-Axis Label
        dataset
        );

    ChartPanel panel = new ChartPanel(chart);
    setContentPane(panel);
  }

  /**
 * @param a1
 * @return el conjunto de datos dictado por los datos de la gradica
 */
private DefaultCategoryDataset createDataset(ArrayList<Double> a1, String descripcion) {

    String series1 = descripcion;

    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    
    int promedio = (a1.size()-1)/20;
    
    for(int i=0; i<a1.size();i+= promedio)
    {
    	dataset.addValue(a1.get(i), series1, String.valueOf(i));
    }

    dataset.addValue(a1.get(a1.size()-1), series1, String.valueOf(a1.size()-1));


    return dataset;
  }
}
