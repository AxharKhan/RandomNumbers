package randomfile;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

public class Graphgui extends ApplicationFrame {

    RandomFile rf = new RandomFile();
    int a = rf.arr[0];

    /**
     * @author Ashar Ali
     */

    public Graphgui(final String title) {

        // Writing on the Graph
        super("Random Numbers Graph");
        Read rd = new Read();
        int[] arr = rd.retarr();
        final XYSeries series = new XYSeries("Random Data");
        series.add(0, arr[0]);
        series.add(1, arr[1]);
        series.add(2, arr[2]);
        series.add(3, arr[3]);
        series.add(4, arr[4]);
        series.add(5, arr[5]);
        series.add(6, arr[6]);
        series.add(7, arr[7]);
        series.add(8, arr[8]);
        series.add(9, arr[9]);
        final XYSeriesCollection data = new XYSeriesCollection(series);
        final JFreeChart chart = ChartFactory.createXYLineChart("Random Number Occurance Rates", "Occurance", "Number",
                data, PlotOrientation.VERTICAL, true, true, false);

        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }
}