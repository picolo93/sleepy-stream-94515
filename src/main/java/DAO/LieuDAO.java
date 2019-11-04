package DAO;

import metier.Lieu;
import java.sql.*;
import java.util.*;

public class LieuDAO {

   /* @Override
    public Lieu create(Lieu obj) throws Exception {
        try (PreparedStatement pstm1 = dbConnect.prepareStatement("insert into LIEU (CODE_AERO,CODE_PORT,NOM,VILLE,PAYS)values(?,?,?,?,?)")) {
            pstm1.setString(3, obj.getNom());
            pstm1.setString(4, obj.getVille());
            pstm1.setString(5, obj.getPays());
            if (obj.getCh() == 1) {
                pstm1.setString(1, obj.getCode());
                pstm1.setString(2, null);
            } else {
                pstm1.setString(1, null);
                pstm1.setString(2, obj.getCode());
            }
            int n = pstm1.executeUpdate();

            if (n != 1) {
                throw new Exception("record non créé");
            }
            /*pstm2.setString(1, obj.getNom());
            pstm2.setString(2, obj.getVille());
            pstm2.setString(3, obj.getPays());
            ResultSet rs = pstm2.executeQuery();
            if (rs.next()) {
                System.out.println("ok4");
                String code_lieu = rs.getString("code_aero");
                if(code_lieu.equals("")){
                    System.out.println("ok5");
                     code_lieu = rs.getString("code_port");
                     return read(code_lieu);
                }else{
                    return read(code_lieu); 
                }         
            } else {
                System.out.println("ok6");
                throw new Exception("record introuvable");
            }*/
       /*     return null;
        } catch (Exception e) {
            throw new Exception("Erreur de création " + e.getMessage());
        }
    }*/

    //@Override
  /*  public Lieu read(int id) throws Exception {

        try (PreparedStatement pstm = dbConnect.prepareStatement("select * from LIEU where idlieu = ?")) {
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                String code_aero = rs.getString("code_aero");
                String code_port = rs.getString("code_port");
                String nom = rs.getString("nom");
                String ville = rs.getString("ville");
                String pays = rs.getString("pays");
                int id_lieu = rs.getInt("idlieu");
                return new Lieu(code_aero,code_port,nom, ville, pays);
                /* if (code_aero == null) {
                    return new Lieu(code_port, nom, ville, pays);
                } else {
                    return new Lieu(code_aero, nom, ville, pays);
                }*/
          /*  } else {
                throw new Exception("Code inconnu");
            }
        } catch (Exception e) {
            throw new Exception("Erreur de lecture " + e.getMessage());
        }
    }*/

  //  @Override
   /* public Lieu update(Lieu obj) throws Exception {

        try (PreparedStatement pstm1 = dbConnect.prepareStatement("update LIEU set nom=?,ville=?,pays=? where code_aero = ? or code_port = ?")) {

            pstm1.setString(1, obj.getNom());
            pstm1.setString(2, obj.getVille());
            pstm1.setString(3, obj.getPays());
            pstm1.setString(4, obj.getCode());
            pstm1.setString(5, obj.getCode());

            int n = pstm1.executeUpdate();
            if (n != 1) {
                throw new Exception("nombre de mises à jours incorrect :" + n);
            }
            return read(obj.getCode());
        } catch (Exception e) {
            throw new Exception("Erreur de mise à jour " + e.getMessage());
        }
    }*/

   // @Override
   /* public void delete(Lieu obj) throws Exception {
        try (PreparedStatement pstm = dbConnect.prepareStatement("delete from Lieu where code_aero = ? OR code_port = ?")) {
            pstm.setString(1, obj.getCode());
            pstm.setString(2, obj.getCode());
            int n = pstm.executeUpdate();
            if (n != 1) {
                throw new Exception("nombre d'effacements incorrect " + n);
            }
        } catch (Exception e) {
            throw new Exception("Erreur d'effacement " + e.getMessage());
        }
    }*/

   // @Override
   /* public List<Lieu> readall() throws Exception {
        List<Lieu> list = new ArrayList<>();
        try (PreparedStatement pstm = dbConnect.prepareStatement("select * from lieu")) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                //System.out.println(i+"Code : "+rs.getString("code_aero")+" nom : "+rs.getString("nom")+" ville : "+rs.getString("ville")+" pays : "+rs.getString("pays"));
                Lieu lieu = new Lieu(rs.getString("code_aero"), rs.getString("nom"), rs.getString("ville"), rs.getString("pays"));
                lieu.setId_lieu(rs.getInt("idlieu"));
                list.add(lieu);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    } */
}
