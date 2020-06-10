package Data;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Supplier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer index;
    public String supplier;
    //@ManyToMany
    //public PurchaseContract purchasectr;
 
    CBA("CBA"),
    Alcoa("Alcoa"),
    South32 ("South32"),
    Maaden ("Maaden"),
    Novelis ("Novelis"),
    Latasa("Latasa"),
    Pressmetal("Pressmetal"),
    RTA ("RTA");

 
    public Supplier() {
    }

    public Supplier(Integer index, String supplier) {
        this.index = index;
        this.supplier = supplier;
    }

    
    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    
}
