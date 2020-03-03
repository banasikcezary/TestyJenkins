package tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Testbase {


    public WebDriver driver;

    @BeforeMethod
    public void beforeTest(){

       // public void beforeTest()throws MalformedURLException{
           // DesiredCapabilities capability = DesiredCapabilities.chrome();
           // driver = new RemoteWebDriver(new URL("http://192.168.115.7:4444/wd/hub"), capability);
       //driver = new RemoteWebDriver(new URL("http://127.0.0.1:13000/wd/hub"), capability);





        System.setProperty("webdriver.chrome.driver", "C:/DRIVERS/chromedriver.exe" );
        driver = new ChromeDriver();
        driver.navigate().to("https://poczta.o2.pl/zaloguj");


        Dimension d = new Dimension(1600,900);
        driver.manage().window().setSize(d);


        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }





    @AfterMethod
    public void afterTest(){

        driver.close();
        driver.quit();


    }


}
