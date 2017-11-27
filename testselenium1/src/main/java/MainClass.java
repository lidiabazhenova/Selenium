import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\projects\\Selenium\\testselenium1\\drivers1\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(900, 700));

//        driver.get("http://localhost:8080/");
//        driver.navigate().to("http://google.com");
//        driver.navigate().refresh();
//        driver.navigate().back();
//        driver.navigate().forward();

//        System.out.println(driver.getTitle());

        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        WebElement link = driver.findElement(By.linkText("Wikipedia store"));
        WebElement link2 = driver.findElement(By.partialLinkText("Donate"));
        WebElement metacontent = driver.findElement(By.name("ResourceLoaderDynamicStyles"));
        WebElement cnotice = driver.findElement(By.className("cnotice"));
        WebElement centralNotice = driver.findElement(By.id("centralNotice"));
        WebElement script = driver.findElement(By.tagName("script"));
        WebElement element = driver.findElement(By.cssSelector("div#p-views h3#p-views-label"));
        WebElement xpathlement = driver.findElement(By.xpath("//div[@id='mw-panel']/div[@id='p-logo']"));

        //System.out.println(link.getText());
        //System.out.println(link2.getText());
        // System.out.println(metacontent.getText());
        // System.out.println(cnotice.getText());

         driver.quit();


    }
}
