package Model.Strategy;

import Model.HttpUrlConnection;
import Model.Pair;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.IOException;
import java.util.ArrayList;

public class ApiCriptoJson implements Strategy {
    private String data;
    private String name;
    private String url = "https://api.covid19api.com/total/country/";

    public ApiCriptoJson() {

    }

    public ApiCriptoJson(String url) {
        this.url = url;
    }

    public void setData(String data, String name) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public boolean loadData(String name) throws IOException {
        data = HttpUrlConnection.downloadFromURL(url + name);
        return !data.equals("Error");
    }

    @Override
    public ArrayList<String> getInfo() {
        return null;
    }

    @Override
    public ArrayList<Pair> getChartDiagram(String id) {
        return new ArrayList<Pair>();
    }

    @Override
    public ArrayList<Pair> getLineDiagram(String id) {
        return new ArrayList<Pair>();
    }

    @Override
    public DefaultCategoryDataset getDiagramDataset() {
        return null;
    }

    @Override
    public boolean actualice(String name) throws IOException {
        return loadData(name);
    }

    @Override
    public String getImageUrl() {
        return null;
    }
}
