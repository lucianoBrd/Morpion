
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;


// Class d'action pour le clic sur une grille de l'ecran accueil ou le bouton croix du jeu 
public class IndiceAction extends AbstractAction{
        
        private SimpleFenetre fenetre;
        private int indice;
        private int option;
        private Grille grille;
        
        public IndiceAction(String texte, SimpleFenetre fenetre, int indice, Grille grille){
            // Mettre le texte du boutton passé en paramètre
            super(texte);
            // Faire le lien avec SimplFenetre -> avoir toutes les méthodes
            this.fenetre = fenetre;
            // Indice savoir a quelle position du CardLayout donc a quel ecran aller
            this.indice = indice;
            // Avoir la grille -> la reset pour retour au menu
            this.grille = grille;
        }
        
        public void actionPerformed(ActionEvent e){
            if(indice == 0){
                // 0 c'est a dire ecran accueil, demande confirmation retour
                option = JOptionPane.showConfirmDialog(null, "Voulez-vous revenir au menu ?", "Morpion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(option == 0){
                    grille.reset();
                    fenetre.setJMenuBar(fenetre.getMenu());
                }
            } else {
                // Changement vers le bon ecran donné par indice
                fenetre.getCardLayout().show(fenetre.getContentPane(), fenetre.getListeContent()[indice]);
                // Enleve le menu pour les ecrans de jeu
                fenetre.setJMenuBar(null);
            }
        }
        
}
