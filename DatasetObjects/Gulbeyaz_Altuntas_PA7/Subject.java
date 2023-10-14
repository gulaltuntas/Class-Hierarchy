import java.util.ArrayList;

public interface Subject {
    void register(Observer observer); // it will register the observer
    void unregister(Observer observer); // it will unregister the observer
    void notifyObservers(ArrayList<BaseClass> data); // if there is a change, it will notify the observers and going to update the changes
    void setSubject(DataSet dataSet);
}
