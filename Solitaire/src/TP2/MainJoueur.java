package TP2;


import java.util.ArrayList;
import java.util.List;

public class MainJoueur {

    private final List<Carte> mainJ;

    public MainJoueur() {
        mainJ = new ArrayList<Carte>();
    }

    public void clear() {
        mainJ.clear();
    }

    public void ajouterCarte(Carte carte) {
        if (mainJ.size() < 6)
            mainJ.add(carte);

    }

    public void enleverCarte(int position) {
        if ((position >= 0) && (position < mainJ.size())) {
            mainJ.remove(position);
        }
    }

    public Carte getCarte(int position) {
        return mainJ.get(position);
    }

    public void trieParValeur() {
        mainJ.sort(new CompareCarte());

    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < mainJ.size(); i++)
            res += mainJ.get(i).toString() + "\n";

        return res;
    }

    public static void main(String[] args) {


            Carte c1 = new Carte(10,2);
            Carte c2 = new Carte(Carte.ROI,Carte.TREFLES);
            Carte c3 = new Carte(Carte.DAME, Carte.CARREAUX);
            Carte c4 = new Carte(8, Carte.PIQUES);
            Carte c5 = new Carte(Carte.AS, Carte.PIQUES);
            Carte c6 = new Carte(7, Carte.TREFLES);
            MainJoueur m = new MainJoueur();
            m.ajouterCarte(c1);
            m.ajouterCarte(c2);
            m.ajouterCarte(c3);
            m.ajouterCarte(c4);
            m.ajouterCarte(c5);
            m.ajouterCarte(c6);
            System.out.println(m);
            m.trieParValeur();
            System.out.println(m);
            m.enleverCarte(2); // on enlève le 8 de Piques
            System.out.println(m);
    }
}

