
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class SimpleFenetre extends JFrame implements ActionListener{
    // CardLayout nous permet d'avoir plusieurs écrans
    private CardLayout cl = new CardLayout();
    // Un tableau contenant le nom de tout nos écrans
    private String[] listContent = {"Accueil", "Jeu3", "Jeu5", "Jeu7"};
    // Objet joueur -> le premier, permet d'avoir son nom
    private Joueur joueur1 = new Joueur(1);
    // Objet joueur -> le second
    private Joueur joueur2 = new Joueur(2);
    // Permet de savoir qui joue
    private int tourJoueur;
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
        tourJoueur = 0;
    }
    
    private void nomJoueur(){
        // Demande les prenoms des joueurs
        joueur1.setJoueur();
        joueur2.setJoueur();
    }
    
    // Action quand on clique sur un bouton de l'ecran jeu
    public void actionPerformed (ActionEvent event) {
        // On récupère le Button a l'origine de l'action
        JButton button = (JButton)event.getSource();
        String joueur;
        Grille grille = null;
        JLabel label = new JLabel();
        
        // Savoir de quelle grille le bouton provient, le bouton a pour nom la taille de la grille 3, 5 ou 7
        switch (button.getName()) {
            case "3":
                // On récupère le label de la grille (tour du joueur ...)
                label = jeu3.getGrille().getLabel();
                // Recupere la grille
                grille = jeu3.getGrille();
                break;
            case "5":
                label = jeu5.getGrille().getLabel();
                grille = jeu5.getGrille();
                break;
            case "7":
                label = jeu7.getGrille().getLabel();
                grille = jeu7.getGrille();
                break;
            default:
                break;
        }
        
            // Verifie que le bouton n'a pas déja ete cliqué
            if(!button.getText().equals("X") && !button.getText().equals("O")){
                String text;
                // A qui de jouer après
                if(tourJoueur%2 == 0){
                    text = "X";
                    joueur = joueur2.getJoueur();
                } else {
                    text = "O";
                    joueur = joueur1.getJoueur();
                }
                
                tourJoueur++;
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
                    this.setJMenuBar(getMenu());
                }
            }
    }
    
    // Inverse la valeur du joueur passé en paramètre
    private String inverseJoueur(String joueur){
        if(joueur.equals(joueur1.getJoueur())){
            joueur = joueur2.getJoueur();
        } else {
            joueur = joueur1.getJoueur();
        }
        return joueur;
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
    public void setTourJoueur(int tourJoueur){
        if(tourJoueur>=0){
            this.tourJoueur = tourJoueur;
        }
    }
    
    // Getteur
    public CardLayout getCardLayout(){
        return cl;
    }
    public String[] getListeContent(){
        return listContent;
    }
    public int getTourJoueur(){
        return tourJoueur;
    }
    public String getJoueur1(){
        return joueur1.getJoueur();
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
