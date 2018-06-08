import javax.swing.*;
import java.awt.event.*;

public class Fermer extends AbstractAction{
    public Fermer(String txt){
        super(txt);
    }
    public void actionPerformed(ActionEvent e) {
            System.exit(0);
    }
}
