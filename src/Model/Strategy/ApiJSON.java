package Model.Strategy;

public interface ApiJSON {
    void getURL(String url);
    void getValues(String name); // Dado un nombre de moneda, o lo que sea, se busca la informacion relativa al mismo
}
