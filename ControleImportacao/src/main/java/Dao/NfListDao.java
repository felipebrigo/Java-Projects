package Dao;

import Data.NfList;
import Data.PurchaseContract;
import Data.SalesContract;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class NfListDao {
    
    
    //Method to list all purchase contracts
    public List<PurchaseContract> PContracts(){
    EntityManager em = JPAUtil.getEntityManager();
    Query query = em.createQuery("from PurchaseContract");
    return query.getResultList();
    }
    
    public List<SalesContract> SContracts(){
    EntityManager em = JPAUtil.getEntityManager();
    Query query = em.createQuery("from SalesContract");
    return query.getResultList();
    }
       
    public List<NfList> Nf(){
    EntityManager em = JPAUtil.getEntityManager();
    Query query = em.createQuery("from NfList");
    return query.getResultList();
    }
}
