package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties pro;

    public ReadConfig()
    {
        File src = new File("./Configuration/config.properties.txt");

        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e){
            System.out.println("Exception is " + e.getMessage());
        }
    }

    public  String getApplicationURL ()
    {
        String url = pro.getProperty("baseURL");
        return url;
    }

    public String getUsername ()
    {
        String username = pro.getProperty("userID");
        return username;
    }

    public String getPassword ()
    {
        String password = pro.getProperty("password");
        return password;
    }

    public String getFirstName ()
    {
        String firstName = pro.getProperty("firstName");
        return firstName;
    }

    public String getLastName ()
    {
        String lastName = pro.getProperty("lastName");
        return lastName;
    }

    public String getChromeDriver ()
    {
        String chrome = pro.getProperty("chrome");
        return chrome;
    }

    public String getFirefoxDriver ()
    {
        String firefox = pro.getProperty("firefox");
        return firefox;
    }

    public String getIEDriver ()
    {
        String IE = pro.getProperty("ie");
        return IE;
    }

}
