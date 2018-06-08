import java.awt.Component;
import javax.swing.*;
import java.awt.event.*;

public class IndiceAction extends AbstractAction{
        
        private SimpleFenetre fenetre;
        private int indice;
        private int option;
        private Component[] component;
        
        public IndiceAction(String texte, SimpleFenetre fenetre, int indice, Component[] component){
            super(texte);
            this.fenetre = fenetre;
            this.indice = indice;
            this.component = component;
        }
        
        public void actionPerformed(ActionEvent e){
            if(indice == 0){
                
                option = JOptionPane.showConfirmDialog(null, "Voulez-vous revenir au menu ?", "Morpion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(option == 0){
                    fenetre.reset(component);
                }
            } else {
                fenetre.getCardLayout().show(fenetre.getContentPane(), fenetre.getListeContent()[indice]);
                
            }
        }
        
}
