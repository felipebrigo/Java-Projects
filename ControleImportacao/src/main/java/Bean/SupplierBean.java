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
public class SupplierBean {

    //Variables Declared
    private Supplier newsupplier;
    private List<Supplier> suppliers = new ArrayList<>();

    //Getters-Setters and Constructors
    public SupplierBean() {
        suppliers = new GenericDao().buscarTodos("from Supplier");
        newsupplier = new Supplier();
    }

    public SupplierBean(Supplier newsupplier) {
        this.newsupplier = newsupplier;
    }

    public Supplier getNewsupplier() {
        return newsupplier;
    }

    public void setNewsupplier(Supplier newsupplier) {
        this.newsupplier = newsupplier;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    //Save method
    public List<Supplier> SaveBean() {

        new GenericDao().salvar(newsupplier);
        newsupplier = new Supplier();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successfully Saved!"));
        suppliers = new GenericDao().buscarTodos("from Supplier");
        return suppliers;
    }

    /*Edit method test on github
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
    }*/
}
