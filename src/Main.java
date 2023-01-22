
import Controller.CovidController;
import Model.Model;
import Model.Proxy.StrategyProxy;
import Model.Strategy.ApiCovidJson;
import View.CovidView;

import java.util.Locale;

public class Main {
    public static void main(String[] args) throws Exception {
        String url = "https://covid-19.dataflowkit.com/v1/costa rica";
        //String url = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=eur&ids=bitcoin&order=market_cap_desc&per_page=100&page=1&sparkline=false";
        //String contents = HttpUrlConnection.downloadFromURL(url);
       // String url2 = "https://api.covid19api.com/total/country/spain";

        //JSONArray jsonArray = new JSONArray(contents);
        //System.out.println(jsonArray.getJSONObject(jsonArray.length()));
        //JSONObject jsonObject = jsonArray.getJSONObject(0);


        /*JSONObject jsonObject2 = new JSONObject(contents);
        JSONArray jsonArray = new JSONArray(HttpUrlConnection.downloadFromURL(url2));
        JSONObject jsonObject = jsonArray.getJSONObject(50);
        System.out.println( jsonObject.getString("Date"));*/


        /*System.out.println(jsonObject.getString("Country"));
        System.out.println(jsonObject.getString("CountryCode"));
        System.out.println(jsonObject.getString("Province"));
        System.out.println(jsonObject.get("Active"));
        System.out.println(jsonObject.getString("Date"));*/
        //System.out.println(jsonObject.getString("id"));
        //System.out.println(jsonObject.getString("Date"));
        //System.out.println(jsonObject.getString("Country"));


        //System.out.println(jsonObject2.getString("Country_text"));

        CovidView covidView = new CovidView();
        Model model = new Model(new StrategyProxy(new ApiCovidJson()));
        CovidController controller = new CovidController(covidView, model);

        /*String fecha1 = "21-01-22T";
        String fecha2 = "10-01-22T";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(25.0, "Casos", fecha1);
        //dataset.addValue(60.0, "Recuperaciones", "fecha1");
        dataset.addValue(35.0, "Casos", fecha2);
        dataset.addValue(20.0, "Casos", "11-01-22T");

        dataset.addValue(50.0, "Recuperaciones", fecha1);
        //dataset.addValue(60.0, "Recuperaciones", "fecha1");
        dataset.addValue(50.0, "Recuperaciones", fecha2);
        dataset.addValue(33.0, "Recuperaciones", "11-01-22T");
        CategoryDatasetRepresentation c = new BarDiagram(dataset);
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
        dataset2 = dataset;
        //dataset2.addValue(20.0, "Culito", "11-01-22T");
        //c.setDataset(dataset2);
        c.removeData("Recuperaciones");
        c.restaure();
        ChartPanel chartPanel = new ChartPanel(c.getChart());
        chartPanel.setPreferredSize(new java.awt.Dimension(378, 311));
        JFrame frame = new JFrame();
        frame.add(chartPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);*/
    }
}
