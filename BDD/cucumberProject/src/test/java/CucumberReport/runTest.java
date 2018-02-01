package CucumberReport;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/Destination"} )

//Specifying pretty as a format option ensure that HTML report will be generated.
//When we specify html:target/Destination - It will generate the HTML report

//inside the Destination folder, in the target folder of the maven project.

public class runTest { }