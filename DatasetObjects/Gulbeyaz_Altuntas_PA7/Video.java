public class Video extends BaseClass implements Visual, Playable {
    private int px;
    private int py;
    private int duration;

    public Video(String n, int x, int y, int duration_x) {
        super(n);
        px = x;
        py = y;
        duration = duration_x;
    }

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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration_x) {
        duration = duration_x;
    }

    public void info() { // print info
        System.out.println("Video:");
        System.out.println("name: " + getName() + ", x: " + px + ", y: " + py + ", duration: " + duration);
        // System.out.println();
    }
}
