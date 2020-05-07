package Bean;

//Import List
import Dao.GenericDao;
import Dao.PurchaseDao;
import Data.PurchaseContract;
import Data.Supplier;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class PurchaseBean {

    //Variables Declared
    private PurchaseContract pc;
    private List<PurchaseContract> contracts = new ArrayList<>();
    /*private List<Supplier> suppliers = new GenericDao().buscarTodos("from Supplier");

    //Getters-Setters and Constructors

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }
    */
    
    public List<PurchaseContract> getContracts() {
        return contracts;
    }

    public void setContracts(List<PurchaseContract> contracts) {
        this.contracts = contracts;
    }

    public PurchaseContract getPc() {
        return pc;
    }

    public void setPc(PurchaseContract pc) {
        this.pc = pc;
    }

    public PurchaseBean() {
        contracts = new PurchaseDao().Contracts();
        pc = new PurchaseContract();
    }

    //Save method
    public List<PurchaseContract> SaveBean() {
        new PurchaseDao().Salvar(pc);
        contracts = new PurchaseDao().Contracts();
        pc = new PurchaseContract();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successfully Saved!"));
        return contracts;
    }

    //Edit method
    public void Edit(PurchaseContract pch) {
        this.pc = pch;
    }

    //Delete method part
    public void DeletePrepared(PurchaseContract pch) {
        this.pc = pch;
    }

    //Delete method
    public void Delete() {
        new PurchaseDao().Delete(pc);
        pc = new PurchaseContract();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successfully Deleted!"));
        contracts = new PurchaseDao().Contracts();
    }

}
