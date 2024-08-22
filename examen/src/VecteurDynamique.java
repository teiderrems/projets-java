import java.util.ArrayList;
import java.util.List;

public class VecteurDynamique implements Vecteur {

    private List<Double> vecteur;

    /**
     * @param x
     * @param i
     */
    @Override
    public void add(double x, int i) {
        if (vecteur == null) {
            vecteur.add(i,x);
        }
    }

    /**
     * @param x
     */
    @Override
    public void setConst(double x) {
        for (int i = 0; i <vecteur.size(); i++) {
            vecteur.set(i,x);
        }
    }

    /**
     * @param n
     */
    @Override
    public void origine(int n) {
        vecteur=new ArrayList<Double>();
        for (int i = 0; i <n; i++) {
            vecteur.add((double) 0);
        }
    }

    /**
     * @param v
     * @return
     */
    @Override
    public double produitScalaire(Object v) {
        double sum = 0;
        if (v instanceof VecteurDynamique) {
            VecteurDynamique vt = (VecteurDynamique) v;
            if (vt.vecteur.size()==this.vecteur.size()) {
                for (int i = 0; i < vecteur.size(); i++) {
                    sum+=vt.vecteur.get(i)*this.vecteur.get(i);
                }

            }
        }
        return sum;
    }
}
