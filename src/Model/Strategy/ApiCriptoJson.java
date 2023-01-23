package Model.Strategy;

import Model.HttpUrlConnection;
import Model.Pair;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class ApiCriptoJson implements Strategy {
    private String data;
    private String name;
    private String url = "https://api.coingecko.com/api/v3/coins/";

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
        ArrayList<String> contents = new ArrayList<>();
        JSONObject o = new JSONObject(data);
        JSONObject o1 = o.getJSONObject("market_data").getJSONObject("current_price");
        contents.add(String.valueOf(o1.get("eur")));
        contents.add(String.valueOf(o.get("market_cap_rank")));
        contents.add(String.valueOf(o.get("developer_score")));
        return contents;
    }

    @Override
    public ArrayList<Pair> getDiagramData(String id) {
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
        JSONObject o = new JSONObject(data);
        JSONObject o1 = o.getJSONObject("image");
        return o1.getString("large");
    }
}
