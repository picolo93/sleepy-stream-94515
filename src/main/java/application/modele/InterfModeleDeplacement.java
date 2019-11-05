/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modele;
import metier.Deplacement;
import java.util.List;

/**
 *
 * @author Michel
 */
public interface InterfModeleDeplacement {

    List<Deplacement> all();

    void close();

    void eff(Deplacement cf) throws Exception;

    void modif(Deplacement cf) throws Exception;

    void nouv(Deplacement cf) throws Exception;

    Deplacement rech(int nr) throws Exception;
    
}
