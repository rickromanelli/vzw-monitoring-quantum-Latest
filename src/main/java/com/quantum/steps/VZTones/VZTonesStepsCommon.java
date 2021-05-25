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
public class VZTonesStepsCommon {
	QAFExtendedWebDriver driver = new WebDriverTestBase().getDriver();
	QAFExtendedWebElement we;
	PerfectoGenericSteps pgs = new PerfectoGenericSteps();

	@When("^I initialize VZTones app")
	public void InitializeApp() throws Exception {

		
		try {
		//	PerfectoApplicationSteps.closeAppByName("Verizon Tones");
		//	PerfectoApplicationSteps.closeAppByName("Verizon Tones");
			
			Map<String, Object> params1 = new HashMap<>();
			params1.put("keySequence", "APP_SWITCH");
			Object result1 = driver.executeScript("mobile:presskey", params1);
			
			Map<String, Object> params2 = new HashMap<>();
			params2.put("label", "Close all");
			params2.put("timeout", "30");
			params2.put("threshold", "90");
			Object result2 = driver.executeScript("mobile:button-text:click", params2);
			
			
		
		} catch (Exception ex) {

		}
		
	
		
		PerfectoApplicationSteps.startAppByName("Verizon Tones");
		
		PerfectoApplicationSteps.waitFor(40);

		if (pgs.textFind("Effective October", "20", "90")) {
			pgs.textClick("Manage Ringback Tones", "30", "90");
		}

		PerfectoApplicationSteps.waitFor(20);
		
	}

	

}
