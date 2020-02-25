/**
 * 
 */
package com.quantum.steps.Contacts;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.steps.PerfectoApplicationSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@QAFTestStepProvider
public class ContactsTurbo extends WebDriverTestCase {
	QAFExtendedWebDriver driver = new WebDriverTestBase().getDriver();
	QAFExtendedWebElement we;


	
	@Given("^I open Contacts Android Phone$")
	public void iOpenContactsAndroidPhone() throws Exception {

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

	@Then("^I delete contact \"([^\"]*)\" Droid Turbo$")
	public void iDeleteContactDroidTurbo(String name) throws InterruptedException {

		
		we = (QAFExtendedWebElement) driver.findElement("contact.search.btn");
		we.waitForPresent(20000);
		we.click();

		we = (QAFExtendedWebElement) driver.findElement("contact.search.box");
		we.waitForPresent(20000);
		we.sendKeys(name);

		while (driver.findElements("contact.resultList").size() != 0) {

			we = (QAFExtendedWebElement) driver.findElement("contact.firstResult");
			we.waitForPresent(20000);
			we.click();

			we = (QAFExtendedWebElement) driver.findElement("contact.more.menu");
			we.waitForPresent(20000);
			we.click();

			we = (QAFExtendedWebElement) driver.findElement("contact.delete.btn");
			we.waitForPresent(20000);
			we.click();

			we = (QAFExtendedWebElement) driver.findElement("contact.deleteConfirm.btn");
			we.waitForPresent(20000);
			we.click();
		}

	}
	
	@Then("^I delete contact \"([^\"]*)\"$")
	public void iDeleteContactLGG5(String name) throws InterruptedException {

		we = (QAFExtendedWebElement) driver.findElement("contact.search.btn");
		we.waitForPresent(20000);
		we.click();

		we = (QAFExtendedWebElement) driver.findElement("contact.search.box");
		we.waitForPresent(20000);
		we.sendKeys(name);
		
		int listSize = driver.findElements("contact.resultList").size();

		we = (QAFExtendedWebElement) driver.findElement("contact.firstResult");
		//we.waitForPresent(20000);
		
		
		//while (driver.findElements("contact.resultList").size() > 1) {
			while(we.isPresent()) {
			
			
		/*	Map<String, Object> params1 = new HashMap<>();
			params1.put("start", "809,450");
			params1.put("end", "869,450");
			params1.put("duration", "1");
			Object result1 = driver.executeScript("mobile:touch:swipe", params1);*/
			
		
			
			//int i = 2;
			//for (i=2; i<10; i++) {
				//we = (QAFExtendedWebElement) driver.findElement("//*[@resource-id='android:id/list']/android.view.ViewGroup[" + i + "]");
				
				we.click();
			//}
			
			we = (QAFExtendedWebElement) driver.findElement("contact.more.menu");
			we.waitForPresent(20000);
			we.click();

			we = (QAFExtendedWebElement) driver.findElement("contact.delete.btn");
			we.waitForPresent(20000);
			we.click();
			
			/*we = (QAFExtendedWebElement) driver.findElement("contact.menuTrashBtn");
			we.waitForPresent(20000);
			we.click();*/

			we = (QAFExtendedWebElement) driver.findElement("contact.deleteConfirm.btn");
			we.waitForPresent(20000);
			we.click();
			
			we = (QAFExtendedWebElement) driver.findElement("contact.firstResult");
			listSize = driver.findElements("contact.resultList").size();
		}


	}

	

	@Then("^I add contact \"([^\"]*)\" Droid Turbo$")
	public void iAddContactDroidTurbo(String name) throws Exception {
		we = (QAFExtendedWebElement) driver.findElement("contact.addContact.btn");
		we.waitForPresent(20000);
		we.click();

		we = (QAFExtendedWebElement) driver.findElement("contact.name.box");
		we.waitForPresent(20000);
		we.sendKeys(name);


		we = (QAFExtendedWebElement) driver.findElement("contact.save.btn");
		we.click();

		we = (QAFExtendedWebElement) driver.findElement("contact.confirm.txt");
		we.waitForPresent(20000);


		if (!we.getText().toString().trim().equals(name.trim())) {
			throw new Exception("Contact not saved");
		}

	}
}
