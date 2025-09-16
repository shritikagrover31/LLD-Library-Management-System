import java.util.*;

public abstract class NotificationSubject {
    private final List<NotificationObserver> observers = new ArrayList<>();

    public void addObserver(NotificationObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(NotificationObserver observer) {
        observers.remove(observer);
    }

    protected void notifyObservers(String message) {
        for (NotificationObserver observer : observers) observer.notify(message);
    }
}

