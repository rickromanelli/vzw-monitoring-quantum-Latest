/**
 * 
 */
package com.quantum.steps.BIS.BB9930;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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

@QAFTestStepProvider
public class BISSteps extends WebDriverTestCase {
	QAFExtendedWebDriver driver = new WebDriverTestBase().getDriver();
	QAFExtendedWebElement we;
	PerfectoGenericSteps pgs = new PerfectoGenericSteps();

	@Given("^I open \"([^\"]*)\" App$")
	public void startAppBB(String app) throws Exception {

		Map<String, Object> params1 = new HashMap<>();
		Object result1 = driver.executeScript("mobile:handset:ready", params1);

		// toChar array #########################################################

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

		app = app.toLowerCase();

		switch (app) {
		case "message":

			pgs.imageClickHaystack("PUBLIC:Prod/BIS/BB_Message_app.png", "20", "85", "0%", "0%", "57%", "100%");

			break;

		case "browser":

			pgs.imageClickHaystack("PUBLIC:Prod/BIS/Browser-9930.png", "20", "85", "0%", "0%", "57%", "100%");
			PerfectoApplicationSteps.waitFor(5);

			break;

		}

	}

	@Given("^I clear Cache BB7$")
	public void clearBrowserCache() throws Exception {

		startAppBB("Browser");
		
		closeBrowserTab();

		Map<String, Object> params15 = new HashMap<>();
		params15.put("keySequence", "MENU");
		Object result15 = driver.executeScript("mobile:presskey", params15);
		PerfectoApplicationSteps.waitFor(5);
		
		for (int i = 0; i < 15; i++) {
			Map<String, Object> params31 = new HashMap<>();
			params31.put("keySequence", "DOWN");
			Object result31 = driver.executeScript("mobile:presskey", params31);
		}

		PerfectoApplicationSteps.waitFor(3);
		
		Map<String, Object> params5 = new HashMap<>();
		params5.put("label", "Options");
		params5.put("threshold", "90");
		/*params5.put("maxscroll", "10");
		params5.put("scrolling", "scroll");*/
		Object result5 = driver.executeScript("mobile:button-text:click", params5);

		for (int i = 0; i < 32; i++) {
			Map<String, Object> params32 = new HashMap<>();
			params32.put("keySequence", "DOWN");
			Object result32 = driver.executeScript("mobile:presskey", params32);
		}
		
		Map<String, Object> params6 = new HashMap<>();
		params6.put("label", "Clear now");
		params6.put("threshold", "90");
		
		Object result6 = driver.executeScript("mobile:button-text:click", params6);

		PerfectoApplicationSteps.waitFor(3);

		Map<String, Object> params66 = new HashMap<>();
		params66.put("keySequence", "MENU");
		Object result66 = driver.executeScript("mobile:presskey", params66);

		pgs.textClick("Close", "20", "90");

		closeBrowserTab();

		// HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
		/*
		 * pgs.textClick("Tabs", "20", "90"); PerfectoApplicationSteps.waitFor(5);
		 * 
		 * driver.executeScript("mobile:presskey", params15); pgs.textClick("Close Tab",
		 * "20", "90");
		 * 
		 * 
		 * int i=0; for (i=0; i<10; i++) { if (!pgs.textFindHaystack("Start Page", "10",
		 * "85", "0%", "0%", "30%", "100%")) { Map<String, Object> params67 = new
		 * HashMap<>(); params67.put("keySequence", "BACK"); Object result67 =
		 * driver.executeScript("mobile:presskey", params67);
		 * 
		 * }else { break; }
		 * 
		 * }
		 * 
		 * 
		 * 
		 * Map<String, Object> params1 = new HashMap<>(); params1.put("keySequence",
		 * "MENU"); Object result1 = driver.executeScript("mobile:presskey", params1);
		 * 
		 * 
		 * pgs.textClick("History", "20", "90");
		 * 
		 * 
		 * if (!pgs.textFindHaystack("Empty", "10", "85", "0%", "0%", "30%", "100%")) {
		 * 
		 * 
		 * driver.executeScript("mobile:presskey", params1); pgs.textClick("Clear All",
		 * "20", "90"); //pgs.wait(5); pgs.textClick("Delete", "20", "90");
		 * 
		 * 
		 * }
		 * 
		 * Map<String, Object> params14 = new HashMap<>(); params14.put("keySequence",
		 * "BACK"); Object result14 = driver.executeScript("mobile:presskey", params14);
		 * 
		 * Map<String, Object> params11 = new HashMap<>(); params11.put("keySequence",
		 * "END"); Object result11 = driver.executeScript("mobile:presskey", params11);
		 * 
		 */

	}

