
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


// Class d'action pour le clic sur une grille de l'ecran accueil ou le bouton croix du jeu 
public class ActionJeu extends AbstractAction{
        
        private SimpleFenetre fenetre;
        private Grille grille;
        
        public ActionJeu(String texte, SimpleFenetre fenetre){
            // Mettre le texte du boutton passé en paramètre
            super(texte);
            // Faire le lien avec SimplFenetre -> avoir toutes les méthodes
            this.fenetre = fenetre;
            // Avoir la grille -> la reset pour retour au menu
            this.grille = grille;
        }
        
        // Action quand on clique sur un bouton de l'ecran jeu
        public void actionPerformed (ActionEvent event) {
            // On récupère le Button a l'origine de l'action
            JButton button = (JButton)event.getSource();
            String joueur;
            JLabel label = new JLabel();

            // Savoir de quelle grille le bouton provient, le bouton a pour nom la taille de la grille 3, 5 ou 7
            switch (button.getName()) {
                case "3":
                    // On récupère le label de la grille (tour du joueur ...)
                    label = fenetre.getJeu3().getGrille().getLabel();
                    // Recupere la grille
                    grille = fenetre.getJeu3().getGrille();
                    break;
                case "5":
                    label = fenetre.getJeu5().getGrille().getLabel();
                    grille = fenetre.getJeu5().getGrille();
                    break;
                case "7":
                    label = fenetre.getJeu7().getGrille().getLabel();
                    grille = fenetre.getJeu7().getGrille();
                    break;
                default:
                    break;
            }

                // Verifie que le bouton n'a pas déja ete cliqué
                if(!button.getText().equals("X") && !button.getText().equals("O")){
                    String text;
                    // A qui de jouer après
                    if(fenetre.getTourJoueur().getTourJoueur()%2 == 0){
                        text = "X";
                        joueur = fenetre.getJoueur2();
                    } else {
                        text = "O";
                        joueur = fenetre.getJoueur1();
                    }

                    fenetre.getTourJoueur().plusTourJoueur();
                    // Le label change avec le nom du prochain joueur
                    label.setText("Tour du joueur " + joueur);
                    // changement de a police et couleur du texte du boutton
                    button.setFont(new Font("Montserrat", Font.PLAIN, 45));
                    button.setForeground(new Color(112, 112, 112));
                    // On met "X" ou "O" sur le bouton
                    button.setText(text);

                    // La grille a t elle des élément alignés 
                    if(grille.aligne()){
                        // On informe du gagnant
                        // Il faut inverser joueur car il contient le prochain
                        JOptionPane.showMessageDialog(null, "Le joueur " + inverseJoueur(joueur) + " remporte la partie !", "Morpion", JOptionPane.INFORMATION_MESSAGE);
                        // On remet la grille a neuf (enlève les "X" ou "O" des boutons...
                        // Et retour a l'ecran principal
                        grille.reset();
                        // On remet le menu afin que l'on puisse le voir de l'écran d'accueil
                        fenetre.setJMenuBar(fenetre.getMenu());
                    }
                    // La grille est elle pleine
                    if(fenetre.getTourJoueur().rempliTourJoueur(Integer.valueOf(button.getName()))){
                        // On informe de l'egalite
                        JOptionPane.showMessageDialog(null, "Egalité !", "Morpion", JOptionPane.INFORMATION_MESSAGE);
                        // On remet la grille a neuf (enlève les "X" ou "O" des boutons...
                        // Et retour a l'ecran principal
                        grille.reset();
                        // On remet le menu afin que l'on puisse le voir de l'écran d'accueil
                        fenetre.setJMenuBar(fenetre.getMenu());
                    }
                }
        }
        
        // Inverse la valeur du joueur passé en paramètre
        public String inverseJoueur(String joueur){
            if(joueur.equals(fenetre.getJoueur1())){
                joueur = fenetre.getJoueur2();
            } else {
                joueur = fenetre.getJoueur1();
            }
            return joueur;
        }
        
}
