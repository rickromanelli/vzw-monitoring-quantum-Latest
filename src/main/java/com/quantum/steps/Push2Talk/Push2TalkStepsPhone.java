/**
 * 
 */
package com.quantum.steps.Push2Talk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.TestBaseProvider;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.listerners.SplunkHelper;
import com.quantum.steps.PerfectoApplicationSteps;
import com.quantum.steps.CommonSteps.PerfectoGenericSteps;
import com.quantum.steps.CommonSteps.PerfectoSplunkSteps;
import com.quantum.utils.DeviceUtils;

import cucumber.api.java.en.Then;

@QAFTestStepProvider
public class Push2TalkStepsPhone {
	QAFExtendedWebDriver driver = new WebDriverTestBase().getDriver();
	QAFExtendedWebElement we;
	QAFExtendedWebElement we1;
	QAFExtendedWebElement we2;
	Push2TalkStepsCommon p2tc = new Push2TalkStepsCommon();
	PerfectoGenericSteps pgs = new PerfectoGenericSteps();
	PerfectoApplicationSteps pas = new PerfectoApplicationSteps();

	public static QAFExtendedWebDriver getDriver() {
		return new WebDriverTestBase().getDriver();
	}

	@Then("^I switch to contacts tab on \"([^\"]*)\"$")
	public void iswitchToContactsTabPTT(String device) {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		String currentDriver = TestBaseProvider.instance().get().getDriverName();
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^switchTocontactsDriver" + currentDriver);

		String model = DeviceUtils.getDeviceProperty("model");
		String cn = "";
		if (model.equalsIgnoreCase("iPhone-7")) {

			Map<String, Object> params3 = new HashMap<>();
			params3.put("label", "PUBLIC:Prod/PTTPlus/ContactsBtniPhone7.png");
			params3.put("timeout", "20");
			params3.put("threshold", "90");
			Object result3 = getDriver().executeScript("mobile:button-image:click", params3);

		} else if (model.equalsIgnoreCase("Galaxy A12")) {

			Map<String, Object> params3 = new HashMap<>();
			params3.put("label", "PUBLIC:contactsTabA12Unclicked.png");
			params3.put("timeout", "20");
			params3.put("threshold", "90");
			Object result3 = getDriver().executeScript("mobile:button-image:click", params3);

		} else {
			we = (QAFExtendedWebElement) getDriver().findElement("home.contacts");
			we.waitForPresent(40000);
			we.click();
		}
	}

