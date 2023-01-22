package Model.Strategy;

public class Context {
    private ApiJSON strategy;

    public Context(ApiJSON strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(ApiJSON strategy) {
        this.strategy = strategy;
    }
}
