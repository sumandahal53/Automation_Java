package table;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ListOfNames {

    WebDriver wd = new ChromeDriver();

    @Before
    public void setup(){

        System.setProperty("webdriver.chrome.driver" , "chromedriver");

        wd.get("https://www.w3schools.com/sql/sql_count_avg_sum.asp");
        wd.manage().window().maximize();

    }

    @Test
    public void showProductNames() throws InterruptedException {
        List<WebElement> rows = wd.findElements(By.xpath("//*[@id=\"main\"]/div[6]/table/tbody/tr/td[2]"));
        for (int i = 0; i< rows.size(); i++){
            String listOfNames = rows.get(i).getText();
            System.out.println(listOfNames);
        }
    }

    @After
    public void exit() {
        wd.quit();
        }

}
