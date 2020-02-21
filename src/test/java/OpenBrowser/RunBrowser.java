package OpenBrowser;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import sun.plugin.dom.html.HTMLBodyElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.sql.Driver;

public class RunBrowser {

    WebDriver wd = new ChromeDriver();

    @Test
    public void openChromeBrowser() throws InterruptedException {

      System.setProperty("webdriver.chrome.driver", "chromedriver");


      wd.get("https://www.gmail.com");
      wd.manage().window().maximize();

      WebElement emailElement = wd.findElement(By.name("identifier"));
      emailElement.sendKeys("qatesting00567@gmail.com");

      WebElement nextButtonElement = wd.findElement(By.xpath("//*[@id='identifierNext']"));
      nextButtonElement.click();
      Thread.sleep(5000);

      WebElement txtPwd = wd.findElement(By.name("password"));
      txtPwd.sendKeys("Test@123");

      WebElement btnNext = wd.findElement(By.id("passwordNext"));
      btnNext.click();
      Thread.sleep(5000);
      wd.quit();

    }

    @Test
    public void validUserInvalidPassword() throws InterruptedException {

        //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        wd.get("http://www.gmail.com");
        wd.manage().window().maximize();
        wd.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("qatesting00567@gmail.com");
        wd.findElement(By.xpath("//div[@id='identifierNext']")).click();
        Thread.sleep(5000);
        WebElement txtpwd = wd.findElement(By.name("password"));
        txtpwd.sendKeys("aaaaa123");
        wd.findElement(By.xpath("//*[@id=\"passwordNext\"]")).click();
        Thread.sleep(5000);

        WebElement text = wd.findElement((By.xpath("//*[text()='Wrong password. Try again or click forget password to reset it.']")));
        String expectedString = "Wrong password. Try again or click forget password to reset it";

        Assert.assertEquals(expectedString,text.getText());

        wd.quit();
    }


}
