import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();
    public void register(Flyable p_flyable, String name) {
        System.out.println("Tower says: " + name + " registered to weather tower.");
        observers.add(p_flyable);
    }
    public void unregister(Flyable p_flyable, String name) {
        System.out.println("Tower says: " + name + " unregistered to weather tower.");
        observers.remove(p_flyable);
    }
    protected void conditionChanged() {
        for (int i=observers.size() - 1; i >= 0; i--) {
            observers.get(i).updateConditions();
        }
    }
}
