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
		
		/*if (driverName.equalsIgnoreCase("perfecto")) {
			ConfigurationManager.getBundle().setProperty("dut1", currentDut);
		
		}else if (driverName.equalsIgnoreCase("perfecto2")) {
			
			ConfigurationManager.getBundle().setProperty("dut2", currentDut);
		}*/
		System.out.println("DDDDDDDDDDDDDDDDD: " + currentDut);
		
		switch (currentDut) {
		case "ZY222TQZLT" : ConfigurationManager.getBundle().setProperty("contactName1", "8680");
		break;
		case "ZY222T8SFX" : ConfigurationManager.getBundle().setProperty("contactName1", "7823");
		break;
		case "613539899" : ConfigurationManager.getBundle().setProperty("contactName2", "4058");
		break;
		case "613540154" : ConfigurationManager.getBundle().setProperty("contactName2", "4727");
		break;
		case "ZY222V5TRR": ConfigurationManager.getBundle().setProperty("contactName1", "DroidMini-8858");
		break;
		case "ZY222VGHCR": ConfigurationManager.getBundle().setProperty("contactName1", "DroidMini-9873");
		break;
		case "F5B245F6": ConfigurationManager.getBundle().setProperty("contactName2", "Galaxy-5192");
		break;
		case "60CFAF2A" : ConfigurationManager.getBundle().setProperty("contactName2", "Galaxy-8072");
		break;
		case "990004220676039" : ConfigurationManager.getBundle().setProperty("contactName1", "2830");
		break;
		case "990004220840726" : ConfigurationManager.getBundle().setProperty("contactName1", "0827");
		break;
		case "990004220844769" : ConfigurationManager.getBundle().setProperty("contactName2", "1226");
		break;
		case "990004220846798" : ConfigurationManager.getBundle().setProperty("contactName2", "2831");
		break;
		
		default: break;
		}
	
		System.out.println("Name1:" + ConfigurationManager.getBundle().getString("contactName1"));
		System.out.println("Name2:" + ConfigurationManager.getBundle().getString("contactName2"));
		
	}

}
