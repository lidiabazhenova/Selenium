import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {

    private static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\projects\\Selenium\\testselenium1\\drivers1\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        driver.manage().window().setSize(new Dimension(900, 700));

        driver.manage().window().maximize();

//        driver.get("http://localhost:8080/");
//        driver.navigate().to("http://google.com");
//        driver.navigate().refresh();
//        driver.navigate().back();
//        driver.navigate().forward();

//        System.out.println(driver.getTitle());
        //lecture 42
//        driver.get("https://en.wikipedia.org/wiki/Main_Page");
//
//        WebElement link = driver.findElement(By.linkText("Wikipedia store"));
//        WebElement link2 = driver.findElement(By.partialLinkText("Donate"));
//        WebElement metacontent = driver.findElement(By.name("ResourceLoaderDynamicStyles"));
//        WebElement cnotice = driver.findElement(By.className("cnotice"));
//        WebElement centralNotice = driver.findElement(By.id("centralNotice"));
//        WebElement script = driver.findElement(By.tagName("script"));
//        WebElement element = driver.findElement(By.cssSelector("div#p-views h3#p-views-label"));
//        WebElement xpathlement = driver.findElement(By.xpath("//div[@id='mw-panel']/div[@id='p-logo']"));

        //lecture 43
//        driver.findElement(By.xpath("//input[@id='searchButton']")).click();
//
//        driver.get("http://github.com");
//        WebElement button = driver.findElement(By.xpath("//form[@class='home-hero-signup js-signup-form']/button"));
//        System.out.println("button text is: " + button.getText());
//        if (button.getText().equals("Sign up for GitHub")) {
//            System.out.println("Success");
//        } else
//            System.out.println("False");
        // button.submit();
//        driver.get("http://github.com/github");
//        driver.findElement(By.xpath("//a[text()='Sign in']")).click();
//        driver.get("http://facebook.com");
//        driver.findElement(By.xpath("//label[@id=\"loginbutton\"]/input")).submit();

        //lecture 44
//        driver.get("https://en.wikipedia.org/wiki/Main_Page ");
//        driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("Selenium WebDriver");
//        driver.findElement(By.xpath("//input[@id='searchButton']")).click();
//        System.out.println(driver.findElement(By.xpath("//input[@id='searchInput']")).getAttribute("value"));
//        driver.findElement(By.xpath("//div[@id='searchText']/input")).clear();

//        driver.get("http://github.com");
//        driver.findElement(By.xpath(".//*[@id='user[login]']")).sendKeys("testusername");
//        driver.findElement(By.xpath(".//*[@id='user[password]']")).sendKeys("testpass");
//        WebElement button = driver.findElement(By.xpath(".//*[@id='user[password]']"));
//        button.submit();

//

        //lecture 45

//        driver.get("https://en.wikipedia.org/wiki/Main_Page ");
//        WebElement link = driver.findElement(By.xpath("//li[@id='n-aboutsite']/a"));
//        System.out.println("link: " + link.getText());
//        link.click();
//
//        driver.get("http://github.com");
//        driver.findElement(By.xpath("//nav//li[1]//a[1]")).click();
//
//        driver.get("https://www.facebook.com");
//        driver.findElement(By.xpath("//a[text()='Why do I need to provide my birthday?']")).click();

        //System.out.println(link.getText());
        //driver.quit();

        //lecture 46
//
//        driver.get("https://market.yandex.by");
//        driver.findElement(By.xpath("//a[text()=\"Бытовая техника\"]")).click();
//        driver.findElement(By.xpath("//a[text()=\"Стиральные машины\"]")).click();
//
//        selectCheckbox("BEKO");
//        deselectCheckbox("BEKO");
//        selectCheckbox("ATLANT");
//
//        selectRadiobutton("Самовывоз");
//        selectRadiobutton("С доставкой");
//
//    }
//
//    public static void selectCheckbox(String name) {
//        String cbxpath = "//label[text()='%s']/preceding-sibling::span";
//        if (!driver.findElement(By.xpath(String.format(cbxpath, name) + "/input")).isSelected()) {
//            driver.findElement(By.xpath(String.format(cbxpath, name))).click();
//        }
//        System.out.println(driver.findElement(By.xpath(String.format(cbxpath, name) + "/input")).isSelected());
//    }
//
//    public static void deselectCheckbox(String name) {
//        String cbxpath = "//label[text()='%s']/preceding-sibling::span";
//        if (driver.findElement(By.xpath(String.format(cbxpath, name) + "/input")).isSelected()) {
//            driver.findElement(By.xpath(String.format(cbxpath, name))).click();
//        }
//        System.out.println(driver.findElement(By.xpath(String.format(cbxpath, name) + "/input")).isSelected());
//    }
//
//    public static void selectRadiobutton(String name) {
//        String rbxpath = "//label[text()='%s']/span";
//        if (!driver.findElement(By.xpath(String.format(rbxpath, name) + "/input")).isSelected()) {
//            driver.findElement(By.xpath(String.format(rbxpath, name))).click();
//        }
//        System.out.println(driver.findElement(By.xpath(String.format(rbxpath, name) + "/input")).isSelected());

        //lecture 47
        driver.get("https://accounts.google.com/SignUp?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%3Fpc%3Dtopnav-about-en&lp=1&hl=ru");
        selectDropDown("Пол", "Мужской");
        selectDropDown("Пол", "Женский");

        selectDropDown("Страна", "Австралия (Australia)");
        selectDropDown("Страна", "Беларусь");

    }

    public static void selectDropDown(String option, String choice) {
        String optionXPath = String.format("(//strong[text()='%s']/following-sibling::div/div[@role='listbox'])[1]", option);
        String choiceXPath = String.format("//div[text()='%s']/parent::div[@role='option']", choice);

        driver.findElement(By.xpath(optionXPath)).click();
        driver.findElement(By.xpath(choiceXPath)).click();
    }

}
