package formule;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Param x1 = new Param("x1", 4.0);
        Param x2 = new Param("x2", -1.5);
        IFormule f = new Somme(x1, new Produit(x2, x2));
        System.out.println(f.ecritureFormelle());
        System.out.println(f.valeurNumerique());
        IFormule f1 = new Somme(x1,f);
        System.out.println(f1.ecritureFormelle());
        System.out.println(f1.valeurNumerique());
        x1.setValue(8.0);
        System.out.println("Nouvelle valeur de la somme après modification de la valeur de x1");
        System.out.println(f1.valeurNumerique());
    }
}