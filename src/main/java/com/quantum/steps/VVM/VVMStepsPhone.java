package com.quantum.steps.VVM;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.core.TestBaseProvider;
import com.qmetry.qaf.automation.keys.ApplicationProperties;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.UiDriver;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.listerners.SplunkHelper;
import com.quantum.steps.PerfectoApplicationSteps;
import com.quantum.steps.PerfectoDeviceSteps;
import com.quantum.steps.Push2Talk.Push2TalkStepsCommon;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.DriverUtils;


import com.quantum.steps.CommonSteps.PerfectoGenericSteps;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;

import cucumber.api.java.en.Then;

@QAFTestStepProvider
public class VVMStepsPhone {
	QAFExtendedWebDriver driver = new WebDriverTestBase().getDriver();
	QAFExtendedWebElement we;
	
	PerfectoGenericSteps pgs = new PerfectoGenericSteps();
	
	public static QAFExtendedWebDriver getDriver() {
		return new WebDriverTestBase().getDriver();
	}

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

		try {
			we = (QAFExtendedWebElement) driver.findElement("call.clickToEndCall");

			we.waitForPresent(20000);
			we.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	

	@Then("^I delete all voicemails on \"([^\"]*)\"$")
	public void iDeleteVMsOn(String device) throws Exception {
		//Current Devices LG V20
		
		
		////*[@content-desc="More options"]
		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);
		
		//we = (QAFExtendedWebElement) driver.findElement("inbox.vmList");

		
		if (pgs.textFind("908", "20", "100")) {
			
			we = (QAFExtendedWebElement) driver.findElement("inbox.hamburger");
			
			we.waitForPresent(20000);
			we.click();

			we = (QAFExtendedWebElement) driver.findElement("inbox.editList");

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
	public void iIgnoreCallOn(String device) throws Exception {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);
		
		
		pgs.textFind("Incoming Call", "40", "80");
		
		
		Map<String, Object> params = new HashMap<>();
		params.put("start", "563,1317");
		params.put("end", "563,674");
		params.put("duration", "3");
		Object res = driver.executeScript("mobile:touch:swipe", params);
		/*
		Map<String, Object> params5 = new HashMap<>();
		params5.put("label", "PUBLIC:ignoreButtonGalaxyA12.png");
		params5.put("timeout", "60");
		params5.put("threshold", "90");
		Object result5 = getDriver().executeScript("mobile:touch:swipe:click", params5);
*/

		//we = (QAFExtendedWebElement) driver.findElement("call.ignore");

		//we.waitForPresent(20000);
		//we.click();

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

		we.waitForPresent(30000);
		PerfectoApplicationSteps.waitFor(18);
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
