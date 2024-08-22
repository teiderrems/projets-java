package formule;

public class Produit implements IFormule {
    private  Param p1,p2;
    public Produit(Param p1, Param p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    private double getValeur(){
        return p1.valeurNumerique()*p2.valeurNumerique();
    }

    @Override
    public String toString() {
        return "("+p1.getLabel()+"*"+p2.getLabel()+")";
    }

    /**
     * @return
     */
    @Override
    public String ecritureFormelle() {
        return this.toString();
    }

    /**
     * @return
     */
    @Override
    public double valeurNumerique() {
        return this.getValeur();
    }
}
