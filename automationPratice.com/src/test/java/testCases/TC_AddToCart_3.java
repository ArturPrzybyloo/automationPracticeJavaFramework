package testCases;

import org.testng.annotations.Test;
import pageObjects.MainPage;

import java.io.IOException;

public class TC_AddToCart_3 extends BaseClass {


    @Test
    public void addToCartTest () throws IOException
    {

        MainPage mp = new MainPage(driver);
        TC_LoginTest_1 login = new TC_LoginTest_1();
        login.loginTest();
        mp.clickHomeButton();
        logger.info("Clicked Home button");
        //mp.clickProductImage();
        mp.clickAddtoCartButton();




    }



}
