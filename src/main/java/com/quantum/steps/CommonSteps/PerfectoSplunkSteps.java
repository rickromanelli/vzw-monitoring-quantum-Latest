/**
 * 
 */
package com.quantum.steps.CommonSteps;

import java.util.HashMap;
import java.util.Map;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.quantum.listerners.SplunkHelper;

import cucumber.api.java.en.Then;

@QAFTestStepProvider
public class PerfectoSplunkSteps {

	//@Then("^I perform a Splunk transaction using the name \"([^\"]*)\" and description of \"([^\"]*)\" with an SLA of \"([^\"]*)\" - I'm also utilizing an OCR checkpoint for the word \"([^\"]*)\" with a timeout of \"([^\"]*)\" and threshold of \"([^\"]*)\"$")
	@Then("^Transaction: \"([^\"]*)\" Description: \"([^\"]*)\" SLA: \"([^\"]*)\" - OCR checkpoint: \"([^\"]*)\" Timeout: \"([^\"]*)\" Threshold: \"([^\"]*)\"$")
	public void visualOCRTimer(String name, String desc, String SLA, String text, String timeout, String threshold)
			throws Exception {
		
		startSplunkStep(name, desc);
		//ConfigurationManager.getBundle().setProperty("splunk.transaction.number", transactionNumber);
		Map<String, Object> params1 = new HashMap<>();
		params1.put("content", text);
		params1.put("source", "camera");
		params1.put("timeout", timeout);
		params1.put("measurement", "Rough");
		params1.put("threshold", threshold);
		params1.put("analysis", "automatic");
		Object result1 = SplunkHelper.getQAFDriver().executeScript("mobile:checkpoint:text", params1);

		if (result1.toString().contains("true")) {

		} else {

			throw new Exception("Text not found!");

		}

		SplunkHelper.testStepEnd(Long.parseLong(SLA), name);

	}

	
	@Then("^Transaction: \"([^\"]*)\" on Device: \"([^\"]*)\" Description: \"([^\"]*)\" SLA: \"([^\"]*)\" - OCR checkpoint: \"([^\"]*)\" Timeout: \"([^\"]*)\" Threshold: \"([^\"]*)\"$")
	public void visualOCRTimerMultievice(String name, String device, String desc, String SLA, String text, String timeout, String threshold)
			throws Exception {
		
		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}
		
		PerfectoGenericSteps.switchToDriver(driverName);
		
		startSplunkStep(name, desc);
		//ConfigurationManager.getBundle().setProperty("splunk.transaction.number", transactionNumber);
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

