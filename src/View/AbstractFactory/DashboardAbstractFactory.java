package View.AbstractFactory;

import View.ICovidView;

import java.io.IOException;

public abstract class DashboardAbstractFactory {
    abstract void CreateCovidDashboard() throws IOException;
        // Aqui se podran facbricar 2 tipos de vistas para los datos covid: Una puede ser con los datos
        // mostrados con el diagrama de lineas de chart y los datos y otro quintando el cahrt y poniendo un pieChart
    abstract void CreateCriptoDashboard();
        // Lo mismo pero para los datos de criptomonedas
}
