package Controller;

import Model.Model;
import View.AbstractFactory.CovidRepresentationFactory;
import View.AbstractFactory.CriptoRepresentationFactory;
import View.AbstractFactory.RepresentationAbstractFactory;
import View.CovidView.CovidView;
import View.CriptoView.CriptoView;
import View.Representations.CategoryDatasetRepresentation;
import org.jfree.chart.ChartPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class CriptoController implements ActionListener {
    private CriptoView view;
    private Model model;
    private CategoryDatasetRepresentation lineDiagram;
    private CategoryDatasetRepresentation barDiagram;
    private ChartPanel chartPanelBar;
    private ChartPanel chartPanelLine;

    public CriptoController(CriptoView view, Model model) throws Exception {
        this.view = view;
        this.model = model;
        this.view.findButton.addActionListener(this);
        this.view.updateButton.addActionListener(this);
        this.view.linebutton.addActionListener(this);
        this.view.barButton.addActionListener(this);
        this.view.helpButton.addActionListener(this);
        init();
    }

    public void init() throws Exception {
        model.loadData("bitcoin");
        setInfo(model.getInfo());

        initialiceGraphics();
        view.graphic1.add(chartPanelBar);
        view.graphic1.setVisible(true);

        view.setImage(model.getImageUrl());
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }

    private void initialiceGraphics() throws CloneNotSupportedException {
        RepresentationAbstractFactory factory = new CriptoRepresentationFactory();
        barDiagram = (CategoryDatasetRepresentation) factory.createBarDiagram(this.model.getDiagramDataset());
        lineDiagram = (CategoryDatasetRepresentation) factory.createLineDiagram(this.model.getDiagramDataset());
        model.subscribe(barDiagram);
        model.subscribe(lineDiagram);

        chartPanelBar = new ChartPanel(barDiagram.getChart());
        view.graphic1.setLayout(new java.awt.BorderLayout());


        chartPanelLine = new ChartPanel(lineDiagram.getChart());
        view.graphic1.setLayout(new java.awt.BorderLayout());
    }

    public void setInfo(ArrayList<String> info) {
        Date date = new Date();
        view.lbCoin.setText(info.get(0));
        view.lbCoinpricevalue.setText(info.get(1));
        view.lbmarketrankVlaue.setText(info.get(2));
        view.lbdeveloperValue.setText(info.get(3));
        view.lbUpdate.setText("Last update: " + String.valueOf(date));
    }

    public void updateButtonFunction() {
        try {
            this.model.actualice(model.getName());
            Date date = new Date();
            view.lbUpdate.setText("Last update: " + String.valueOf(date));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
