package util;


import java.util.Properties;

public class DBPropertyUtil {
	
	public static String getPropertyString() {
		
        Properties properties = new Properties();
        properties.setProperty("db.url", "jdbc:mysql://localhost:3306/cars");
        properties.setProperty("db.user", "root");
        properties.setProperty("db.password", "1234");
        String url = properties.getProperty("db.url", "");
        String user = properties.getProperty("db.user", "");
        String password = properties.getProperty("db.password", "");
        return url +"?useSSL=false&user=" + user + "&password=" + password;
    }

}