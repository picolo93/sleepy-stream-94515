/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import application.modele.InterfModeleLieu;
import application.modele.ModeleLieu;
//import application.modele.Modele;
import metier.Lieu;
import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 *
 * @author Michel
 */
@Configuration
public class SpringBootConfiguration implements WebMvcConfigurer {
    //WebMvcConfigurer est une interface destinée à gérer les locales
    //elle demande le développement de la méthode "addInterceptors"

    @Bean
    public LocaleResolver localeResolver() {
        //la locale est un objet encapsulant la langue en cours d'utilisation
        //ce bean permet de connaître la locale actuellement en cours d'utilisation
        //et de la positionner à une valeur par défaut
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.FRANCE);
        return sessionLocaleResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        //ce bean permet de détecter l'envoi d'un paramètre "lang"
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //on enregistre le bean ci-dessus dans la liste des "intercepteurs" à activer
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
//si pas proxy etc erreur d'initialisation car aucune session active lors de l'initialisation 
//le bean proxy est créé et fera l'interface avec le "vrai" bean session 
    public Lieu lieu() {
        return new Lieu();
    }

    @Bean  //singleton par défaut => pas de problème de session
    InterfModeleLieu mdc() {
        return new ModeleLieu();
        // return new ModeleClientList();
    }

}
