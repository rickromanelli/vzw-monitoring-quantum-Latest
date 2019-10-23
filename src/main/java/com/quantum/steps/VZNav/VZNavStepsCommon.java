/**
 * 
 */
package com.quantum.steps.VZNav;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.steps.PerfectoApplicationSteps;

import cucumber.api.java.en.Given;

@QAFTestStepProvider
public class VZNavStepsCommon extends WebDriverTestCase {
	QAFExtendedWebDriver driver = new WebDriverTestBase().getDriver();
	QAFExtendedWebElement we;

	public void cleanAndStartApp(boolean clean) {

		if (clean) {
			PerfectoApplicationSteps.cleanAppByName("VZ Navigator");
		}

		try {
			PerfectoApplicationSteps.closeAppByName("VZ Navigator");
			PerfectoApplicationSteps.closeAppByName("VZ Navigator");
		} catch (Exception ex) {

		}
		PerfectoApplicationSteps.startAppByName("VZ Navigator");
	}

}
