package FileSync.BL;

import FileSync.Dal.DaoFileObj;
import FileSync.Dal.FileObjStatus;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by Ady on 2/16/2015.
 */
public class FileObj {

    private static EntityManagerFactory factory;
    private static EntityManagerFactory getFactory(){
        if (factory==null){
            factory=Persistence.createEntityManagerFactory("main");
        }
        return factory;
    }

    private static EntityManager manager;
    private static EntityManager getManager(){
        if (manager==null){
            manager= getFactory().createEntityManager();
        }
        return manager;
    }

    public static DaoFileObj getByHash(String hash){

        EntityManager em = getManager();
        TypedQuery<DaoFileObj> q = em.createQuery("select file from DaoFileObj file where file.hash=:hash", DaoFileObj.class);
        q.setParameter("hash",hash);
        DaoFileObj d = q.getResultList().isEmpty() ? null : q.getSingleResult();
     //   em.close();
     //   factory.close();
        return d;
    }

    public static boolean addFile(DaoFileObj file){

        EntityManager em = getManager();
        em.getTransaction().begin();
        em.persist(file);
        em.getTransaction().commit();
     //  em.close();
      //  factory.close();
        return true;
    }

    public static List getChangedFiles(){
        EntityManager em = getManager();
        TypedQuery<DaoFileObj> q = em.createQuery("select file from DaoFileObj file where file.status!=:status", DaoFileObj.class);
        q.setParameter("status", FileObjStatus.Synced);
        List d = q.getResultList();
        //   em.close();
        //   factory.close();
        return d;
    }
    
}
