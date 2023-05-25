package com.quantum.steps.CommonSteps;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebElement;
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

import cucumber.api.java.en.Then;
import io.appium.java_client.ScreenshotState;

@QAFTestStepProvider
public class PerfectoGenericSteps {

	QAFExtendedWebDriver driver = new WebDriverTestBase().getDriver();
	QAFExtendedWebElement we;

	private static String getCurrentDriver() {

		return ConfigurationManager.getBundle().getString("driver.name");
	}

	private static String getDefaultDriver() {

		return ConfigurationManager.getBundle().getString("default.driver.name");

	}

	@Then("^I call \"([^\"]*)\" from \"([^\"]*)\"$")
	public void iEnterPhNum(String ctPhNum, String device) throws Exception {
		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		String phNum = "";

		if (device.equalsIgnoreCase("DUT1")) {
			phNum = ConfigurationManager.getBundle().getProperty("phNum2").toString().substring(1);

		} else if (device.equalsIgnoreCase("DUT2")) {
			phNum = ConfigurationManager.getBundle().getProperty("phNum1").toString().substring(1);

		}

		String[] phNums = phNum.split("");

		String model = DeviceUtils.getDeviceProperty("model");

		if (model.equals("Z30")) {

			String contactName = ConfigurationManager.getBundle().getString("contactDesc2");
			textClick(contactName, "20", "90");
			PerfectoApplicationSteps.waitFor(3);
			textClick("Call Mobile", "20", "90");

		} else if (model.equals("9930")) {

		} else if (model.equals("V20")) {

			we = (QAFExtendedWebElement) driver.findElement("call.dailTab");
			we.waitForPresent(20000);
			we.click();

			we = (QAFExtendedWebElement) driver.findElement("call.deleteDigit");
			for (int i = 0; i < phNums.length; ++i) {
				if (we.isPresent()) {
					we.click();
				} else {
					break;
				}
			}

			we = (QAFExtendedWebElement) driver.findElement("call.phNumField");
			we.waitForPresent(20000);
			we.click();
			we.sendKeys(phNum);

			PerfectoApplicationSteps.waitFor(10);
			we = (QAFExtendedWebElement) driver.findElement("call.callButton");
			we.waitForPresent(20000);
			we.click();

		} else if (model.equals("iPhone-7") || (model.equals("iPhone-SE (2020)")) || (model.equals("iPhone-12 Mini"))) {

			String contactName = ConfigurationManager.getBundle().getString("contactDesc2");
			textClick(contactName, "30", "80");
			PerfectoApplicationSteps.waitFor(3);
			// textClick("Call Mobile", "20", "90");

			// imageClick("PUBLIC:Prod/International/CallButtoniPhone7.png", "30", "90");
			we = (QAFExtendedWebElement) driver.findElement("call.callButton");
			we.waitForPresent(20000);
			we.click();

		} else if (model.equals("Galaxy S7")) {
			we = (QAFExtendedWebElement) driver.findElement("call.dailTab");
			we.waitForPresent(20000);
			we.click();

			we = (QAFExtendedWebElement) driver.findElement("call.deleteDigit");
			for (int i = 0; i < phNums.length; ++i) {
				if (we.isPresent()) {

					we.click();
				} else {
					break;
				}
			}

			we = (QAFExtendedWebElement) driver.findElement("call.phNumField");
			we.waitForPresent(20000);
			we.click();
			we.sendKeys(phNum);

			PerfectoApplicationSteps.waitFor(10);
			we = (QAFExtendedWebElement) driver.findElement("call.callButton");
			we.waitForPresent(20000);
			we.click();

		} else if (model.equals("Galaxy S8")
				&& ConfigurationManager.getBundle().getString("app").equalsIgnoreCase("VVM")) {

			String phoneApp = "Phone";

			try {
				PerfectoApplicationSteps.closeAppByName(phoneApp);
				PerfectoApplicationSteps.closeAppByName(phoneApp);
			} catch (Exception ex) {

			}

			PerfectoApplicationSteps.startAppByName(phoneApp);

			we = (QAFExtendedWebElement) driver.findElement("call.dailTab");
			PerfectoApplicationSteps.waitFor(10);
			if (we.isPresent()) {
				we.click();
			}

			we = (QAFExtendedWebElement) driver.findElement("call.deleteDigit");

			for (int i = 0; i < phNums.length; ++i) {
				if (we.isPresent()) {

					we.click();
				} else {
					break;
				}
			}

			we = (QAFExtendedWebElement) driver.findElement("call.phNumField");
			we.waitForPresent(20000);
			we.click();
			we.sendKeys(phNum);

			PerfectoApplicationSteps.waitFor(10);
			we = (QAFExtendedWebElement) driver.findElement("call.callButton");
			we.waitForPresent(20000);
			we.click();
		} else if (model.equals("Galaxy S8") || model.equals("Galaxy S10") || model.equals("Moto Z2")) {

			String contactName = ConfigurationManager.getBundle().getString("contactDesc2");

			if (textFindHaystack("Contacts", "20", "90", "0%", "0%", "100%", "100%")) {

				Map<String, Object> params1 = new HashMap<>();
				params1.put("label", "Contacts");
				params1.put("timeout", "20");
				params1.put("threshold", "90");
				Object result1 = driver.executeScript("mobile:button-text:click", params1);

			}

			we = (QAFExtendedWebElement) driver.findElement("call.contacts.search");
			we.waitForPresent(20000);
			we.click();

			Map<String, Object> params5 = new HashMap<>();
			params5.put("label", "Search");
			params5.put("text", contactName);
			params5.put("screen.top", "0%");
			params5.put("screen.height", "34%");
			params5.put("screen.left", "0%");
			params5.put("screen.width", "100%");
			Object result5 = getDriver().executeScript("mobile:edit-text:set", params5);

			we = (QAFExtendedWebElement) driver.findElement("call.contactsResult");
			we.waitForPresent(20000);
			we.click();

			PerfectoApplicationSteps.waitFor(3);

			if (!model.equals("Moto Z2")) {
				we = (QAFExtendedWebElement) driver.findElement("call.callButton");
				we.waitForPresent(20000);
				we.click();
			}

		} else if (model.equals("Galaxy A12")) {
			String phoneApp = "Phone";

			try {
				PerfectoApplicationSteps.closeAppByName(phoneApp);
				PerfectoApplicationSteps.closeAppByName(phoneApp);
			} catch (Exception ex) {

			}

			PerfectoApplicationSteps.startAppByName(phoneApp);

			we = (QAFExtendedWebElement) driver.findElement("call.dailTab");
			PerfectoApplicationSteps.waitFor(10);
			if (we.isPresent()) {
				we.click();
			}

			we = (QAFExtendedWebElement) driver.findElement("call.deleteDigit");

			for (int i = 0; i < phNums.length; ++i) {
				if (we.isPresent()) {

					we.click();
				} else {
					break;
				}
			}

			we = (QAFExtendedWebElement) driver.findElement("call.phNumField");
			we.waitForPresent(20000);
			we.click();
			we.sendKeys(phNum);

			PerfectoApplicationSteps.waitFor(10);
			we = (QAFExtendedWebElement) driver.findElement("call.callButton");
			we.waitForPresent(20000);
			we.click();

		} else {

			we = (QAFExtendedWebElement) driver.findElement("call.dailTab");
			we.waitForPresent(20000);
			we.click();

			we = (QAFExtendedWebElement) driver.findElement("call.deleteDigit");
			for (int i = 0; i < phNums.length; ++i) {
				if (we.isPresent()) {

					we.click();
				} else {
					break;
				}
			}

			we = (QAFExtendedWebElement) driver.findElement("call.phNumField");
			we.waitForPresent(20000);
			we.click();
			we.sendKeys(phNum);

			PerfectoApplicationSteps.waitFor(10);
			we = (QAFExtendedWebElement) driver.findElement("call.callButton");
			we.waitForPresent(20000);
			we.click();
		}

	}

