package View.Representations;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class CriptoLineDiagram extends CategoryDatasetRepresentation {
    public CriptoLineDiagram(DefaultCategoryDataset dataset) throws CloneNotSupportedException {
        super(dataset, "Cripto Line Diagram");
    }

    @Override
    public void makeDiagram() {
        chart = ChartFactory.createLineChart(
                "Cripto Line Diagram",
                "Days",
                "Values",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
    }
}
