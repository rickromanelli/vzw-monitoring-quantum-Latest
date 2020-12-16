/**
 * 
 */
package com.quantum.steps.Roaming;

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
public class RoamingStepsPhone {
	QAFExtendedWebDriver driver = new WebDriverTestBase().getDriver();
	QAFExtendedWebElement we;
	PerfectoGenericSteps pgs = new PerfectoGenericSteps();
	
	@Then("^I click to end roaming call on \"([^\"]*)\"$")
	public void iClickToEndRoamingCallp2t(String device) throws Exception {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);
		String model = DeviceUtils.getDeviceProperty("model");

		if (model.equals("iPhone-7")) {
		
			pgs.imageClick("PUBLIC:endPhoneCalliPhone7.png", "30", "90");
		} else if (model.equals("Galaxy S8")) {

			if (ConfigurationManager.getBundle().getString("app").equalsIgnoreCase("Push2Talk")) {
				
			
			try {
				pgs.imageClick("PUBLIC:Prod/PTTPlus/EndCallS8.png", "30", "90");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			} else {
				we = (QAFExtendedWebElement) driver.findElement("call.clickToEndCall");
				we.waitForPresent(20000);
				we.click();
			
				
			}
		} else if (model.equals("E6810"))  {
			pgs.imageClick("PUBLIC:Prod/PTTPlus/EndCallDura.png", "30", "90");
		} else {
			we = (QAFExtendedWebElement) driver.findElement("call.clickToEndCall");
			we.waitForPresent(20000);
			we.click();
		}
	}
	

}
