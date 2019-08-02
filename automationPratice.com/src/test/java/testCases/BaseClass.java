package testCases;


import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utilities.ReadConfig;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    ReadConfig readconfig = new ReadConfig();


    public String baseURL = readconfig.getApplicationURL();
    public String userID = readconfig.getUsername();
    public String password = readconfig.getPassword();
    public String firstName = readconfig.getFirstName();
    public String lastName = readconfig.getLastName();
    public String message = readconfig.getMessage();

    public static WebDriver driver;
    public static Logger logger;


    @Parameters("browser")
    @BeforeClass
    public void setUp (String br)
    {

        logger = Logger.getLogger("automationPratice");
        PropertyConfigurator.configure("Log4j.properties");



        if(br.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", readconfig.getChromeDriver());
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(baseURL);
        }
        else if(br.equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxDriver());
            driver = new FirefoxDriver();
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(baseURL);
        }
        else if(br.equals("ie"))
        {
            System.setProperty("webdriver.ie.driver", readconfig.getIEDriver());
            driver = new InternetExplorerDriver();
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(baseURL);
        }




    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }



}
