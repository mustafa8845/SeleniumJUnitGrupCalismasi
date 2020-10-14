import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ornek3 {

    static WebDriver driver;

    @BeforeClass
    public static void satup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
    }
    @Test
    public void dropdown(){

        driver.get("https://amazon.com/");
        //WebElement forms = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]"));
        //forms.click();
       // WebElement form = driver.findElement(By.xpath("(//li[@id='item-0'])[3]"));
       // form.click();
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));
        Select select = new Select(dropdown);
    // select.selectByVisibleText("Books");
       // select.selectByIndex(0);
        select.selectByValue("search-alias=stripbooks-intl-ship");

        List<WebElement> tumBaslilar = select.getOptions();
        for(WebElement w : tumBaslilar){

            System.out.println(w.getText());}

// Ana sayfa da  "Amazon's response to COVID-19"  ifadesinin oldugunu dogrulayalim
            WebElement ifade = driver.findElement(By.xpath("//*[@id=\"nav-swmslot\"]/a"));
            System.out.println(ifade.getText());
            boolean varMi = ifade.isDisplayed();
            Assert.assertFalse(varMi);
      //  Assert.assertEquals("Amazon's response to COVID-19",ifade.getText());



        }
    }







