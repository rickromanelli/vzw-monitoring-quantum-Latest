/**
 * 
 */
package com.quantum.steps.Push2Talk;

import java.util.HashMap;
import java.util.Map;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.listerners.SplunkHelper;
import com.quantum.steps.PerfectoApplicationSteps;
import com.quantum.steps.CommonSteps.PerfectoGenericSteps;
import com.quantum.utils.DeviceUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

@QAFTestStepProvider
public class Push2TalkStepsCommon extends WebDriverTestCase {
	QAFExtendedWebDriver driver = new WebDriverTestBase().getDriver();
	QAFExtendedWebElement we;
	
	PerfectoGenericSteps pgs = new PerfectoGenericSteps();

	public void cleanAndStartApp(boolean clean) {
		

		if (clean) {
			PerfectoApplicationSteps.cleanAppByName("Push To Talk+");
		}

		try {
			PerfectoApplicationSteps.closeAppByName("Push To Talk+");
			PerfectoApplicationSteps.closeAppByName("Push To Talk+");
		} catch (Exception ex) {

		}
		PerfectoApplicationSteps.startAppByName("Push To Talk+");
	}

	@Given("^I open Push2Talk on \"([^\"]*)\"$")
	public void iOpenPush2TalkAppPhone(String dut) throws Exception {
		String driverName = "perfecto";
		if (dut.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}
		
		PerfectoGenericSteps.switchToDriver(driverName);
		
		//ConfigurationManager.getBundle().setProperty(dut.toLowerCase(), DeviceUtils.getDeviceProperty("deviceID"));
			
	
		cleanAndStartApp(false);
		
	String model = DeviceUtils.getDeviceProperty("model");
		
		//if (model.equalsIgnoreCase("iPhone-7")) {
			
			Map<String, Object> params1 = new HashMap<>();
			params1.put("content", "available");
			params1.put("source", "camera");
			params1.put("timeout", "40");
			params1.put("threshold", "90");
			Object result1 = SplunkHelper.getQAFDriver().executeScript("mobile:checkpoint:text", params1);

			if (result1.toString().contains("true")) {
				
				try {
					we = (QAFExtendedWebElement) driver.findElement("home.missedCall.decline");
					we.waitForPresent(5000);
					we.click();
				} catch (Exception ex2) {

				}

			} else {

				throw new Exception("PTT login failed!");

			}
			
			
	/*	}else {

		try {
			we = (QAFExtendedWebElement) driver.findElement("home.available.txt");
			we.waitForPresent(30000);
		} catch (Exception ex) {
			try {
				we = (QAFExtendedWebElement) driver.findElement("home.missedCall.decline");
				we.waitForPresent(5000);
				we.click();
			} catch (Exception ex2) {

			}
		}
		
		}*/
		
		//Activation Required to be tested next time needed
		
	/*if(pgs.textFind("Activation Required", "30", "90")) {
			
			we = (QAFExtendedWebElement) driver.findElement("home.confirmYes");
			we.waitForPresent(40000);
			we.click();
			
			if(pgs.textFind("Customer Agreement", "30", "90")) {
				pgs.imageClick("PUBLIC:PTTPlusAcceptConditions.png", "30", "90");
				
				if(pgs.textFind("Skip tutorial", "30", "90")) {
					pgs.textClick("Skip tutorial", "30", "90");
				}
			}
			
			
			//PUBLIC:PTTPlusAcceptConditions.png
		}*/
	
		//we = (QAFExtendedWebElement) driver.findElement("home.available.txt");
		//we.waitForPresent(40000);
	
		
		System.out.println("FFFFFFFFFFFFFFFFFFFFF:" + driverName);
		setPTTContactNames(driverName);
	}

	public String getMyContactName(String driverName) {
		return ConfigurationManager.getBundle().getString(driverName + ".myContactName");
	}
	
