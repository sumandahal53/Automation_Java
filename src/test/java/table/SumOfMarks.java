package table;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SumOfMarks {

    WebDriver wd = new ChromeDriver();

    @Before
    public void setup() throws InterruptedException{



        System.setProperty("webdriver.chrome.driver", "chromedriver");


        wd.get("https://www.w3schools.com/sql/sql_count_avg_sum.asp");
        wd.manage().window().maximize();

        //wd.findElement(By.xpath("//*[@data-id='dashboard']")).click();

       // List<WebElement> element= wd.findElements(By.tagName("tr"));

       /* int integerValue;
        int sumValue=0;
        for(int i=1;i<=element.size()-1;i++)
        {
            //Here enter your Xpath value for the table.
            WebElement todaysValue= wd.findElement(By.xpath("//*[@id=\"main\"]/div[6]/table/tbody/tr[\"+i+\"]/td[6]"));
            String tableValue=todaysValue.getText();
            integerValue=Integer.parseInt(tableValue);
            sumValue=sumValue+integerValue;
        }
        System.out.println("Total Sum : "+sumValue);
*/



    }

    @Test
    public void sumTable(){
        double sum = 0.00;
        double expectedSum = 91.35;
        List<WebElement> rows = wd.findElements(By.xpath("//*[@id=\"main\"]/div[6]/table/tbody/tr/td[6]"));

        for (WebElement row : rows){
            double no = Double.parseDouble(row.getText());
            sum = sum + no;
        }

        Assert.assertEquals(sum,expectedSum,2); //delta is 2 decimal place value


    }

    @After
    public void exit(){
        wd.quit();

    }


}
