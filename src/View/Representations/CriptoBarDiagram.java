package View.Representations;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class CriptoBarDiagram extends CategoryDatasetRepresentation {
    public CriptoBarDiagram(DefaultCategoryDataset dataset) throws CloneNotSupportedException {
        super(dataset, "Cripto Bar Diagram");
    }

    @Override
    public void makeDiagram() {
        chart = ChartFactory.createBarChart(
                "Cripto Bar Diagram",
                "Days",
                "Values",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
    }
}
