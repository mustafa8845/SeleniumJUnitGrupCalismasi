import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ornek1 {
//1-) "https://demoqa.com/" adresine git
//2-) Book Store Aplication basligina tikla
//3-) Sayfada ki arama kutusuna "JavaScript" yaz
//4-) sonuclari arat
//5-) ikinci siradaki urune tikla
//6-) sayfada Back To Book Store butonun aktif oldugunu dogrula

  @Test
    public void test1(){

      WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();

      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

      driver.get("https://demoqa.com/");
      driver.quit();
      driver.close();

      driver.navigate().to("http://amazon.com");
      driver.navigate().back();
      driver.navigate().forward();
      driver.navigate().refresh();

      //Locator id,name,className,tagName,linkText,partialLinkText, xpath, cssSelector

    //       xpath:   //tagName[@attribute='value']
    //                 (//tagName[@attribute='value'])[2]

    //  A.sendKeys("")
    //  A.getText();
    //  A.click
    //  A.submit
    // Keys.ENTER

  }
  @Test
  public void test2(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

    driver.get("https://demoqa.com/");
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {

    }

    WebElement bookStoreApp = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[6]"));
   // bookStoreApp.sendKeys(Keys.PAGE_DOWN);
    bookStoreApp.click();

    WebElement searchBox = driver.findElement(By.xpath("//input[@autocomplete='off']"));
    searchBox.sendKeys("JavaScript");
    //searchBox.submit();

    WebElement ikinciUrun = driver.findElement(By.linkText("Speaking JavaScript"));
   // ikinciUrun.click();

//    WebElement button = driver.findElement(By.id("addNewRecordButton"));
//    boolean aktifMi = button.isEnabled();
//    System.out.println(aktifMi);

    List<WebElement> tumLinker = driver.findElements(By.tagName("a"));
    for (WebElement w : tumLinker){

      System.out.println(w.getText());
    }






  }



}
