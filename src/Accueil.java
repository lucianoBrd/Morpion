
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;


public class Accueil {
    private Grille grille;
    private SimpleFenetre fenetre;
    private JPanel accueil;
    private Label label;
    
    public Accueil(SimpleFenetre fenetre){
        accueil = new JPanel();
        this.fenetre = fenetre;
        buildAccueil();
        buildBox(3);
        buildBox(5);
        buildBox(7);
    }
    
    private void buildAccueil(){
        accueil.setLayout(new BoxLayout(accueil, BoxLayout.Y_AXIS));
        Box b1 = Box.createHorizontalBox();
        label = new Label("Choisir la grille", 35);
        b1.add(label.getLabel());
        b1.setBorder(BorderFactory.createMatteBorder(30, 0, 20, 0, accueil.getBackground()));
        accueil.add(b1);
    }
    
    private void buildBox(int taille){
        grille = new Grille(fenetre, taille);
        Box box = Box.createVerticalBox();
        Box box_1 = Box.createHorizontalBox();
        Box box_2 = Box.createHorizontalBox();
        box_1.add(grille.getGrille());
        label = new Label(taille + "x" + taille, 35);
        box_2.add(label.getLabel());
        box.add(box_1);
        box.add(box_2);
        box.setBorder(BorderFactory.createMatteBorder(0, 0, 20, 0, accueil.getBackground()));
        accueil.add(box);
    }
    
    public JPanel getPanel(){
        return accueil;
    }
}
