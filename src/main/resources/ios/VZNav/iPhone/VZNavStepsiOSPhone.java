/**
 * 
 */
package com.quantum.steps.VZNav;

import java.awt.Point;

import org.openqa.selenium.Rectangle;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.steps.PerfectoApplicationSteps;
import com.quantum.steps.PerfectoDeviceSteps;
import com.quantum.steps.CommonSteps.PerfectoGenericSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

@QAFTestStepProvider
public class VZNavStepsiOSPhone {
	QAFExtendedWebDriver driver = new WebDriverTestBase().getDriver();
	QAFExtendedWebElement we;
	VZNavStepsCommon vzsc = new VZNavStepsCommon();

	@Given("^I open VZNav app iOSphone$")
	public void iOpenVZNavAppiOSPhone() throws Exception {
		
		vzsc.cleanAndStartApp(false);

		try {
			we = (QAFExtendedWebElement) driver.findElement("vzNav.home.gasStation");
			we.waitForPresent(10000);
		} catch (Exception ex) {
			iInitializeVZNavAppiOSphone();
		}

		vzsc.cleanAndStartApp(false);

	}

	@Given("^I initialize VZNav app iOSphone$")
	public void iInitializeVZNavAppiOSphone() throws Exception {

		vzsc.cleanAndStartApp(true);

		try {
			we = (QAFExtendedWebElement) driver.findElement("vzNav.splash.letsGo");
			we.waitForPresent(10000);
			we.click();
		} catch (Exception ex) {

		}
		try {
			we = (QAFExtendedWebElement) driver.findElement("vzNav.splash.skip");
			we.waitForPresent(5000);
			we.click();
		} catch (Exception ex) {

		}
		try {
			we = (QAFExtendedWebElement) driver.findElement("vzNav.splash.start");
			we.waitForPresent(5000);
			we.click();
		} catch (Exception ex) {

		}

		try {
			we = (QAFExtendedWebElement) driver.findElement("vzNav.home.helpBox");
			we.waitForPresent(5000);
			we.click();
		} catch (Exception ex) {

		}

	}

	@Given("^I open Gas Stations iOSphone$")
	public void iOpenGasStationsiOSphone() throws Exception {
		we = (QAFExtendedWebElement) driver.findElement("vzNav.home.gasStation");
		we.click();

	}

	@Given("^I search for address \"([^\"]*)\" iOSphone$")
	public void iSearchForAddressiOSphone(String address) throws Exception {
		we = (QAFExtendedWebElement) driver.findElement("vzNav.home.searchBox");
		
		we.sendKeys(address);
		we.click();
		//we.sendKeys(" ");

	}

	@Given("^I select dialog \"([^\"]*)\" iOSphone$")
	public void iSelectDialog(String address) throws Exception {
		PerfectoGenericSteps pgs = new PerfectoGenericSteps();
		pgs.textClick(address, "20", "100");

	}

	@When("^I click on map address \"([^\"]*)\" iOSphone$")
	public void iClickOnAddressiOSphone(String address) throws Exception {
		PerfectoGenericSteps pgs = new PerfectoGenericSteps();
		pgs.textClick(address, "10", "100");

	}

	@Given("^I click go on route iOSphone$")
	public void iclickGoOnRouteiOSphone() throws Exception {
		PerfectoGenericSteps pgs = new PerfectoGenericSteps();
		//pgs.textClick("Go", "10", "100");

		we = (QAFExtendedWebElement) driver.findElement("vzNav.routeResult.go");
		we.waitForPresent(10000);
		Rectangle goButton = we.getRect();
		int x = goButton.getX();
		int y = goButton.getY();
		y = y + goButton.getHeight()/2;
		x = x + goButton.getWidth()/2;
		
		System.out.println("Touching go button " + x + "," + y);
		PerfectoDeviceSteps.touch(x + "," + y);
		//we.click();
	}

}
