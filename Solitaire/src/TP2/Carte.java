package TP2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Carte {
    // Les attributs prives
    private int valeur;
    private int couleur;
//    private boolean visible;
    private boolean visible;

    // Codes pour les 4 couleurs
    public final static int PIQUES = 0, COEURS = 1, CARREAUX = 2, TREFLES = 3;

    // codes pour les cartes non numériques : les valeurs 2 à 10 ont leur propre valeur
    public final static int AS = 1, VALET = 11, DAME = 12, ROI = 13;

    public final static int LARGEUR = 60, HAUTEUR = 90;
    public Carte(int valeur, int couleur) {
        this.valeur = valeur;
        this.couleur = couleur;
        this.visible = false;
    }

    public int getValeur() {
        return this.valeur;
    }

    public int getCouleur() {
        return this.couleur;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getCouleurCommeChaine() {
        switch (this.couleur) {
            case 0 : 
                return  "Piques";
            case 1 : 
                return  "Coeur";
            case 2 : 
                return  "Carreaux";
            case 3 : 
                return  "Trefles";
            default : 
                return  "??";
        }
    }

    public String getValeurCommeChaine() {
         switch (this.valeur) {
             case 1 : return "As";
             case 11 : return "Valet";
             case 12 : return "Dame";
             case 13 : return "Roi";
             default :
                if(this.valeur >= 2 && this.valeur <= 10) {
                    return this.valeur + "";
                } else {
                    return "??";
                }
        }
    }

    @Override
    public String toString() {
        return getValeurCommeChaine() + " de " + getCouleurCommeChaine() + "\n";
    }

    public void retourne() {
        this.visible = !this.visible;
    }

    public void draw(GraphicsContext gc, int x, int y) {
        gc = drawRect(gc, x, y);

        if(this.visible) {
            gc.setFill(Color.WHITE);
            gc.fillRect(x+1, y+1, LARGEUR-2, HAUTEUR-2);
            switch (couleur) {
                case PIQUES: {
                    gc = drawSpade(gc, x, y);
                    break;
                }
                case COEURS: {
                    gc = drawHeart(gc, x, y);
                    break;
                }
                case CARREAUX: {
                    gc = drawTile(gc, x, y);
                    break;
                }
                case TREFLES: {
                    gc = drawClover(gc, x, y);
                    break;
                }
                default: {
                    System.out.println("??");
                }
            }
        } else {
            gc = drawHidden(gc, x, y);
        }

    }

    public GraphicsContext drawRect(GraphicsContext gc, int x, int y) {
        gc.setStroke(Color.BLACK);
        gc.strokeRect(x, y, LARGEUR, HAUTEUR);
        gc.setFill(Color.BLACK);

        return gc;
    }

    public GraphicsContext drawSpade(GraphicsContext gc, int x, int y) { // PIQUES
        gc.strokeText(getValeurCommeChaine(), x+5, y+15);
        gc.strokeLine(x + 8, y + 20, x + 4, y + 27);
        gc.strokeLine(x + 4, y + 27, x + 12, y + 27);
        gc.strokeLine(x + 12, y + 27, x + 8, y + 20);
        gc.strokeLine(x + 8, y + 25, x + 6, y + 30);
        gc.strokeLine(x + 6, y + 30, x + 10, y + 30);
        gc.strokeLine(x + 10, y + 30, x + 8, y + 25);

        gc.strokeLine(x + 8+34, y + 20+35, x + 4+34, y + 27+35);
        gc.strokeLine(x + 4+34, y + 27+35, x + 12+34, y + 27+35);
        gc.strokeLine(x + 12+34, y + 27+35, x + 8+34, y + 20+35);
        gc.strokeLine(x + 8+34, y + 25+35, x + 6+34, y + 30+35);
        gc.strokeLine(x + 6+34, y + 30+35, x + 10+34, y + 30+35);
        gc.strokeLine(x + 10+34, y + 30+35, x + 8+34, y + 25+35);

        gc.strokeLine(x + 15, y + 50, x + 35, y + 50);
        gc.strokeLine(x + 35, y + 50, x + 25, y + 30);
        gc.strokeLine(x + 25, y + 30,x + 15, y + 50);
        gc.strokeLine(x + 25, y + 45, x + 15, y + 60);
        gc.strokeLine(x + 15, y + 60, x + 35, y + 60);
        gc.strokeLine(x + 35, y + 60, x + 25, y + 45);
        gc.strokeText(getValeurCommeChaine(), x + 39, y + 79);

        return gc;
    }

    public GraphicsContext drawHeart(GraphicsContext gc, int x, int y) { // COEURS
        gc.setStroke(Color.RED);
        gc.strokeText(getValeurCommeChaine(), x+5, y+15);
        gc.strokeLine(x + 4, y + 22, x + 6, y + 20);
        gc.strokeLine(x + 6, y + 20, x + 8, y + 22);
        gc.strokeLine(x + 8, y + 22, x + 10, y + 20);
        gc.strokeLine(x + 10, y + 20, x + 12, y + 22);
        gc.strokeLine(x + 12, y + 22, x + 8, y + 30);
        gc.strokeLine(x + 8, y + 30, x + 4, y + 22);

        gc.strokeLine(x + 4+34, y + 22+35, x + 6+34, y + 20+35);
        gc.strokeLine(x + 6+34, y + 20+35, x + 8+34, y + 22+35);
        gc.strokeLine(x + 8+34, y + 22+35, x + 10+34, y + 20+35);
        gc.strokeLine(x + 10+34, y + 20+35, x + 12+34, y + 22+35);
        gc.strokeLine(x + 12+34, y + 22+35, x + 8+34, y + 30+35);
        gc.strokeLine(x + 8+34, y + 30+35, x + 4+34, y + 22+35);

        gc.strokeLine(x + 15, y + 40, x + 20, y + 30);
        gc.strokeLine(x + 20, y + 30, x + 25, y + 40);
        gc.strokeLine(x + 25, y + 40, x + 30, y + 30);
        gc.strokeLine(x + 30, y + 30, x + 35, y + 40);
        gc.strokeLine(x + 35, y + 40, x + 25, y + 60);
        gc.strokeLine(x + 25, y + 60, x + 15, y + 40);
        gc.strokeText(getValeurCommeChaine(), x + 39, y + 79);

        return gc;
    }

    public GraphicsContext drawTile(GraphicsContext gc, int x, int y) { // CARREAUX
        gc.setStroke(Color.RED);
        gc.strokeText(getValeurCommeChaine(), x+5, y+15);
        gc.strokeLine(x + 8, y + 20, x + 4, y + 25);
        gc.strokeLine(x + 4, y + 25, x + 8, y + 30);
        gc.strokeLine(x + 8, y + 30, x + 12, y + 25);
        gc.strokeLine(x + 12, y + 25, x + 8, y + 20);

        gc.strokeLine(x + 42, y + 55, x + 38, y + 60);
        gc.strokeLine(x + 38, y + 60, x + 42, y + 65);
        gc.strokeLine(x + 42, y + 65, x + 46, y + 60);
        gc.strokeLine(x + 46, y + 60, x + 42, y + 55);


        gc.strokeLine(x + 25, y + 30, x + 15, y + 45);
        gc.strokeLine(x + 15, y + 45, x + 25, y + 60);
        gc.strokeLine(x + 25, y + 60, x + 35, y + 45);
        gc.strokeLine(x + 35, y + 45,x + 25, y + 30);
        gc.strokeText(getValeurCommeChaine(), x + 39, y + 79);

        return gc;
    }


    public GraphicsContext drawClover(GraphicsContext gc, int x, int y) { // TREFLES
        gc.strokeText(getValeurCommeChaine(), x+5, y+15);
        drawCircle(gc,x+10,y+25,2);
        drawCircle(gc,x+6,y+25,2);
        drawCircle(gc,x+8,y+22,2);
        gc.strokeLine(x + 8, y + 25, x + 6, y + 30);
        gc.strokeLine(x + 6, y + 30, x + 10, y + 30);
        gc.strokeLine(x + 10, y + 30, x + 8, y + 25);

        drawCircle(gc,x+10+34,y+25+35,2);
        drawCircle(gc,x+6+34,y+25+35,2);
        drawCircle(gc,x+8+34,y+22+35,2);
        gc.strokeLine(x + 8+34, y + 25+35, x + 6+34, y + 30+35);
        gc.strokeLine(x + 6+34, y + 30+35, x + 10+34, y + 30+35);
        gc.strokeLine(x + 10+34, y + 30+35, x + 8+34, y + 25+35);

        drawCircle(gc,x+30,y+45,5);
        drawCircle(gc,x+20,y+45,5);
        drawCircle(gc,x+25,y+35,5);
        gc.strokeLine(x + 25, y + 45, x + 15, y + 60);
        gc.strokeLine(x + 15, y + 60, x + 35, y + 60);
        gc.strokeLine(x + 35, y + 60, x + 25, y + 45);
        gc.strokeText(getValeurCommeChaine(), x + 39, y + 79);

        return gc;
    }

    public GraphicsContext drawHidden(GraphicsContext gc, int x, int y) {
        gc.setFill(Color.WHITE);
        gc.fillRect(x+1, y+1, LARGEUR-2, HAUTEUR-2);
        gc.setStroke(Color.BLUE);
        gc.strokeLine(x + 15, y + 5, x + 15, y + 65);
        gc.strokeLine(x + 35, y + 5, x + 35, y + 65);
        gc.strokeLine(x + 5, y + 15, x + 45, y + 15);
        gc.strokeLine(x + 5, y + 35, x + 45, y + 35);
        gc.strokeLine(x + 5, y + 55, x + 45, y + 55);

        return gc;
    }

    private void drawCircle(GraphicsContext gc, int centerX, int centerY, int radius) {
        gc.strokeOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
    }

}
