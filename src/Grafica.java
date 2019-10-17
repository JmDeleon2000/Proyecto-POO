import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.plot.PlotOrientation;
import java.awt.Dimension;
import javax.swing.*;
import java.io.File;
 
public class Grafica extends JFrame {
 
    public Grafica(ArrayList<String> areas, ArrayList<Integer> habitantes){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        DefaultCategoryDataset datasetArchivo = new DefaultCategoryDataset();
        int i = 0;
        for (i = 0; i<=areas.length-1;i++){
            dataset.addValue(habitantes.get(i), "Habitantes", areas.get(i));
        }
        JFreeChart chart = ChartFactory.createBarChart("Area vs Habitantes",
                                                        "Areas",
                                                        "Habitantes",
                                                        dataset,
                                                        PlotOrientation.HORIZONTAL, true, true, true);
        ChartPanel chartPanel = new ChartPanel(chart, false);
        chartPanel.setPreferredSize(new Dimension(500, 500));
        setContentPane(chartPanel);
        try {
            JFreeChart chartArchivo= ChartFactory.createBarChart("Area vs Habitantes", "Areas", "Habitantes", datasetArchivo, PlotOrientation.HORIZONTAL, true, true, true);
            ChartUtilities.saveChartAsJPEG(new File("imagen.jpeg"),chartArchivo,this.getHeight(),this.getWidth());
        }catch (Exception ex) {
            System.out.println (ex);
        }
    }

}
