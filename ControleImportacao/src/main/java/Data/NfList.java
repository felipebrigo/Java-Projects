package Data;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
public class NfList implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id; 
    @Transient
    private Supplier supplier;//Show on report 2nd column - purchase view / 5nd column - sales view
    @Transient
    private Enum_Customer customer;//Show on report 5nd column - purchase view / 2nd column sales view
    private Integer numnfpurchase;//Show on report 1st column - purchase view
    private Integer numnfsales;//Show on report 1st column - sales view
    private Integer volume;//Show on report 4th column - all view
    @ManyToOne
    private PurchaseContract purchasectr;
    @ManyToOne
    private SalesContract salesctr;//Show on report 3rd column - purchase view
    @Transient
    private Enum_Product productobject;//Show on report 3rd column - all view

    public NfList() {
    }

    public NfList(Supplier supplier, Enum_Customer customer, Integer numnfpurchase, Integer numnfsales, Integer volume, PurchaseContract purchasectr, SalesContract salesctr, Enum_Product productobject) {
        this.supplier = supplier;
        this.customer = customer;
        this.numnfpurchase = numnfpurchase;
        this.numnfsales = numnfsales;
        this.volume = volume;
        this.purchasectr = purchasectr;
        this.salesctr = salesctr;
        this.productobject = productobject;
    }   
  
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull
    public Integer getNumnfpurchase() {
        return numnfpurchase;
    }

    public void setNumnfpurchase(Integer numnfpurchase) {
        this.numnfpurchase = numnfpurchase;
    }

    @NotNull
    public Integer getNumnfsales() {
        return numnfsales;
    }

    public void setNumnfsales(Integer numnfsales) {
        this.numnfsales = numnfsales;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public PurchaseContract getPurchasectr() {
        return purchasectr;
    }

    public void setPurchasectr(PurchaseContract purchasectr) {
        this.purchasectr = purchasectr;
    }

    public SalesContract getSalesctr() {
        return salesctr;
    }

    public void setSalesctr(SalesContract salesctr) {
        this.salesctr = salesctr;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Enum_Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Enum_Customer customer) {
        this.customer = customer;
    }

    public Enum_Product getProductobject() {
        return productobject;
    }

    public void setProductobject(Enum_Product productobject) {
        this.productobject = productobject;
    }

}
