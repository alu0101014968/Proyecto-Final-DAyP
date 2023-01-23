package View.AbstractFactory;

import View.Representations.CategoryDatasetRepresentation;
import View.Representations.CovidLineDiagram;
import View.Representations.CriptoBarDiagram;
import View.Representations.Representation;
import org.jfree.data.category.DefaultCategoryDataset;

public class CovidRepresentationFactory extends RepresentationAbstractFactory {
    @Override
    public Representation createBarDiagram(DefaultCategoryDataset dataset) throws CloneNotSupportedException {
        return new CriptoBarDiagram(dataset);
    }

    @Override
    public Representation createLineDiagram(DefaultCategoryDataset dataset) throws CloneNotSupportedException {
        return new CovidLineDiagram(dataset);
    }
}
