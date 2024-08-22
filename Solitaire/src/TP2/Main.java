package TP2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {
    private static GraphicsContext gc;
    // les constantes et variables globales
    public final static int CARTES_PAR_COULEUR = 13;
    public final static int NOMBRE_COULEURS = 4;
    public final static int NOMBRE_PILES = 7;
    public final static int MARGE_HAUTE = 100;
    public final static int MARGE_GAUCHE = 400;
    @Override
    public void start(Stage stage) throws Exception {
        initUI(stage);
    }
    private void initUI(Stage stage) {
        Pane root = new Pane();
        Canvas canvas = new Canvas(1580, 1080);
        gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        var scene = new Scene(root, 300, 250, Color.WHITESMOKE);
        stage.setTitle("Solitaire");
        //détecte le clic gauche
        gc.setFill(Color.GREEN);
        gc.fillRect(0,0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());

        Solitaire s=new Solitaire();
        s.initialisation(gc,0,0);
        root.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
//                System.out.println("Clic gauche détecté à la position (" + event.getX() + ", " +
//                     event.getY() + ")");
                int x, y;
                x = (int) event.getX();
                y = (int) event.getY();
                s.action(x,y,gc);
//                for (int i = 0; i < Solitaire.NOMBRE_DE_PILES; i++)
//                    if (Solitaire.pileCartes.get(i).estInclus(x, y)){
//                        System.out.println("la pile " + i + " a été cliqué");
//                    }
            }
        });
        stage.setScene(scene);
        stage.show();
        run4();
    }
    public static void run(int x,int y){
        Solitaire s=new Solitaire();
        s.initialisation(gc,0,0);
//        s.action(x,y);
    }

    // test des piles sur la table
    public static void run4(){

        Solitaire s=new Solitaire();
        s.initialisation(gc,0,0);

    }

    // test des piles sur la table
//    public static void run5(){
//        ArrayList<PileOrdonnee> toutesPiles = new ArrayList<PileOrdonnee>();
//        for (int i = 0; i < NOMBRE_PILES; i++)
//            toutesPiles.add(
//                    new PileOrdonnee(MARGE_GAUCHE + (Carte.LARGEUR + 20) * i,
//                            Carte.HAUTEUR + 20 + MARGE_HAUTE, i+1));
//        for (int i = 0; i < NOMBRE_PILES; i++){
//            toutesPiles.get(i).draw(gc);
//        }
//
//    }

}
