package TP2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PileOrdonnee extends PileCartes{
    public PileOrdonnee(int x, int y) {
        super(x, y);

//        Solitaire.deck.shuffle();
//        for (int i = 0; i < Solitaire.NOMBRE_DE_PILES; i++) {
//            if (peutPoser(Solitaire.deck.pileCartes.get(i))){
//                this.pileCartes.add(Solitaire.deck.pileCartes.remove(i));
//            }
//        }
//        if (!this.pileCartes.isEmpty()){
//            this.top().retourne();
//        }
    }

    public boolean peutPoser(Carte carte){

        if (this.pileCartes.isEmpty()){
            if (carte.getValeur()==Carte.AS){
                return true;
            }
            else {
                return false;
            }
        }
        else{
            if ((this.pileCartes.getFirst().getValeur()+1==carte.getValeur())
                    && (carte.getCouleur()==this.pileCartes.getFirst().getCouleur())){
                return true;
            }
            return false;
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        if (this.pileCartes.isEmpty()){
            gc.setFill(Color.WHITE);
            gc.fillRect(this.getX(),this.getY(),Carte.LARGEUR,Carte.HAUTEUR);
            gc.fillRect(this.getX(),this.getY(),Carte.LARGEUR,Carte.HAUTEUR);
        }
        if (this.getPileCartes().size()==1){
            this.pileCartes.getFirst().retourne();
            this.getPileCartes().getFirst().draw(gc,this.getX(),this.getY());
        }
        else if (this.pileCartes.size()>1){
            int position=this.getY();
            this.pileCartes.getFirst().retourne();
            for (int i=this.getPileCartes().size()-1;i>=0;i--){
                if (i==0){
                    this.getPileCartes().get(i).draw(gc,this.getX(),position);
                }
                if (i==this.getPileCartes().size()-1){
                    this.getPileCartes().get(i).draw(gc,this.getX(),this.getY());
                }
                else
                    this.getPileCartes().get(i).draw(gc,this.getX(),position);
//                position+=15;
            }
        }
    }
}
