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
import java.net.URL;


import java.net.MalformedURLException;


public class Testbase {


    public WebDriver driver;
    @Parameters({"x"})
    @BeforeMethod
    public void beforeTest(@Optional("0") String x)throws MalformedURLException{


    ChromeOptions options = new ChromeOptions();
    options.addArguments(x);

    driver = new RemoteWebDriver(new URL("http://192.168.56.1:4444/wd/hub"), options);
    driver.navigate().to("https://poczta.o2.pl/zaloguj");




    }





    @AfterMethod
    public void afterTest(){

        driver.close();
        driver.quit();


    }


}
