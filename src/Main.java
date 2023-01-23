
import Controller.CovidController;
import Model.Model;
import Model.Proxy.StrategyProxy;
import Model.Strategy.ApiCovidJson;
import View.CovidView.CovidView;

import View.CovidView.DarkCovidView;
import Model.HttpUrlConnection;
import View.CovidView.LightCovidView;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) throws Exception {
        //String url = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=eur&ids=bitcoin&order=market_cap_desc&per_page=100&page=1&sparkline=false";
        CovidView darkCovidView = new DarkCovidView();
        CovidView lightCovidView = new LightCovidView();
        Model model = new Model(new StrategyProxy(new ApiCovidJson()));
        CovidController controller = new CovidController(lightCovidView, model);
      /*  String url = "https://api.coingecko.com/api/v3/coins/bitcoin";
        String data = HttpUrlConnection.downloadFromURL(url);
        JSONObject o = new JSONObject(data);
        JSONObject o1 = o.getJSONObject("market_data").getJSONObject("current_price");
        System.out.println(o.get("market_cap_rank"));*/
    }
}
