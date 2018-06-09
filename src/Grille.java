
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Grille {
    private SimpleFenetre fenetre;
    private JPanel grille;
    private Component[] component;
    private int taille;
    private JLabel label;
    
    public Grille(SimpleFenetre fenetre, int taille){
        this.fenetre = fenetre;
        grille = new JPanel();
        this.taille = taille;
        component = null;
        buildGrille();
        label = null;
        buttonGrille();
    }
    
    public Grille(SimpleFenetre fenetre, int taille, JLabel label){
        this.fenetre = fenetre;
        grille = new JPanel();
        this.taille = taille;
        component = new Component[taille*taille];
        buildGrille();
        this.label = label;
        buttonGrilleJeu();
    }
    
    private void buildGrille(){
        
        grille.setLayout(new GridLayout(taille, taille, 2, 2));
        grille.setMaximumSize(new Dimension(250,250));
    }
    
    private void buttonGrille(){
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
        
        for(int i=0; i<taille*taille; i++){
            button = new JButton(new IndiceAction("", fenetre, indice, this));
            grille.add(button);
        }
    }
    
    private void buttonGrilleJeu(){
        JButton button;
        for(int i=0; i<taille*taille; i++){
            button = new JButton();
            button.addActionListener(fenetre);
            grille.add(button);
            component[i] = button;
            button.setName(String.valueOf(taille));
        }
        
    }
    
    public void reset(){
        fenetre.setTourJoueur(0);
        label.setText("Tour du joueur " + fenetre.getJoueur1());
            
        if(component != null){
            for (Component component1 : component) {
            if (component1 instanceof JButton) {
                    JButton button = (JButton) component1;
                    button.setEnabled(true);
                    button.setText("");
                }
            }
        }
        fenetre.getCardLayout().show(fenetre.getContentPane(), fenetre.getListeContent()[0]);
    }
    
    public JPanel getGrille(){
        return grille;
    }
    
    public JLabel getLabel(){
        return label;
    }
    
    public boolean aligne(){
        switch (component.length) {
            case 3*3:
                return aligne3(component);
            case 5*5:
                return aligne5(component);
            case 7*7:
                return aligne7(component);
            default:
                break;
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
}
