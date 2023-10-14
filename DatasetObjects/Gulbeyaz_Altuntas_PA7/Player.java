import java.util.ArrayList;
import java.util.List;

public class Player implements Observer {
    private DataSet dataSet; // the dataset player is observing
    public List<BaseClass> obsData; // a list to store observed datas
    private int current_index; // to track the currently playing index

    public void setSubject(DataSet s) {
        if (dataSet != s) { // if the dataset is not the same, it updates the variable
            dataSet = s;
            dataSet.register(this); // with this
            current_index = 0; // resets the current index to start from start
        }
    }

    public void update(ArrayList<BaseClass> newData) {
        current_index = 0;
        obsData = new ArrayList<>(newData); // to add new data to observers
    }

    public Player(DataSet newDataSet) { // constructor
        obsData = new ArrayList<BaseClass>();
        dataSet = newDataSet;
        dataSet.register(this);
        current_index = 0;
    }

    public Player() { // default constructor
        obsData = new ArrayList<>();
        current_index = 0;
    }

    public void showList() { // this is for to print the objects we have
        for (BaseClass e : obsData) {
            if (e instanceof Playable) {
                Playable p = (Playable) e;
                p.info();
            }
        }
    }

    public void next() {
        int startIndex = current_index;  // take the index
        current_index = (current_index + 1) % obsData.size();  // computing the next viewing index
    
        while (current_index != startIndex) {
            if (obsData.get(current_index) instanceof Playable)
                return;  // if there is a playable object, return
    
            current_index = (current_index + 1) % obsData.size();  // move to the next object
        }
    
        throw new RuntimeException("There is no playable object! :(");
        // if the loop completes without finding a playable object, throw an exception
    }
    
    public void previous() {
        int startIndex = current_index;  // take the index
        current_index = (current_index - 1 + obsData.size()) % obsData.size();  // compute the previous index
    
        while (current_index != startIndex) {
            if (obsData.get(current_index) instanceof Playable)
                return;  // if there is a playable object, return 
    
            current_index = (current_index - 1 + obsData.size()) % obsData.size();  // move to the previous index
        }
    
        throw new RuntimeException("There is no playable object! :(");
        // if the loop completes without finding a playable object, throw an exception
    }

    public Playable currently_playing() { // returns the currently playing object
        boolean found = false;
        for (int i = 0; i < obsData.size(); ++i) {
            if (obsData.get(i) instanceof Playable) // it checks the playable objects ( such as video and audio)
                found = true;
        }

        if (!found)
            throw new RuntimeException("There is no playable object! :(");

        while (!(obsData.get(current_index) instanceof Playable))
            next();
        return (Playable) obsData.get(current_index);
    }
}