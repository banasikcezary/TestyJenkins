package tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Testbase {


    public WebDriver driver;
@Parameters({"x"})
    @BeforeMethod
    public void beforeTest(@Optional("0") String x){

       // public void beforeTest()throws MalformedURLException{
           // DesiredCapabilities capability = DesiredCapabilities.chrome();
           // driver = new RemoteWebDriver(new URL("http://192.168.115.7:4444/wd/hub"), capability);
       //driver = new RemoteWebDriver(new URL("http://127.0.0.1:13000/wd/hub"), capability);




        System.setProperty("webdriver.chrome.driver", "C:/DRIVERS/chromedriver.exe" );
ChromeOptions options = new ChromeOptions();
options.addArguments(x);
    options.addArguments("window-size=1382,744");



        driver = new ChromeDriver(options);



        driver.navigate().to("https://poczta.o2.pl/zaloguj");




        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
    }





    @AfterMethod
    public void afterTest(){

        driver.close();
        driver.quit();


    }


}
