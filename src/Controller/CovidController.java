package Controller;

import Model.Model;
import View.Representations.BarDiagram;
import View.Representations.CategoryDatasetRepresentation;
import View.CovidView;
import org.jfree.chart.ChartPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class CovidController implements ActionListener {
    private CovidView view;
    private Model model;
    private CategoryDatasetRepresentation lineDiagram;
    private CategoryDatasetRepresentation barDiagram;

    public CovidController(CovidView view, Model model) throws Exception {
        this.view = view;
        this.model = model;
        this.view.findButton.addActionListener(this);

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

    public void init() throws Exception {
        model.loadData("Spain");
        setInfo(model.getInfo());
        barDiagram = new BarDiagram(this.model.getDiagramDataset());
        model.subscribe(barDiagram);
        ChartPanel chartPanel = new ChartPanel(barDiagram.getChart());
        chartPanel.setPreferredSize(new java.awt.Dimension(view.graphic1.getWidth(), view.graphic1.getHeight()));
        JPanel mainPanel = new JPanel();
        mainPanel.add(chartPanel);
        view.graphic1.add(mainPanel);

        view.graphic1.setVisible(true);

        view.setImage(model.getImageUrl());
        view.setVisible(true);
        view.setLocationRelativeTo(null);
    }
}
