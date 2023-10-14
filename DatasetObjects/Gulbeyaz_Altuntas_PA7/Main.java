import javax.sound.midi.SysexMessage;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class Main {
    public static void main(String[] args) {

        DataSet ds = new DataSet();
        // Lets create different observers.
        Player p1 = new Player();
        Player p2 = new Player();
        Viewer v1 = new Viewer();
        Viewer v2 = new Viewer();

        ds.register(p1);
        ds.register(p2);
        ds.register(v1);
        ds.register(v2);

        // Create and add Image objects
        Image imagename1 = new Image("imagename1", 1, 1);
        ds.add(imagename1);
        Image imagename2 = new Image("imagename2", 2, 2);
        ds.add(imagename2);
        Image imagename3 = new Image("imagename3", 3, 3);
        ds.add(imagename3);
        Image imagename4 = new Image("imagename4", 4, 4);
        ds.add(imagename4);
        Image imagename5 = new Image("imagename5", 5, 5);
        ds.add(imagename5);

        // Create and add Audio objects
        Audio audioname1 = new Audio("audioname1", 1204);
        ds.add(audioname1);
        Audio audioname2 = new Audio("audioname2", 1306);
        ds.add(audioname2);
        Audio audioname3 = new Audio("audioname3", 1230);
        ds.add(audioname3);

        // Create and add Video objects
        Video video1 = new Video("videoname1", 1, 1, 1204);
        ds.add(video1);
        Video video2 = new Video("videoname2", 2, 2, 1306);
        ds.add(video2);
        Video video3 = new Video("videoname3", 3, 3, 1230);
        ds.add(video3);

        // Create and add Text objects
        Text text1 = new Text("textname1", "times new roman");
        ds.add(text1);
        Text text2 = new Text("textname2", "calibri");
        ds.add(text2);
        Text text3 = new Text("textname3", "new black");
        ds.add(text3);

        // Print the current state of the viewers
        System.out.println();
        System.out.println("Viewer 1:");
        v1.showList(); // Assuming showList() prints the information of the viewed objects
        ds.remove(imagename1); // Remove an Image object from the dataset

        // Print the updated state of the viewers
        System.out.println();
        System.out.println("Viewer 1 after removing an Image:");
        v1.showList();


        // Print the updated state of the players
        System.out.println();
        System.out.println("Player 1:");
        p1.showList(); //
        p1.next();

        // Add a new Audio object
        Audio audio5 = new Audio("audioname5", 1001);
        ds.add(audio5);
        System.out.println();
        System.out.println("After adding a new Audio:");
        System.out.println("Player 1:");
        p1.showList(); //


        System.out.println();
        System.out.println("-- CURRENTLY PLAYING -- ");
        System.out.println();
        System.out.println("Currently playing Playable object ");
        Playable po = p1.currently_playing();
        // This prints info about the playing object.
        po.info();
         // we can remove this object from the dataset
         System.out.println();
         System.out.println("Delete the current playing object:");
         ds.remove((BaseClass) po);
        //  p1.showList();
        System.out.println("New currently playing:");
        Playable p4 = p1.currently_playing();
        // This prints info about the playing object.
        p4.info();

        System.out.println();
        System.out.println("-- CALL THE NEXT / PREVIOUS / CURRENT ONE --- ");
        System.out.println();
         // po is no longer in the dataset. all of the interested observers will get this
         // update.
        p4.info();
        p1.next();
        System.out.println("(After calling the next function)");
        System.out.println("Currently playing Playable object ");
        Playable po2 = p1.currently_playing();
        po2.info();

    

        System.out.println();
        System.out.println("Previous function:");
        System.out.println("Currently playing Playable object ");
        Playable xo = p1.currently_playing();
        // This prints info about the playing object.
        xo.info();
        p1.previous();
       


        System.out.println("(After calling the previous function)");
        System.out.println("Currently playing Playable object ");
        Playable xo2 = p1.currently_playing();
        xo2.info();

       

        System.out.println();
        // similarly, viewer object:
        System.out.println("Currently playing Viewer object: ");
        NonPlayable np = v1.currently_viewing();
        np.info(); // this prints info about the object being viewed.
        v1.next();

        System.out.println("(After calling the next function)");
        System.out.println("Currently playing Viewer object: ");
        NonPlayable np2 = v1.currently_viewing();
        np2.info();

        System.out.println();
        // similarly, viewer object:
        System.out.println("Currently playing Viewer object: ");
        NonPlayable xo3 = v1.currently_viewing();
        xo3.info(); // this prints info about the object being viewed.
        v1.previous();

        System.out.println("(After calling the previous function)");
        System.out.println("Currently playing Viewer object: ");
        NonPlayable xo4 = v1.currently_viewing();
        xo4.info();

    }

}
