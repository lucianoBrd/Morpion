
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;



//Action pour fermer la fenetre -> bouton du menu fermer
public class Fermer extends AbstractAction{
    public Fermer(String txt){
        super(txt);
    }
    public void actionPerformed(ActionEvent e) {
            System.exit(0);
    }
}
