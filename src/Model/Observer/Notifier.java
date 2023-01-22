package Model.Observer;

import View.Representations.Representation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.ArrayList;
import java.util.List;

public class Notifier {
    private List<Representation> susbcribers;
    private DefaultCategoryDataset dataset;

    public Notifier() {
        susbcribers = new ArrayList<>();
    }

    public void subscribe(Representation representation) {
        susbcribers.add(representation);
    }

    public void unsubscribe(Representation representations) {
        susbcribers.remove(representations);
    }

    public void setDataset(DefaultCategoryDataset dataset) throws Exception {
        this.dataset = dataset;
    }

    public void actualiceData() throws Exception {
        notifySubs(dataset);
    }

    public void notifySubs(DefaultCategoryDataset dataset) {
        susbcribers.forEach(representations -> representations.update(dataset));
    }
}