	public static void setPTTContactNames(String driverName) {

		String currentDut = DeviceUtils.getDeviceProperty("deviceId");
		String dutNum = "";
		if (driverName.equalsIgnoreCase("perfecto")) {
			dutNum = "1";
		
		}else if (driverName.equalsIgnoreCase("perfecto2")) {
			
			dutNum = "2";
		}
		System.out.println("DDDDDDDDDDDDDDDDD: " + currentDut);
		
		switch (currentDut) {
		
		//DuraForce
		case "613539899" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "4058");
		break;
		case "613540154" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "4727");
		break;
		//DuraForcePro2
		case "510000440594" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "5361");
		break;
		case "510000441118" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "5379");
		break;
		case "510000440952" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "6993");
		break;
		
		
		
		//Sonim
		case "B2F1C236" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "2755");
		break;
		case "B526DC05" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "3350");
		break;
		case "4E07C485" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "0738");
		break;
		//S8
		case "988B5C413545374847" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "5140");
		break;
		
		case "988B5C3151455A4B58" : ConfigurationManager.getBundle().setProperty("contactName"  + dutNum, "5192");
		break;
		case "988B5A484145415247" : ConfigurationManager.getBundle().setProperty("contactName"  + dutNum, "9043");
		break;
		//S10
		case "R38MA0KDVAK" : ConfigurationManager.getBundle().setProperty("contactName"  + dutNum, "7823");
		break;
		case "R38MA0KD4JJ" : ConfigurationManager.getBundle().setProperty("contactName"  + dutNum, "8680");
		break;
		//iP7
		
		case "31D4632F6CA8F7417734A08B8E1DF7C1995C0840" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "7493");
		break;
		
		case "C16BF6D623E5F282E53E44EBFE55ED63B6E0B43F" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "9460");
		break;
		//Galaxy A12
		case "R58RA0EDD2N" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "4924");
		break;
		case "R58RA0EE3MJ" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "9460");
		break;
		//iPhone 12 Mini
		case "00008101-000D0C901AB9003A" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "9869");
		break;
		
		case "00008101-001A3424140A001E" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "1379");
		break;
		
		case "00008101-000C75800E80001E" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "1203");
		break;
		
		case "00008101-000545642EF8001E" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "5262");
		break;
		
		case "00008101-000161E82242001E" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "2413");
		break;
		
		
		case "00008101-001A30403402001E" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "5260");
		break;
		default: break;
		
		
		}
	
		System.out.println("Name1:" + ConfigurationManager.getBundle().getString("contactName1"));
		System.out.println("Name2:" + ConfigurationManager.getBundle().getString("contactName2"));
		
	}
	
	@Then("^I click PTTPlus \"([^\"]*)\" on \"([^\"]*)\"$")
	public void iclickPTTPlusGroups(String group, String device) throws Exception {
		
		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);
		
		we = (QAFExtendedWebElement) driver.findElement("home.groups");
		we.waitForPresent(20000);
		we.click();
	
		
		if(group.equalsIgnoreCase("ASP-ONE")) {
			pgs.textClick("ASP-ONE", "20", "100");
		} else { 
			pgs.textClick("ASP-TWO", "20", "100");
		}
		
	}
	
	@Then("^I send PTT message on \"([^\"]*)\"$")
	public void iclickPTTPlusMessage(String device) throws Exception {
		
		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);
		
		//pgs.imageClick("PUBLIC:PTTMessageBtn_DuraFprce.png", "30", "80");
		
		//we = (QAFExtendedWebElement) driver.findElement("call.messagebtn");
		//we.waitForPresent(20000);
		//we.click();
		
		pgs.imageCheckPoint("PUBLIC:messageBtnA12.png", "10", "90", false);
		
		pgs.imageClick("PUBLIC:messageBtnA12.png", "10", "90");
		
		
		
		we = (QAFExtendedWebElement) driver.findElement("call.messageField");
		we.waitForPresent(20000);
		we.click();
		
		we = (QAFExtendedWebElement) driver.findElement("call.messageField");
		we.waitForPresent(20000);
		we.sendKeys("Location");
		
	
		
		String model = DeviceUtils.getDeviceProperty("model");

		if (model.equalsIgnoreCase("Galaxy A12")) {
		
		pgs.imageClick("PUBLIC:A12-messageSendBtn.png", "30", "80");
		}
		
		String deviceModel = DeviceUtils.getDeviceProperty("model");

		Map<String, Object> params2 = new HashMap<>();

		switch (deviceModel) {

		case "iPhone-12 Mini":
			params2.put("label", "PUBLIC:historyBtniPhone12.png");
			break;
		case "Galaxy A12":
			params2.put("label", "PUBLIC:historyBtnA12.png");
			break;

		default:
			break;
		
		}
		
		
	}
	
	@Then("^I send PTT location on \"([^\"]*)\"$")
	public void iclickPTTPlusLocation(String device) throws Exception {
		
		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);
		
		
		//360,255
		
		//pgs.imageClick("PUBLIC:PTTLocationBtn_Sonim.png", "30", "80");
		pgs.imageClick("PUBLIC:PTTLocationBtn_iPhone12Mini.png", "30", "80");
		
		pgs.imageCheckPoint("PUBLIC:LocationSharebtn-iPhone12.png", "10", "90", false);
		
		pgs.imageClick("PUBLIC:LocationSharebtn-iPhone12.png", "10", "90");
		
		
		
		
		
	}
		
	@Then("^I view location on \"([^\"]*)\"$")
	public void iViewPTTPlusLocation(String device) throws Exception {
		
		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);
		
		
		
		
		pgs.imageCheckPoint("PUBLIC:PTTLocationIcon-iPhone.png", "10", "90", false);
		
		pgs.imageClick("PUBLIC:PTTLocationIcon-iPhone.png", "10", "90");
		
		
		
		
		
	}


}
