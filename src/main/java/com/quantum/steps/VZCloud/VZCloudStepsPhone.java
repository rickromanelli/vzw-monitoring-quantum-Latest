/**
 * 
 */
package com.quantum.steps.VZCloud;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.steps.CommonSteps.PerfectoGenericSteps;

import cucumber.api.java.en.Then;

@QAFTestStepProvider
public class VZCloudStepsPhone {
	QAFExtendedWebDriver driver = new WebDriverTestBase().getDriver();
	QAFExtendedWebElement we;

	@Then("^I open cloud menu phone$")
	public void iOpenCloudMenuPhone() {
		we = (QAFExtendedWebElement) driver.findElement("menu.btn");
		we.waitForPresent(20000);
		we.click();
	}
	
	@Then("^I go to cloud home phone$")
	public void iGoToCloudHomePhone()
	{
		we = (QAFExtendedWebElement) driver.findElement("menu.home.btn");
		we.waitForPresent(20000);
		we.click();
		
		we = (QAFExtendedWebElement) driver.findElement("home.title");
		we.waitForPresent(20000);
		
		
	}

	@Then("^I open backup screen phone$")
	public void iopenbackupscreenPhone() throws Exception {
		we = (QAFExtendedWebElement) driver.findElement("menu.backupScreen");
		we.waitForPresent(20000);
		we.click();



		
	}
	
	@Then("^I backup phone$")
	public void ibackupPhone() throws Exception {
		we = (QAFExtendedWebElement) driver.findElement("menu.backupNow");
		we.waitForPresent(20000);
		we.click();



		
	}
	
	@Then("^I confirm backup phone$")
	public void iConfirmBackupPhone() throws Exception
	{
		PerfectoGenericSteps pgs = new PerfectoGenericSteps();
		pgs.textCheckpoint("Everything is backed up", "400", "100");
	}

}
