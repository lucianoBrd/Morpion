
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
        JMenu option = new JMenu("Option");
        JMenuItem changeName = new JMenuItem("Changer nom joueur");
        changeName.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                fenetre.getJoueurClass1().setJoueur();
                fenetre.getJoueurClass2().setJoueur();
                fenetre.getJeu3().getGrille().getLabel().setText("Tour du joueur " + fenetre.getJoueur1());
                fenetre.getJeu5().getGrille().getLabel().setText("Tour du joueur " + fenetre.getJoueur1());
                fenetre.getJeu7().getGrille().getLabel().setText("Tour du joueur " + fenetre.getJoueur1());
            }
        });
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
