/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modele;

import metier.Lieu;
import com.example.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Michel
 */
public class ModeleLieu implements InterfModeleLieu {

    Session s;

    public ModeleLieu() {
        s = GestSession.getSession();
    }

    @Override
    public void nouv(Lieu cl) throws Exception {
        Transaction t = null;
        try {
            t = s.beginTransaction();
            s.save(cl);
            t.commit();
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
            s.clear();
            throw new Exception("erreur de création :" + e.getMessage());
        }
    }

    @Override
    public Lieu rech(int nr) throws Exception {
        try {
            Lieu cl = null;
            Query q = s.createQuery("from Lieu where idlieu= :numrech");
            q.setInteger("numrech", nr);
            cl = (Lieu) q.uniqueResult();
            return cl;
        } catch (Exception e) {
            s.clear();
            throw new Exception("recherche infructueuse : " + e.getMessage());
        }

    }

    @Override
    public void modif(Lieu cl) throws Exception {
        Transaction t = null;
        try {
            t = s.beginTransaction();
            s.save(cl);
            t.commit();
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
            s.clear();
            throw new Exception("erreur de mise à jour : " + e.getMessage());
        }
    }

    @Override
    public void eff(Lieu cl) throws Exception {
        Transaction t = null;
        try {
            t = s.beginTransaction();
            s.delete(cl);
            t.commit();
        } catch (Exception e) {
            if (t != null) {
                t.rollback();
            }
            s.clear();
            throw new Exception("erreur d'effacement : " + e.getMessage());
        }
    }

    @Override
    public List<Lieu> all() {
        Query q = s.createQuery("from Lieu");
        List<Lieu> liste = (List<Lieu>) q.list();
        return liste;
    }
   
    @Override
    public void close() {
        GestSession.close();
    } 
}
