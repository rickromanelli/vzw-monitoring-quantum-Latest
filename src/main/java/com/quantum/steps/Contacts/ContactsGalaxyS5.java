/**
 * 
 */
package com.quantum.steps.Contacts;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.steps.PerfectoApplicationSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@QAFTestStepProvider
public class ContactsGalaxyS5 extends WebDriverTestCase {
	QAFExtendedWebDriver driver = new WebDriverTestBase().getDriver();
	QAFExtendedWebElement we;
	
	@Given("^I open Contacts app GalaxyS5$")
	public void iOpenContactsAppGalaxyS5() throws Exception {

		cleanAndStartApp(false);

	}

	public void cleanAndStartApp(boolean clean) {

		if (clean) {
			PerfectoApplicationSteps.cleanAppByName("Contacts");
		}

		try {
			PerfectoApplicationSteps.closeAppByName("Contacts");
			PerfectoApplicationSteps.closeAppByName("Contacts");
		} catch (Exception ex) {

		}
		PerfectoApplicationSteps.startAppByName("Contacts");
	}

	@Then("^I delete contact \"([^\"]*)\" GalaxyS5$")
	public void iDeleteContactGalaxyS5(String name) throws Exception 
	{
		we = (QAFExtendedWebElement) driver.findElement("galaxyS5.home.search.box");
		we.waitForPresent(20000);
		we.click();
		we.sendKeys(name);
		
		
		
		while (driver.findElements("galaxyS5.searchContact.resultList").size() != 0) {

			we = (QAFExtendedWebElement) driver.findElement("galaxyS5.searchContact.firstResult");
			we.waitForPresent(20000);
			we.click();

			we = (QAFExtendedWebElement) driver.findElement("galaxyS5.editContact.more.menu");
			we.waitForPresent(20000);
			we.click();

			we = (QAFExtendedWebElement) driver.findElement("galaxyS5.editContact.delete.btn");
			we.waitForPresent(20000);
			we.click();

			we = (QAFExtendedWebElement) driver.findElement("galaxyS5.editContact.deleteConfirm.btn");
			we.waitForPresent(20000);
			we.click();
		}
		
		
		
		
		
		we = (QAFExtendedWebElement) driver.findElement("galaxyS5.searchContact.confirmDelete.txt");
		
		we.waitForPresent(20000);


		if (!we.getText().toString().trim().equals("No results found")) {
			throw new Exception("Contact not deleted");
		}
		
		
		
		
		
		
		
		
		
		
	}
	
	
	@Then("^I add contact \"([^\"]*)\" GalaxyS5$")
	public void iAddContactGalaxyS5(String name) throws Exception {
		we = (QAFExtendedWebElement) driver.findElement("galaxyS5.home.addContact.btn");
		we.waitForPresent(20000);
		we.click();
		
		
		we = (QAFExtendedWebElement) driver.findElement("galaxyS5.addContact.name.box");
		we.waitForPresent(20000);
		we.sendKeys(name);
		
		we = (QAFExtendedWebElement) driver.findElement("galaxyS5.addContact.save.btn");
		we.waitForPresent(20000);
		we.click();
		
		
		
		try
		{
			we = (QAFExtendedWebElement) driver.findElement("galaxyS5.addContact.confirmDuplicate.txt");
			we.waitForPresent(10000);	
			
			we = (QAFExtendedWebElement) driver.findElement("galaxyS5.addContact.confirmDuplicate.btn");
			we.click();
		}
		catch(Exception ex)
		{
			
		}
		
		
		
		
		we = (QAFExtendedWebElement) driver.findElement("galaxyS5.addContact.confirm.txt");
		we.waitForPresent(20000);


		
	}
	
}
