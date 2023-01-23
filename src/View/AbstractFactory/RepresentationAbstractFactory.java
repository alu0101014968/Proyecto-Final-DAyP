package View.AbstractFactory;

import View.Representations.CategoryDatasetRepresentation;
import View.Representations.Representation;
import org.jfree.data.category.DefaultCategoryDataset;

public abstract class RepresentationAbstractFactory {
    public abstract Representation createBarDiagram(DefaultCategoryDataset dataset) throws CloneNotSupportedException;

    public abstract Representation createLineDiagram(DefaultCategoryDataset dataset) throws CloneNotSupportedException;
}
