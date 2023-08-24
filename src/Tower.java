import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();
    public void register(Flyable p_flyable, String name) {
        System.out.println("Tower says: " + name + " registered to weather tower.");
        observers.add(p_flyable);
    }
    public void unregister(Flyable p_flyable) {
        observers.remove(p_flyable);
    }
    protected void conditionChanged() {
        for (Flyable observers: this.observers) {
            observers.updateConditions();
        }
    }
}
