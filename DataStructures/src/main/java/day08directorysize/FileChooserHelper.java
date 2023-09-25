package day08directorysize;


import javax.swing.JFileChooser;

public class FileChooserHelper {

    // Singleton pattern
    public static JFileChooser chooser;

    public static JFileChooser getFileChooser() {
        if (chooser == null) {
            chooser = new JFileChooser();
        }
        return chooser;
    }
    
    // if factory pattern
    // every time instancier a new JFileChooser and getFileChooser() receive parameter that shows which kind of file do we need to choose
}
