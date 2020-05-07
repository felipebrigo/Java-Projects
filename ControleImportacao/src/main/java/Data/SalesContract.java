package Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class SalesContract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Enum_Customer customer;
    private String salesctr;
    private String productobject;
    private Integer ctrvolume;
    private Integer monthlyvolume;
    private boolean annual;
    private boolean active;
    private LocalDateTime expirydate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salesctr")
    //@JoinColumn(name = "numnfsales")
    private List<NfList> nf;

    public SalesContract() {
    }
    

    public SalesContract(Integer id, Enum_Customer customer, String salesctr, String productobject, Integer ctrvolume, Integer monthlyvolume, boolean annual, boolean active, LocalDateTime expirydate) {
        this.id = id;
        this.customer = customer;
        this.salesctr = salesctr;
        this.productobject = productobject;
        this.ctrvolume = ctrvolume;
        this.monthlyvolume = monthlyvolume;
        this.annual = annual;
        this.active = active;
        this.expirydate = expirydate;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Enum_Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Enum_Customer customer) {
        this.customer = customer;
    }

    public String getSalesctr() {
        return salesctr;
    }

    public void setSalesctr(String salesctr) {
        this.salesctr = salesctr;
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
