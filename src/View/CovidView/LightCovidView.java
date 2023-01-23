package View.CovidView;

import View.CovidView.CovidView;

import java.awt.*;
import java.io.IOException;

public class LightCovidView extends CovidView {
    public LightCovidView() throws IOException {
        super();
    }

    @Override
    public void viewType() {
        panel.setBackground(SystemColor.textHighlight);
        panel_1.setBackground(SystemColor.textHighlight);
    }

    @Override
    public void fontType() {
        font = "Roboto";
    }
}
