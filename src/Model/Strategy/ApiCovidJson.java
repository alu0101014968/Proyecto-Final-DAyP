package Model.Strategy;

import Model.HttpUrlConnection;
import Model.Pair;
import org.jfree.data.category.DefaultCategoryDataset;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;

public class ApiCovidJson implements Strategy {
    private String data;
    private String infoData;
    private String name;
    final private String url = "https://api.covid19api.com/total/country/";
    final private String infoUrl = "https://covid-19.dataflowkit.com/v1/";
    final private String imageUrl = "https://countryflagsapi.com/png/";

    public ApiCovidJson() {

    }

    public ApiCovidJson(String name) throws IOException {
        loadData(name);
    }

    public void setData(String data, String name) throws IOException {
        this.name = name;
        this.data = data;
        this.infoData = HttpUrlConnection.downloadFromURL(infoUrl + name);
    }

    public String getData() {
        return data;
    }

    @Override
    public boolean loadData(String name) throws IOException {
        this.name = name;
        this.data = HttpUrlConnection.downloadFromURL(url + name);
        this.infoData = HttpUrlConnection.downloadFromURL(infoUrl + name);
        return !data.equals("Error")  && !infoData.equals("Error");
    }

    @Override
    public boolean actualice(String name) throws IOException {
        return loadData(name);
    }

    @Override
    public String getImageUrl() throws IOException {
        return imageUrl + name.replace(" ", "%20");
    }

    @Override
    public ArrayList<String> getInfo() throws IOException, ParseException {
        if (infoData == null) {
            infoData = HttpUrlConnection.downloadFromURL(infoUrl + name);
        }
        ArrayList<String> contents = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(infoData);
        contents.add(jsonObject.getString("Country_text"));
        contents.add(jsonObject.getString("Total Cases_text"));
        contents.add(jsonObject.getString("Total Deaths_text"));
        contents.add(jsonObject.getString("Total Recovered_text"));
        long number = (long) NumberFormat.getNumberInstance(java.util.Locale.US).parse(contents.get(1));
        contents.add(String.valueOf(number * 3));
        String aux = jsonObject.getString("New Cases_text");
        if (!aux.isEmpty())
            contents.add(jsonObject.getString("New Cases_text"));
        else
            contents.add("There is no new cases");
        return contents;
    }

    @Override
    public ArrayList<Pair> getDiagramData(String id) { // getDiagramData
        ArrayList<Pair> values = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(data);
        JSONObject jsonObject;
        for (int i = 0; i < jsonArray.length(); i++) {
            jsonObject = jsonArray.getJSONObject(i);
            //System.out.println(jsonObject);
            String date = removeLastNchars(jsonObject.getString("Date"), 10);
            Integer number = jsonObject.getInt(id);
            if (i > 0) {
                if (number == 0) {
                    number = 0;
                } else {
                    JSONObject aux = jsonArray.getJSONObject(i - 1);
                    number = Math.abs(number - aux.getInt(id));
                }
            }
            values.add(new Pair(date,number));
        }
        return values;
    }

    public DefaultCategoryDataset getDiagramDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Pair p : getDiagramData("Confirmed")) {
            dataset.addValue((Integer) p.getSecond(), "Cases", (String) p.getFirst());
        }

        for (Pair p : getDiagramData("Deaths")) {
            dataset.addValue((Integer) p.getSecond(), "Deaths", (String) p.getFirst());
        }

        for (Pair p : getDiagramData("Recovered")) {
            dataset.addValue((Integer) p.getSecond(), "Recovered", (String) p.getFirst());
        }
        return dataset;
    }

    private String removeLastNchars(String str, int n) {
        return str.substring(0, str.length() - n);
    }
}
