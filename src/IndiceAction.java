import java.awt.Component;
import javax.swing.*;
import java.awt.event.*;

public class IndiceAction extends AbstractAction{
        
        private SimpleFenetre fenetre;
        private int indice;
        private int option;
        private Grille grille;
        
        public IndiceAction(String texte, SimpleFenetre fenetre, int indice, Grille grille){
            super(texte);
            this.fenetre = fenetre;
            this.indice = indice;
            this.grille = grille;
        }
        
        public void actionPerformed(ActionEvent e){
            if(indice == 0){
                
                option = JOptionPane.showConfirmDialog(null, "Voulez-vous revenir au menu ?", "Morpion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(option == 0){
                    grille.reset();
                }
            } else {
                fenetre.getCardLayout().show(fenetre.getContentPane(), fenetre.getListeContent()[indice]);
            }
        }
        
}
