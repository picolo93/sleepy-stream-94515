/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.modele;

import metier.Lieu;
import java.util.List;

/**
 *
 * @author Michel
 */
public interface InterfModeleLieu {

    List<Lieu> all();


    void close();

    void eff(Lieu cl) throws Exception;

    void modif(Lieu cl) throws Exception;

    void nouv(Lieu cl) throws Exception;

    Lieu rech(int nr) throws Exception;

}