		SplunkHelper.testStepEnd(Long.parseLong(SLA), name);

	}

	@Then("^Transaction: \"([^\"]*)\" Description: BIS Timestamp \"([^\"]*)\" SLA: \"([^\"]*)\" Timeout: \"([^\"]*)\" Threshold: \"([^\"]*)\"$")
	public void visualOCRTimerTimestampString(String name, String desc, String SLA, String timeout, String threshold)
			throws Exception {
		
		String timestamp = ConfigurationManager.getBundle().getPropertyValue("timeStamp");
		startSplunkStep(name, desc);
		//ConfigurationManager.getBundle().setProperty("splunk.transaction.number", transactionNumber);
		Map<String, Object> params1 = new HashMap<>();
		params1.put("content", timestamp);
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

		SplunkHelper.testStepEnd(Long.parseLong(SLA), name);

	}

	public void startSplunkStep(String name, String desc) throws Exception {
		// TODO Auto-generated method stub
		
		String transactionNumber = ConfigurationManager.getBundle().getString("splunk.transaction.number", "1");
		System.out.println("TRANSACTION NUMBER: " + transactionNumber);
		SplunkHelper.testStepStart(name, desc, transactionNumber);
		//transactionNumber = String.valueOf(Integer.getInteger(transactionNumber) + 1);
		int intTransactionNumber = (Integer.parseInt(transactionNumber) + 1);
		ConfigurationManager.getBundle().setProperty("splunk.transaction.number", Integer.toString(intTransactionNumber));
		
		
	}

	@Then("^Transaction \"([^\"]*)\" description: \"([^\"]*)\" SLA: \"([^\"]*)\" - OCR Checkpoint: \"([^\"]*)\" Timeout: \"([^\"]*)\" Threshold: \"([^\"]*)\"$")
	public void visualOCRTimerShort(String name, String desc, String SLA, String text, String timeout, String threshold)
			throws Exception {

		//SplunkHelper.testStepStart(name, desc);
		startSplunkStep(name, desc);
		Map<String, Object> params1 = new HashMap<>();
		params1.put("content", text);
		params1.put("source", "camera");
		params1.put("timeout", timeout);
		//params1.put("measurement", "accurate");
		params1.put("threshold", threshold);
		//params1.put("analysis", "automatic");
		Object result1 = SplunkHelper.getQAFDriver().executeScript("mobile:checkpoint:text", params1);

		if (result1.toString().contains("true")) {

		} else {

			throw new Exception("Text not found!");

		}

		SplunkHelper.testStepEnd(Long.parseLong(SLA), name);

	}
	
	//on Device: \"([^\"]*)\"
	
	
	
	@Then("^Transaction: \"([^\"]*)\" on \"([^\"]*)\" Description: \"([^\"]*)\" SLA: \"([^\"]*)\" - Image checkpoint: \"([^\"]*)\" Timeout: \"([^\"]*)\" Threshold: \"([^\"]*)\"$")
	public void visualImageTimer2Device(String name, String device, String desc, String SLA, String repo, String timeout, String threshold)
			throws Exception {
		
		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}
		
		PerfectoGenericSteps.switchToDriver(driverName);

		//SplunkHelper.testStepStart(name, desc);
		startSplunkStep(name, desc);
		Map<String, Object> params1 = new HashMap<>();
		params1.put("content", repo);
		//params1.put("match", "identical");
		//params1.put("source", "camera");
		//params1.put("measurement", "accurate");
		params1.put("timeout", timeout);
		params1.put("threshold", threshold);
		Object result1 = SplunkHelper.getQAFDriver().executeScript("mobile:checkpoint:image", params1);
		//System.out.println("SomethingXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
		if (result1.toString().contains("true")) {

		} else {

			throw new Exception("Image not found!");

		}

		SplunkHelper.testStepEnd(Long.parseLong(SLA), name);

	}
	
	@Then("^Transaction: \"([^\"]*)\" Description: \"([^\"]*)\" SLA: \"([^\"]*)\" - Image checkpoint: \"([^\"]*)\" Timeout: \"([^\"]*)\" Threshold: \"([^\"]*)\"$")
	public void visualImageTimer(String name, String desc, String SLA, String repo, String timeout, String threshold)
			throws Exception {
		
	

		//SplunkHelper.testStepStart(name, desc);
		startSplunkStep(name, desc);
		Map<String, Object> params1 = new HashMap<>();
		params1.put("content", repo);
		//params1.put("match", "identical");
		//params1.put("source", "camera");
		//params1.put("measurement", "accurate");
		params1.put("timeout", timeout);
		params1.put("threshold", threshold);
		Object result1 = SplunkHelper.getQAFDriver().executeScript("mobile:checkpoint:image", params1);
		//System.out.println("SomethingXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
		if (result1.toString().contains("true")) {

		} else {

			throw new Exception("Image not found!");

		}

		SplunkHelper.testStepEnd(Long.parseLong(SLA), name);

	}
	@Then("^Transaction: \"([^\"]*)\" Description: \"([^\"]*)\" SLA: \"([^\"]*)\" Volume: \"([^\"]*)\" Timeout: \"([^\"]*)\" Duration: \"([^\"]*)\"$")
	public void audioCheckpointTimer(String name, String desc, String SLA, String volume, String timeout, String duration)
			throws Exception {

		//SplunkHelper.testStepStart(name, desc);
		startSplunkStep(name, desc);
		Map<String, Object> params1 = new HashMap<>();
		
		params1.put("volume", volume);
		params1.put("timeout", timeout);
		params1.put("duration", duration);
		Object result1 = SplunkHelper.getQAFDriver().executeScript("mobile:checkpoint:audio", params1);
		
		if(!result1.toString().equals("true"))
		{
			throw new Exception("Audio wasn't received");
		}

	
		SplunkHelper.testStepEnd(Long.parseLong(SLA), name);

	}

	//@Then("^I perform a negative Image checkpoint for the Image \"([^\"]*)\" with a timeout of \"([^\"]*)\" and a threshold of \"([^\"]*)\"$")
	
	public boolean imageNegativeCheckPoint(String name, String desc, String repo, String SLA, String threshold, boolean assertImage)
			throws Exception {
		
		//SplunkHelper.testStepStart(name, desc);
		startSplunkStep(name, desc);
		Object result1 = null;
		
		Map<String, Object> params1 = new HashMap<>();
		
		params1.put("match", "bounded");
		params1.put("imageBounds.needleBound", "15");
		params1.put("content", repo);
		params1.put("threshold", threshold);
		
		for (int i = 0; i < 4; i++) {
			
		
			try {
			result1 = SplunkHelper.getQAFDriver().executeScript("mobile:image:find", params1);
			} catch(Exception e) {
				e.printStackTrace();
			}
			if (!result1.toString().contains("true") && i >= 4) {
				break;
			}
		}
		SplunkHelper.testStepEnd(Long.parseLong(SLA), name);
		
		if (result1.toString().contains("true")) {
			if (assertImage) {
				throw new Exception("Image found!");
			}
			return true;
		} else {
			return false;
			
		}
		
		
	}


}