	@Then("^I send Photo to DUT2$")
	public void iSendPhotoToDUT2() {

		we = (QAFExtendedWebElement) driver.findElement("call.photoButton");
		we.waitForPresent(20000);
		we.click();

		pas.waitFor(5);

		we = (QAFExtendedWebElement) driver.findElement("call.takePhoto");
		we.waitForPresent(20000);
		we.click();

		pas.waitFor(5);

		Map<String, Object> params2 = new HashMap<>();
		params2.put("keySequence", "VOL_DOWN");
		Object result2 = driver.executeScript("mobile:presskey", params2);
		result2 = driver.executeScript("mobile:presskey", params2);

		try {
			pgs.textCheckpoint("Retry", "20", "80");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		we = (QAFExtendedWebElement) driver.findElement("call.okPhoto");
		we.waitForPresent(20000);
		we.click();

		try {
			pgs.textCheckpoint("Confirm", "20", "90");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		we = (QAFExtendedWebElement) getDriver().findElement("call.confirmOk");
		we.waitForPresent(40000);
		we.click();

	}

	@Then("^I delete messages on \"([^\"]*)\"$")
	public void iDeleteMessages(String device) throws Exception {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		// PTTResponderCommon.setPTTContactNames(driverName);
		String cn1 = ConfigurationManager.getBundle().getString("contactName1");
		String cn2 = ConfigurationManager.getBundle().getString("contactName2");

		String cn = "";
		if (device.equalsIgnoreCase("DUT1")) {
			cn = cn2;
		} else if (device.equalsIgnoreCase("DUT2")) {
			cn = cn1;
		}

		String deviceModel = DeviceUtils.getDeviceProperty("model");

		Map<String, Object> params2 = new HashMap<>();

		switch (deviceModel) {

		case "iPhone-12 Mini":
			params2.put("label", "PUBLIC:history-BtniPhone12Mini.png");
			break;
		case "Galaxy A12":
			params2.put("label", "PUBLIC:historyBtnA12.png");
			break;
		case "DuraForce Pro 2":
			params2.put("label", "PUBLIC:historyBtnDuraForcePro2.png");
			break;

		default:
			break;

		}

		params2.put("timeout", "20");
		params2.put("threshold", "90");
		Object result2 = driver.executeScript("mobile:button-image:click", params2);

		if (!pgs.textFind("No history exists", "10", "80")) {
			
			Map<String, Object> params3 = new HashMap<>();
			switch (deviceModel) {
			case "iPhone-12 Mini":
				params3.put("label", "PUBLIC:PTTMessageArrowiPhone12Mini.png");
				break;
				
			case "Galaxy A12":
				params3.put("label", "PUBLIC:PTTMessageArrowGalaxyA12.png");
				break;
				
			case "DuraForce Pro 2":
				params3.put("label", "PUBLIC:PTTMessageArrowDuraForce.png");
				break;
				default:
				break;
				
			}
			
			params3.put("timeout", "30");
			params3.put("threshold", "90");
			params3.put("operation", "long");
			Object result3 = driver.executeScript("mobile:button-image:click", params3);
			
		
			
			pas.waitFor(5);

			Map<String, Object> params1 = new HashMap<>();
			params1.put("label", "Delete all");
			params1.put("timeout", "30");
			params1.put("threshold", "80");
			Object result1 = driver.executeScript("mobile:button-text:click", params1);

			pas.waitFor(3);
			
			pgs.textClick("Yes", "30", "100");
			
			pgs.textCheckpoint("No history exists", "60", "90");

		
		}

		Map<String, Object> params4 = new HashMap<>();
		params4.put("timeout", "30");
		params4.put("threshold", "90");
		
		switch (deviceModel) {

		case "iPhone-12 Mini":
			params4.put("label", "PUBLIC:contactsTabiPhone12-Unclicked.png");
			break;
		case "Galaxy A12":
			params4.put("label", "PUBLIC:contactsTabA12Unclicked.png");
			break;
		case "DuraForce Pro 2":
			params4.put("label", "PUBLIC:contactsTabDuraforceUnclicked.png");
			break;

		default:
			break;
			
		}
			
			Object result4 = driver.executeScript("mobile:button-image:click", params4);
		
	
	
	
		pgs.textCheckpoint("Search", "60", "90");
	}

	@Then("^I search for PTT contact on \"([^\"]*)\"$")
	public void isearchforp2tcontact(String device) throws Exception {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		Push2TalkStepsCommon.setPTTContactNames(driverName);
		String cn1 = ConfigurationManager.getBundle().getString("contactName1");
		String cn2 = ConfigurationManager.getBundle().getString("contactName2");
		/*
		 * Map<String, Object> params5 = new HashMap<>(); params5.put("location",
		 * "510,327"); Object result5 = driver.executeScript("mobile:touch:tap",
		 * params5);
		 */

		String model = DeviceUtils.getDeviceProperty("model");
		/*
		 * if (model.equalsIgnoreCase("iPhone-7")) {
		 * 
		 * Map<String, Object> params3 = new HashMap<>(); params3.put("label",
		 * "PUBLIC:Prod/PTTPlus/ContactsBtniPhone7.png"); params3.put("timeout", "20");
		 * params3.put("threshold", "90"); Object result3 =
		 * getDriver().executeScript("mobile:button-image:click", params3);
		 * 
		 * } else {
		 */
		String cn = "";
		if (device.equalsIgnoreCase("DUT1")) {
			cn = cn2;
		} else if (device.equalsIgnoreCase("DUT2")) {
			cn = cn1;
		}

		// iswitchToContactsTabPTT(device);
		// }

		/*
		 * try { pas.closeAppByName("Push To Talk+");
		 * pas.closeAppByName("Push To Talk+"); } catch (Exception ex) {
		 * 
		 * } pas.startAppByName("Push To Talk+");
		 * 
		 * pgs.textCheckpoint("Available", "30", "80");
		 */

		model = DeviceUtils.getDeviceProperty("model");

		if (model.equalsIgnoreCase("iPhone-7")) {

			Map<String, Object> params1 = new HashMap<>();
			params1.put("label", "Search");
			params1.put("text", cn);
			params1.put("timeout", "20");
			params1.put("threshold", "90");
			Object result1 = getDriver().executeScript("mobile:edit-text:set", params1);

		} else if (model.equalsIgnoreCase("iPhone-12 Mini") || model.equalsIgnoreCase("Galaxy S10")
				|| model.equalsIgnoreCase("Galaxy A12") || model.equalsIgnoreCase("XP8800")
				|| model.equalsIgnoreCase("DuraForce Pro 2")) {

			Map<String, Object> params1 = new HashMap<>();
			params1.put("label", "Search");
			params1.put("text", cn);
			params1.put("timeout", "20");
			params1.put("threshold", "90");
			Object result1 = getDriver().executeScript("mobile:edit-text:set", params1);

		} else {
			/*
			 * Map<String, Object> params2 = new HashMap<>(); params2.put("location",
			 * "263,762"); Object result2 = getDriver().executeScript("mobile:touch:tap",
			 * params2);
			 */

			System.out.println((QAFExtendedWebElement) getDriver().findElement("home.search"));
			we = (QAFExtendedWebElement) getDriver().findElement("home.search");
			we.waitForPresent(20000);

			if (device.equalsIgnoreCase("DUT1")) {
				we.sendKeys(cn2);
			} else if (device.equalsIgnoreCase("DUT2")) {
				we.sendKeys(cn1);
			}

		}

	}

	@Then("^Transaction \"([^\"]*)\" search for PTT Contact, \"([^\"]*)\" timeout, \"([^\"]*)\" threshold, \"([^\"]*)\" haystack: X: \"([^\"]*)\" , y: \"([^\"]*)\" , height: \"([^\"]*)\" , width: \"([^\"]*)\" , SLA: \"([^\"]*)\"$")
	public void textSearchHaystack(String name, String text, String timeout, String threshold, String xstart,
			String ystart, String height, String width, String SLA) throws Exception {

		PerfectoSplunkSteps pss = new PerfectoSplunkSteps();
		pss.startSplunkStep(name, name);
		Push2TalkStepsCommon.setPTTContactNames(text);
		String cn1 = ConfigurationManager.getBundle().getString("contactName1");
		String cn2 = ConfigurationManager.getBundle().getString("contactName2");
		// iswitchToContactsTabPTT();

		if (text.equalsIgnoreCase("DUT1")) {
			text = cn1.toString();
		} else if (text.equalsIgnoreCase("DUT2")) {
			text = cn2.toString();
		}

		Map<String, Object> params6 = new HashMap<>();
		params6.put("content", text);
		params6.put("timeout", timeout);
		params6.put("screen.top", ystart);
		params6.put("screen.left", xstart);
		params6.put("screen.height", height);
		params6.put("screen.width", width);
		params6.put("threshold", threshold);
		ArrayList genericOptions2 = new ArrayList();
		genericOptions2.add("natural-language=true");
		params6.put("ocr", genericOptions2);
		Object result6 = getDriver().executeScript("mobile:checkpoint:text", params6);

		SplunkHelper.testStepEnd(Long.parseLong(SLA), name);

	}

	@Then("^I click on phone contact on \"([^\"]*)\" Turbo$")
	public void iClickOnPhoneContactp2tTurbo(String device) throws Exception {
		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		String cn1 = ConfigurationManager.getBundle().getString("contactName1");
		String cn2 = ConfigurationManager.getBundle().getString("contactName2");
		String cn = "";
		if (device.equalsIgnoreCase("DUT1")) {
			cn = cn2.toString();
		} else if (device.equalsIgnoreCase("DUT2")) {
			cn = cn1.toString();
		}

		/*
		 * Map<String, Object> params3 = new HashMap<>(); params3.put("label",
		 * "Brigadier"); params3.put("timeout", "20"); params3.put("threshold", "80");
		 * //params3.put("index", "2"); Object result3 =
		 * driver.executeScript("mobile:button-text:click", params3);
		 * 
		 

		we = (QAFExtendedWebElement) driver.findElement("contacts.result");
		we.waitForPresent(60000);
		we.click(); */
		
		pgs.textClickIndex(cn, "20", "100", "2");
	}

	@Then("^I click on phone contact on \"([^\"]*)\" iPhone$")
	public void iClickOnPhoneContactp2tiPhone(String device) {
		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		String cn1 = ConfigurationManager.getBundle().getString("contactName1");
		String cn2 = ConfigurationManager.getBundle().getString("contactName2");
		String cn = "";
		if (device.equalsIgnoreCase("DUT1")) {
			cn = cn2.toString();
		} else if (device.equalsIgnoreCase("DUT2")) {
			cn = cn1.toString();
		}

		/*
		 * Map<String, Object> params3 = new HashMap<>(); params3.put("label", cn);
		 * params3.put("timeout", "20"); params3.put("threshold", "80");
		 * params3.put("index", "2"); Object result3 =
		 * driver.executeScript("mobile:button-text:click", params3);
		 * 
		 */

		we = (QAFExtendedWebElement) driver.findElement("contacts.result");
		we.waitForPresent(20000);
		we.click();
	}

	@Then("^I click on phone contact on \"([^\"]*)\"$")
	public void iClickOnPhoneContactp2t(String device) {
		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		String cn1 = ConfigurationManager.getBundle().getString("contactName1");
		String cn2 = ConfigurationManager.getBundle().getString("contactName2");
		String cn = "";
		if (device.equalsIgnoreCase("DUT1")) {
			cn = cn2.toString();
		} else if (device.equalsIgnoreCase("DUT2")) {
			cn = cn1.toString();
		}

		Map<String, Object> params3 = new HashMap<>();
		params3.put("label", "Brigadier");
		params3.put("timeout", "20");
		params3.put("threshold", "80");
		// params3.put("index", "2");
		Object result3 = getDriver().executeScript("mobile:button-text:click", params3);

		Map<String, Object> params33 = new HashMap<>();
		params33.put("label", "Brigadier");
		params33.put("timeout", "20");
		params33.put("threshold", "80");
		// params3.put("index", "2");
		Object result33 = getDriver().executeScript("mobile:button-text:click", params33);

		// DeviceUtils.getQAFDriver().executeScript("mobile:button-text:click",
		// params33);

		/*
		 * we = (QAFExtendedWebElement) driver.findElement("contacts.result");
		 * we.waitForPresent(20000); we.click();
		 */
	}

	@Then("^I click to call on \"([^\"]*)\"$")
	public void iClickToCallp2t(String device) throws InterruptedException {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		String model = DeviceUtils.getDeviceProperty("model");

		try {
			we = (QAFExtendedWebElement) driver.findElement("home.missedCall.decline");
			we.waitForPresent(5000);
			we.click();
		} catch (Exception ex2) {

		}

		if (model.equals("iPhone-7")) {

			Map<String, Object> params3 = new HashMap<>();
			params3.put("location", "50%,60%");
			params3.put("operation", "down");
			params3.put("duration", "6");
			Object result3 = driver.executeScript("mobile:touch:tap", params3);

		} else {

			Map<String, Object> params1 = new HashMap<>();
			params1.put("location", "50%,50%");
			params1.put("operation", "down");
			Object result1 = getDriver().executeScript("mobile:touch:tap", params1);
		}

		/*
		 * we = (QAFExtendedWebElement) driver.findElement("call.clickToCall");
		 * we.waitForPresent(20000); we.click();
		 */
	}

	@Then("^I press button down on \"([^\"]*)\"$")
	public void iPressButtonDownp2t(String device) {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		Map<String, Object> params1 = new HashMap<>();
		params1.put("location", "50%,50%");
		params1.put("operation", "down");
		Object result1 = getDriver().executeScript("mobile:touch:tap", params1);

	}

	@Then("^I click to end call on \"([^\"]*)\"$")
	public void iClickToEndCallp2t(String device) throws Exception {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);
		String model = DeviceUtils.getDeviceProperty("model");

		if (pgs.textFind("Ready", "8", "80")) {

			if (model.equals("Z30")) {
				pgs.textClick("End Call", "20", "90");

			} else if (model.equals("iPhone-7")) {

				pgs.imageClick("PUBLIC:PTT_EndCallBtn-iPhone.png", "30", "90");
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
			} else if (model.equals("E6810")) {
				if (pgs.imageCheckPoint("PUBLIC:EndCallDura.png", "30", "90", false)) {
					pgs.imageClick("PUBLIC:EndCallDura.png", "30", "90");
				}
			} else {
				we = (QAFExtendedWebElement) driver.findElement("call.clickToEndCall");
				we.waitForPresent(20000);
				we.click();
			}
		}
	}

	@Then("^Transaction: \"([^\"]*)\" on PTT Device: \"([^\"]*)\" Description: \"([^\"]*)\" SLA: \"([^\"]*)\" Volume: \"([^\"]*)\" Timeout: \"([^\"]*)\" Duration: \"([^\"]*)\"$")
	public void pttAudioCheckpointTimer(String name, String device, String desc, String SLA, String volume,
			String timeout, String duration) throws Exception {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);
		PerfectoSplunkSteps pss = new PerfectoSplunkSteps();
		pss.startSplunkStep(name, desc);

		Map<String, Object> params = new HashMap<>();
		Object audUrl = (String) SplunkHelper.getQAFDriver().executeScript("mobile:audio.recording:start", params);

		Map<String, Object> params3 = new HashMap<>();
		params3.put("deviceAudio", "URL");
		params3.put("key", "PUBLIC:VM2TXT3.mp3");
		params3.put("threshold", "3.0");
		params3.put("profile", "voip");
		params3.put("deviceAudio.silenceTrimming.type", "absolute");
		params3.put("deviceAudio.silenceTrimming.level", "0");
		params3.put("deviceAudio.calibration", "");
		List<String> genericOptions3 = new ArrayList<>();
		genericOptions3.add("");
		// params3.put("generic", genericOptions3);
		Object result3 = SplunkHelper.getQAFDriver().executeScript("mobile:audio:validation", params3);

		/*
		 * Map<String, Object> params11 = new HashMap<>();
		 * 
		 * params11.put("volume", volume); params11.put("timeout", timeout);
		 * params11.put("duration", duration); Object result11 =
		 * SplunkHelper.getQAFDriver().executeScript("mobile:checkpoint:audio",
		 * params11);
		 */

		if (!result3.toString().equals("true")) {
			throw new Exception("Audio wasn't received");
		}

		SplunkHelper.testStepEnd(Long.parseLong(SLA), name);

	}

