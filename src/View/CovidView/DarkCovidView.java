package View.CovidView;

import View.CovidView.CovidView;

import java.awt.*;
import java.io.IOException;

public class DarkCovidView extends CovidView {
    public DarkCovidView() throws IOException {
        super();
    }

    @Override
    public void viewType() {
        panel.setBackground(SystemColor.BLACK);
        panel_1.setBackground(SystemColor.BLACK);
    }

    @Override
    public void fontType() {
        font = "Tempus Sans ITC";
    }
}
