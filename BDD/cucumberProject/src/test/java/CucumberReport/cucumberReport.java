package CucumberReport;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class cucumberReport {

    private final static String GECKO_BASE_PATH = "C:\\projects\\Selenium\\PageObjectSeleniumTest\\drivers\\geckodriver.exe";

    WebDriver driver = null;

    @Given("^I have opened the browser$")
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", GECKO_BASE_PATH);
       driver = new ChromeDriver();
    }

    @When("^I open Facebook website$")
    public void goToFacebook() {
        driver.navigate().to("https://www.facebook.com/");
    }

    @Then("^Login button should exists$")
    public void loginButton() {
        if(driver.findElement(By.id("u_0_v")).isEnabled()) {
            System.out.println("Test 1 Pass");
        } else {
            System.out.println("Test 1 Fail");
        }
    }

    @Then("^Forgot password link should exists$")
    public void forgotPWD() {
        if(driver.findElement(By.id("")).isEnabled()) {
            System.out.println("Test 1 Pass");
        } else {
            System.out.println("Test 1 Fail");
        }
    }
}