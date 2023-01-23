package Model.Strategy;

import Model.Pair;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public interface Strategy {
    boolean loadData(String name) throws IOException;
    ArrayList<String> getInfo() throws IOException, ParseException;
    void setData(String data, String name) throws IOException;
    String getData();
    ArrayList<Pair> getDiagramData(String id);
    DefaultCategoryDataset getDiagramDataset();
    boolean actualice(String name) throws IOException;
    String getImageUrl() throws IOException;
}
