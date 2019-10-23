/**
 * 
 */
package com.quantum.steps.VVM;

import java.util.HashMap;
import java.util.Map;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.steps.PerfectoApplicationSteps;
import com.quantum.steps.CommonSteps.PerfectoGenericSteps;
import com.quantum.utils.DeviceUtils;

import cucumber.api.java.en.Then;

@QAFTestStepProvider
public class VVMStepsPhone {
	QAFExtendedWebDriver driver = new WebDriverTestBase().getDriver();
	QAFExtendedWebElement we;
	
	PerfectoGenericSteps pgs = new PerfectoGenericSteps();

	@Then("^I open Voicemail App on \"([^\"]*)\"$")
	public void iOpenVoicemailAppOn(String device) throws Exception {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		String model = DeviceUtils.getDeviceProperty("model");

		try {
			PerfectoApplicationSteps.closeAppByName("Voicemail");
			PerfectoApplicationSteps.closeAppByName("Voicemail");
		} catch (Exception ex) {

		}

		PerfectoApplicationSteps.startAppByName("Voicemail");
		
		
	}

	@Then("^I end call on \"([^\"]*)\"$")
	public void iEndCall(String device) {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		we = (QAFExtendedWebElement) driver.findElement("call.clickToEndCall");

		we.waitForPresent(20000);
		we.click();

	}

	@Then("^I delete all voicemails on \"([^\"]*)\"$")
	public void iDeleteVMsOn(String device) {
		//Current Devices LG V20
		
		
		////*[@content-desc="More options"]
		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);
		
		we = (QAFExtendedWebElement) driver.findElement("inbox.trash");

		if (we.isPresent()) {
			we.waitForPresent(20000);
			we.click();

			we = (QAFExtendedWebElement) driver.findElement("inbox.selectAll");

			we.waitForPresent(20000);
			we.click();

			we = (QAFExtendedWebElement) driver.findElement("inbox.delete");

			we.waitForPresent(20000);
			we.click();

			we = (QAFExtendedWebElement) driver.findElement("inbox.yesDelete");

			we.waitForPresent(20000);
			we.click();
		}

		Map<String, Object> params1 = new HashMap<>();
		Object result1 = driver.executeScript("mobile:handset:ready", params1);

	}

	@Then("^I ignore call on \"([^\"]*)\"$")
	public void iIgnoreCallOn(String device) {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		we = (QAFExtendedWebElement) driver.findElement("call.ignore");

		we.waitForPresent(20000);
		we.click();

	}

	@Then ("^I click on voicemail message on \"([^\\\"]*)\"$")
public void iClickVoicemailMessage(String device) throws InterruptedException {
		
		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);
		
		
		we = (QAFExtendedWebElement) driver.findElement("inbox.vmMessage");
		we.waitForPresent(20000);
		we.click();
	}

	@Then("^I inject audio message \"([^\"]*)\" on \"([^\"]*)\"$")
	public void iInjectAudioOn(String repo, String device) throws InterruptedException {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		we = (QAFExtendedWebElement) driver.findElement("call.timer");

		PerfectoGenericSteps pgs = new PerfectoGenericSteps();

		we.waitForPresent(60000);
		PerfectoApplicationSteps.waitFor(13);
		pgs.injectAudio(repo, device);
		PerfectoApplicationSteps.waitFor(10);

	}

	@Then("^I open VVM menu phone$")
	public void iOpenVVMMenuPhone() {
		we = (QAFExtendedWebElement) driver.findElement("menu.btn");
		we.waitForPresent(20000);
		we.click();
	}

	@Then("^I go to VVM home phone$")
	public void iGoToVVMHomePhone() {
		we = (QAFExtendedWebElement) driver.findElement("menu.home.btn");
		we.waitForPresent(20000);
		we.click();

		we = (QAFExtendedWebElement) driver.findElement("home.title");
		we.waitForPresent(20000);

	}

}
