package metier;


// Generated 25-sept.-2019 16:10:06 by Hibernate Tools 4.3.1

import metier.Voyage;
import metier.Deplacement;




/**
 * Infos generated by hbm2java
 */
public class Infos  implements java.io.Serializable {


     private int idInfo;
     private Deplacement deplacement;
     private Voyage voyage;
     private Integer numeroOrdre;

    public Infos() {
    }

	
    public Infos(int idInfo, Deplacement deplacement, Voyage voyage) {
        this.idInfo = idInfo;
        this.deplacement = deplacement;
        this.voyage = voyage;
    }
    public Infos(int idInfo, Deplacement deplacement, Voyage voyage, Integer numeroOrdre) {
       this.idInfo = idInfo;
       this.deplacement = deplacement;
       this.voyage = voyage;
       this.numeroOrdre = numeroOrdre;
    }
   
    public int getIdInfo() {
        return this.idInfo;
    }
    
    public void setIdInfo(int idInfo) {
        this.idInfo = idInfo;
    }
    public Deplacement getDeplacement() {
        return this.deplacement;
    }
    
    public void setDeplacement(Deplacement deplacement) {
        this.deplacement = deplacement;
    }
    public Voyage getVoyage() {
        return this.voyage;
    }
    
    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;
    }
    public Integer getNumeroOrdre() {
        return this.numeroOrdre;
    }
    
    public void setNumeroOrdre(Integer numeroOrdre) {
        this.numeroOrdre = numeroOrdre;
    }




}


