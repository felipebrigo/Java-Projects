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
    private Integer index;
    private String suppliername;

    public Supplier() {
    }

    public Supplier(Integer index, String suppliername) {
        this.index = index;
        this.suppliername = suppliername;
    }

    @Override
    public String toString() {
        return "Supplier{" + "index=" + index + ", suppliername=" + suppliername + '}';
    }
    
    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

}
