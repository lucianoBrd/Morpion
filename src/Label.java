
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;


public class Label {
    private JLabel label;
    private String nom;
    private int size;
    
    // Permet de creer des labels au bon format, on peut choisir son texte et sa taille
    public Label(String nom, int size){
        this.nom = nom;
        this.size = size;
        label = new JLabel(nom);
        buildLabel();
    }
    
    private void buildLabel(){
        // Définit la police, taille du texte
        Font police = new Font("Montserrat", Font.PLAIN, size);
        label.setFont(police);
        // Couleur du texte
        label.setForeground(new Color(112, 112, 112));
        // Alignement du texte
        label.setHorizontalAlignment(JLabel.CENTER);
    }
    
    public JLabel getLabel(){
        return label;
    }
}
