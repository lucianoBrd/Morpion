import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.Border;

public class SimpleFenetre extends JFrame implements ActionListener{
    private CardLayout cl = new CardLayout();
    private String[] listContent = {"Accueil", "Jeu3", "Jeu5", "Jeu7"};
    private String joueur1;
    private String joueur2;
    private int tourJoueur;
    private Component[] component3 = new Component[3*3+1];
    private Component[] component5 = new Component[5*5+1];
    private Component[] component7 = new Component[7*7+1];
    
    public SimpleFenetre(){
        super();
        nomJoueur();
        build();
        tourJoueur = 0;
    }
    
    private void nomJoueur(){
        joueur1 = JOptionPane.showInputDialog(null, "Entrer le prenom du joueur 1.", "Morpion", JOptionPane.QUESTION_MESSAGE);
        joueur1 = Character.toString(joueur1.charAt(0)).toUpperCase() + joueur1.substring(1, joueur1.length()).toLowerCase();
        joueur2 = JOptionPane.showInputDialog(null, "Entrer le prenom du joueur 2.", "Morpion", JOptionPane.QUESTION_MESSAGE);
        joueur2 = Character.toString(joueur2.charAt(0)).toUpperCase() + joueur2.substring(1, joueur2.length()).toLowerCase();
    }
    
    public void actionPerformed (ActionEvent event) {
        JButton button = (JButton)event.getSource();
        String joueur;
        Component[] component = null;
        JLabel label = new JLabel();
        
        switch (button.getName()) {
            case "3":
                label = (JLabel)component3[component3.length-1];
                component = component3;
                break;
            case "5":
                label = (JLabel)component5[component5.length-1];
                component = component5;
                break;
            case "7":
                label = (JLabel)component7[component7.length-1];
                component = component7;
                break;
            default:
                break;
        }
        
        
            if(!button.getText().equals("X") && !button.getText().equals("O")){
                String text;
                if(tourJoueur%2 == 0){
                    text = "X";
                    joueur = joueur2;
                } else {
                    text = "O";
                    joueur = joueur1;
                }
                
                tourJoueur++;
                label.setText("Tour du joueur " + joueur);
                button.setFont(new Font("Montserrat", Font.PLAIN, 45));
                button.setForeground(new Color(112, 112, 112));

                button.setText(text);
                if(aligne(component)){
                    JOptionPane.showMessageDialog(null, "Le joueur " + inverseJoueur(joueur) + " remporte la partie !", "Morpion", JOptionPane.INFORMATION_MESSAGE);
                    reset(component);
                }
            }
    }
    
    private String inverseJoueur(String joueur){
        if(joueur.equals(joueur1)){
            joueur = joueur2;
        } else {
            joueur = joueur1;
        }
        return joueur;
    }
    
