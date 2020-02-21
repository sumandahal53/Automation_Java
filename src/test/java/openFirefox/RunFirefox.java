package openFirefox;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class RunFirefox {

    @Test
    public void openFirefoxBrowser() throws InterruptedException {

        //Set chrome Browser Driver
        System.setProperty("webdriver.gecko.driver", "geckodriver");

        //Create ChromeDriver instance
        WebDriver wd = new FirefoxDriver();

        //open Driver
        wd.get("http://www.gmail.com");

        //maximize browser
        wd.manage().window().maximize();

        //wait for 5 sec
        Thread.sleep(5000);

        //close browser
        wd.quit();


    }

}




