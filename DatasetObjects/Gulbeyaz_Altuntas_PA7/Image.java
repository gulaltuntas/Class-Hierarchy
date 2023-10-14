public class Image extends BaseClass implements Visual, NonPlayable {

    private int px; // point x
    private int py; // point y

    public Image(String n, int x, int y) {
        super(n); // name of the image
        px = x;
        py = y; // image has a width and height
    }

    // getters & setters for x and y
    public int getDimensionX() {
        return px;
    }

    public int getDimensionY() {
        return py;
    }

    public void setDimensionX(int x) {
        px = x;
    }

    public void setDimensionY(int y) {
        py = y;
    }

    public void info() { // print info
        System.out.println("Image:");
        System.out.println("name: " + getName() + ", x: " + px + ", y: " + py);
        // System.out.println();
    }
}
