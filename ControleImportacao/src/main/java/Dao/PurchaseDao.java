package Dao;

import Data.PurchaseContract;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PurchaseDao {
    
    //Save persistence method - Connection to Database
    public void Salvar (PurchaseContract pc){
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();    
        em.merge(pc);
        em.getTransaction().commit();
        em.close();
    }
    
    //Edit persistence method - Connection to Database
    public void Editar (PurchaseContract pc){
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin(); 
        em.createQuery("where Id = Id");
        em.merge(pc);
        em.getTransaction().commit();
        em.close();
    }
    
    //Delete persistence method - Connection to Database
    public void Delete(PurchaseContract pc){
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin(); 
        pc=em.merge(pc);
        em.remove(pc);
        em.getTransaction().commit();
        em.close();
    }
    
    //Method to list all contracts
    public List<PurchaseContract> Contracts(){
    EntityManager em = JPAUtil.getEntityManager();
    Query query = em.createQuery("from PurchaseContract");
    return query.getResultList();
    }
       
}
