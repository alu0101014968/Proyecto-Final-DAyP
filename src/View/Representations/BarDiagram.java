package View.Representations;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarDiagram extends CategoryDatasetRepresentation {
    public BarDiagram(DefaultCategoryDataset dataset) throws CloneNotSupportedException {
        super(dataset, "Covid Bar Diagram");
    }

    @Override
    public void makeDiagram() {
       chart = ChartFactory.createBarChart(
                "Bar Diagram",
                "Days",
                "Values",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
    }
}
