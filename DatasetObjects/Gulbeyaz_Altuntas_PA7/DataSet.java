import java.util.ArrayList;

public class DataSet {

    private ArrayList<Observer> observers; // array list of observers from the observer class
    private ArrayList<BaseClass> data; // array list for the data from the base class (ITAV)

    public DataSet() { // default constructor
        observers = new ArrayList<>();
        data = new ArrayList<>();
    }

    public void add(BaseClass e) { // adder function to add the data we get from the base class to data
        data.add(e);
        notifyObservers(); // call the notify function to update
    }

    public void remove(BaseClass e) { // removes the base class object from the data set
        data.remove(e);
        notifyObservers();
    }

    public void register(Observer obj) { // this registers an observer
        observers.add(obj);
        obj.setSubject(this); // it sets the observer to the subject instantly
    }

    public void unregister(Observer obj) {
        observers.remove(obj); // removes the object from the observers
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(data); // it calles the update function and changes the list to what's given
        }
    }
}
