/**
 * 
 */
package com.quantum.steps.PictureMe;

import java.util.HashMap;
import java.util.Map;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.DriverUtils;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.steps.PerfectoApplicationSteps;
import com.quantum.steps.CommonSteps.PerfectoGenericSteps;

import cucumber.api.java.en.Then;

@QAFTestStepProvider
public class PictureMeStepsPhone {
	QAFExtendedWebDriver driver = new WebDriverTestBase().getDriver();
	QAFExtendedWebElement we;
	
	@Then("^I toggle power button on \"([^\"]*)\"$")
	public void togglePowerButton(String device) throws InterruptedException {
		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}
		
		PerfectoGenericSteps.switchToDriver(driverName);
			
		
		
		Map<String, Object> params1 = new HashMap<>();
		params1.put("keySequence", "POWER");
		
		for(int i = 0; i < 3; i++) {
			Object result1 = driver.executeScript("mobile:presskey", params1);
			PerfectoApplicationSteps.waitFor(3);
		}
		
		
	}



	
	@Then("^I go to cloud home phone$")
	public void iGoToCloudHomePhone()
	{
		we = (QAFExtendedWebElement) driver.findElement("menu.home.btn");
		we.waitForPresent(20000);
		we.click();
		
		we = (QAFExtendedWebElement) driver.findElement("home.title");
		we.waitForPresent(20000);
		
		
	}

	@Then("^I open backup screen phone$")
	public void iopenbackupscreenPhone() throws Exception {
		we = (QAFExtendedWebElement) driver.findElement("menu.backupScreen");
		we.waitForPresent(20000);
		we.click();



		
	}
	
	@Then("^I backup phone$")
	public void ibackupPhone() throws Exception {
		we = (QAFExtendedWebElement) driver.findElement("menu.backupNow");
		we.waitForPresent(20000);
		we.click();



		
	}
	
	@Then("^I confirm backup phone$")
	public void iConfirmBackupPhone() throws Exception
	{
		PerfectoGenericSteps pgs = new PerfectoGenericSteps();
		pgs.textCheckpoint("Everything is backed up", "400", "100");
	}

}