	@Then("^I set device location to \"([^\"]*)\"$")
	public void setLocation(String coordinates) {
		Map<String, Object> params1 = new HashMap<>();
		params1.put("coordinates", coordinates);
		Object result1 = driver.executeScript("mobile:location:set", params1);

	}

	@Then("^I use default driver")
	public static void switchToDefaultDriver() {

		switchToDriver(getDefaultDriver());
	}

	public static QAFExtendedWebDriver getDriver() {
		return new WebDriverTestBase().getDriver();
	}

	/*
	 * public static String getCurrentDriverName() {
	 * 
	 * String currentDriver; //currentDriver =
	 * TestBaseProvider.instance().get().getUiDriver(); //currentDriver =
	 * QAFTestBase.STBArgs.browser_str.getFrom(args); return "string"; }
	 */

	@Then("^I switch to driver \"([^\"]*)\"$")
	public static void switchToDriver(String driverName) {

		String currentDriver = TestBaseProvider.instance().get().getDriverName();

		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^Pre-SwitchDriver" + currentDriver);

		try {
			// TestBaseProvider.instance().get().setDriver(driverName + "RemoteDriver");
			DriverUtils.switchToDriver(driverName);
			if (driverName.contains("2")) {
				ConfigurationManager.getBundle().setProperty("deviceCount", "2");
				ConfigurationManager.getBundle().setProperty("reportURL2",
						DriverUtils.getDriver().getCapabilities().getCapability("testGridReportUrl"));
			} else if (driverName.contains("2")) {
				ConfigurationManager.getBundle().setProperty("deviceCount", "3");
				ConfigurationManager.getBundle().setProperty("reportURL3",
						DriverUtils.getDriver().getCapabilities().getCapability("testGridReportUrl"));

			}
			String envResources = ConfigurationManager.getBundle().getString(driverName + ".env.resources");
			ConfigurationManager.getBundle().setProperty("env.resources", envResources);

			// currentDriver = TestBaseProvider.instance().get().getBrowser();
			currentDriver = TestBaseProvider.instance().get().getDriverName();
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^Post-SwitchDriver" + currentDriver);

		} catch (Exception e) {
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^Failed to switch^^^^^^^^^^^^^^^^^^^^^^^");

		}

		storePhNumber(driverName);
		storeDeviceID(driverName);
		storeDeviceDesc(driverName);

	}

