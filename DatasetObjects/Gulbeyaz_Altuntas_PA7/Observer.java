import java.util.ArrayList;

public interface Observer { // observer class that updates the objects
    void update(ArrayList<BaseClass> vData);

    void setSubject(DataSet dataSet);
}
