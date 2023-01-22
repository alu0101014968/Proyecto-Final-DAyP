package View.Representations;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineDiagram extends CategoryDatasetRepresentation {
    public LineDiagram(DefaultCategoryDataset dataset) throws CloneNotSupportedException {
        super(dataset, "Covid Line Diagram");
    }

    @Override
    public void makeDiagram() {
        chart = ChartFactory.createLineChart(
                "Bar Diagram",
                "Days",
                "Values",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
    }
}