	@Then("^Transaction \"([^\"]*)\" call received on \"([^\"]*)\" SLA: \"([^\"]*)\"$")
	public void iConfirmCallOnDevicep2t(String name, String device, String SLA) throws Exception {

		PerfectoSplunkSteps pss = new PerfectoSplunkSteps();
		pss.startSplunkStep(name, "Confirm call on" + device);

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);
		// Push2TalkStepsCommon.setPTTContactNames(driverName);
		String cn = ConfigurationManager.getBundle().getString("contactName2");
		if (driverName.equalsIgnoreCase("perfecto2")) {
			cn = ConfigurationManager.getBundle().getString("contactName1");
		}

		String model = DeviceUtils.getDeviceProperty("model");

		if (model.equals("iPhone-7")) {

			Map<String, Object> params1 = new HashMap<>();
			params1.put("content", cn);
			params1.put("timeout", "40");
			params1.put("threshold", "80");
			params1.put("index", "1");
			// ArrayList genericOptions2 = new ArrayList();
			// genericOptions2.add("natural-language=true");
			// params1.put("ocr", genericOptions2);
			Object result1 = driver.executeScript("mobile:checkpoint:text", params1);
		} else {

			try {
				we1 = new QAFExtendedWebElement("//*[contains(@text,\"" + cn + "\")]");
				we = (QAFExtendedWebElement) driver.findElementByXPath("//*[@text=\"" + cn + "\"]");
				we1.waitForPresent(40000);

			} catch (Exception ex) {
				try {
					/*
					 * we2 = (QAFExtendedWebElement) driver.findElement("home.missedCall.decline");
					 * we2.waitForPresent(10000); we2.click(); we1.waitForPresent(10000);
					 */
				} catch (Exception ex2) {

				}

			}
		}