	@Then("^I open phone App on \"([^\"]*)\"$")
	public void iOpenPhoneAppPhone(String device) throws Exception {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		String model = DeviceUtils.getDeviceProperty("model");

		switch (model) {

		case "9930":

			Map<String, Object> params2 = new HashMap<>();
			Object result2 = driver.executeScript("mobile:handset:ready", params2);

			// toChar array #########################################################
			String app = "phone";
			// char[] appNameArray = app.toCharArray();
			String[] appNameArray = app.toUpperCase().split("");

			Map<String, Object> params3 = new HashMap<>();

			for (int i = 0; i < appNameArray.length; i++) {

				String letter = appNameArray[i];
				System.out.println(letter);
				System.out.println(i);
				params3.put("keySequence", letter);
				getDriver().executeScript("mobile:presskey", params3);

			}

			Map<String, Object> params11 = new HashMap<>();
			params11.put("label", "Phone");
			params11.put("timeout", "20");
			params11.put("index", "2");
			params11.put("label.direction", "below");
			params11.put("label.offset", "11%");
			Object result11 = driver.executeScript("mobile:button-text:click", params11);

			break;

		case "Galaxy S8":

			String phoneApp = "Contacts";

			// if (imageFindHaystack("PUBLIC:Prod/International/PhoneappButtonS8.png", "30",
			// "90", "0%", "0%", "100%", "100%")) {
			// imageClick("PUBLIC:Prod/International/PhoneappButtonS8.png", "30", "90");
			// }

			try {
				PerfectoApplicationSteps.closeAppByName(phoneApp);
				PerfectoApplicationSteps.closeAppByName(phoneApp);
			} catch (Exception ex) {

			}

			PerfectoApplicationSteps.startAppByName(phoneApp);

			break;

		case "Galaxy A12":

			phoneApp = "Contacts";

			// if (imageFindHaystack("PUBLIC:Prod/International/PhoneappButtonS8.png", "30",
			// "90", "0%", "0%", "100%", "100%")) {
			// imageClick("PUBLIC:Prod/International/PhoneappButtonS8.png", "30", "90");
			// }

			try {
				PerfectoApplicationSteps.closeAppByName(phoneApp);
				PerfectoApplicationSteps.closeAppByName(phoneApp);
			} catch (Exception ex) {

			}

			PerfectoApplicationSteps.startAppByName(phoneApp);

			break;

		case "Galaxy S10":

			phoneApp = "Phone";

			// if (imageFindHaystack("PUBLIC:Prod/International/PhoneappButtonS8.png", "30",
			// "90", "0%", "0%", "100%", "100%")) {
			// imageClick("PUBLIC:Prod/International/PhoneappButtonS8.png", "30", "90");
			// }

			try {
				PerfectoApplicationSteps.closeAppByName(phoneApp);
				PerfectoApplicationSteps.closeAppByName(phoneApp);
			} catch (Exception ex) {

			}

			PerfectoApplicationSteps.startAppByName(phoneApp);

			break;

		default:
			String phoneAppName = "Phone";
			if (model.equals("V20")) {
				phoneAppName = "Contacts";
			}
			try {
				PerfectoApplicationSteps.closeAppByName(phoneAppName);
				PerfectoApplicationSteps.closeAppByName(phoneAppName);
			} catch (Exception ex) {

			}

			PerfectoApplicationSteps.startAppByName(phoneAppName);

			we = (QAFExtendedWebElement) driver.findElement("call.contacts");
			we.waitForPresent(30000);
			we.click();

			break;
		}

	}

	@Then("^I open contacts App on \"([^\"]*)\"$")
	public void iOpenContactsAppPhone(String device) throws Exception {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		String model = DeviceUtils.getDeviceProperty("model");

		if (model.equals("Z30")) {

			Map<String, Object> params25 = new HashMap<>();
			Object result25 = driver.executeScript("mobile:handset:ready", params25);

			Map<String, Object> params19 = new HashMap<>();
			Object result19 = getDriver().executeScript("mobile:handset:ready", params19);

			Map<String, Object> params1 = new HashMap<>();
			params1.put("start", "299,1267");
			params1.put("end", "334,0");
			params1.put("duration", "0");
			Object result1 = driver.executeScript("mobile:touch:swipe", params1);

			if (textFindHaystack("Contacts", "10", "90", "0%", "0%", "100%", "100%")) {
				Map<String, Object> params22 = new HashMap<>();
				params22.put("label", "Contacts");
				params22.put("timeout", "10");
				params22.put("threshold", "90");
				params22.put("label.direction", "left");
				params22.put("label.offset", "29%");
				Object result22 = driver.executeScript("mobile:button-text:click", params22);

			}

			Map<String, Object> params18 = new HashMap<>();
			Object result18 = getDriver().executeScript("mobile:handset:ready", params18);

			Map<String, Object> params2 = new HashMap<>();
			params2.put("label", "Contacts");
			params2.put("timeout", "10");
			params2.put("threshold", "90");
			params2.put("label.direction", "below");
			params2.put("label.offset", "5%");
			Object result2 = driver.executeScript("mobile:button-text:click", params2);

		}
	}

