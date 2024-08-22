
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        VecteurTableau vt1 = new VecteurTableau();
        vt1.origine(5);
        VecteurTableau vt2 = new VecteurTableau();
        vt2.origine(5);
        vt1.setConst(2);
        vt2.setConst(3);
        System.out.println(vt1.produitScalaire(vt2));
        Vecteur vd1 = new VecteurDynamique();
        Vecteur vd2 = new VecteurDynamique();
        vd1.origine(5);
        vd2.origine(5);
        vd1.setConst(2);
        vd2.setConst(3);
        System.out.println(vd1.produitScalaire(vd2));
    }
}