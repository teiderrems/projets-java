package TP2;

import javafx.scene.canvas.GraphicsContext;

public class PilesTable extends PileCartes{

    private int nombresCartes;
    public final int YDIST=4;

    public PilesTable(int x, int y, int nombresCartes) {
        super(x, y);
        Solitaire.deck.shuffle();
        for (int i = 0; i < nombresCartes; i++) {
            this.pileCartes.add(Solitaire.deck.pop());
        }
        this.nombresCartes=nombresCartes;
        if (!this.pileCartes.isEmpty()){
            this.top().retourne();
        }
    }
    @Override
    public boolean estInclus(int tx, int ty){
        if( (this.getX()<=tx && tx<=this.getX()+Carte.LARGEUR) && (this.getY()<=ty && ty<=this.getY()+Carte.HAUTEUR)){
            return true;
        }
        return false;
    }

    public boolean peutPoser(Carte carte){

        if (this.pileCartes.isEmpty()){
            if (carte.getValeur()==Carte.ROI){
                return true;
            }
            else {
                return false;
            }
        }
        else{
            if ((this.pileCartes.getFirst().getValeur()-1==carte.getValeur())
                    && (carte.getCouleur()!=this.pileCartes.getFirst().getCouleur())){
                   return true;
            }
            return false;
        }
    }

//    public void selectionne(int a,int b) {
//
//    }

    @Override
    public void draw(GraphicsContext gc) {
        if (this.getPileCartes().size()==1){
            this.getPileCartes().getFirst().draw(gc,this.getX(),this.getY());
        }
        else{
            int position=this.getY();
            for (int i=this.getPileCartes().size()-1;i>=0;i--){
                if (i==0){
                    this.getPileCartes().get(i).draw(gc,this.getX(),position+25);
                }
                if (i==this.getPileCartes().size()-1){
                    this.getPileCartes().get(i).draw(gc,this.getX(),this.getY());
                }
                else
                    this.getPileCartes().get(i).draw(gc,this.getX(),position+25);
                position+=25;
            }
        }
    }


}
