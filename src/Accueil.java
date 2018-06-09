
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
        // Accueil est de type BoxLayout en longueur (l'axe y) donc garde preferedSize
        accueil.setLayout(new BoxLayout(accueil, BoxLayout.Y_AXIS));
        // Objet Box -> horizontale que l'on peut ajouter a accueil, plus simple a gérer
        Box b1 = Box.createHorizontalBox();
        // nouveau texte a mettre dans le label
        label = new Label("Choisir la grille", 35);
        b1.add(label.getLabel());
        // Ajout d'une bordure pour que le titre ne soit pas collé en haut et quil y ai de l'espace en dessous
        b1.setBorder(BorderFactory.createMatteBorder(30, 0, 20, 0, accueil.getBackground()));
        accueil.add(b1);
    }
    
    private void buildBox(int taille){
        grille = new Grille(fenetre, taille);
        // Une box verticale contenant deux horizontales
        Box box = Box.createVerticalBox();
        Box box_1 = Box.createHorizontalBox();
        Box box_2 = Box.createHorizontalBox();
        box_1.add(grille.getGrille());
        label = new Label(taille + "x" + taille, 35);
        box_2.add(label.getLabel());
        box.add(box_1);
        box.add(box_2);
        // Ajout de d'une bordure, meme couleur que background -> cela devient margin
        box.setBorder(BorderFactory.createMatteBorder(0, 0, 20, 0, accueil.getBackground()));
        // Ajout de la box a accueil
        accueil.add(box);
    }
    
    public JPanel getPanel(){
        return accueil;
    }
}
