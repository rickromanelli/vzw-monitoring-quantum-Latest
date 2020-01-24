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

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@QAFTestStepProvider
public class VZTonesStepsCommon {
	QAFExtendedWebDriver driver = new WebDriverTestBase().getDriver();
	QAFExtendedWebElement we;

	@When("^I initialize VZTones app")
	public void InitializeApp() throws Exception {

		
		try {
			PerfectoApplicationSteps.closeAppByName("Verizon Tones");
			PerfectoApplicationSteps.closeAppByName("Verizon Tones");
		} catch (Exception ex) {

		}
		
	
		
		PerfectoApplicationSteps.startAppByName("Verizon Tones");
		
		we.wait(15);

		we = (QAFExtendedWebElement) driver.findElement("home.signin");
		if(we.isPresent()) {
			we.click();
		}
	}

	

}
