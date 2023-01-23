
import Controller.CovidController;
import Controller.CriptoController;
import Model.Model;
import Model.Proxy.StrategyProxy;
import Model.Strategy.ApiCovidJson;
import Model.Strategy.ApiCriptoJson;
import View.CovidView.CovidView;

import View.CovidView.DarkCovidView;
import Model.HttpUrlConnection;
import View.CovidView.LightCovidView;
import View.CriptoView.CriptoView;
import View.CriptoView.LightCriptoView;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) throws Exception {
        CovidView darkCovidView = new DarkCovidView();
        CovidView lightCovidView = new LightCovidView();
        CriptoView lightCriptoview = new LightCriptoView();

        Model covidModel = new Model(new StrategyProxy(new ApiCovidJson()));
        Model criptoModel = new Model(new StrategyProxy(new ApiCriptoJson()));

        //CovidController controller = new CovidController(darkCovidView, covidModel);
        CriptoController criptoController = new CriptoController(lightCriptoview, criptoModel);
    }
}
