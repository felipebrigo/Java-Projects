package Bean;

//Import List
import Dao.NfListDao;
import Data.PurchaseContract;
import Data.NfList;
import Data.SalesContract;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.TreeNode;

@ManagedBean
@SessionScoped
public class NfListBean {

    //Variables Declared
    private List<PurchaseContract> pcontracts = new ArrayList<>();
    private List<SalesContract> scontracts = new ArrayList<>();
    private List<NfList> nfs = new ArrayList<>();
    private SalesContract sc;
    private NfList nfl;
    private PurchaseContract pc;
    private DocumentService service;
    private TreeNode root;
    
    //@PostConstruct
    public void init(){
/*        PurchaseContract purchase = new PurchaseContract(CBA, "ALP-XX-XXXX", "Hillside", "P1020", 500000, 250000, "True", "False", LocalDateTime.now());
        NfList nf1 = new NfList("CBA", "GDRW", 11111, 22222, 25000, purchase, sales, "P1020");*/
        root=service.createDocuments();
    }
    
    //Getters and Setters
    public DocumentService getService() {
        return service;
    }

    public void setService(DocumentService service) {
        this.service = service;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public List<PurchaseContract> getPcontracts() {
        return pcontracts;
    }

    public void setPcontracts(List<PurchaseContract> pcontracts) {
        this.pcontracts = pcontracts;
    }

    public List<SalesContract> getScontracts() {
        return scontracts;
    }

    public void setScontracts(List<SalesContract> scontracts) {
        this.scontracts = scontracts;
    }

    public List<NfList> getNfs() {
        return nfs;
    }

    public void setNfs(List<NfList> nfs) {
        this.nfs = nfs;
    }

    public PurchaseContract getPc() {
        return pc;
    }

    public void setPc(PurchaseContract pc) {
        this.pc = pc;
    }

    public SalesContract getSc() {
        return sc;
    }

    public void setSc(SalesContract sc) {
        this.sc = sc;
    }

    public NfList getNfl() {
        return nfl;
    }

    public void setNfl(NfList nfl) {
        this.nfl = nfl;
    }

    //Lists method
    public List<PurchaseContract> PContract() {
        List pcontracts = new NfListDao().PContracts();
        pc = new PurchaseContract();
        return pcontracts;
    }

    public List<SalesContract> SContract() {
        List scontracts = new NfListDao().SContracts();
        sc = new SalesContract();
        return scontracts;
    }

    public List<NfList> Allnflist() {
        List nfs = new NfListDao().Nf();
        nfl = new NfList();
        return nfs;
    }

}
