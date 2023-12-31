/**
 * 
 */
package com.quantum.steps.PictureMe;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.steps.PerfectoApplicationSteps;

import cucumber.api.java.en.Given;

@QAFTestStepProvider
public class PictureMeStepsCommon extends WebDriverTestCase {
	QAFExtendedWebDriver driver = new WebDriverTestBase().getDriver();
	QAFExtendedWebElement we;

	public void cleanAndStartApp(boolean clean) {

		if (clean) {
			PerfectoApplicationSteps.cleanAppByName("Cloud");
		}

		try {
			PerfectoApplicationSteps.closeAppByName("Cloud");
			PerfectoApplicationSteps.closeAppByName("Cloud");
		} catch (Exception ex) {

		}
		PerfectoApplicationSteps.startAppByName("Cloud");
	}

	

}
