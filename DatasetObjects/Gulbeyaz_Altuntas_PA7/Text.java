public class Text extends BaseClass implements NonPlayable, Visual {

    private String punto; // other info which i took it as "punto"

    public Text(String n, String new_punto) {
        super(n);
        punto = new_punto;
    }

    // setter and getter for the punto
    public String getPunto() {
        return punto;
    }

    public void setPunto(String new_punto) {
        punto = new_punto;
    }

    public void info() { // print info
        System.out.println("Text:");
        System.out.println("name: " + getName() + ", punto: " + punto);
        // System.out.println();
    }
}
