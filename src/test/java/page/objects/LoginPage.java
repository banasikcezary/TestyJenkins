package page.objects;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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


    @Step("sendLogin")
    public void sendLogin() {
        login.sendKeys("testyasercji123");
        logger.info("Wpisano login");
    }
    @Step("sendPassword")
    public void sendPassword() {
        password.sendKeys("123456abC");
        logger.info("Wpisano hasło");
    }
    @Step("clickOnLogInSubmit")
    public void clickOnLogInSubmit() { button.click();
        logger.info("Zalogowano");}
    @Step("clickOnButtonCreateNewEmail")
    public void clickOnButtonCreateNewEmail(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 100);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sc-dUjcNx")));

        Actions actions = new Actions(driver);
        actions.moveToElement(send).click().build().perform();

        logger.info("Wybrano opcję wyślij email");}


    @Step("sendAddresseeEmail")
public void sendAddresseeEmail(){
       WebDriverWait webDriverWait = new WebDriverWait(driver, 100);
      webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sc-gJWqzi")));
   Actions actions = new Actions(driver);
   actions.moveToElement(email).perform();
    email.sendKeys("testyasercji123@o2.pl");
        logger.info("Wpisano adresata");
    }



    @Step("sendMessageSubject")
    public void sendMessageSubject(){

        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sc-kAzzGY")));

        subject.sendKeys("Bluesoft");
        logger.info("Wpisano temat wiadomości");}
    @Step("sendMessageContent")
    public void sendMessageContent(){ description.sendKeys("tralalala");
        logger.info("Wpisano treść wiadomości");}
    @Step("clickOnSendEmailButton")
    public void clickOnSendEmailButton(){ //go.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(go).perform();
        go.click();
        logger.info("Wysłano emaila");}
    @Step("checkEmailOnPage")
    public void checkEmailOnPage(){


        WebDriverWait webDriverWait = new WebDriverWait(driver, 100);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Bluesoft']")));

        assertEquals(check.getText(), "Bluesoft");
        logger.info("Sprawdzono wysłanie maila");
    }


}