    private void build(){
        setTitle("Morpion");
        setSize(768,1024);
        setLocationRelativeTo(null);
        setResizable(false);
        
        this.setContentPane(buildPanel());
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private JPanel buildPanel(){
        
        JPanel panel = new JPanel();
        JPanel borderPanel = buildAcuccueil();
        JPanel jeu3Panel = buildJeu(3);
        JPanel jeu5Panel = buildJeu(5);
        JPanel jeu7Panel = buildJeu(7);
        
        panel.setLayout(cl);
        panel.add(borderPanel, listContent[0]);
        panel.add(jeu3Panel, listContent[1]);
        panel.add(jeu5Panel, listContent[2]);
        panel.add(jeu7Panel, listContent[3]);

        return panel;
    }
    
    private JLabel buildLabel(String nom, int size){
        JLabel label = new JLabel(nom);
        //Définition d'une police d'écriture
        Font police = new Font("Montserrat", Font.PLAIN, size);
        //On l'applique au JLabel
        label.setFont(police);
        //Changement de la couleur du texte
        label.setForeground(new Color(112, 112, 112));
        //On modifie l'alignement du texte grâce aux attributs statiques
        //de la classe JLabel
        label.setHorizontalAlignment(JLabel.CENTER);

        return label;
    }
    
    private JPanel buildGrille(int taille){
        JPanel grille = new JPanel();
        JButton button;
        int indice;
        switch(taille){
            case 3 :    indice = 1;
                        break;
            case 5 :    indice = 2;
                        break;
            case 7 :    indice = 3;
                        break;
            default :   indice = 0;
        }
        grille.setLayout(new GridLayout(taille, taille, 2, 2));
        grille.setMaximumSize(new Dimension(250,250));
        for(int i=0; i<taille*taille; i++){
            button = new JButton(new IndiceAction("", this, indice, null));
            grille.add(button);
        }
        
        return grille;
    }
    
    private JPanel buildGrilleJeu(int taille, JLabel label){
        JPanel grille = new JPanel();
        JButton button;
        
        grille.setLayout(new GridLayout(taille, taille, 2, 2));
        grille.setMaximumSize(new Dimension(250,250));
        
        switch(taille){
            case 3 :    component3[component3.length - 1] = label;
                        break;
            case 5 :    component5[component5.length - 1] = label;;
                        break;
            case 7 :    component7[component7.length - 1] = label;;
                        break;
        }
        
        for(int i=0; i<taille*taille; i++){
            button = new JButton();
            button.addActionListener(this);
            grille.add(button);
            switch(taille){
                case 3 :    component3[i] = button;
                            button.setName("3");
                            //button.setText(String.valueOf(i));
                            break;
                case 5 :    component5[i] = button;
                            button.setName("5");
                            break;
                case 7 :    component7[i] = button;
                            button.setName("7");
                            break;
            }

        }
        
        return grille;
    }
    
    private JPanel buildAcuccueil(){
        JPanel boderPanel = new JPanel();
        
        boderPanel.setLayout(new BoxLayout(boderPanel, BoxLayout.Y_AXIS));
        
        Box b1 = Box.createHorizontalBox();
        b1.add(buildLabel("Choisir la grille", 35));
        b1.setBorder(BorderFactory.createMatteBorder(30, 0, 20, 0, boderPanel.getBackground()));
        boderPanel.add(b1);
        
        Box b3 = Box.createVerticalBox();
        Box b3_1 = Box.createHorizontalBox();
        Box b3_2 = Box.createHorizontalBox();
        b3_1.add(buildGrille(3));
        b3_2.add(buildLabel("3x3", 30));
        b3.add(b3_1);
        b3.add(b3_2);
        b3.setBorder(BorderFactory.createMatteBorder(0, 0, 20, 0, boderPanel.getBackground()));
        boderPanel.add(b3);
        
        Box b5 = Box.createVerticalBox();
        Box b5_1 = Box.createHorizontalBox();
        Box b5_2 = Box.createHorizontalBox();
        b5_1.add(buildGrille(5));
        b5_2.add(buildLabel("5x5", 30));
        b5.add(b5_1);
        b5.add(b5_2);
        b5.setBorder(BorderFactory.createMatteBorder(0, 0, 20, 0, boderPanel.getBackground()));
        boderPanel.add(b5);
        
        Box b7 = Box.createVerticalBox();
        Box b7_1 = Box.createHorizontalBox();
        Box b7_2 = Box.createHorizontalBox();
        b7_1.add(buildGrille(7));
        b7_2.add(buildLabel("7x7", 30));
        b7.add(b7_1);
        b7.add(b7_2);
        b7.setBorder(BorderFactory.createMatteBorder(0, 0, 20, 0, boderPanel.getBackground()));
        boderPanel.add(b7);
        
        return boderPanel;
    }
    
    private JPanel buildJeu(int taille){
        JPanel jeuPanel = new JPanel();
        JPanel grille;
        JPanel panel = new JPanel();
        JLabel label;
        JButton button = new JButton();
        int place = 3;
        
        switch(taille){
            case 3 :    button = new JButton(new IndiceAction("X", this, 0, component3));
                        place = 3;
                        break;
            case 5 :    button = new JButton(new IndiceAction("X", this, 0, component5));
                        place = 4;
                        break;
            case 7 :    button = new JButton(new IndiceAction("X", this, 0, component7));
                        place = 4;
                        break;
        }
        
        
        jeuPanel.setLayout(new BorderLayout());
        panel.setLayout(new BorderLayout());
        
        button.setFont(new Font("Montserrat", Font.PLAIN, 25));
        button.setForeground(new Color(112, 112, 112));
        
        label = buildLabel("Tour du joueur " + joueur1, 35);
        
        panel.add(button, BorderLayout.EAST);
        panel.add(label, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createMatteBorder(30, 50, 20, 30, jeuPanel.getBackground()));
        jeuPanel.add(panel, BorderLayout.NORTH);

        grille = buildGrilleJeu(taille, label);
        grille.setBorder(BorderFactory.createMatteBorder(150, 100, 150, 100, jeuPanel.getBackground()));
        jeuPanel.add(grille, BorderLayout.CENTER);
        
        label = buildLabel("Places-en " + place + " à la suite", 30);
        label.setBorder(BorderFactory.createMatteBorder(20, 0, 30, 0, jeuPanel.getBackground()));
        jeuPanel.add(label, BorderLayout.SOUTH);
        
        return jeuPanel;
    }
    
    private boolean aligne(Component[] component){
        if(component.length-1 == 3*3){
            return aligne3(component);
        } else if(component.length-1 == 5*5){
            return aligne5(component);
        } else if(component.length-1 == 7*7){
            return aligne7(component);
        }
        
        return false;
    }
    
    private boolean aligne3(Component[] component){
        JButton button1;
        JButton button2;
        JButton button3;
        
        for(int i=0; i<7; i+=3){
            button1 = (JButton)component[i];
            button2 = (JButton)component[i+1];
            button3 = (JButton)component[i+2];
            if(!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText())){
                return true;
            }
        }
        for(int i=0; i<3; i++){
            button1 = (JButton)component[i];
            button2 = (JButton)component[i+3];
            button3 = (JButton)component[i+6];
            if(!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText())){
                return true;
            }
        }
        button1 = (JButton)component[0];
        button2 = (JButton)component[4];
        button3 = (JButton)component[8];
        if(!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText())){
            return true;
        }
        button1 = (JButton)component[2];
        button2 = (JButton)component[4];
        button3 = (JButton)component[6];
        if(!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText())){
            return true;
        }
        
        return false;
    }
    
    private boolean aligne5(Component[] component){
        JButton button1;
        JButton button2;
        JButton button3;
        JButton button4;
        
        for(int i=0; i<21; i+=5){
            button1 = (JButton)component[i];
            button2 = (JButton)component[i+1];
            button3 = (JButton)component[i+2];
            button4 = (JButton)component[i+3];
            if(!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText()) && button1.getText().equals(button4.getText())){
                return true;
            }
            button1 = (JButton)component[i+1];
            button2 = (JButton)component[i+2];
            button3 = (JButton)component[i+3];
            button4 = (JButton)component[i+4];
            if(!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText()) && button1.getText().equals(button4.getText())){
                return true;
            }
        }
        for(int i=0; i<5; i++){
            button1 = (JButton)component[i];
            button2 = (JButton)component[i+5];
            button3 = (JButton)component[i+10];
            button4 = (JButton)component[i+15];
            if(!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText()) && button1.getText().equals(button4.getText())){
                return true;
            }
            button1 = (JButton)component[i+5];
            button2 = (JButton)component[i+10];
            button3 = (JButton)component[i+15];
            button4 = (JButton)component[i+20];
            if(!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText()) && button1.getText().equals(button4.getText())){
                return true;
            }
        }
        for(int i=0; i<2; i++){
            button1 = (JButton)component[i];
            button2 = (JButton)component[i+6];
            button3 = (JButton)component[i+12];
            button4 = (JButton)component[i+18];
            if(!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText()) && button1.getText().equals(button4.getText())){
                return true;
            }
            button1 = (JButton)component[i+3];
            button2 = (JButton)component[i+7];
            button3 = (JButton)component[i+11];
            button4 = (JButton)component[i+15];
            if(!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText()) && button1.getText().equals(button4.getText())){
                return true;
            }
        }
        for(int i=5; i<7; i++){
            button1 = (JButton)component[i];
            button2 = (JButton)component[i+6];
            button3 = (JButton)component[i+12];
            button4 = (JButton)component[i+18];
            if(!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText()) && button1.getText().equals(button4.getText())){
                return true;
            }
            button1 = (JButton)component[i+3];
            button2 = (JButton)component[i+7];
            button3 = (JButton)component[i+11];
            button4 = (JButton)component[i+15];
            if(!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText()) && button1.getText().equals(button4.getText())){
                return true;
            }
        }
        
        return false;
    }
    
    private boolean aligne7(Component[] component){
        JButton button1;
        JButton button2;
        JButton button3;
        JButton button4;
        
        for(int i=0; i<43; i+=7){
            button1 = (JButton)component[i];
            button2 = (JButton)component[i+1];
            button3 = (JButton)component[i+2];
            button4 = (JButton)component[i+3];
            if(!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText()) && button1.getText().equals(button4.getText())){
                return true;
            }
            button1 = (JButton)component[i+1];
            button2 = (JButton)component[i+2];
            button3 = (JButton)component[i+3];
            button4 = (JButton)component[i+4];
            if(!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText()) && button1.getText().equals(button4.getText())){
                return true;
            }
            button1 = (JButton)component[i+2];
            button2 = (JButton)component[i+3];
            button3 = (JButton)component[i+4];
            button4 = (JButton)component[i+5];
            if(!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText()) && button1.getText().equals(button4.getText())){
                return true;
            }
            button1 = (JButton)component[i+3];
            button2 = (JButton)component[i+4];
            button3 = (JButton)component[i+5];
            button4 = (JButton)component[i+6];
            if(!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText()) && button1.getText().equals(button4.getText())){
                return true;
            }
        }
        for(int i=0; i<7; i++){
            button1 = (JButton)component[i];
            button2 = (JButton)component[i+7];
            button3 = (JButton)component[i+14];
            button4 = (JButton)component[i+21];
            if(!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText()) && button1.getText().equals(button4.getText())){
                return true;
            }
            button1 = (JButton)component[i+7];
            button2 = (JButton)component[i+14];
            button3 = (JButton)component[i+21];
            button4 = (JButton)component[i+28];
            if(!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText()) && button1.getText().equals(button4.getText())){
                return true;
            }
            button1 = (JButton)component[i+14];
            button2 = (JButton)component[i+21];
            button3 = (JButton)component[i+28];
            button4 = (JButton)component[i+35];
            if(!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText()) && button1.getText().equals(button4.getText())){
                return true;
            }
            button1 = (JButton)component[i+21];
            button2 = (JButton)component[i+28];
            button3 = (JButton)component[i+35];
            button4 = (JButton)component[i+42];
            if(!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText()) && button1.getText().equals(button4.getText())){
                return true;
            }
        }
        //diagonales 
        for(int i=0; i<25; i+=8){
            button1 = (JButton)component[i];
            button2 = (JButton)component[i+8];
            button3 = (JButton)component[i+16];
            button4 = (JButton)component[i+24];
            if(!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText()) && button1.getText().equals(button4.getText())){
                return true;
            }
            if(i<18){
                button1 = (JButton)component[i+1];
                button2 = (JButton)component[i+9];
                button3 = (JButton)component[i+17];
                button4 = (JButton)component[i+25];
                if(!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText()) && button1.getText().equals(button4.getText())){
                    return true;
                }
            }
            if(i<11){
                button1 = (JButton)component[i+2];
                button2 = (JButton)component[i+10];
                button3 = (JButton)component[i+18];
                button4 = (JButton)component[i+26];
                if(!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText()) && button1.getText().equals(button4.getText())){
                    return true;
                }
            }
        }
        for(int i=14; i<23; i+=8){
            button1 = (JButton)component[i];
            button2 = (JButton)component[i+8];
            button3 = (JButton)component[i+16];
            button4 = (JButton)component[i+24];
            if(!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText()) && button1.getText().equals(button4.getText())){
                return true;
            }
        }
        for(int i=7; i<24; i+=8){
            button1 = (JButton)component[i];
            button2 = (JButton)component[i+8];
            button3 = (JButton)component[i+16];
            button4 = (JButton)component[i+24];
            if(!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText()) && button1.getText().equals(button4.getText())){
                return true;
            }
        }
        button1 = (JButton)component[21];
        button2 = (JButton)component[29];
        button3 = (JButton)component[37];
        button4 = (JButton)component[45];
        if(!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText()) && button1.getText().equals(button4.getText())){
            return true;
        }
        
        //diagonales superieures
        button1 = (JButton)component[3];
        button2 = (JButton)component[11];
        button3 = (JButton)component[19];
        button4 = (JButton)component[27];
        if(!button1.getText().equals("") && button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText()) && button1.getText().equals(button4.getText())){
            return true;
        }
        
        return false;
    }
    
    public void reset(Component[] component){
        setTourJoueur(0);
        JLabel label = (JLabel)component[component.length-1];
        label.setText("Tour du joueur " + joueur1);
            
        if(component != null){
            for (Component component1 : component) {
            if (component1 instanceof JButton) {
                    JButton button = (JButton) component1;
                    button.setEnabled(true);
                    button.setText("");
                }
            }
        }
        this.getCardLayout().show(this.getContentPane(), this.getListeContent()[0]);
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
    public void setTourJoueur(int tourJoueur){
        if(tourJoueur>=0){
            this.tourJoueur = tourJoueur;
        }
    }
 
}
