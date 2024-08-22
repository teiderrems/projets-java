package TP2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Defausse extends PileCartes{
    public Defausse(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(GraphicsContext gc) {
        if (this.pileCartes.isEmpty()){
            gc.setFill(Color.WHITE);
            gc.fillRect(this.getX(),this.getY(),Carte.LARGEUR,Carte.HAUTEUR);
            gc.fillRect(this.getX(),this.getY(),Carte.LARGEUR,Carte.HAUTEUR);
        }
        else if (this.getPileCartes().size()==1){
            this.getPileCartes().getFirst().draw(gc,this.getX(),this.getY());
        }
        else {
            for (int i = this.getPileCartes().size() - 1; i >= 0; i--) {
                this.getPileCartes().get(i).draw(gc, this.getX(), this.getY());
            }
        }
    }

    @Override
    public void ajouteCarte(Carte c) {
        if (c.getVisible())
            super.ajouteCarte(c);
        else {
            c.retourne();
            super.ajouteCarte(c);
        }
    }
}
