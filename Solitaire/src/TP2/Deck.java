package TP2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Deck extends PileCartes {

//    private final LinkedList<Carte> deck;
    // Un tableau de 52 cartes correspondant à un jeu complet

    public static int NOMBRE_CARTES =  52;

    private int cartesUtilisees;

    public Deck(int x,int y){
        super(x,y);
        this.cartesUtilisees=0;
        for(int couleur = Carte.PIQUES; couleur <= Carte.TREFLES; couleur++){
            for(int valeur = Carte.AS; valeur <= Carte.ROI; valeur++){
                pileCartes.add( new Carte(valeur, couleur));
            }
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        if (this.pileCartes.isEmpty()){
            gc.setFill(Color.BLACK);
            gc.fillRect(this.getX(),this.getY(),Carte.LARGEUR,Carte.HAUTEUR);
            gc.fillRect(this.getX(),this.getY(),Carte.LARGEUR,Carte.HAUTEUR);
        }
        else{
            if (this.getPileCartes().size()==1){
                this.getPileCartes().getFirst().draw(gc,this.getX(),this.getY());
            }
            else
                this.pileCartes.forEach((c->{
                    c.draw(gc,this.getX(),this.getY());
                }));
        }

    }


    @Override
    public boolean estInclus(int tx, int ty){
        if( (this.getX()<=tx && tx<=this.getX()+Carte.LARGEUR) && (this.getY()<=ty && ty<=this.getY()+Carte.HAUTEUR)){
            return true;
        }
        return false;
    }

    public Carte distribuerCarte(){
        this.cartesUtilisees++;
        Deck.NOMBRE_CARTES--;
        return this.top();
    }



    @Override
    public String toString(){
        String res = "TP2.Deck\n";

        for(int i = 0; i < this.getPileCartes().size(); i++)
            res += this.getPileCartes().get(i).toString() + "\n";

        return res;

    }

    public void shuffle(){
        Collections.shuffle(this.getPileCartes());
    }


    public int cartesRestantes(){
        return Deck.NOMBRE_CARTES-this.cartesUtilisees;
    }


    public List<Carte> getDeck(){
        return this.getPileCartes();
    }
//    public static void main(String [] args){
//        Deck deck1 = new Deck();
//        System.out.println(deck1);
//        deck1.shuffle();
//        System.out.print(deck1);
//        System.out.println(deck1.getDeck().size());
//
//    }
}
