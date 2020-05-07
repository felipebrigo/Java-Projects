package Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class PurchaseContract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String purchasectr;//Show on report 1st column
    private String producer;
    private String productobject;//Show on report 3rd column
    private Integer ctrvolume;//Show on report 4th column
    private Integer monthlyvolume;
    private boolean annual;
    private boolean active;//Show on report 6th column
    private LocalDateTime expirydate;//Show on report 5th column
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchasectr")
    //@JoinColumn(name = "numnfpurchase")
    private List<NfList> nf;
    
    //@ManyToMany(cascade = CascadeType.ALL, mappedBy = "purchasectr")
    //@JoinColumn(name = 
    //private List<Supplier> supplier;
    
    //@OneToMany de PurchaseContract com NfList e @OneToMany de PurchaseContract com SalesContract
    
    public PurchaseContract() {
    }

    public PurchaseContract(String purchasectr, String productobject, Integer ctrvolume, LocalDateTime expirydate) {
        this.purchasectr = purchasectr;
        this.productobject = productobject;
        this.ctrvolume = ctrvolume;
        this.expirydate = expirydate;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPurchasectr() {
        return purchasectr;
    }

    public void setPurchasectr(String purchasectr) {
        this.purchasectr = purchasectr;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getProductobject() {
        return productobject;
    }

    public void setProductobject(String productobject) {
        this.productobject = productobject;
    }

    public Integer getCtrvolume() {
        return ctrvolume;
    }

    public void setCtrvolume(Integer ctrvolume) {
        this.ctrvolume = ctrvolume;
    }

    public Integer getMonthlyvolume() {
        return monthlyvolume;
    }

    public void setMonthlyvolume(Integer monthlyvolume) {
        this.monthlyvolume = monthlyvolume;
    }

    public boolean isAnnual() {
        return annual;
    }

    public void setAnnual(boolean annual) {
        this.annual = annual;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(LocalDateTime expirydate) {
        this.expirydate = expirydate;
    }
    
    /*
    public List<NfList> getNf() {
        return nf;
    }

    public void setNf(List<NfList> nf) {
        this.nf = nf;
    }
    */
    
}
