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

@QAFTestStepProvider
public class Push2TalkStepsCommon extends WebDriverTestCase {
	QAFExtendedWebDriver driver = new WebDriverTestBase().getDriver();
	QAFExtendedWebElement we;

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
		
		if (model.equalsIgnoreCase("iPhone-7")) {
			
			Map<String, Object> params1 = new HashMap<>();
			params1.put("content", "available");
			params1.put("source", "camera");
			params1.put("timeout", "20");
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
			
			
		}else {

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
		
	
		we = (QAFExtendedWebElement) driver.findElement("home.available.txt");
		we.waitForPresent(20000);
		}
		
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
		//Brig
		case "990004220676039" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "2830");
		break;
		case "990004220840726" : ConfigurationManager.getBundle().setProperty("contactName"  + dutNum, "0827");
		break;
		case "990004220844769" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "1226");
		break;
		case "990004220846798" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "2831");
		break;
		//S8
		case "988B5C413545374847" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "5140");
		break;
		case "988B9A38575930324C" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "4924");
		break;	
		case "988B5C3151455A4B58" : ConfigurationManager.getBundle().setProperty("contactName"  + dutNum, "5192");
		break;
		case "988B5C355456374F48" : ConfigurationManager.getBundle().setProperty("contactName"  + dutNum, "8072");
		break;
		//S10
		case "R38MA0KDVAK" : ConfigurationManager.getBundle().setProperty("contactName"  + dutNum, "7823");
		break;
		case "R38MA0KD4JJ" : ConfigurationManager.getBundle().setProperty("contactName"  + dutNum, "8680");
		break;
		//iP7
		case "9958153C7DC2380B9D68690989B7AC5E973964AB" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "1203");
		break;
		case "31D4632F6CA8F7417734A08B8E1DF7C1995C0840" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "7493");
		break;
		case "FB9D601560B829B2B1AE615B86D5963DA80DE928" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "1379");
		break;
		case "233CFDB6B9E44FCFAC45562D37C92E5B8E84FA88" : ConfigurationManager.getBundle().setProperty("contactName" + dutNum, "9869");
		break;
		default: break;
		}
	
		System.out.println("Name1:" + ConfigurationManager.getBundle().getString("contactName1"));
		System.out.println("Name2:" + ConfigurationManager.getBundle().getString("contactName2"));
		
	}

}
