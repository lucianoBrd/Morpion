import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class IndiceActionJeu extends AbstractAction{
        
        private SimpleFenetre fenetre;
        private int tourJoueur;
        
        public IndiceActionJeu(String texte, SimpleFenetre fenetre){
            super(texte);
            this.fenetre = fenetre;
            this.tourJoueur = fenetre.getTourJoueur();
        }
        
        public void actionPerformed(ActionEvent e){
            JButton button = (JButton)e.getSource();
            
            if(!button.getText().equals("X") && !button.getText().equals("O"));{
                
                String text;
                if(tourJoueur%2 == 0){
                    text = "X";
                } else {
                    text = "O";
                }
                
                fenetre.setTourJoueur(tourJoueur++);
                
                button.setFont(new Font("Montserrat", Font.PLAIN, 45));
                button.setForeground(new Color(112, 112, 112));

                button.setText(text);
            }
        }
}
