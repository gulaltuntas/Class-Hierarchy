import java.util.ArrayList;
import java.util.List;

public class Viewer implements Observer {

    private DataSet dataSet; // the subject that we observe
    private List<BaseClass> obsData; // stores the data we get from the subject
    private int current_index; // holds the index we are currently in

    public void setSubject(DataSet s) {
        if (dataSet != s) { // to prevent resetting currently viewing index if dataset is the same
            dataSet = s;
            dataSet.register(this);
            current_index = 0; // it starts from the first data we look
        }
    }

    public void update(ArrayList<BaseClass> newData) { // if there is new entry, we will update the data
        current_index = 0; // update the data and reset currently viewing
        obsData = new ArrayList<>(newData);
    }

    public Viewer(DataSet newDataSet) { // constructor initiliazer
        obsData = new ArrayList<>();
        dataSet = newDataSet;
        dataSet.register(this);
        current_index = 0;
    }

    public Viewer() { // empty constructor (default)
        obsData = new ArrayList<>();
        current_index = 0;
    }

    public void showList() {
        for (BaseClass e : obsData) { // for each item in the data list,
            if (e instanceof NonPlayable) { // if instance is viewable (nonplayable)
                NonPlayable v = (NonPlayable) e; // cast it
                v.info(); // print info
            }
        }
    }

    public void next() {
        int startIndex = current_index;
        current_index = (current_index + 1) % obsData.size();

        while (current_index != startIndex) {
            if (obsData.get(current_index) instanceof NonPlayable)
                return;

            current_index = (current_index + 1) % obsData.size();
        }

        throw new RuntimeException("There is no viewable object! :(");
    }

    public void previous() {
        int startIndex = current_index;
        current_index = (current_index - 1 + obsData.size()) % obsData.size();

        while (current_index != startIndex) {
            if (obsData.get(current_index) instanceof NonPlayable)
                return;

            current_index = (current_index - 1 + obsData.size()) % obsData.size();
        }

        throw new RuntimeException("There is no viewable object! :(");
    }

    public NonPlayable currently_viewing() {
        boolean found = false;
        for (BaseClass item : obsData) {
            if (item instanceof NonPlayable) {
                found = true;
                break;
            }
        }
        if (!found) { // if it is not found that means there is not object in it
            throw new RuntimeException("There is not an object");
        }

        while (!(obsData.get(current_index) instanceof NonPlayable)) { // if there is no data
            next(); // call next item
        }
        return (NonPlayable) obsData.get(current_index);
    }
}
