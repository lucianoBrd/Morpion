
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;



public class SimpleFenetre extends JFrame{
    // CardLayout nous permet d'avoir plusieurs écrans
    private CardLayout cl = new CardLayout();
    // Un tableau contenant le nom de tout nos écrans
    private String[] listContent = {"Accueil", "Jeu3", "Jeu5", "Jeu7"};
    // Objet joueur -> le premier, permet d'avoir son nom
    private Joueur joueur1 = new Joueur(1);
    // Objet joueur -> le second
    private Joueur joueur2 = new Joueur(2);
    // Permet de savoir qui joue, si la grille est pleine
    private TourJoueur tourJoueur = new TourJoueur();
    // Ojbet jeu -> ecran du jeu 3x3
    private Jeu jeu3;
    // 5x5
    private Jeu jeu5;
    // 7/7
    private Jeu jeu7;
    // Objet menu -> contient le JMenuBar
    private Menu menu;
    
    public SimpleFenetre(){
        super();
        nomJoueur();
        build();
    }
    
    private void nomJoueur(){
        // Demande les prenoms des joueurs
        joueur1.setJoueur();
        joueur2.setJoueur();
    }
    
    private void build(){
        setTitle("Morpion");
        setSize(768,1024);
        setLocationRelativeTo(null);
        setResizable(false);
        
        this.setContentPane(buildPanel());
        this.setJMenuBar(buildMenu());
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private JPanel buildPanel(){
        
        JPanel panel = new JPanel();
        JPanel accueil = buildAcuccueil();
        buildJeu();
        
        // Ajout des differents écrans au CardLayout
        panel.setLayout(cl);
        // Accueil position 0 du CardLayout
        panel.add(accueil, listContent[0]);
        // Ecran 3*3 position 1
        panel.add(jeu3.getPanel(), listContent[1]);
        // 5*5 -> 2
        panel.add(jeu5.getPanel(), listContent[2]);
        // 7*7 -> 3
        panel.add(jeu7.getPanel(), listContent[3]);

        return panel;
    }
    
    // Objet Accueil -> retoure un panel e l'ecran accueil
    private JPanel buildAcuccueil(){
        Accueil accueil = new Accueil(this);
        return accueil.getPanel();
    }
    
    // Objet Jeu -> contient le panel et label... des différents ecran de jeu 
    private void buildJeu(){
        jeu3 = new Jeu(this, 3);
        jeu5 = new Jeu(this, 5);
        jeu7 = new Jeu(this, 7);
    }
    
    // Objet menu -> retourne le JMenuBar
    private JMenuBar buildMenu(){
        menu = new Menu(this);
        return menu.getMenuBar();
    }
    
    // Setteur
    public void resetTourJoueur(){
        tourJoueur.resetTourJoueur();
    }
    
    // Getteur
    public CardLayout getCardLayout(){
        return cl;
    }
    public String[] getListeContent(){
        return listContent;
    }
    public TourJoueur getTourJoueur(){
        return tourJoueur;
    }
    public String getJoueur1(){
        return joueur1.getJoueur();
    }
    public String getJoueur2(){
        return joueur2.getJoueur();
    }
    public Joueur getJoueurClass1(){
        return joueur1;
    }
    public Joueur getJoueurClass2(){
        return joueur2;
    }
    public Jeu getJeu3(){
        return jeu3;
    }
    public Jeu getJeu5(){
        return jeu5;
    }
    public Jeu getJeu7(){
        return jeu7;
    }
    public JMenuBar getMenu(){
        return menu.getMenuBar();
    }
 
}
