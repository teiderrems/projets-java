package formule;

public class Somme implements IFormule {

    private IFormule f1;
    private IFormule f2;

    public Somme(IFormule f1,IFormule f2){
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public String toString() {
        if (f1 instanceof Produit && f2 instanceof Produit){
            return "("+((Produit)f1).ecritureFormelle()+"+"+((Produit)f2).ecritureFormelle()+")";
        }
        if (f1 instanceof Param && f2 instanceof Produit){
            return "("+((Param)f1).ecritureFormelle()+"+"+((Produit)f2).ecritureFormelle()+")";
        }
        if (f1 instanceof Param && f2 instanceof Param){
            return "("+((Param)f1).ecritureFormelle()+"+"+((Produit)f2).ecritureFormelle()+")";
        }
        return "";
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
        return f2.valeurNumerique()+f1.valeurNumerique();
    }
}
