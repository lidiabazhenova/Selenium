package stepdefin;


import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class AttitudeTest {
		
	@Given("^I work in ([^\"]*)$")
	public void ln(String str)
	{
		if(str.equals("Latenights"))
		{
			System.out.println("latenight\n");
		}
		
		if(str.equals("Mornings"))
		{
			System.out.println("Morning automation\n");
		}
	}
	
	
	
	@When("^I meet ([^\"]*)$")
	public void Imeet(String str){
		if(str.equals("watchmen"))
		{
			System.out.println("watchmen automation\n");
		}
		if(str.equals("NewspaperBoy"))
		{
			System.out.println("NewspaperBoy automation\n");
		}
	}


@Then("^I ([^\"]*) him$")
public void gre(String str)
{
	if(str.equals("Greeted"))
	{
		System.out.println("Greeted automation\n");
	}
	if(str.equals("skipGreeting"))
	{
		System.out.println("skipGreeting automation\n");
	}
}
	

	

	
	}
	
		
	


