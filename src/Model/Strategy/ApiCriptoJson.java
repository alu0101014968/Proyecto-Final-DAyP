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
        this.name = name;
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public boolean loadData(String name) throws IOException {
        this.name = name;
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
        ArrayList<Pair> values = new ArrayList<>();
        JSONObject o = new JSONObject(data);
        JSONObject o1 = o.getJSONObject("market_data").getJSONObject(id);
        values.add(new Pair("aed", o1.get("aed")));
        values.add(new Pair("bmd", o1.get("bmd")));
        values.add(new Pair("cad", o1.get("cad")));
        values.add(new Pair("czk", o1.get("czk")));
        values.add(new Pair("cny", o1.get("cny")));
        values.add(new Pair("eur", o1.get("eur")));
        values.add(new Pair("eos", o1.get("eos")));
        values.add(new Pair("gbp", o1.get("gbp")));
        values.add(new Pair("nzd", o1.get("nzd")));
        return values;
    }

    @Override
    public DefaultCategoryDataset getDiagramDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Pair p : getDiagramData("current_price")) {
            dataset.addValue((Integer) p.getSecond(), "Type of market value", (String) p.getFirst());
        }
        return dataset;
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
