public class Audio extends BaseClass implements NonVisual, Playable {

    private int duration; // the time

    public Audio(String n, int duration_x) {
        super(n);
        duration = duration_x;
    }

    public void setDuration(int duration_x) {
        duration = duration_x;
    } // setter and getter for the "other info" which means duration in the audio

    public int getDuration() {
        return duration;
    }

    public void info() { // print info
        System.out.println("Audio:");
        System.out.println("name: " + getName() + ", duration: " + duration);
        // System.out.println();
    }
}
