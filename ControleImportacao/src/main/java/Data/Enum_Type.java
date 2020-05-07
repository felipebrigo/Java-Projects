
package Data;

public enum Enum_Type {

PURCHASE("Purchase","purchase"),
SALES("Sales","sales");

private String typeofcontract;
private String css;


    private Enum_Type(String typeofcontract, String css) {
        this.typeofcontract = typeofcontract;
        this.css = css;
        
    }

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }
    

    public String getTypeofcontract() {
        return typeofcontract;
    }

    public void setTypeofcontract(String typeofcontract) {
        this.typeofcontract = typeofcontract;
    }    
    
}
