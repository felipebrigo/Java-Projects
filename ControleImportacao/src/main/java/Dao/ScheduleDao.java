package Dao;

import Data.ScheduleData;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ScheduleDao {

    //Save persistence method - Connection to Database
    public void Salvar(ScheduleData cse) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(cse);
        em.getTransaction().commit();
        em.close();
    }

    //Edit persistence method - Connection to Database
    public void Editar(ScheduleData cse) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.createQuery("where Id = Id");
        em.merge(cse);
        em.getTransaction().commit();
        em.close();
    }

    //Delete persistence method - Connection to Database
    public void Delete(ScheduleData cse) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        cse = em.merge(cse);
        em.remove(cse);
        em.getTransaction().commit();
        em.close();
    }

    //Method to list all contracts
    public List<ScheduleData> Deliveries() {
        EntityManager em = JPAUtil.getEntityManager();
        Query query = em.createQuery("from ScheduleData");
        return query.getResultList();
    }

        /*
        METHOD TO CREATE QUERY AND UPDATE ONLY ONE COLUMN WHERE ID = ID
        Query query = em.createQuery("update ScheduleData set idSchedule = :idSchedule where id = :positionId");
        query.setParameter("idSchedule", idSchedule);
        query.setParameter("positionId", positionId);
        int result = query.executeUpdate();
        */

}
