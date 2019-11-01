/**
 * 
 */
package com.quantum.steps.VZNav;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Rectangle;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.steps.PerfectoApplicationSteps;
import com.quantum.steps.PerfectoDeviceSteps;
import com.quantum.steps.CommonSteps.PerfectoGenericSteps;
import com.quantum.utils.DeviceUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

@QAFTestStepProvider
public class VZNavStepsPhone {
	QAFExtendedWebDriver driver = new WebDriverTestBase().getDriver();
	QAFExtendedWebElement we;
	VZNavStepsCommon vzsc = new VZNavStepsCommon();
	PerfectoGenericSteps pgs = new PerfectoGenericSteps();

	@Given("^I open VZNav app phone$")
	public void iOpenVZNavAppPhone() throws Exception {
		
		vzsc.cleanAndStartApp(false);

		try {
			we = (QAFExtendedWebElement) driver.findElement("home.gasStation");
			we.waitForPresent(10000);
		} catch (Exception ex) {
			iInitializeVZNavAppPhone();
			vzsc.cleanAndStartApp(false);
		}

		

	}

	@Given("^I initialize VZNav app phone$")
	public void iInitializeVZNavAppPhone() throws Exception {

		vzsc.cleanAndStartApp(false);

		try {
			we = (QAFExtendedWebElement) driver.findElement("splash.letsGo");
			we.waitForPresent(10000);
			we.click();
		} catch (Exception ex) {

		}
		try {
			we = (QAFExtendedWebElement) driver.findElement("splash.skip");
			we.waitForPresent(5000);
			we.click();
		} catch (Exception ex) {

		}
		try {
			we = (QAFExtendedWebElement) driver.findElement("splash.start");
			we.waitForPresent(5000);
			we.click();
		} catch (Exception ex) {

		}

		try {
			we = (QAFExtendedWebElement) driver.findElement("home.helpBox");
			we.waitForPresent(5000);
			we.click();
		} catch (Exception ex) {

		}

	}

	@Given("^I open Gas Stations phone$")
	public void iOpenGasStationsPhone() throws Exception {
		we = (QAFExtendedWebElement) driver.findElement("home.gasStation");
		we.click();

	}
	
	@Given("^I open Gas Stations iOSphone$")
	public void iOpenGasStationsiOSPhone() throws Exception {
		we = (QAFExtendedWebElement) driver.findElement("home.gasStation");
		we.click();

	}

	@Given("^I search for address \"([^\"]*)\" phone$")
	public void iSearchForAddressPhone(String address) throws Exception {
		
		try {
			
		we = (QAFExtendedWebElement) driver.findElement("home.searchBox");
		
		
		} catch (Exception ex) {
			
			//PerfectoGenericSteps pgs = new PerfectoGenericSteps();
			//pgs.textClick("Cancel", "20", "90");
			
			//we = (QAFExtendedWebElement) driver.findElement("home.searchBox");
			
		}
		
		we.click();
		we.sendKeys(address);
		
		if (!pgs.textFindHaystack(address, "10", "80", "0%", "15%", "85%", "100%")) {
			
			/*Map<String, Object> params3 = new HashMap<>();
			params3.put("location", "672,2311");
			Object result3 = driver.executeScript("mobile:touch:tap", params3);*/
			
			
			Map<String, Object> params4 = new HashMap<>();
			params4.put("label", "123");
			params4.put("timeout", "10");
			params4.put("threshold", "90");
			params4.put("screen.top", "79%");
			params4.put("screen.height", "21%");
			params4.put("screen.left", "0%");
			params4.put("screen.width", "100%");
			params4.put("label.direction", "left");
			params4.put("label.offset", "23%");
			Object result4 = driver.executeScript("mobile:button-text:click", params4);
			
			
			
			//driver.getKeyboard().sendKeys(" ");
			
		}


	}

	@Given("^I select dialog \"([^\"]*)\" phone$")
	public void iSelectDialog(String address) throws Exception {
		PerfectoGenericSteps pgs = new PerfectoGenericSteps();
		pgs.textClick(address, "20", "90");

	}
	
	@Given("^I select dialog \"([^\"]*)\" with a haystack defined by x: \"([^\"]*)\" , y: \"([^\"]*)\" , height: \"([^\"]*)\" , width: \"([^\"]*)\"$")
	public void iSelectDialogHaystack(String address, String xstart, String ystart, String height, String width) throws Exception {
		PerfectoGenericSteps pgs = new PerfectoGenericSteps();
		pgs.textClickHaystack(address, "20", "90", xstart, ystart, height, width );

	}
	
	@Given("^I search for POI \"([^\"]*)\" phone$")
	public void iSearchForPOIPhone(String address) throws Exception {
		try {
			
			we = (QAFExtendedWebElement) driver.findElement("home.searchBox");
			
			
			} catch (Exception ex) {
				
				PerfectoGenericSteps pgs = new PerfectoGenericSteps();
				pgs.textClick("Cancel", "20", "90");
				
				we = (QAFExtendedWebElement) driver.findElement("home.searchBox");
				
			}
			
			we.click();
			we.sendKeys(address);
			
			if (!pgs.textFindHaystack(address, "10", "80", "0%", "15%", "85%", "100%")) {
				
				/*Map<String, Object> params3 = new HashMap<>();
				params3.put("location", "672,2311");
				Object result3 = driver.executeScript("mobile:touch:tap", params3);*/
				
				
				Map<String, Object> params4 = new HashMap<>();
				params4.put("label", "123");
				params4.put("timeout", "10");
				params4.put("threshold", "90");
				params4.put("screen.top", "79%");
				params4.put("screen.height", "21%");
				params4.put("screen.left", "0%");
				params4.put("screen.width", "100%");
				params4.put("label.direction", "left");
				params4.put("label.offset", "23%");
				Object result4 = driver.executeScript("mobile:button-text:click", params4);
				
				
				
				//driver.getKeyboard().sendKeys(" ");
				
			}

	}


	@When("^I click on map address \"([^\"]*)\" phone$")
	public void iClickOnAddressPhone(String address) throws Exception {
		PerfectoGenericSteps pgs = new PerfectoGenericSteps();
		pgs.textClick(address, "10", "100");

	}

	@Given("^I click go on route iOSphone$")
	public void iclickGoOnRouteiOSPhone() throws Exception {
		PerfectoGenericSteps pgs = new PerfectoGenericSteps();
		pgs.textClick("Go", "10", "100");
		
	}
	
	@Given("^I click go on route phone$")
	public void iclickGoOnRoutePhone() throws Exception {
		PerfectoGenericSteps pgs = new PerfectoGenericSteps();
		
		
		we = (QAFExtendedWebElement) driver.findElement("routeResult.go");
		we.waitForPresent(10000);
		
		pgs.textClick("Go", "10", "100");
		

		/*we = (QAFExtendedWebElement) driver.findElement("routeResult.go");
		we.waitForPresent(10000);
		Rectangle goButton = we.getRect();
		int x = goButton.getX();
		int y = goButton.getY();
		y = y + goButton.getHeight()/2;
		x = x + goButton.getWidth()/2;
		
		System.out.println("Touching go button " + x + "," + y);
		PerfectoDeviceSteps.touch(x + "," + y);*/
		//we.click();
	}

}
