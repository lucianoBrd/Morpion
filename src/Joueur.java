
import javax.swing.JOptionPane;


public class Joueur {
    private String joueur;
    private int numJoueur;
    
    // Joueur a un numero de joueur soit 1 soit 2 -> savoir qui est le premier
    public Joueur(int numJoueur){
        this.numJoueur = numJoueur;
    }
    
    // Demander le prenom des joueurs
    public void setJoueur(){
        joueur = JOptionPane.showInputDialog(null, "Entrer le prenom du joueur " + numJoueur + ".", "Morpion", JOptionPane.QUESTION_MESSAGE);
        joueur = Character.toString(joueur.charAt(0)).toUpperCase() + joueur.substring(1, joueur.length()).toLowerCase();
    }
    
    public String getJoueur(){
        return joueur;
    }
}
