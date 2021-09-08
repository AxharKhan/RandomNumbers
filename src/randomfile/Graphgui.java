package randomfile;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYDataset;

/** @see http://stackoverflow.com/questions/5522575 */
public class Graphgui {

    private static final String title = "Random Number Graph";
    private ChartPanel chartPanel = createChart();

    static int strt = 1;
    static int nd = 1;


    public Graphgui(int k, int l) {

        JFrame f = new JFrame(title);
        f.setTitle(title);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout(0, 5));
        f.add(chartPanel, BorderLayout.CENTER);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setHorizontalAxisTrace(true);
        chartPanel.setVerticalAxisTrace(true);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.add(createTrace());
        // panel.add(createDate());
        panel.add(createZoom());
        f.add(panel, BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private JComboBox createTrace() {
        final JComboBox trace = new JComboBox();
        final String[] traceCmds = { "Enable Trace", "Disable Trace" };
        trace.setModel(new DefaultComboBoxModel(traceCmds));
        trace.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (traceCmds[0].equals(trace.getSelectedItem())) {
                    chartPanel.setHorizontalAxisTrace(true);
                    chartPanel.setVerticalAxisTrace(true);
                    chartPanel.repaint();
                } else {
                    chartPanel.setHorizontalAxisTrace(false);
                    chartPanel.setVerticalAxisTrace(false);
                    chartPanel.repaint();
                }
            }
        });
        return trace;
    }


    private JButton createZoom() {
        final JButton auto = new JButton(new AbstractAction("Auto Zoom") {

            @Override
            public void actionPerformed(ActionEvent e) {
                chartPanel.restoreAutoBounds();
            }
        });
        return auto;
    }

    private ChartPanel createChart() {
        GenerateGraph ob = new GenerateGraph();


        XYDataset roiData = createDatasetlooped(getstrt(), getnd());
        JFreeChart chart = ChartFactory.createXYLineChart("Random Number Occurance Rates", "Occurance", "Number",
                roiData, PlotOrientation.VERTICAL, true, true, false);
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.setBaseShapesVisible(true);

        NumberAxis xAxis = new NumberAxis();
        xAxis.setRange(800, 1100);
        NumberAxis yAxis = new NumberAxis();
        yAxis.setRange(0, 9);
        yAxis.setTickUnit(new NumberTickUnit(1.0));
        plot.setDomainAxis(yAxis);
        plot.setRangeAxis(xAxis);
        return new ChartPanel(chart);
    }

    private XYDataset createDataset(int seed) {
        XYSeriesCollection tsc = new XYSeriesCollection();

        tsc.addSeries(createSeries("Series " + seed + "seed", seed));

        return tsc;
    }

    private XYDataset createDatasetlooped(int t, int d) {
        XYSeriesCollection tsc = new XYSeriesCollection();
        int l = d - t;
        l = l + 1;
        for (int i = 0; i < l; i++) {
            tsc.addSeries(createSeries("Seed " + t, t));
            t = t + 1;
        }
        return tsc;
    }

    private XYSeries createSeries(String name, int seed) {
        XYSeries series = new XYSeries(name);
        Read ob = new Read();
        int[] arr;
        arr = ob.retarr(seed);
        for (int i = 0; i < 10; i++) {
            series.add(i, arr[i]);
        }
        return series;
    }

    Graphgui(int k, int l, int j) {
        setstrt(k);
        setnd(l);

        Graphgui cpd = new Graphgui(k, l);
    }

    public void setstrt(int k) {
        strt = k;
    }

    public void setnd(int l) {
        nd = l;
    }

    public int getstrt() {
        return strt;
    }

    public int getnd() {
        return nd;
    }
}
