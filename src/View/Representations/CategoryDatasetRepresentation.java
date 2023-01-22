package View.Representations;

import Model.Pair;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.ArrayList;

public abstract class CategoryDatasetRepresentation extends JFrame implements Representation {
    protected JFreeChart chart;
    protected String title;
    protected DefaultCategoryDataset dataset;
    protected DefaultCategoryDataset datasetCopy;

    public CategoryDatasetRepresentation(DefaultCategoryDataset dataset, String title) throws CloneNotSupportedException {
        this.dataset = dataset;
        this.datasetCopy = (DefaultCategoryDataset) dataset.clone();
        makeDiagram();
    }

    public abstract void makeDiagram();

    public void setTitle(String title) {
        this.title = title;
    }

    public void addData(ArrayList<Pair> data, String id) {
        for (Pair p : data) {
            dataset.addValue((Double) p.getSecond(), id, (Integer) p.getFirst());
        }
        setDataset(dataset);
    }

    public JFreeChart getChart() {
        return chart;
    }

    public void removeData(String id) {
        dataset.removeRow(id);
        setDataset(dataset);
    }

    public void restaure() {
        setDataset(datasetCopy);
    }

    public void setDataset(DefaultCategoryDataset dataset) {
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setDataset(dataset);
    }

    @Override
    public void update(DefaultCategoryDataset dataset) {
        setDataset(dataset);
    }
}
