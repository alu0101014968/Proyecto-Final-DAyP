package Model.Proxy;

import Model.Pair;
import Model.Strategy.ApiCovidJson;
import Model.Strategy.Strategy;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class StrategyProxy implements Strategy {
    Strategy apiData;
    HashMap<String, String> cache;
    Thread thread;

    public StrategyProxy() {
        cache = new HashMap<>();
    }

    public StrategyProxy(Strategy strategy) {
        cache = new HashMap<>();
        apiData = strategy;
    }

    @Override
    public boolean loadData(String name) throws IOException {
        if (cache.containsKey(name)) {
            apiData.setData(cache.get(name), name);
            return true;
        } else {
            if (apiData == null) {
                apiData = new ApiCovidJson();
            }
            boolean value = apiData.loadData(name);
            cache.put(name.toLowerCase(Locale.ROOT),apiData.getData());
            return value;
        }
    }

    @Override
    public ArrayList<String> getInfo() throws IOException, ParseException {
        if (apiData == null) {
            apiData = new ApiCovidJson();
        }
        return apiData.getInfo();
    }

    @Override
    public void setData(String data,String name) throws IOException {
        if (apiData == null) {
            apiData = new ApiCovidJson();
        }
        apiData.setData(data, name);
    }

    @Override
    public String getData() {
        if (apiData == null) {
            apiData = new ApiCovidJson();
        }
        return apiData.getData();
    }

    @Override
    public ArrayList<Pair> getChartDiagram(String id) {
        if (apiData == null) {
            apiData = new ApiCovidJson();
        }
        return apiData.getChartDiagram(id);
    }

    @Override
    public ArrayList<Pair> getLineDiagram(String id) {
        if (apiData == null) {
            apiData = new ApiCovidJson();
        }
        return apiData.getLineDiagram(id);
    }

    @Override
    public DefaultCategoryDataset getDiagramDataset() {
        if (apiData == null) {
            apiData = new ApiCovidJson();
        }
        return apiData.getDiagramDataset();
    }

    public boolean actualice(String name) throws IOException {
        if (apiData == null) {
            apiData = new ApiCovidJson();
        }
        boolean value = apiData.actualice(name);
        cache.put(name.toLowerCase(Locale.ROOT),apiData.getData());
        return value;
    }

    @Override
    public String getImageUrl() throws IOException {
        return apiData.getImageUrl();
    }
}
