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
	
	public static QAFExtendedWebDriver getDriver() {
		return new WebDriverTestBase().getDriver();
	}
	
	@Then("^I toggle power button on \"([^\"]*)\"$")
	public void togglePowerButton(String device) throws InterruptedException {
		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}
		
		PerfectoGenericSteps.switchToDriver(driverName);
			
		Map<String, Object> params1 = new HashMap<>();
		Object result1 = getDriver().executeScript("mobile:handset:ready", params1);
		
		
		Map<String, Object> params2 = new HashMap<>();
		params2.put("keySequence", "POWER");
		
		for(int i = 0; i < 3; i++) {
			Object result3 = getDriver().executeScript("mobile:presskey", params2);
			PerfectoApplicationSteps.waitFor(3);
		}
		
		
	}

	@Then("^I go to home screen on \"([^\"]*)\"$")
	public void iGoToHomeScreenOn(String device) {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		Map<String, Object> params1 = new HashMap<>();
		Object result1 = getDriver().executeScript("mobile:handset:ready", params1);
		
		

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
		PerfectoGenericSteps pgs = new PerfectoGenericSteps();
		
		we = (QAFExtendedWebElement) driver.findElement("menu.backupNow");
		we.waitForPresent(20000);
		we.click();
		
		
		
		PerfectoApplicationSteps.waitFor(5);
		
		if(pgs.textFind("Just so you know", "10", "80") ) {
			
			we = (QAFExtendedWebElement) driver.findElement("menu.wifiWarning.yes");
			we.waitForPresent(20000);
			we.click();
		}

	}
	
	@Then("^I confirm backup phone$")
	public void iConfirmBackupPhone() throws Exception
	{
		PerfectoGenericSteps pgs = new PerfectoGenericSteps();
		pgs.textCheckpoint("All your files are synced", "400", "100");
	}

}
