package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testCases.BaseClass;

import java.util.List;

public class SearchPage {

    WebDriver ldriver;
    BaseClass bc = new BaseClass();

    public SearchPage(WebDriver rdriver) {

        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);

    }

    String productNames = "//*[@class='product-name']";




    public void verifySearchResult ()
    {
        java.util.List<WebElement> products = ldriver.findElements(By.xpath(productNames));

        for (WebElement product:products){
            System.out.println(product.getText());
        }

    }

}