	@Then("^I delete voicemails on \"([^\"]*)\"$")
	public void iDeleteVoicemails(String device) {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		String model = DeviceUtils.getDeviceProperty("model");

		PerfectoApplicationSteps.closeAppByName("Voicemail");
		PerfectoApplicationSteps.closeAppByName("Voicemail");

		PerfectoApplicationSteps.startAppByName("Voicemail");

		try {
			if (imageFindHaystack("PUBLIC:Prod/VVM/trashcanLG_v20.png", "30", "80", "0%", "0%", "100%", "100%")) {

				we = (QAFExtendedWebElement) driver.findElement("inbox.trash");
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

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("^I open browser App on \"([^\"]*)\"$")
	public void iOpenBrowserAppOn(String device) {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		String model = DeviceUtils.getDeviceProperty("model");

		if (model.equals("Z30")) {

			Map<String, Object> params33 = new HashMap<>();
			Object result33 = driver.executeScript("mobile:handset:ready", params33);

			Map<String, Object> params2 = new HashMap<>();
			params2.put("label", "Browser");
			params2.put("timeout", "10");
			params2.put("threshold", "90");
			params2.put("label.direction", "below");
			params2.put("label.offset", "5%");
			Object result2 = driver.executeScript("mobile:button-text:click", params2);

		}
	}

	public static void storePhNumber(String driverName) {

		String devicePhNum = DeviceUtils.getDeviceProperty("phoneNumber");
		String phNum = (driverName.contains("2")) ? "phNum2" : "phNum1";

		ConfigurationManager.getBundle().setProperty(phNum, devicePhNum);

	}

	public static void storeDeviceID(String driverName) {

		String deviceID = DeviceUtils.getDeviceProperty("deviceID");
		String devID = (driverName.contains("2")) ? "deviceID2" : "deviceID1";

		ConfigurationManager.getBundle().setProperty(devID, deviceID);
		System.out.println("DeviceID1: " + ConfigurationManager.getBundle().getString("deviceID1"));
		System.out.println("DeviceID2: " + ConfigurationManager.getBundle().getString("deviceID2"));
	}

	public static void storeDeviceDesc(String driverName) {

		String deviceDesc = DeviceUtils.getDeviceProperty("Description");
		String devDesc = (driverName.contains("2")) ? "contactDesc2" : "contactDesc1";

		ConfigurationManager.getBundle().setProperty(devDesc, deviceDesc);
		System.out.println("DeviceDesc1: " + ConfigurationManager.getBundle().getString("contactDesc1"));
		System.out.println("DeviceDesc2: " + ConfigurationManager.getBundle().getString("contactDesc2"));
	}

	@Then("^I perform an Image checkpoint for the Image \"([^\"]*)\" with a timeout of \"([^\"]*)\" and a threshold of \"([^\"]*)\" and status is \"([^\"]*)\"$")
	public boolean imageCheckPoint(String repo, String timeout, String threshold, boolean assertImage)
			throws Exception {
		Map<String, Object> params1 = new HashMap<>();
		params1.put("content", repo);
		params1.put("timeout", timeout);
		params1.put("threshold", threshold);
		Object result1 = getDriver().executeScript("mobile:checkpoint:image", params1);

		if (result1.toString().contains("true")) {
			return true;
		} else {
			if (assertImage) {
				throw new Exception("Image not found!");
			}
			return false;
		}
	}

	/*
	 * @Then("^I perform a negative Image checkpoint for the Image \"([^\"]*)\" with a timeout of \"([^\"]*)\" and a threshold of \"([^\"]*)\"$"
	 * ) public boolean imageNegativeCheckPoint(String repo, String timeout, String
	 * threshold, boolean assertImage) throws Exception { Object result1 = null;
	 * 
	 * for (int i = 0; i < Integer.parseInt(timeout); i++) { Map<String, Object>
	 * params1 = new HashMap<>(); params1.put("match;", "bounded");
	 * params1.put("imageBounds.needleBound", "30"); params1.put("content", repo);
	 * params1.put("threshold", threshold); //params1.put("timeout", timeout);
	 * QAFExtendedWebDriver myDriver = getDriver(); try { result1 =
	 * myDriver.executeScript("mobile:image:find", params1); } catch(Exception e) {
	 * e.printStackTrace(); myDriver.wait(1); } if
	 * (!result1.toString().contains("true") && i >= 5) { break; } }
	 * 
	 * if (result1.toString().contains("true")) { if (assertImage) { throw new
	 * Exception("Image found!"); } return true; } else { return false; } }
	 */

	@Then("^I perform an Image click \"([^\"]*)\" with a timeout of \"([^\"]*)\" and a threshold of \"([^\"]*)\"$")
	public void imageClick(String repo, String timeout, String threshold) throws Exception {

		Map<String, Object> params5 = new HashMap<>();
		params5.put("label", repo);
		params5.put("timeout", timeout);
		params5.put("threshold", threshold);
		Object result5 = getDriver().executeScript("mobile:button-image:click", params5);

	}

	@Then("^I perform an Image click \"([^\"]*)\" with a timeout of \"([^\"]*)\" and a threshold of \"([^\"]*)\" index of \"([^\"]*)\"$")
	public void imageClickIndex(String repo, String timeout, String threshold, String index) throws Exception {

		Map<String, Object> params5 = new HashMap<>();
		params5.put("label", repo);
		params5.put("timeout", timeout);
		params5.put("threshold", threshold);
		params5.put("index", index);
		Object result5 = getDriver().executeScript("mobile:button-image:click", params5);

	}

	@Then("^I perform an Object click \"([^\"]*)\" with a timeout of \"([^\"]*)\"$")
	public void objectClick(String xpath, String timeout) throws Exception {

		WebDriverWait wait = new WebDriverWait(getDriver(), Long.parseLong(timeout));
		QAFWebElement we = (QAFWebElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

		we.click();

	}

	@Then("^I perform a locator click \"([^\"]*)\" with a timeout of \"([^\"]*)\"$")
	public void objectLocatorClick(String objectLocator, String timeout) throws Exception {

		QAFWebElement we = getDriver().findElement(objectLocator);
		we.waitForEnabled(Long.parseLong(timeout));
		we.waitForVisible(Long.parseLong(timeout));

		we.click();

	}

	@Then("^I perform a text click \"([^\"]*)\" with a timeout of \"([^\"]*)\" and a threshold of \"([^\"]*)\"$")
	public void textClick(String text, String timeout, String threshold) throws Exception {

		Map<String, Object> params6 = new HashMap<>();
		params6.put("label", text);
		params6.put("timeout", timeout);
		params6.put("threshold", threshold);
		Object result6 = getDriver().executeScript("mobile:button-text:click", params6);

	}

	public void textClickIndex(String text, String timeout, String threshold, String index) throws Exception {

		Map<String, Object> params6 = new HashMap<>();
		params6.put("label", text);
		params6.put("timeout", timeout);
		params6.put("threshold", threshold);
		params6.put("index", index);
		Object result6 = getDriver().executeScript("mobile:button-text:click", params6);

	}

	@Then("^I perform a text click \"([^\"]*)\" with a timeout of \"([^\"]*)\" and a threshold of \"([^\"]*)\" with a haystack defined by x: \"([^\"]*)\" , y: \"([^\"]*)\" , height: \"([^\"]*)\" , width: \"([^\"]*)\" $")
	public void textClickHaystack(String text, String timeout, String threshold, String xstart, String ystart,
			String height, String width) throws Exception {

		Map<String, Object> params6 = new HashMap<>();
		params6.put("label", text);
		params6.put("timeout", timeout);
		params6.put("screen.top", ystart);
		params6.put("screen.left", xstart);
		params6.put("screen.height", height);
		params6.put("screen.width", width);
		params6.put("threshold", threshold);
		Object result6 = getDriver().executeScript("mobile:button-text:click", params6);

	}

	@Then("^I perform an Image click \"([^\"]*)\" with a timeout of \"([^\"]*)\" and a threshold of \"([^\"]*)\" haystack x: \"([^\"]*)\" , y: \"([^\"]*)\" , height: \"([^\"]*)\" , width: \"([^\"]*)\"$")
	public void imageClickHaystack(String repo, String timeout, String threshold, String xstart, String ystart,
			String height, String width) throws Exception {

		Map<String, Object> params6 = new HashMap<>();
		params6.put("label", repo);
		params6.put("timeout", timeout);
		params6.put("screen.top", ystart);
		params6.put("screen.left", xstart);
		params6.put("screen.height", height);
		params6.put("screen.width", width);
		params6.put("threshold", threshold);
		Object result6 = getDriver().executeScript("mobile:button-image:click", params6);

	}

	public void imageClickHaystackIndex(String repo, String timeout, String threshold, String xstart, String ystart,
			String height, String width, String index) throws Exception {

		Map<String, Object> params6 = new HashMap<>();
		params6.put("label", repo);
		params6.put("timeout", timeout);
		params6.put("screen.top", ystart);
		params6.put("screen.left", xstart);
		params6.put("screen.height", height);
		params6.put("screen.width", width);
		params6.put("threshold", threshold);
		params6.put("index", index);
		Object result6 = getDriver().executeScript("mobile:button-image:click", params6);

	}

	public boolean textFindHaystack(String text, String timeout, String threshold, String xstart, String ystart,
			String height, String width) throws Exception {

		Map<String, Object> params6 = new HashMap<>();
		params6.put("content", text);
		params6.put("timeout", timeout);
		params6.put("screen.top", ystart);
		params6.put("screen.left", xstart);
		params6.put("screen.height", height);
		params6.put("screen.width", width);
		params6.put("threshold", threshold);
		Object result6 = getDriver().executeScript("mobile:text:find", params6);
		if (result6.toString().contains("true")) {
			return true;
		}

		return false;

	}

	public boolean textFind(String text, String timeout, String threshold) throws Exception {

		Map<String, Object> params6 = new HashMap<>();
		params6.put("content", text);
		params6.put("timeout", timeout);
		params6.put("threshold", threshold);
		Object result6 = getDriver().executeScript("mobile:text:find", params6);
		if (result6.toString().contains("true")) {
			return true;
		}

		return false;

	}

	public boolean textFindIndex(String text, String timeout, String threshold, String index) throws Exception {

		Map<String, Object> params6 = new HashMap<>();
		params6.put("content", text);
		params6.put("timeout", timeout);
		params6.put("threshold", threshold);
		params6.put("index", index);
		Object result6 = getDriver().executeScript("mobile:text:find", params6);
		if (result6.toString().contains("true")) {
			return true;
		}

		return false;

	}

	public boolean imageFindHaystack(String imageRepo, String timeout, String threshold, String xstart, String ystart,
			String height, String width) throws Exception {

		Map<String, Object> params6 = new HashMap<>();
		params6.put("content", imageRepo);
		params6.put("timeout", timeout);
		params6.put("screen.top", ystart);
		params6.put("screen.left", xstart);
		params6.put("screen.height", height);
		params6.put("screen.width", width);
		params6.put("threshold", threshold);
		Object result6 = getDriver().executeScript("mobile:image:find", params6);
		if (result6.toString().contains("true")) {
			return true;
		}

		return false;
	}

	@Then("^I enter \"(.*?)\" to \"(.*?)\"$")
	public static void iSet(String text, String locator) {
		// sendKeys(text, locator);
		QAFWebElement we = getDriver().findElement(locator);
		we.sendKeys(text);

	}

	@Then("^I perform audio checkpoint on \"([^\"]*)\" with volume of \"([^\"]*)\" a timeout of \"([^\"]*)\" and a duration of \"([^\"]*)\"$")
	public void performAudioCheckpoint(String device, String volume, String timeout, String duration) throws Exception {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		Map<String, Object> params1 = new HashMap<>();
		params1.put("volume", volume);
		params1.put("timeout", timeout);
		params1.put("duration", duration);
		Object result1 = getDriver().executeScript("mobile:checkpoint:audio", params1);

		if (!result1.toString().equals("true")) {
			throw new Exception("Audio wasn't received");
		}
	}

	@Then("^I inject audio file \"([^\"]*)\" on \"([^\"]*)\"$")
	public void injectAudio(String repo, String device) {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);
		Map<String, Object> params2 = new HashMap<>();
		params2.put("key", repo);
		params2.put("wait", "nowait");
		Object result2 = getDriver().executeScript("mobile:audio:inject", params2);

	}

	@Then("^I increase to max volume$")
	public void volumeMax() {
		for (int i = 0; i < 5; i++) {
			Map<String, Object> params2 = new HashMap<>();
			params2.put("keySequence", "VOL_UP");
			Object result2 = getDriver().executeScript("mobile:presskey", params2);
		}
	}

	public void volumeMute() {
		for (int i = 0; i < 5; i++) {
			Map<String, Object> params3 = new HashMap<>();
			params3.put("keySequence", "VOL_DOWN");
			Object result3 = getDriver().executeScript("mobile:presskey", params3);
		}

	}

	public void textCheckpoint(String text, String timeout, String threshold) throws Exception {
		Map<String, Object> params1 = new HashMap<>();
		params1.put("content", text);
		params1.put("source", "camera");
		params1.put("timeout", timeout);
		params1.put("measurement", "accurate");
		params1.put("threshold", threshold);
		params1.put("analysis", "automatic");
		Object result1 = SplunkHelper.getQAFDriver().executeScript("mobile:checkpoint:text", params1);

		if (result1.toString().contains("true")) {

		} else {

			throw new Exception("Text not found!");

		}
	}

	public void textCheckpointHaystack(String text, String timeout, String threshold, String xstart, String ystart,
			String height, String width) throws Exception {
		PerfectoGenericSteps pgs = new PerfectoGenericSteps();
		pgs.textClickHaystack(text, "20", "90", xstart, ystart, height, width);
		Map<String, Object> params1 = new HashMap<>();
		params1.put("content", text);
		params1.put("source", "camera");
		params1.put("timeout", timeout);
		params1.put("measurement", "accurate");
		params1.put("threshold", threshold);
		params1.put("analysis", "automatic");
		Object result1 = SplunkHelper.getQAFDriver().executeScript("mobile:checkpoint:text", params1);

		if (result1.toString().contains("true")) {

		} else {

			throw new Exception("Text not found!");

		}
	}

	@Then("^I go to webpage: \"([^\"]*)\" on \"([^\"]*)\"$")
	public void gotoWebpageOn(String url, String device) throws Exception {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		String model = DeviceUtils.getDeviceProperty("model");

		if (model.equals("Galaxy S10") || model.equals("Galaxy S10e") || model.equals("Galaxy A12")) {
			Map<String, Object> params = new HashMap<>();

			try {
				PerfectoApplicationSteps.closeAppByName("Chrome");
				PerfectoApplicationSteps.closeAppByName("Chrome");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			PerfectoApplicationSteps.startAppByName("Chrome");

			we = (QAFExtendedWebElement) getDriver().findElement("browser.addressBar");
			we.waitForPresent(40000);

			we.click();

			we.sendKeys(url);
			Map<String, Object> params1 = new HashMap<>();
			params1.put("label", "Go");
			params1.put("timeout", "40");
			params1.put("threshold", "80");
			params1.put("screen.top", "78%");
			params1.put("screen.height", "22%");
			params1.put("screen.left", "57%");
			params1.put("screen.width", "43%");
			Object result1 = getDriver().executeScript("mobile:button-text:click", params1);

		} else {
			
			
			try {
				PerfectoApplicationSteps.closeAppByName("Safari");
				PerfectoApplicationSteps.closeAppByName("Safari");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}

			PerfectoApplicationSteps.startAppByName("Safari");
			
			

			
			
			  we = (QAFExtendedWebElement) getDriver().findElement("browser.addressBar");
			  we.waitForPresent(40000);
			  we.click();
			  
			  we = (QAFExtendedWebElement) getDriver().findElement("browser.clearAddressBar");
			  we.waitForPresent(40000);
			  we.click();
			  
			  we = (QAFExtendedWebElement) getDriver().findElement("browser.addressBarCleared");
			  we.waitForPresent(40000);
			  we.sendKeys(url);
			 
			
			
			we = (QAFExtendedWebElement) getDriver().findElement("browser.go");
			we.waitForPresent(40000);

			we.click();

			
			//we.sendKeys(url);
			//we.sendKeys(Keys.ENTER);

		}

	}

	@Then("^I clear cache on \"([^\"]*)\"$")
	public void clearCache(String device) throws Exception {

		String model = DeviceUtils.getDeviceProperty("model");
		int i = 0;

		if (model.equals("Z30")) {

			Map<String, Object> params37 = new HashMap<>();
			Object result37 = driver.executeScript("mobile:handset:ready", params37);

			iOpenBrowserAppOn(device);

			// close tabs
			imageClickHaystack("PUBLIC:Prod/International/Tabs-Z30.png", "10", "85", "0%", "87%", "13%", "100%");
			for (i = 0; i < 10; i++) {
				if (imageFindHaystack("PUBLIC:Prod/International/closeTab-z30.png", "10", "90", "0%", "0%", "100%",
						"100%")) {
					imageClickHaystack("PUBLIC:Prod/International/closeTab-z30.png", "10", "90", "0%", "0%", "100%",
							"100%");
				} else {
					break;
				}
			}

			imageClickHaystack("PUBLIC:Prod/International/Tabs-Z30.png", "10", "85", "0%", "87%", "13%", "100%");

			textClick("History", "10", "90");
			imageClickHaystack("PUBLIC:Prod/International/closeTab-z30.png", "10", "90", "0%", "0%", "100%", "100%");
			imageClickHaystack("PUBLIC:Prod/International/TrashCan-Z30.png", "10", "90", "0%", "0%", "100%", "100%");

			textFindHaystack("No Browsing History", "10", "90", "0%", "0%", "100%", "100%");
			imageClickHaystack("PUBLIC:Prod/International/BrowserBack-z30.png", "10", "90", "0%", "0%", "100%", "100%");

		}
	}

	@Then("^I toggle wifi \"([^\"]*)\"$")
	public void toggleWifiSingleDriver(String wifiValue) throws Exception {

		QAFExtendedWebDriver myDriver = getDriver();
		Map params = new HashMap<>(); // Set the "wifi" value to turn off the Wifi
		PerfectoApplicationSteps.switchNativeContext();

		if (ConfigurationManager.getBundle().getString("platform").equalsIgnoreCase("android")) {
			params.put("wifi", wifiValue);
			myDriver.executeScript("mobile:network.settings:set", params); // Set the "wifi" value to turn the Wifi back
																			// on params1.put("wifi", "enabled");
		} else {
			// iOS
			params.put("name", "Settings");
			myDriver.executeScript("mobile:application:open", params);
			myDriver.executeScript("mobile:application:close", params);
			myDriver.executeScript("mobile:application:open", params);
			if (textFindHaystack("Perfecto", "20", "90", "0%", "35%", "65%", "100%")) {

				we = (QAFExtendedWebElement) driver.findElement("settings.home.wifi.btn");
				we.waitForPresent(20000);
				we.click();

				we = (QAFExtendedWebElement) driver.findElement("settings.wifi.toggle");
				we.waitForPresent(20000);

				we.click();
			}

		}

	}

	@Then("^I toggle wifi \"([^\"]*)\" on \"([^\"]*)\"$")
	public void toggleWifi(String wifiValue, String device) throws Exception {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		} else if (device.equalsIgnoreCase("dut3")) {
			driverName = "perfecto3";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		QAFExtendedWebDriver myDriver = getDriver();
		Map params = new HashMap<>(); // Set the "wifi" value to turn off the Wifi
		PerfectoApplicationSteps.switchNativeContext();

		String platform = DeviceUtils.getDeviceProperty("OS");

		if (platform.equalsIgnoreCase("Android")) {
			params.put("wifi", wifiValue);
			myDriver.executeScript("mobile:network.settings:set", params); // Set the "wifi" value to turn the Wifi back
																			// on params1.put("wifi", "enabled");
		} else {
			// iOS
			params.put("name", "Settings");
			myDriver.executeScript("mobile:application:open", params);
			myDriver.executeScript("mobile:application:close", params);
			myDriver.executeScript("mobile:application:open", params);

			/*
			 * Map<String, Object> params1 = new HashMap<>(); params1.put("content",
			 * "Perfecto"); params1.put("timeout", "5"); params1.put("threshold", "90");
			 * params1.put("screen.top", "41%"); params1.put("screen.left", "0%");
			 * params1.put("screen.width", "100%"); params1.put("screen.height", "28%");
			 * driver.executeScript("mobile:text:find", params1);
			 */
			if (textFindHaystack("Perfecto", "5", "90", "0%", "41%", "28%", "100%")) {
				we = (QAFExtendedWebElement) driver.findElement("//*[@value=\"Wi-Fi\"]");
				we.waitForPresent(20000);
				we.click();

				we = (QAFExtendedWebElement) driver.findElement("//*[@label=\"Wi-Fi\" and @value=\"1\"]");
				we.waitForPresent(20000);

				we.click();

			}

		}
	}
	
	

	@Then("I set picker wheel$")
	public void setPickerWheel() {

		PerfectoApplicationSteps.startAppByName("Clock");

		we = (QAFExtendedWebElement) driver.findElement("//*[@label=\"Alarm\"]");
		we.waitForPresent(20000);
		we.click();

		we = (QAFExtendedWebElement) driver.findElement("//*[@label=\"Add\"]");
		we.waitForPresent(20000);
		we.click();

		we = (QAFExtendedWebElement) driver.findElement("//*[@type=\"XCUIElementTypePickerWheel\"][1]");
		we.waitForPresent(20000);
		
		String wheelValue = we.getText();
		
		System.out.println(wheelValue);
		
		//we.sendKeys(null)
		
		Map<String, Object> params1 = new HashMap<>();
		params1.put("label", "Today");
		params1.put("timeout", "10");
		params1.put("threshold", "100");
		params1.put("label.direction", "Above");
		params1.put("label.offset", "5%");
		Object result1 = getDriver().executeScript("mobile:button-text:click", params1);
		
		
		
		//we.click();

		//DeviceUtils.pickerwheelStep(we, "next");
		
		
		
		//char day = i.charAt(0);

	}
	
	

	@Then("^I restart device$")
	public void restartDevice() throws Exception {

		/*
		 * String driverName = "perfecto"; if (device.equalsIgnoreCase("dut2")) {
		 * driverName = "perfecto2"; } else if (device.equalsIgnoreCase("dut3")) {
		 * driverName = "perfecto3"; }
		 */
		// PerfectoGenericSteps.switchToDriver(driverName);
		// DeviceUtils.pic

		Map<String, Object> pars = new HashMap<>();
		String reStr = (String) driver.executeScript("mobile:handset:reboot", pars);
		
		//DeviceUtils.assertVisualImg(reStr)

	}
	
	@Then("^I restart devices$")
	public void daily_restart() {

		Map<String, Object> params = new HashMap<>();
		DeviceUtils.getQAFDriver().executeScript("mobile:device:ready", params);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}

		Map<String, Object> pars = new HashMap<>();
		DeviceUtils.getQAFDriver().executeScript("mobile:handset:reboot", pars);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}

		Map<String, Object> pars2 = new HashMap<>();
		DeviceUtils.getQAFDriver().executeScript("mobile:handset:recover", pars2);
		try {
			Thread.sleep(90000);
		} catch (InterruptedException e) {
		}

	}

}
