package Data;

public enum Enum_Customer {

Latasa("Latasa"),
Intelli("Intelli"),
Leeds("Leeds"),
Chelsea("Chelsea"),
Novelis("Novelis"),
Cordeiro("Cordeiro"),
GDRW("GDRW");

private String label; 

    private Enum_Customer (String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    
}
