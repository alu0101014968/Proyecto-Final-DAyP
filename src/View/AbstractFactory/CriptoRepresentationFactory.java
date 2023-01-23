package View.AbstractFactory;

import View.Representations.CriptoBarDiagram;
import View.Representations.CriptoLineDiagram;
import View.Representations.Representation;
import org.jfree.data.category.DefaultCategoryDataset;

public class CriptoRepresentationFactory extends RepresentationAbstractFactory {

    @Override
    public Representation createBarDiagram(DefaultCategoryDataset dataset) throws CloneNotSupportedException {
        return new CriptoBarDiagram(dataset);
    }

    @Override
    public Representation createLineDiagram(DefaultCategoryDataset dataset) throws CloneNotSupportedException {
        return new CriptoLineDiagram(dataset);
    }
}
