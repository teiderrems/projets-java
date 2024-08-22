package TP2;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Solitaire {
    public final static int NOMBRE_DE_PILES = 13;
    public final static int NOMBRE_PILES_ORDONNES = 4;
    public final static int NOMBRE_PILES_TABLES = 7;

    /* valeurs pour le graphisme */
    public final static int MARGE_SOMMET = 40;
    public final static int MARGE_GAUCHE = 5;
    public final static int DISTANCE_TABLE = 5;
    public final static int DISTANCE_ORDO = 5;
    /* on crée maintenant nos différentes piles de cartes qui
    seront des variables de classes
     */
    public static Deck deck; // le deck où on pioche les cartes
    public static Defausse defausse; // la défausse
    public static ArrayList<PilesTable> pilesTables; // les 7 piles sur la table
    public static ArrayList<PileOrdonnee> pileOrdonnees; // les 4 piles ordonnées
    public static ArrayList<PileCartes> pileCartes; // toutes les piles de cartes


//    public Solidaire(GraphicsContext gc,double x,double y){
//        gc.setStroke(Color.BLACK);
//        double tx=x;
//        tx+=40;
//        for (int i = 0; i < NOMBRE_PILES_ORDONNES; i++){
//            gc.strokeRect(tx,y+MARGE_SOMMET,Carte.LARGEUR,Carte.HAUTEUR);
////            gc.setFill(Color.RED);
//            gc.fillRect(tx,y+MARGE_SOMMET,Carte.LARGEUR,Carte.HAUTEUR);
//
//            tx+=Carte.LARGEUR+20;
//        }
//        tx=gc.getCanvas().getWidth()-Carte.LARGEUR*4;
//        for (int i = 0; i < 2; i++){
//            gc.fillRect(tx,y+MARGE_SOMMET,Carte.LARGEUR,Carte.HAUTEUR);
//            gc.strokeRect(tx,y+MARGE_SOMMET,Carte.LARGEUR,Carte.HAUTEUR);
//            tx+=Carte.LARGEUR+20;
//        }
//        deck=new Deck((int)(x),(int)y);
//        pilesTables=new ArrayList<PilesTable>();
//        for(int i=0; i<NOMBRE_PILES_TABLES; i++){
//            pilesTables.add(
//                    new PilesTable(MARGE_GAUCHE*2 + (Carte.LARGEUR + 20) * i,
//                            Carte.HAUTEUR + 20 + MARGE_SOMMET*5, i+1,deck)
//            );
//        }
//
//        for (int i = 0; i < NOMBRE_PILES_TABLES; i++){
//            pilesTables.get(i).draw(gc);
//        }
//    }
    public void  initialisation(GraphicsContext gc,int x, int y){
        deck=new Deck((int)(gc.getCanvas().getWidth()-Carte.LARGEUR*4),y+MARGE_SOMMET);
        defausse=new Defausse(x+(int)(gc.getCanvas().getWidth()-Carte.LARGEUR*4)+MARGE_SOMMET+50,y+MARGE_SOMMET);
        pilesTables=new ArrayList<>();
        pileCartes=new ArrayList<>();
        for(int i=0; i<NOMBRE_PILES_TABLES; i++){
            pilesTables.add(
                    new PilesTable(MARGE_GAUCHE+20 + (Carte.LARGEUR + 20) * i,
                            Carte.HAUTEUR + 200 + MARGE_SOMMET, i+1)
            );
        }

        pileOrdonnees=new ArrayList<>();
        for(int i=0; i<NOMBRE_PILES_ORDONNES; i++){
            pileOrdonnees.add(new PileOrdonnee(x+20+(Carte.LARGEUR+20)*(i),y+MARGE_SOMMET));
        }
        pileCartes.addAll(pileOrdonnees);
        pileCartes.addAll(pilesTables);
        pileCartes.add(defausse);
        pileCartes.add(deck);
        draw(gc);
    }

    public void draw(GraphicsContext gc){
        pileCartes.forEach((c)->c.draw(gc));
    }

    public void action(double x, double y,GraphicsContext gc){
        if ((deck.getX()<=x && x<=deck.getX()+Carte.LARGEUR) && (deck.getY()<=y && y<=deck.getY()+Carte.HAUTEUR)){
            if (deck.pileCartes.isEmpty()){
                defausse.pileCartes.forEach(c->c.retourne());
                deck.pileCartes.addAll(defausse.pileCartes);
                defausse.pileCartes.clear();
//                gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
            }
            else {
                defausse.ajouteCarte(deck.pileCartes.removeLast());
            }
            draw(gc);
        }
        if ((defausse.getX()<=x && x<=defausse.getX()+Carte.LARGEUR) && (defausse.getY()<=y && y<=defausse.getY()+Carte.HAUTEUR)){
            if (!defausse.pileCartes.isEmpty()){
                pilesTables.forEach(p->{
                    if (p.peutPoser(defausse.top())){
                        p.top().retourne();
                        p.ajouteCarte(defausse.top());
                        draw(gc);
                    }
                });
            }
        }
        if (!pilesTables.isEmpty() && pilesTables.getFirst().getX()<=x && x<=(pilesTables.getFirst().getX()+Carte.LARGEUR+MARGE_GAUCHE)*pilesTables.size()){
            pilesTables.forEach(p->{
                    if (!(p.pileCartes.isEmpty())) {
                        if((p.getX()<=x && x<=p.getX()+Carte.LARGEUR) &&
                                (p.getY()<=y && y<=p.getY()+Carte.HAUTEUR*(p.pileCartes.size()))) {
                            if (!p.top().getVisible()) {
                                p.top().retourne();
                                draw(gc);
                            }
                            pileOrdonnees.forEach(po -> {
                                if (po.peutPoser(p.pileCartes.getFirst())) {
                                    Carte c = p.pileCartes.getFirst();
                                    po.ajouteCarte(p.pileCartes.remove(p.pileCartes.lastIndexOf(c)));

                                    gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
                                    gc.setFill(Color.GREEN);
                                    gc.fillRect(0,0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
                                    draw(gc);
                                }
                            });
                        }
                    }
            });
        }
    }
}
