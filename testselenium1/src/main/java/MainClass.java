import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainClass {

    private static WebDriver driver;

    public static void main(String[] args) {
      //  System.setProperty("webdriver.gecko.driver", "C:\\projects\\Selenium\\testselenium1\\drivers\\geckodriver.exe");
      //  System.setProperty("phantomjs.binary.path", "C:\\projects\\Selenium\\testselenium1\\drivers\\phantomjs.exe");

        driver = new FirefoxDriver();
       // driver = new PhantomJSDriver();

        driver.manage().timeouts().implicitlyWait(17, TimeUnit.SECONDS);
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
//        driver.get("https://accounts.google.com/SignUp?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%3Fpc%3Dtopnav-about-en&lp=1&hl=ru");
//        selectDropDown("Пол", "Мужской");
//        selectDropDown("Пол", "Женский");
//
//        selectDropDown("Страна", "Австралия (Australia)");
//        selectDropDown("Страна", "Беларусь");

//        List<WebElement> list= dropdown.getOptions();
//        System.out.println(list.get(1).getText());


//    }


//    public static void selectDropDown(String option, String choice) {
//        String optionXPath = String.format("(//strong[text()='%s']/following-sibling::div/div[@role='listbox'])[1]", option);
//        String choiceXPath = String.format("//div[text()='%s']/parent::div[@role='option']", choice);
//
//        driver.findElement(By.xpath(optionXPath)).click();
//        driver.findElement(By.xpath(choiceXPath)).click();
//    }

        //lecture 48

//        driver.get("https://market.yandex.by");
//        driver.findElement(By.xpath("//a[text()=\"Бытовая техника\"]")).click();
//        driver.findElement(By.xpath("//a[text()=\"Стиральные машины\"]")).click();
//
//        List<WebElement> checkBoxes = driver.findElements(By.xpath("//div[@class=\"n-filter-panel-aside__content\"]/div[4]//span[@class='checkbox__box']"));
//
//        if (checkBoxes.size() == 12) {
//            System.out.println("Ok");
//        } else System.out.println("False");
//
//        for (WebElement checkBoxe : checkBoxes) {
//            checkBoxe.click();
//        }
//
//        lecture 49

        driver.get("https://www.w3schools.com/html/html_tables.asp");

        WebElement tableElement = driver.findElement(By.xpath("//table[@id='customers']"));

        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh_mm_ss");
        String filename = format.format(dateNow) + ".png";

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshot, new File("C:\\projects\\Selenium\\testselenium1\\screenshots\\" + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Table table = new Table(tableElement, driver);
        System.out.println("Rows number is: " + table.getRows().size());

        System.out.println(table.getValueFromCell(2, 3));
        System.out.println(table.getValueFromCell(4, 1));

        System.out.println(table.getValueFromCell(4, "Company"));
        System.out.println(table.getValueFromCell(1, "Country"));
        System.out.println(table.getValueFromCell(2, "Contact"));

        driver.quit();

    }
}