		SplunkHelper.testStepEnd(Long.parseLong(SLA), name);
		/*
		 * we = (QAFExtendedWebElement)
		 * driver.findElement("phone.push2talk.callscreen.speakerOff");
		 * we.waitForPresent(20000); we.click();
		 */

	}

	@Then("^I send audio on \"([^\"]*)\"$")
	public void iSendAudiop2t(String device) {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		String model = DeviceUtils.getDeviceProperty("model");

		if (model.equals("iPhone-7")) {

			try {
				we = (QAFExtendedWebElement) driver.findElement("home.missedCall.decline");
				we.waitForPresent(5000);
				we.click();
			} catch (Exception ex2) {

			}

			try {
				// pgs.imageClick("PUBLIC:Prod/PTTPlus/PTTCall-iPhone.png", "20", "85");

				/*
				 * Map<String, Object> params1 = new HashMap<>(); params1.put("label",
				 * "PUBLIC:Prod/PTTPlus/PTTCall-iPhone.png"); params1.put("timeout", "20");
				 * params1.put("threshold", "80"); params1.put("operation", "long"); Object
				 * result1 = getDriver().executeScript("mobile:button-image:click", params1);
				 */
				Map<String, Object> params1 = new HashMap<>();
				params1.put("location", "50%, 60%");
				params1.put("duration", "20");
				Object result1 = driver.executeScript("mobile:touch:tap", params1);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// PUBLIC:Prod/PTTPlus/PTTCall-iPhone.png

			try {
				we = (QAFExtendedWebElement) driver.findElement("home.missedCall.decline");
				we.waitForPresent(5000);
				we.click();
			} catch (Exception ex2) {

			}

			Map<String, Object> params5 = new HashMap<>();
			params5.put("location", "50%,70%");
			params5.put("operation", "down");
			Object result5 = getDriver().executeScript("mobile:touch:tap", params5);
		}
		//
		// Object result5 = getDriver().executeScript()

	}

	@Then("^I stop sending audio on \"([^\"]*)\"$")
	public void istopSendAudiop2t(String device) {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);
		Map<String, Object> params5 = new HashMap<>();
		params5.put("location", "50%,50%");
		params5.put("operation", "up");

		Object result5 = getDriver().executeScript("mobile:touch:tap", params5);

	}

	@Then("^I confirm audio$")
	public void iConfirmAudiop2t(String device) {

		
	}

	
	@Then ("^I change status to \"([^\"]*)\" on \"([^\"]*)\"$")
	public void changeStatusToOn(String status, String device) throws Exception {
		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}
		

		PerfectoGenericSteps.switchToDriver(driverName);
		
		if (pgs.textFind(status, "10", "90")) {
			
		} else {
		
		if (pgs.textFind("Available", "10", "90")) {
			
			pas.waitFor(3);
		
		Map<String, Object> params33 = new HashMap<>();
		params33.put("label", "Available");
		params33.put("timeout", "20");
		params33.put("threshold", "90");
		params33.put("label.direction", "Left");
		params33.put("label.offset", "50%");
		Object result33 = getDriver().executeScript("mobile:button-text:click", params33);
		
			
				
		
		} else if (pgs.textFind("Do not disturb", "20", "90")) {
			
			pas.waitFor(3);
			
			Map<String, Object> params33 = new HashMap<>();
			params33.put("label", "Do not disturb");
			params33.put("timeout", "20");
			params33.put("threshold", "90");
			params33.put("label.direction", "Left");
			params33.put("label.offset", "50%");
			Object result33 = getDriver().executeScript("mobile:button-text:click", params33);
			
				
					
				
		}
			
		pgs.textClick(status, "20", "90");
		
		pas.waitFor(3);
		
		pgs.textCheckpoint(status, "20", "90");
		
		
	//pgs.textClickHaystack(status, "10", "90", "0%", "14%", "86%", "100%");
		
			
		
		}

		
	}
}
