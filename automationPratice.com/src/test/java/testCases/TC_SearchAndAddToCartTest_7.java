package testCases;

import org.testng.annotations.Test;
import pageObjects.MainPage;
import pageObjects.SearchPage;

import java.io.IOException;

public class TC_SearchAndAddToCartTest_7 extends BaseClass {

@Test
    public void SearchAndAddToCart () throws IOException
{
    MainPage mp = new MainPage(driver);
    SearchPage sp = new SearchPage(driver);
    TC_LoginTest_1 login = new TC_LoginTest_1();

    login.loginTest();
    mp.enterSearchText(search);
    logger.info("Entered searching word");
    sp.clickListView();
    logger.info("Clicked list view");
    sp.clickAddToCartBtn();
    logger.info("Clicked add to cart button");
    sp.clickProceedButton();
    logger.info("Clicked proceed to checkout button");




}


}
