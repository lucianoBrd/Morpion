
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;


public class Label {
    private JLabel label;
    private String nom;
    private int size;
    
    public Label(String nom, int size){
        this.nom = nom;
        this.size = size;
        label = new JLabel(nom);
        buildLabel();
    }
    
    private void buildLabel(){
        Font police = new Font("Montserrat", Font.PLAIN, size);
        label.setFont(police);
        label.setForeground(new Color(112, 112, 112));
        label.setHorizontalAlignment(JLabel.CENTER);
    }
    
    public JLabel getLabel(){
        return label;
    }
}
