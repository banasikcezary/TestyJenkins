package page.objects;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.Logger;



import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


public class LoginPage {


    Logger logger = LogManager.getRootLogger();

    @FindBy(id = "login")
     private WebElement login;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement button;

    @FindBy(className = "sc-dUjcNx")
    private WebElement send;

    @FindBy(css = ".sc-gJWqzi")
    private WebElement email;

    @FindBy(className = "sc-kAzzGY")
    private WebElement subject;

    @FindBy(css = "div[class=DraftEditor-editorContainer]")
    private WebElement description;

    @FindBy(className = "sc-kLIISr")
    private WebElement go;

    @FindBy (xpath = "//*[text()='Bluesoft']")
    private WebElement check;







    private WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }



    public void sendLogin() {
        login.sendKeys("testyasercji123");
        logger.info("Wpisano login");
    }

    public void sendPassword() {
        password.sendKeys("123456abC");
        logger.info("Wpisano hasło");
    }

    public void clickOnLogInSubmit() { button.click();
        logger.info("Zalogowano");}

    public void clickOnButtonCreateNewEmail(){ //send.click();

       Actions actions = new Actions(driver);
      actions.moveToElement(send).click().build().perform();
        logger.info("Wybrano opcję wyślij email");}

    public void sendAddresseeEmail(){// email.sendKeys("testyasercji123@o2.pl");
        Actions actions = new Actions(driver);
        actions.moveToElement(email).click(email).sendKeys("testyasercji123@o2.pl").build().perform();
        logger.info("Wpisano adresata");}

    public void sendMessageSubject(){ subject.sendKeys("Bluesoft");
        logger.info("Wpisano temat wiadomości");}

    public void sendMessageContent(){ description.sendKeys("tralalala");
        logger.info("Wpisano treść wiadomości");}

    public void clickOnSendEmailButton(){ //go.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(go).click().build().perform();
        logger.info("Wysłano emaila");}

    public void checkEmailOnPage(){ assertEquals(check.getText(), "Bluesoft");
        logger.info("Sprawdzono wysłanie maila");
    }










}

