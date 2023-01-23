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
        contents.add(this.name);
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
        values.add(new Pair("aed", String.valueOf(o1.get("aed")).replace(".", "")));
        values.add(new Pair("bmd", String.valueOf(o1.get("bmd")).replace(".", "")));
        values.add(new Pair("cad", String.valueOf(o1.get("cad")).replace(".", "")));
        values.add(new Pair("xrp", String.valueOf(o1.get("xrp")).replace(".", "")));
        values.add(new Pair("cny", String.valueOf(o1.get("cny")).replace(".", "")));
        values.add(new Pair("eur", String.valueOf(o1.get("eur")).replace(".", "")));
        values.add(new Pair("eos", String.valueOf(o1.get("eos")).replace(".", "")));
        values.add(new Pair("chf", String.valueOf(o1.get("chf")).replace(".", "")));
        values.add(new Pair("nzd", String.valueOf(o1.get("nzd")).replace(".", "")));
        return values;
    }

    @Override
    public DefaultCategoryDataset getDiagramDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Pair p : getDiagramData("current_price")) {
            Integer val = Integer.parseInt((String) p.getSecond());
            dataset.addValue(val, "Type of market value", (String) p.getFirst());
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
