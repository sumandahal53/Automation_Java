package Toolsqa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeForm {

    WebDriver wd = new ChromeDriver();

    JavascriptExecutor js = (JavascriptExecutor) wd;

    @Before
    public void setup(){

        System.setProperty("webdriver.chrome.driver" , "chromedriver");

        wd.get("https://www.toolsqa.com/automation-practice-form");
        wd.manage().window().maximize();

    }

    @Test
    public void testPage() throws InterruptedException {

        WebElement plt = wd.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/div/div[2]/div/form/fieldset/div[2]/a/strong"));
        String expectedPlt = "Partial Link Test"; //getAttribute
        Assert.assertEquals(expectedPlt,plt.getText());
        Assert.assertTrue(plt.isDisplayed());

        WebElement lt = wd.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/div/div[2]/div/form/fieldset/div[5]/a/strong"));
        String expectedLt = "Link Test";
        Assert.assertEquals(expectedLt,lt.getText());

        wd.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/div/div[2]/div/form/fieldset/div[8]/input")).sendKeys("Ram");

        js.executeScript("window.scrollBy(0,1000)");
        wd.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("Thapa");

        WebElement radio1 = wd.findElement(By.xpath("//*[@id=\"sex-1\"]"));
        radio1.click();

        WebElement radio2 = wd.findElement(By.xpath("//*[@id=\"exp-4\"]"));
        radio2.click();



    }
}
