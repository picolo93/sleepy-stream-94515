package myconnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.PropertyResourceBundle;

import javax.sql.DataSource;

import org.postgresql.ds.PGSimpleDataSource;
//import org.postgresql.ds.PGPoolingDataSource;

public class MyDataSourceFactory {

    public static DataSource getPGQLDataSource() {
        Properties props = new Properties();
        FileInputStream fis = null;
        PGSimpleDataSource mysqlDS = null;
        PropertyResourceBundle properties
       = (PropertyResourceBundle) PropertyResourceBundle.getBundle("resources.application");
        //nom du fichier properties à utiliser
        mysqlDS = new PGSimpleDataSource();
        String serverName = properties.getString("cours.DB.server");
        String dbName = properties.getString("cours.DB.database");
        String login = properties.getString("cours.DB.login");
        String password = properties.getString("cours.DB.password");
        String dbPort = properties.getString("cours.DB.port");
        String url = "jdbc:postgresql://"+serverName + ":" + dbPort + "/" + dbName;
        mysqlDS.setURL(url);
        mysqlDS.setUser(login);
        mysqlDS.setPassword(password);
        return mysqlDS ;
}
}
