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

   /* public boolean loadData(String name) throws IOException {
        this.name = name;
        //if (!strategyProxy.loadData(name))
            //strategyProxy.loadData("spain");
        return strategyProxy.loadData(name); // En el caso que de error mostramos ventana con error
    }*/
    // Seria proxy porque simula ser un strategy
    public void setStrategy(Strategy strategy) {
        this.strategyProxy = strategy;
    }

    // Crea el modelo con los datos necesarios como graficas e informacion, de un tipo de dato en especifico
    // Por ejemplo de un name[pais]: Spain o de una name[moneda]: bitcoin
    // El name se pasa a traves de la vista this.name = view.textfield() o view.getName()
    public HashMap<String, ArrayList<Pair>> makeModel(String name) throws IOException {
        // Podria contener los anteriores metodos usando cada una de sus funciones
        //this.name = name;
        HashMap<String, ArrayList<Pair>> components = new HashMap<>();
        //if (!strategyProxy.loadData(name))
            //strategyProxy.loadData("spain");
        //components.put("LineDiagram", strategyProxy.getLineDiagram());
        ///components.put("Info", strategyProxy.getInfo());
        //components.put("ChartDiagram", strategyProxy.getChartDiagram());
        return components;
    }

    public boolean loadData(String name) throws Exception {
        this.name = name;
        boolean value = strategyProxy.loadData(name);
        notifier.setDataset(strategyProxy.getDiagramDataset());
        notifier.actualiceData();
        return value;
    }

    public boolean actualice() throws Exception {

        // thread = new Runable lo que sea
        // thread.sleep() tiempo que sea (Covid 10 min, Cripto 1 min)
        strategyProxy.actualice(name);
        return loadData(name);
        // thread.close();
    }

    public HashMap<String, ArrayList<Pair>> getGraphics(String id) { // Seria el makeModel()
        HashMap<String, ArrayList<Pair>> components = new HashMap<>();
        components.put("LineDiagram", getLineGraphic(id));
        components.put("ChartDiagram", getBarGraphic(id));
        return components;
    }

    public ArrayList<Pair> getLineGraphic(String id) {
        //strategyProxy.getLineDiagram(id);
        return null;
    }

    public ArrayList<Pair> getBarGraphic(String id) {
        //strategyProxy.getBarDiagram(id);
        return null;
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
}
