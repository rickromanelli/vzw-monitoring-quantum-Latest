/**
 * 
 */
package com.quantum.steps.SmartFamily;

import java.util.HashMap;
import java.util.Map;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.steps.PerfectoApplicationSteps;
import com.quantum.steps.CommonSteps.PerfectoGenericSteps;
import com.quantum.utils.DeviceUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

@QAFTestStepProvider
public class SmartFamilySteps extends WebDriverTestCase {
	QAFExtendedWebDriver driver = new WebDriverTestBase().getDriver();
	QAFExtendedWebElement we;
	PerfectoGenericSteps pgs = new PerfectoGenericSteps();

	@Given("^I open Smart Family App on \"([^\"]*)\"$")
	public void StartOperaApp(String device) throws Exception {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		try {
			PerfectoApplicationSteps.closeAppByName("Smart Family");
			PerfectoApplicationSteps.closeAppByName("Smart Family");
		} catch (Exception ex) {

		}
		PerfectoApplicationSteps.startAppByName("Smart Family");
	}

	@Then("^I log in to Smart Family on \"([^\"]*)\"$")
	public void iLogInSmartFamily(String device) {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);
		String model = DeviceUtils.getDeviceProperty("model");

		System.out.println((QAFExtendedWebElement) driver.findElement("login.password"));
		we = (QAFExtendedWebElement) driver.findElement("login.password");
		we.waitForPresent(20000);

		we.sendKeys("vzw@$P01");

		if (model.equalsIgnoreCase("Galaxy S5 SM-G900A")) {
			Map<String, Object> params1 = new HashMap<>();
			params1.put("content", "PUBLIC:Prod/SmartFamily/PasswordCompletedS5.png");
			params1.put("timeout", "20");
			params1.put("threshold", "90");
			Object result1 = driver.executeScript("mobile:image:find", params1);

		} else {
			we = (QAFExtendedWebElement) driver.findElement("login.passwordCompleted");
			we.waitForPresent(20000);
		}

		we = (QAFExtendedWebElement) driver.findElement("login.signInButton");
		we.waitForPresent(20000);
		we.click();

	}

}