/**
 * 
 */
package com.quantum.steps.Gizmo;

import java.util.HashMap;

import java.util.Map;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.listerners.SplunkHelper;
import com.quantum.steps.PerfectoApplicationSteps;
import com.quantum.steps.CommonSteps.PerfectoGenericSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



@QAFTestStepProvider
public class GizmoStepsCommon {
	QAFExtendedWebDriver driver = new WebDriverTestBase().getDriver();
	QAFExtendedWebElement we;
	PerfectoGenericSteps pgs = new PerfectoGenericSteps();
	
	@When("^I initialize Gizmo app")
	public void InitializeGizmoApp() throws Exception {

		try {
			PerfectoApplicationSteps.closeAppByName("GizmoHub");
			PerfectoApplicationSteps.closeAppByName("GizmoHub");
		} catch (Exception ex) {

		}
		PerfectoApplicationSteps.startAppByName("GizmoHub");

	}
	
	@When("^I click to show location Phone")
	public void showLocationGizmoApp() throws Exception {
		
		//we = (QAFExtendedWebElement) driver.findElement("menu.maps.button");
		//we.click();
		
		pgs.imageClick("PUBLIC:GalaxyA12-locateButton.png", "20", "85");
	}
	
	@When("^I click to show location iPhone")
	public void showLocationiPhoneGizmoApp() throws Exception {
		
		pgs.imageClick("PUBLIC:Prod/Gizmo/iPhonelocateButton.png", "20", "85");
		
	}
	
	@When("^I search for Child Phone")
	public void SearchForChildGizmoApp() throws Exception {
		
		//we = (QAFExtendedWebElement) driver.findElement("maps.locate.button");
		//we.click();
		
		pgs.imageClick("PUBLIC:Prod/Gizmo/iPhonelocateButton.png", "20", "85");
		
		//textCheckpoint("look", "20", "90");
		//we = (QAFExtendedWebElement) driver.findElement("maps.locate.button");
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
	
	}
	