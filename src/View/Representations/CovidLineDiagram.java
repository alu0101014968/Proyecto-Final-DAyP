package View.Representations;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class CovidLineDiagram extends CategoryDatasetRepresentation {
    public CovidLineDiagram(DefaultCategoryDataset dataset) throws CloneNotSupportedException {
        super(dataset, "Covid Line Diagram");
    }

    @Override
    public void makeDiagram() {
        chart = ChartFactory.createLineChart(
                "Covid Line Diagram",
                "Days",
                "Values",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
    }
}
