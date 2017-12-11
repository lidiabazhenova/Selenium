import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainClass {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\student\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\student\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://signup.live.com");
        String mainTab = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text()='соглашения об использовании служб Майкрософт']")).click();

        for (String tab : driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }

        driver.findElement(By.xpath("(//span[text()='Часто задаваемые вопросы']/parent::a)[2]")).click();

        driver.switchTo().window(mainTab);

        driver.findElement(By.xpath(".//*[@id='LastName']")).sendKeys("test");






//        driver.quit();
    }
}
