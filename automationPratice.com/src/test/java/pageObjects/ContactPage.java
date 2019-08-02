package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import testCases.BaseClass;

import java.io.File;

public class ContactPage {

    WebDriver ldriver;
    BaseClass bc = new BaseClass();

    public ContactPage (WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(id = "id_contact")
    @CacheLookup
    WebElement subjectDropdown;

    @FindBy(xpath = "//*[@name='id_order']")
    @CacheLookup
    WebElement referenceDropdown;

    @FindBy(id = "fileUpload")
    @CacheLookup
    WebElement fileUpload;

    @FindBy(id = "submitMessage")
    @CacheLookup
    WebElement sendButton;

    @FindBy(id = "message")
    @CacheLookup
    WebElement messageInput;

    @FindBy(xpath = "//*[@class='alert alert-success']")
    @CacheLookup
    WebElement sucessMessage;


    public void chooseSubject ()
    {
        Select monthOfBirth = new Select(subjectDropdown);
        monthOfBirth.selectByValue("1");
    }

    public void attachFile ()
    {
        File file = new File("./Configuration/test.txt");
        fileUpload.sendKeys(file.getAbsolutePath());
    }

    public void enterMessage (String message)
    {
        messageInput.sendKeys(message);
    }

    public void clickSend ()
    {
        sendButton.click();
    }

    public void verifySucessMessage()
    {

        String text = sucessMessage.getText();
        if(text.contains("Your message has been successfully sent to our team."))
        {
            Assert.assertTrue(true);
            bc.logger.info("Sucess screen appears");
        }
        else
        {
            Assert.assertTrue(false);
            bc.logger.info("Test Failed");
        }
    }



}
