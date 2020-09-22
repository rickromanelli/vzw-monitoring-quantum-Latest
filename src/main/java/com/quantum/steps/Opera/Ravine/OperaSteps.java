package com.quantum.steps.Opera.Ravine;

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

import cucumber.api.java.en.Given;





@QAFTestStepProvider
public class OperaSteps extends WebDriverTestCase {
	QAFExtendedWebDriver driver = new WebDriverTestBase().getDriver();
	QAFExtendedWebElement we;
	PerfectoGenericSteps pgs = new PerfectoGenericSteps();

	@Given("^I open Opera App$")
	public void startOpera() {
		Map<String, Object> params1 = new HashMap<>();
		params1.put("keySequence", "OK");
		Object result1 = driver.executeScript("mobile:presskey", params1);

		params1.put("keySequence", "LEFT");
		result1 = driver.executeScript("mobile:presskey", params1);

		params1.put("keySequence", "OK");
		result1 = driver.executeScript("mobile:presskey", params1);

		params1.clear();
		params1.put("content", "my web");
		params1.put("timeout", "30");
		params1.put("threshold", "90");
		result1 = driver.executeScript("mobile:checkpoint:text", params1);

	}

	@Given("^I open Brew App$")
	public void StartBrewApp() {
		Map<String, Object> params1 = new HashMap<>();
		params1.put("keySequence", "OK");
		Object result1 = driver.executeScript("mobile:presskey", params1);

		params1.put("keySequence", "5");
		result1 = driver.executeScript("mobile:presskey", params1);

		params1.clear();

		params1.put("keySequence", "1");
		result1 = driver.executeScript("mobile:presskey", params1);

	}
	
	@Given("^I open Tools and Applications$")
	public void ScrollToTools() throws Exception {
		
		Map<String, Object> params1 = new HashMap<>();
		params1.put("keySequence", "DOWN");
		Object result1 = driver.executeScript("mobile:presskey", params1);
		
		for (int i = 0; i < 12; ++i) {
			
			
			params1.put("keySequence", "DOWN");
			result1 = driver.executeScript("mobile:presskey", params1);

		}
		
		if (!pgs.textFindHaystack("Tools", "20", "90", "0%", "0%", "100%", "100%")) {

			for (int i = 0; i < 12; ++i) {
				
				
				params1.put("keySequence", "OK");
				result1 = driver.executeScript("mobile:presskey", params1);

			}

		}

		
		params1.clear();

		
		params1.put("keySequence", "OK");
		result1 = driver.executeScript("mobile:presskey", params1);

		

	}

	@Given("^I load Brew App Catalog$")
	public void LoadBrewAppCatalog() throws Exception {

		Map<String, Object> params1 = new HashMap<>();
		params1.put("keySequence", "UP");
		Object result1 = driver.executeScript("mobile:presskey", params1);

		if (pgs.textFindHaystack("MobileIM", "20", "90", "0%", "0%", "100%", "100%")) {

			params1.put("keySequence", "OK");
			result1 = driver.executeScript("mobile:presskey", params1);

		}

		params1.put("keySequence", "UP");
		result1 = driver.executeScript("mobile:presskey", params1);

		PerfectoApplicationSteps.waitFor(5);

		params1.clear();

		params1.put("keySequence", "OK");
		result1 = driver.executeScript("mobile:presskey", params1);

		if (!pgs.textFindHaystack("Shop Apps", "20", "90", "0%", "0%", "100%", "100%")) {
			params1.clear();
			params1.put("keySequence", "UP");
			result1 = driver.executeScript("mobile:presskey", params1);
			result1 = driver.executeScript("mobile:presskey", params1);
			PerfectoApplicationSteps.waitFor(3);
			params1.clear();
			params1.put("keySequence", "OK");
			result1 = driver.executeScript("mobile:presskey", params1);
			PerfectoApplicationSteps.waitFor(5);
		}

	}

	@Given("^I open ESPN App$")
	public void OpenESPNOpera() throws Exception {
		Map<String, Object> params1 = new HashMap<>();
		params1.put("keySequence", "DOWN");
		Object result1 = driver.executeScript("mobile:presskey", params1);

		params1.put("keySequence", "RIGHT");
		result1 = driver.executeScript("mobile:presskey", params1);

		params1.put("keySequence", "RIGHT");
		result1 = driver.executeScript("mobile:presskey", params1);

		params1.put("keySequence", "OK");
		result1 = driver.executeScript("mobile:presskey", params1);
		
		PerfectoApplicationSteps.waitFor(3);
		
		params1.put("keySequence", "DOWN");
		
		pgs.textFindHaystack("Accessing Secure", "20", "80", "0%", "0%", "100%", "100%");
		
		for (int i = 0; i < 12; ++i) {
			result1 = driver.executeScript("mobile:presskey", params1);
		
		}
		params1.put("keySequence", "OK");
		result1 = driver.executeScript("mobile:presskey", params1);
	}

	@Given("^I open My Web 3 App$")
	public void OpenMW3Opera() {
		Map<String, Object> params1 = new HashMap<>();
		params1.put("keySequence", "DOWN");
		Object result1 = driver.executeScript("mobile:presskey", params1);

		params1.put("keySequence", "OK");
		result1 = driver.executeScript("mobile:presskey", params1);

	}

	@Given("^I go to Casio Home$")
	public void homeScreen() {
		Map<String, Object> params8 = new HashMap<>();
		Object result8 = driver.executeScript("mobile:handset:ready", params8);

	}

}
