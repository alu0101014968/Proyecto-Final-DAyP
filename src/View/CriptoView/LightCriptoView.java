package View.CriptoView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class LightCriptoView extends CriptoView {
    public LightCriptoView() throws IOException {
        super();
    }

    @Override
    public void viewType() {
        panel.setBackground(SystemColor.textHighlight);
        panel_1.setBackground(SystemColor.textHighlight);
    }
}
