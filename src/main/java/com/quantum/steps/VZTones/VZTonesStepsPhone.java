/**
 * 
 */
package com.quantum.steps.VZTones;

import java.util.HashMap;
import java.util.Map;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.steps.PerfectoApplicationSteps;
import com.quantum.steps.CommonSteps.PerfectoGenericSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@QAFTestStepProvider
public class VZTonesStepsPhone {
	 QAFExtendedWebDriver driver = new WebDriverTestBase().getDriver();
	 QAFExtendedWebElement we;
	 PerfectoGenericSteps pgs = new PerfectoGenericSteps();

	
	
	@Then("^I search for \"([^\"]*)\" phone$")
	public void searchForTonePhone(String tone)
	{
		we = (QAFExtendedWebElement) driver.findElement("home.search.input");
		we.waitForPresent(20000);
		we.click();
		we.sendKeys(tone);
		we = (QAFExtendedWebElement) driver.findElement("home.search.button");
		we.click();
		
		//we.wait(5);
		PerfectoApplicationSteps.waitFor(5);
	}
	
	@Then("^I press play phone$")
	public void playTonePhone()
	{
		
		we = (QAFExtendedWebElement) driver.findElement("searchResults.play");
		we.click();
		
		
	}
	
	@Then("^I navigate to buy phone$")
	public void navigateToBuyPhone()
	{
		we = (QAFExtendedWebElement) driver.findElement("whatsNew.info");
		we.waitForPresent(30);
		we.click();
		
	}
	
	@Then("^I navigate to jukeboxes phone$")
	public void navigateJukeboxesPhone()
	{
		we = (QAFExtendedWebElement) driver.findElement("myRBTs.myJukeboxes.btn");
		we.click();
	}

}
