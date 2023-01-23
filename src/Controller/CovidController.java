package Controller;

import Model.Model;
import View.AbstractFactory.CovidRepresentationFactory;
import View.AbstractFactory.CriptoRepresentationFactory;
import View.AbstractFactory.RepresentationAbstractFactory;
import View.Representations.CategoryDatasetRepresentation;
import View.CovidView.CovidView;
import View.Representations.CriptoLineDiagram;
import org.jfree.chart.ChartPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class CovidController implements ActionListener {
    private CovidView view;
    private Model model;
    private CategoryDatasetRepresentation lineDiagram;
    private CategoryDatasetRepresentation barDiagram;
    private ChartPanel chartPanelBar;
    private ChartPanel chartPanelLine;

    public CovidController(CovidView view, Model model) throws Exception {
        this.view = view;
        this.model = model;
        this.view.findButton.addActionListener(this);
        this.view.updateButton.addActionListener(this);
        this.view.comboBox1.addActionListener(this);
        this.view.comboBox2.addActionListener(this);
        this.view.casesButton.addActionListener(this);
        this.view.summaryButton.addActionListener(this);
        this.view.recoverButton.addActionListener(this);
        this.view.helpButton.addActionListener(this);
        this.view.deathsButton.addActionListener(this);
        init();
    }

    public void setInfo(ArrayList<String> info) {
        Date date = new Date();
        view.lbCountry.setText(info.get(0));
        view.lblCasesValue.setText(info.get(1));
        view.lblDeathsValue.setText(info.get(2));
        view.lbRecovered.setText(info.get(3));
        view.lbVaccinated.setText(info.get(4));
        view.lbnewCasesToday.setText(info.get(5));
        view.lbUpdate.setText("Last update: " + String.valueOf(date));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CovidRepresentationFactory factory = new CovidRepresentationFactory();
        try {
            CategoryDatasetRepresentation auxlineDiagram = (CategoryDatasetRepresentation) factory.createLineDiagram(lineDiagram.getDataset());
            CategoryDatasetRepresentation auxbarDiagram = (CategoryDatasetRepresentation) factory.createBarDiagram(barDiagram.getDataset());
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        if (view.comboBox1.getSelectedItem().equals("Bar Diagram")) {
            view.graphic1.removeAll();
            view.graphic1.add(chartPanelBar);
        } else {
            view.graphic1.removeAll();
            view.graphic1.add(chartPanelLine);
        }
        if (view.comboBox2.getSelectedItem().equals("All")) {
            restaure();
        } else if (view.comboBox2.getSelectedItem().equals("2020")) {
            restaure();
            barDiagram.removeAllColums("2022");
            lineDiagram.removeAllColums("2022");
            barDiagram.removeAllColums("2021");
            lineDiagram.removeAllColums("2021");
        } else if (view.comboBox2.getSelectedItem().equals("2021")) {
            restaure();
            barDiagram.removeAllColums("2022");
            lineDiagram.removeAllColums("2022");
            barDiagram.removeAllColums("2020");
            lineDiagram.removeAllColums("2020");
        } else if (view.comboBox2.getSelectedItem().equals("2022")) {
            restaure();
            barDiagram.removeAllColums("2021");
            lineDiagram.removeAllColums("2021");
            barDiagram.removeAllColums("2020");
            lineDiagram.removeAllColums("2020");
        }
        view.graphic1.revalidate();
        view.graphic1.repaint();
        view.graphic1.setVisible(true);

        Object origen = e.getSource();
        if (origen == this.view.findButton) {
            findButtonFunction();
        } else if (origen == view.updateButton) {
            updateButtonFunction();
        } else if (origen == view.helpButton) {
            JOptionPane.showMessageDialog(null, "Write a Country and then click in the find button " +
                    "to see all its covid data");
        } else if (origen == view.recoverButton) {
            restaure();
            barDiagram.removeData("Cases");
            barDiagram.removeData("Deaths");
        } else if (origen == view.deathsButton) {
            restaure();
            barDiagram.removeData("Cases");
            barDiagram.removeData("Recovered");
        } else if (origen == view.casesButton) {
            restaure();
            barDiagram.removeData("Deaths");
            barDiagram.removeData("Recovered");
        } else if (origen == view.summaryButton) {
           restaure();
        }
    }

    public void restaure() {
        barDiagram.setDataset(model.getDiagramDataset());
        lineDiagram.setDataset(model.getDiagramDataset());
    }

    private void findButtonFunction() {
        if (!view.countryTextfield.getText().isEmpty()) {
            try {
                this.model.loadData(view.countryTextfield.getText());
                view.countryTextfield.setText("");
                setInfo(model.getInfo());
                view.setImage(model.getImageUrl());
            } catch (Exception ex) {
                view.countryTextfield.setText("");
                JOptionPane.showMessageDialog(null, "Unknown Country");
            }
        } else {
            JOptionPane.showMessageDialog(null, "You must write a Name of a country");
        }
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

    public void init() throws Exception {
        model.loadData("Spain");
        setInfo(model.getInfo());

        initialiceGraphics();
        view.graphic1.add(chartPanelBar);
        view.graphic1.setVisible(true);
        view.panel_2.setVisible(true);

        view.setImage(model.getImageUrl());
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }

    private void initialiceGraphics() throws CloneNotSupportedException {
        RepresentationAbstractFactory factory = new CovidRepresentationFactory();
        barDiagram = (CategoryDatasetRepresentation) factory.createBarDiagram(this.model.getDiagramDataset());
        lineDiagram = (CategoryDatasetRepresentation) factory.createLineDiagram(this.model.getDiagramDataset());
        model.subscribe(barDiagram);
        model.subscribe(lineDiagram);

        chartPanelBar = new ChartPanel(barDiagram.getChart());
        view.graphic1.setLayout(new java.awt.BorderLayout());


        chartPanelLine = new ChartPanel(lineDiagram.getChart());
        view.graphic1.setLayout(new java.awt.BorderLayout());
    }
}
