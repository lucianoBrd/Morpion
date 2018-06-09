
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
    private CardLayout cl = new CardLayout();
    private String[] listContent = {"Accueil", "Jeu3", "Jeu5", "Jeu7"};
    private Joueur joueur1 = new Joueur(1);
    private Joueur joueur2 = new Joueur(2);
    private int tourJoueur;
    private Jeu jeu3;
    private Jeu jeu5;
    private Jeu jeu7;
    private Menu menu;
    
    public SimpleFenetre(){
        super();
        nomJoueur();
        build();
        tourJoueur = 0;
    }
    
    private void nomJoueur(){
        joueur1.setJoueur();
        joueur2.setJoueur();
    }
    
    public void actionPerformed (ActionEvent event) {
        JButton button = (JButton)event.getSource();
        String joueur;
        Grille grille = null;
        JLabel label = new JLabel();
        
        switch (button.getName()) {
            case "3":
                label = jeu3.getGrille().getLabel();
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
        
        
            if(!button.getText().equals("X") && !button.getText().equals("O")){
                String text;
                if(tourJoueur%2 == 0){
                    text = "X";
                    joueur = joueur2.getJoueur();
                } else {
                    text = "O";
                    joueur = joueur1.getJoueur();
                }
                
                tourJoueur++;
                label.setText("Tour du joueur " + joueur);
                button.setFont(new Font("Montserrat", Font.PLAIN, 45));
                button.setForeground(new Color(112, 112, 112));

                button.setText(text);
                if(grille.aligne()){
                    JOptionPane.showMessageDialog(null, "Le joueur " + inverseJoueur(joueur) + " remporte la partie !", "Morpion", JOptionPane.INFORMATION_MESSAGE);
                    grille.reset();
                    this.setJMenuBar(getMenu());
                }
            }
    }
    
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
        
        panel.setLayout(cl);
        panel.add(accueil, listContent[0]);
        panel.add(jeu3.getPanel(), listContent[1]);
        panel.add(jeu5.getPanel(), listContent[2]);
        panel.add(jeu7.getPanel(), listContent[3]);

        return panel;
    }
    
    private JPanel buildAcuccueil(){
        Accueil accueil = new Accueil(this);
        return accueil.getPanel();
    }
    
    private void buildJeu(){
        jeu3 = new Jeu(this, 3);
        jeu5 = new Jeu(this, 5);
        jeu7 = new Jeu(this, 7);
    }
    
    private JMenuBar buildMenu(){
        menu = new Menu(this);
        return menu.getMenuBar();
    }
    
    
    public void setTourJoueur(int tourJoueur){
        if(tourJoueur>=0){
            this.tourJoueur = tourJoueur;
        }
    }
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
