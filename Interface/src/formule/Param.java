package formule;

public class Param implements IFormule {
    private String label;
    private double value;

    public Param(String label, double value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    private double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * @return
     */
    @Override
    public String ecritureFormelle() {
        return this.getLabel();
    }

    /**
     * @return
     */
    @Override
    public double valeurNumerique() {
        return this.getValue();
    }
}
