/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import DAO.LieuDAO;
import metier.Lieu;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/lieu")
public class LieuCtrl {
    
    @Autowired
    private DataSource dataSource;

    @Autowired
    private LieuDAO ldao;
    
    @Autowired
    private Lieu lieu;
    
     @Autowired
    private List<Lieu> listeLieu;

    

    @RequestMapping("/")
    String index() {
        return "lieu/gestlieu";
    }

   
    @RequestMapping("/nouvlieu")
    String nouvcli( Map<String, Object> model) {
        model.put("mode","nouvlieu");
        return "lieu/gestlieu";
    }
    
   /*   @RequestMapping("/addcli")
    String ajout(
            @RequestParam("nom") String nom,
            @RequestParam("prenom") String prenom, 
            @RequestParam("cp") String cps,
            @RequestParam("loc") String loc,
            @RequestParam("rue") String rue,
            @RequestParam("num") String num,
            @RequestParam("tel") String tel,
            Map<String, Object> model) {
        int cp;
        try{
            cp=Integer.parseInt(cps);
        
        Client cl = new Client(0,nom,prenom,cp,loc,rue,num,tel);
        cl=cldao.create(cl); //objet session
        model.put("mode","affnouvcli");
         model.put("monClient", cl);
        }
        catch(Exception e){
             model.put("erreur",e.getMessage());
           model.put("mode","erreur");
        }
        return "client/gestclient";
    }
    
    
     @RequestMapping("/rechcli")
    String rech(Map<String, Object> model) {
        model.put("mode","rechcli");
        return "client/gestclient";
    }
    
     @RequestMapping("/recherche")
    String recherche(@RequestParam("nrech") String nom, Map<String, Object> model) {

      
        ArrayList<Client> liste;
        try {
            liste = cldao.rechNom(nom);
            listeClients.clear();
            listeClients.addAll(liste);
            model.put("mesClients", liste);
             model.put("mode","clistrouves");
              model.put("mode2","affichage");
        } catch (Exception e) {
            model.put("erreur",e.getMessage());
           model.put("mode","erreur");
        }
        return "client/gestclient";
    }

    @RequestMapping("/selection")
    String selection(@RequestParam("numcli") int numcli, Map<String, Object> model) {

        Client cl = null;
       
        try {

            cl = cldao.read(numcli);
            model.put("monClient", cl);
            model.put("mesClients",listeClients);
            client.setIdclient(cl.getIdclient());
            client.setNom(cl.getNom());
            client.setPrenom(cl.getPrenom());
            client.setCp(cl.getCp());
            client.setLocalite(cl.getLocalite());
            client.setRue(cl.getRue());
            client.setNum(cl.getNum());
            client.setTel(cl.getTel());
            model.put("mode","clistrouves");
            model.put("mode2","edition");
            
        } catch (Exception e) {
            
           model.put("erreur",e.getMessage());
           model.put("mode","erreur");
        }
        return "client/gestclient";
    }

    @RequestMapping("/changement")
    String changement(@RequestParam("tel") String tel, Map<String, Object> model) {
      
        client.setTel(tel);
        model.put("monClient", client);
        try {
            cldao.update(client);
            ArrayList<Client> liste;
            liste = cldao.rechNom(client.getNom());
            listeClients.clear();
            listeClients.addAll(liste);
            model.put("mesClients", liste);
            model.put("mode","clistrouves");
            model.put("mode2","affichage");
           
            
        } catch (Exception e) {
            model.put("erreur",e.getMessage());
           model.put("mode","erreur");
        }

        return "client/gestclient";
    }

  
    
      @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS )
    public List<Client> listeClients() {
        return new ArrayList<Client>();
    }
     
    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS )
    public Client client() {
        return new Client();
    }
    
    @Bean
   @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS )
    public ClientDAO cldao() throws Exception{
        ClientDAO cldao = new ClientDAO();
        cldao.setConnection(dataSource.getConnection());
        return cldao;
    }*/

 
    }
    
    
    
 


