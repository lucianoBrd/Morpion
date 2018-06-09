
import javax.swing.JOptionPane;


public class Joueur {
    private String joueur;
    private int numJoueur;
    
    public Joueur(int numJoueur){
        this.numJoueur = numJoueur;
    }
    
    
    public void setJoueur(){
        joueur = JOptionPane.showInputDialog(null, "Entrer le prenom du joueur " + numJoueur + ".", "Morpion", JOptionPane.QUESTION_MESSAGE);
        joueur = Character.toString(joueur.charAt(0)).toUpperCase() + joueur.substring(1, joueur.length()).toLowerCase();
    }
    
    public String getJoueur(){
        return joueur;
    }
}
