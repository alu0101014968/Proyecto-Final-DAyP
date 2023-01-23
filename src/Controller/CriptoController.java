package Controller;

import Model.Model;
import View.CriptoView.CriptoView;
import View.Representations.CategoryDatasetRepresentation;
import org.jfree.chart.ChartPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriptoController implements ActionListener {
    private CriptoView view;
    private Model model;
    private CategoryDatasetRepresentation lineDiagram;
    private CategoryDatasetRepresentation barDiagram;
    private ChartPanel chartPanelBar;
    private ChartPanel chartPanelLine;



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
