public class VecteurTableau implements Vecteur {


    private double[] vecteur;



    public VecteurTableau() {

    }


    /**
     * @param x
     * @param i
     */
    @Override
    public void add(double x, int i) {
        vecteur[i] = x;
    }

    /**
     * @param x
     */
    @Override
    public void setConst(double x) {
        if (vecteur.length!=0){
            for (int i = 0; i < vecteur.length; i++) {
                vecteur[i]=x;
            }
        }
    }


    /**
     * @param n
     */
    @Override
    public void origine(int n) {
        vecteur = new double[n];
        for (int i = 0; i < n; i++) {
            vecteur[i] = 0;
        }
    }

    /**
     * @param v
     * @return
     */
    @Override
    public double produitScalaire(Object v) {
        double sum = 0;
        if (v instanceof VecteurTableau) {
            VecteurTableau vt = (VecteurTableau) v;
            if (vt.vecteur.length==this.vecteur.length) {
                for (int i = 0; i < vecteur.length; i++) {
                    sum+=vt.vecteur[i]*this.vecteur[i];
                }

            }
        }
        return sum;
    }
}
