
import javax.swing.SwingUtilities;

public class Test {
    public static void main(String[] args) {
        // L'interface s'execute en dehors afin d'etre plus fluide
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new SimpleFenetre();
            }
        });

    }
}
