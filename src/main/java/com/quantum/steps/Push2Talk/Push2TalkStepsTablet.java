/**
 * 
 */
package com.quantum.steps.Push2Talk;

import java.util.HashMap;
import java.util.Map;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.steps.PerfectoApplicationSteps;
import com.quantum.steps.CommonSteps.PerfectoGenericSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@QAFTestStepProvider
public class Push2TalkStepsTablet extends WebDriverTestCase {
	QAFExtendedWebDriver driver = PerfectoGenericSteps.getDriver();
	QAFExtendedWebElement we;
	Push2TalkStepsCommon vzsc = new Push2TalkStepsCommon();


}
