
import io.github.bonigarcia.wdm.WebDriverManager;


import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Ornek2 {


//1-) "https://demoqa.com/" adresine git
//2-) Elements basligina tikla
//3-) Elements altinda Links sekmesine tikla
//4-) sayfada bulunan "Bad Request" linkine tikla
//5-) sayfada "Link has responded with staus 400 and status text Bad Request" yazisi gozukuyor mu dogrula
    static WebDriver driver;
    @BeforeClass
    public static void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
    }
    @Test
    public void ornek2(){

        driver.get("https://demoqa.com/");
        WebElement elementButton = driver.findElement(By.xpath("(//*[@stroke='currentColor'])[1]"));
        elementButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        WebElement linksButton = driver.findElement(By.xpath("(//*[@id=\"item-5\"]/span)[1]"));
        linksButton.click();

    }

    // ishak'dan selamlar

}
