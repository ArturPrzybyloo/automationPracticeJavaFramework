package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import testCases.BaseClass;
import utilities.ReadConfig;


import java.util.List;


public class SearchPage {

    WebDriver ldriver;
    BaseClass bc = new BaseClass();
    ReadConfig readconfig = new ReadConfig();

    public SearchPage(WebDriver rdriver) {

        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);

    }

    String productNames = "//*[@class='product-name']";

    @FindBy(id = "search_query_top")
    @CacheLookup
    WebElement searchInput;

    @FindBy(xpath = "//*[@class='alert alert-warning']")
    @CacheLookup
    WebElement alertMessage;

    @FindBy(xpath = "//*[@class='icon-th-list']")
    @CacheLookup
    WebElement listView;

    @FindBy(xpath = "//a[@data-id-product='1']//span[contains(text(),'Add to cart')]")
    @CacheLookup
    WebElement addToCartBtn;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    @CacheLookup
    WebElement proceedToCheckoutButton;




    public boolean verifySearchResult () {
        readconfig.getSearch();
        String search = readconfig.getSearch();
        List<WebElement> list = ldriver.findElements(By.xpath(productNames));
        for(WebElement e : list) {
            if (e.getText().contains(search))
            {
                Assert.assertTrue(true);
                BaseClass.logger.info("Found searched word");
            }

        }
        return false;
    }

    public void verifyIncorectSearchResult ()
    {
        searchInput.sendKeys("xxxxxxxxx");
        searchInput.sendKeys(Keys.RETURN);

        if(alertMessage.isDisplayed())
        {
            Assert.assertTrue(true);
            bc.logger.info("'No results' - alert message is displayed");
        }
        else
        {
            Assert.assertTrue(false);
            bc.logger.info("'No alert' - displayed for wrong search result");
        }

    }

    public void clickListView ()
    {
        listView.click();
    }

    public void clickAddToCartBtn ()
    {
        addToCartBtn.click();

    }

    public void clickProceedButton ()
    {
        proceedToCheckoutButton.click();
    }


}
