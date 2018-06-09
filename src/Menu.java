
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Menu {
    private JMenuBar menuBar;
    private SimpleFenetre fenetre;
        
    public Menu(SimpleFenetre fenetre){
        this.fenetre = fenetre;
        menuBar = new JMenuBar();
        buildMenu();
    }
    
    private void buildMenu(){
        // Menu a un menu option
        JMenu option = new JMenu("Option");
        // item du menu changer le nom avec action dedans
        JMenuItem changeName = new JMenuItem("Changer nom joueur");
        changeName.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                // change le nom des joueurs
                fenetre.getJoueurClass1().setJoueur();
                fenetre.getJoueurClass2().setJoueur();
                // met a jour les label des fenetres de jeu
                fenetre.getJeu3().getGrille().getLabel().setText("Tour du joueur " + fenetre.getJoueur1());
                fenetre.getJeu5().getGrille().getLabel().setText("Tour du joueur " + fenetre.getJoueur1());
                fenetre.getJeu7().getGrille().getLabel().setText("Tour du joueur " + fenetre.getJoueur1());
            }
        });
        // Item fermer avec action de la classe fermer
        JMenuItem fermer = new JMenuItem(new Fermer("Fermer"));
        menuBar.add(option);
        option.add(changeName);
        option.add(fermer);
        option.addSeparator();
    }
    
    public JMenuBar getMenuBar(){
        return menuBar;
    }
}
