package Data;

public enum Enum_Product {

P1020("P1020"),
P0610("P0610"),
P0406("P0406"),
AlAlloys("Al-Alloys"),
GeneralBillets("GeneralBillets"),
Billets4("Billets4"),
Billets5("Billets5"),
Billets6("Billets6"),
Billets7("Billets7"),
Billets8("Billets8");

private String label; 

    private Enum_Product (String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    
}
