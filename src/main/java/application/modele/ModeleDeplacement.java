/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modele;

import metier.Deplacement;
import com.example.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Michel
 */
public class ModeleDeplacement implements InterfModeleDeplacement {
    Session s;
    public ModeleDeplacement(){
          s = GestSession.getSession();
    }
    
    @Override
    public void nouv(Deplacement cf) throws Exception {
        Transaction t = null;
        try {
            t = s.beginTransaction();
            s.save(cf);
            t.commit();
        } catch (Exception e) {
            if(t!=null) t.rollback();
             s.clear();
            throw new Exception("erreur de création :"+e.getMessage());
        }
    }

    @Override
    public Deplacement rech(int nr) throws Exception {
        try{
        Deplacement cf = null;
        Query q = s.createQuery("from Deplacement where idDep = :numrech");
        q.setInteger("numrech", nr);
        cf = (Deplacement) q.uniqueResult();
        return cf;
        }
        catch (Exception e){
             s.clear();
             throw new Exception("recherche infructueuse : "+e.getMessage());
        }
    }

    @Override
   public void modif(Deplacement cf) throws Exception{
        Transaction t = null;
        try {
            t = s.beginTransaction();
            s.save(cf);
            t.commit();
        } catch (Exception e) {
            if(t!=null)t.rollback();
             s.clear();
            throw new Exception("erreur de mise à jour : "+e.getMessage());
        }
    }

    @Override
    public void eff(Deplacement cl) throws Exception{
        Transaction t = null;
        try {
            t = s.beginTransaction();
            s.delete(cl);
            t.commit();
        } catch (Exception e) {
            if(t!=null)   t.rollback();
             s.clear();
            throw new Exception("erreur d'effacement : "+e.getMessage());
        }
    }

    @Override
    public List<Deplacement> all() {
        Query q = s.createQuery("from Deplacement");
        List<Deplacement> liste = (List<Deplacement>) q.list();
        return liste;
     }
    
    @Override
    public void close(){
       GestSession.close();
    }
    

}
