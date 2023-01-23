package Model;

import Model.Observer.Notifier;
import View.Representations.Representation;
import Model.Strategy.Strategy;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public class Model {
    private Strategy strategyProxy;
    private String name;
    private Notifier notifier; // Los graficos estan el la vista y seran notificados desde aqui

    public Model(Strategy strategy) {
        this.strategyProxy = strategy;
        notifier = new Notifier();
    }

    public void setStrategy(Strategy strategy) {
        this.strategyProxy = strategy;
    }

    public boolean loadData(String name) throws Exception {
        this.name = name;
        boolean value = strategyProxy.loadData(name);
        notifier.setDataset(strategyProxy.getDiagramDataset());
        notifier.actualiceData();
        return value;
    }

    public boolean actualice(String name) throws Exception {

        // thread = new Runable lo que sea
        // thread.sleep() tiempo que sea (Covid 10 min, Cripto 1 min)
        return strategyProxy.actualice(this.name);
        // thread.close();
    }

    public void subscribe(Representation representation) {
        notifier.subscribe(representation);
    }

    public DefaultCategoryDataset getDiagramDataset() {
        return strategyProxy.getDiagramDataset();
    }

    public void unsubscribe(Representation representation) {
        notifier.unsubscribe(representation);
    }

    public String getImageUrl() throws IOException {
        return strategyProxy.getImageUrl();
    }

    public ArrayList<String> getInfo() throws IOException, ParseException {
        return strategyProxy.getInfo();
    }

    public Notifier getNotifier() {
        return notifier;
    }

    public String getName() {
        return name;
    }
}
