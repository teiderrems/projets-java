package TP2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.LinkedList;

public class PileCartes {
    private int x,y;
    public LinkedList<Carte> pileCartes;

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public PileCartes(int x, int y){
        this.x = x;
        this.y = y;
        this.pileCartes=new LinkedList<Carte>();
    }

    public Carte top(){
        return pileCartes.getFirst();
    }
    public Carte pop(){
        return pileCartes.removeFirst();
    }

    public boolean estVide(){
        return pileCartes.isEmpty();
    }

    public int taille(){
        return pileCartes.size();
    }

    public LinkedList<Carte> getPileCartes() {
        return pileCartes;
    }

    public void ajouteCarte(Carte c){
        pileCartes.push(c);
    }
    public void  setPileCartes(LinkedList<Carte> pileCartes){
        this.pileCartes = pileCartes;
    }

    public void draw(GraphicsContext gc){
        if (pileCartes.size()>0){
            pileCartes.getFirst().draw(gc,x,y);
        }
        gc.setFill(Color.WHITE);
        gc.fillRect(x,y,Carte.LARGEUR,Carte.HAUTEUR);
        gc.fillRect(x,y,Carte.LARGEUR,Carte.HAUTEUR);
    }

    public boolean estInclus(int tx, int ty){
        if( (x<=tx && tx<=x+Carte.LARGEUR) && (y<=ty && ty<=y+Carte.HAUTEUR)){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        String res = "TP2.PileCartes\n";

        for(int i = 0; i < this.pileCartes.size(); i++)
            res += this.pileCartes.get(i).toString() + "\n";

        return res;
    }
}
