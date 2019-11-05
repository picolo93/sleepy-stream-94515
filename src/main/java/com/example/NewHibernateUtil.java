/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.Properties;
import org.hibernate.cfg.*;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Rachile
 */
public class NewHibernateUtil {

  private static final SessionFactory sessionFactory;
    static {
        try {
            String url = System.getenv().get("JDBC_DATABASE_URL");
            String username = System.getenv("JDBC_DATABASE_USERNAME");
            String password = System.getenv("JDBC_DATABASE_PASSWORD");
            Properties prop = new Properties();
            //provide the required properties
            prop.setProperty("hibernate.connection.url", url);
            prop.setProperty("hibernate.connection.username", username);
            prop.setProperty("hibernate.connection.password", password);
            prop.setProperty("dialect", "org.hibernate.dialect.PostgreSQLDialect");
            prop.setProperty("hibernate.query.factory_class", "org.hibernate.hql.internal.ast.ASTQueryTranslatorFactory");
            prop.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
            //create a configuration
            org.hibernate.cfg.Configuration config = new org.hibernate.cfg.Configuration();
            //provide all properties to this configuration
            config.setProperties(prop);
            //add classes which are mapped to database tables.
            config.addResource("com/mycompany/marven_project_tour_operator/Deplacement.hbm.xml");
            config.addResource("com/mycompany/marven_project_tour_operator/Infos.hbm.xml");
            config.addResource("com/mycompany/marven_project_tour_operator/Lieu.hbm.xml");
            config.addResource("com/mycompany/marven_project_tour_operator/Voyage.hbm.xml");
            sessionFactory = config.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
