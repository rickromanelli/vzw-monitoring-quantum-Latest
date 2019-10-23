/**
 * 
 */
package com.quantum.steps.VVM;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.steps.PerfectoApplicationSteps;

import cucumber.api.java.en.Given;

@QAFTestStepProvider
public class VVMStepsCommon extends WebDriverTestCase {
	QAFExtendedWebDriver driver = new WebDriverTestBase().getDriver();
	QAFExtendedWebElement we;

	public void cleanAndStartApp(boolean clean) {

		if (clean) {
			PerfectoApplicationSteps.cleanAppByName("Voicemail");
		}

		try {
			PerfectoApplicationSteps.closeAppByName("Voicemail");
			PerfectoApplicationSteps.closeAppByName("Voicemail");
		} catch (Exception ex) {

		}
		PerfectoApplicationSteps.startAppByName("Voicemail");
	}

	@Given("^I open Voicemail app phone$")
	public void iOpenVVMAppPhone() throws Exception {

		cleanAndStartApp(false);

	}

}