	@Given("^I close the current tab$")
	public void closeBrowserTab() throws Exception {
		
		PerfectoApplicationSteps.waitFor(3);
		
		if (pgs.imageFindHaystack("PUBLIC:Prod/BIS/TabsButtonBrowser-9930.png", "10", "90", "0%", "0%", "30%", "100%")) {
			Map<String, Object> params1 = new HashMap<>();
			params1.put("label", "PUBLIC:Prod/BIS/TabsButtonBrowser-9930.png");
			Object result1 = driver.executeScript("mobile:button-image:click", params1);
		} else {
			
			Map<String, Object> params1 = new HashMap<>();
		params1.put("label", "PUBLIC:Prod/BIS/TabsButtonBlueBrowser-9930.png");
		Object result1 = driver.executeScript("mobile:button-image:click", params1);
		}
		

		Map<String, Object> params60 = new HashMap<>();
		params60.put("keySequence", "MENU");
		Object result60 = driver.executeScript("mobile:presskey", params60);

		pgs.textClick("Close Tab", "20", "90");
		
	}
	@Given("^I browse to \"([^\"]*)\"$")
	public void browserNavigation(String url) throws Exception {

		String[] urlArray = url.toUpperCase().split("");

		Map<String, Object> params3 = new HashMap<>();

		pgs.textClick("Type search", "10", "90");

		for (int i = 0; i < urlArray.length; i++) {

			String letter = urlArray[i];
			System.out.println(letter);
			System.out.println(i);
			if (letter.equalsIgnoreCase(".")) {

				Map<String, Object> params1 = new HashMap<>();
				params1.put("keySequence", "ALT");
				Object result1 = driver.executeScript("mobile:presskey", params1);

				Map<String, Object> params2 = new HashMap<>();
				params2.put("keySequence", "M");
				Object result2 = driver.executeScript("mobile:presskey", params2);

			} else {
				params3.put("keySequence", letter);
				getDriver().executeScript("mobile:presskey", params3);

			}
		}

		Map<String, Object> params33 = new HashMap<>();
		params33.put("keySequence", "ENTER");
		Object result33 = driver.executeScript("mobile:presskey", params33);

	}

	@Given("^I delete all BIS emails$")
	public void deleteBISEmails() throws Exception {

		if (!pgs.textFindHaystack("No messages", "10", "85", "0%", "0%", "30%", "100%")) {
			boolean deleteNow = true;

			Map<String, Object> params1 = new HashMap<>();
			params1.put("keySequence", "MENU");
			Object result1 = driver.executeScript("mobile:presskey", params1);

			pgs.textClick("Delete Prior", "20", "90");

			pgs.textFindHaystack("Delete all prior items?", "20", "85", "0%", "0%", "60%", "100%");

			Map<String, Object> params3 = new HashMap<>();
			params3.put("keySequence", "UP");
			Object result3 = driver.executeScript("mobile:presskey", params3);

			params3.put("keySequence", "OK");
			Object result4 = driver.executeScript("mobile:presskey", params3);

		}

	}

	@Given("^I send BIS Email BB7$")
	public void sendBISEmailBB7() throws Exception {
		boolean emailReady = true;

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String strTimestamp = timestamp.toString();
		System.out.println(timestamp);
		ConfigurationManager.getBundle().setProperty("timeStamp", strTimestamp);

		Map<String, Object> params3 = new HashMap<>();
		params3.put("keySequence", "MENU");
		Object result1 = driver.executeScript("mobile:presskey", params3);

		pgs.textClick("Compose Email", "20", "90");

		emailReady = pgs.textFindHaystack("To:", "20", "85", "0%", "0%", "60%", "100%");

		// #################################
		String gmailAddress = "";
		gmailAddress = DeviceUtils.getDeviceProperty("Google Email");

		// Map<String, Object> params2 = new HashMap<>();
		params3.clear();
		params3.put("label", "To:");
		params3.put("text", gmailAddress);
		params3.put("label.direction", "left");
		params3.put("label.offset", "4%");
		params3.put("timeout", "20");
		params3.put("threshold", "90");
		result1 = driver.executeScript("mobile:edit-text:set", params3);

		Map<String, Object> params1 = new HashMap<>();
		params1.put("keySequence", "OK");
		Object result3 = driver.executeScript("mobile:presskey", params1);

		params3.clear();
		params3.put("label", "Subject:");
		params3.put("text", strTimestamp);
		params3.put("label.direction", "left");
		params3.put("label.offset", "4%");
		params3.put("timeout", "20");
		params3.put("threshold", "90");
		Object result2 = driver.executeScript("mobile:edit-text:set", params3);

		params3.clear();
		params3.put("label", "Subject:");
		params3.put("text", strTimestamp);
		params3.put("label.direction", "above");
		params3.put("label.offset", "9%");
		params3.put("timeout", "20");
		params3.put("threshold", "90");
		Object result4 = driver.executeScript("mobile:edit-text:set", params3);

		params3.clear();
		params3.put("keySequence", "MENU");
		driver.executeScript("mobile:presskey", params3);

		pgs.textClickIndex("Send", "20", "90", "2");

	}

	@Given("^I go to Casio Home$")
	public void homeScreen() {
		Map<String, Object> params8 = new HashMap<>();
		Object result8 = driver.executeScript("mobile:handset:ready", params8);

	}
	
	@Given("^I go to 9930 Home$")
	public void homeScreen9930() {
		Map<String, Object> params8 = new HashMap<>();
		Object result8 = driver.executeScript("mobile:handset:ready", params8);

	}

}
