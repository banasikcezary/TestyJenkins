package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
            //throws MalformedURLException
           // DesiredCapabilities capability = DesiredCapabilities.chrome();
            //driver = new RemoteWebDriver(new URL("http://192.168.56.1:4444/wd/hub"), capability);


        System.setProperty("webdriver.chrome.driver", "C:/DRIVERS/chromedriver.exe" );
        driver = new ChromeDriver();
        driver.navigate().to("https://poczta.o2.pl/zaloguj");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }





    @AfterMethod
    public void afterTest(){

        driver.close();
        driver.quit();


    }


}
