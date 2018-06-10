
public class TourJoueur {
    private int tourJoueur;
    // Tour joueur initialisé a 0
    public TourJoueur(){
        tourJoueur = 0;
    }
    // Le remettre a 0
    public void resetTourJoueur(){
        tourJoueur = 0;
    }
    // L'incrementer
    public void plusTourJoueur(){
        tourJoueur++;
    }
    // Savoir i la grille est rempli elon la taille
    public boolean rempliTourJoueur(int taille){
        return (tourJoueur == taille * taille);
    }
    
    public int getTourJoueur(){
        return tourJoueur;
    }
}
