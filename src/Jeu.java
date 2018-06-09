
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Jeu {
    private Grille grille;
    private SimpleFenetre fenetre;
    private JPanel jeuPanel;
    private Label label;
    private int taille;
    
    
    public Jeu(SimpleFenetre fenetre, int taille){
        this.fenetre = fenetre;
        jeuPanel = new JPanel();
        this.taille = taille;
        buildJeu();
    }
    
    private void buildJeu(){
        JPanel panel = new JPanel();
        JButton button;
        int place = 3;
        
        jeuPanel.setLayout(new BorderLayout());
        panel.setLayout(new BorderLayout());
        label = new Label("Tour du joueur " + fenetre.getJoueur1(), 35);
        panel.add(label.getLabel(), BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createMatteBorder(30, 50, 20, 30, jeuPanel.getBackground()));
        
        grille = new Grille(fenetre, taille, label.getLabel());
        grille.getGrille().setBorder(BorderFactory.createMatteBorder(150, 100, 150, 100, jeuPanel.getBackground()));
        jeuPanel.add(grille.getGrille(), BorderLayout.CENTER);
        
        button = new JButton(new IndiceAction("X", fenetre, 0, grille));
        button.setFont(new Font("Montserrat", Font.PLAIN, 25));
        button.setForeground(new Color(112, 112, 112));
        panel.add(button, BorderLayout.EAST);
        
        jeuPanel.add(panel, BorderLayout.NORTH);
        
        switch(taille){
            case 3 :    place = 3;
                        break;
            case 5 :    place = 4;
                        break;
            case 7 :    place = 4;
                        break;
        }
        label = new Label("Places-en " + place + " à la suite", 30);
        label.getLabel().setBorder(BorderFactory.createMatteBorder(20, 0, 30, 0, jeuPanel.getBackground()));
        jeuPanel.add(label.getLabel(), BorderLayout.SOUTH);
        
    }
    
    public Grille getGrille(){
        return grille;
    }
    public JPanel getPanel(){
        return jeuPanel;
    }
}
