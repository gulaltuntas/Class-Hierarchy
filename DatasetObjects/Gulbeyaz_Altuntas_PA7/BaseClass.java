import java.util.ArrayList;
import java.util.List;

public class BaseClass {
    private String name; // name of the image, text, audio, video

    public BaseClass(String v_name) { // constructor with name
        name = v_name;
    }

    public String getName() {
        return name;
    }
}
