/**
 * 
 */
package com.quantum.steps.Emergency;

import java.time.LocalTime;
import java.util.Calendar;
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
import com.quantum.utils.DeviceUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.it.Date;

@QAFTestStepProvider
public class EmergencySteps extends WebDriverTestCase {
	QAFExtendedWebDriver driver = new WebDriverTestBase().getDriver();
	QAFExtendedWebElement we;
	PerfectoGenericSteps pgs = new PerfectoGenericSteps();


	@Given("^I send a text to NineTwoTwo")
	public void sendText922() throws Exception {

	
		
		try {
			PerfectoApplicationSteps.closeAppByName("Messages");
			PerfectoApplicationSteps.closeAppByName("Messages");
		} catch (Exception ex) {

		}
		PerfectoApplicationSteps.startAppByName("Messages");
		
		pgs.textCheckpoint("Conversations", "30", "90");
		
		we = (QAFExtendedWebElement) driver.findElement("messages.newMessage");
		we.waitForPresent(60000);
		we.click();
		
		
			
			
			we = (QAFExtendedWebElement) driver.findElement("messages.recipientFrame");
			we.waitForPresent(60000);
			//we.click();
			
			//we.sendKeys("922");
			
			Map<String, Object> params5 = new HashMap<>();
			params5.put("label", "Recipient");
			params5.put("text", "922");
			//params5.put("screen.top", "0%");
			//params5.put("screen.height", "34%");
			//params5.put("screen.left", "0%");
			//params5.put("screen.width", "100%");
			Object result5 = getDriver().executeScript("mobile:edit-text:set", params5);
			
			//iDelete922Messages();
			
			we = (QAFExtendedWebElement) driver.findElement("messages.messageField");
			we.waitForPresent(60000);
			we.click();
			
			Map<String, Object> params6 = new HashMap<>();
			params6.put("label", "Enter Message");
			params6.put("text", "test");
			//params5.put("screen.top", "0%");
			//params5.put("screen.height", "34%");
			//params5.put("screen.left", "0%");
			//params5.put("screen.width", "100%");
			Object result6 = getDriver().executeScript("mobile:edit-text:set", params6);
			
			
			//we.sendKeys("test");
			
			if (pgs.textFind("test", "10", "100")) {
			
			
			
			we = (QAFExtendedWebElement) driver.findElement("messages.sendButton");
			we.waitForPresent(60000);
			we.click();
			
			
			Map<String, Object> params1 = new HashMap<>();
			params1.put("source", "Primary");
			params1.put("key", "PUBLIC:screenshotTest.jpg");
			params1.put("format", "jpg");
			params1.put("report.resolution", "High");
			Object result1 = getDriver().executeScript("mobile:screen:image", params1);
			
		
			
		//PUBLIC:TextDeniedCircle.png

	}

	}
	
	@Then("^I delete All messages")
	public void iDeleteAllMessages() throws Exception {
		
		try {
			PerfectoApplicationSteps.closeAppByName("Messages");
			PerfectoApplicationSteps.closeAppByName("Messages");
		} catch (Exception ex) {

		}
		PerfectoApplicationSteps.startAppByName("Messages");
		
		pgs.textCheckpoint("Conversations", "30", "90");
		
		we = (QAFExtendedWebElement) driver.findElement("messages.noMessages");
		
		
		
		if(we.isPresent()){
			
		} else {

		we = (QAFExtendedWebElement) driver.findElement("messages.deleteAll.hamburger");
		we.waitForPresent(60000);
		we.click();
		
		we = (QAFExtendedWebElement) driver.findElement("messages.deleteAll.delete");
		we.waitForPresent(60000);
		we.click();
		
		
		we = (QAFExtendedWebElement) driver.findElement("messages.deleteAll.deleteAllButton");
		
		
		if(we.isPresent()){
			
			
			
		} else {
			we = (QAFExtendedWebElement) driver.findElement("messages.deleteAll.selectAll");
			we.waitForPresent(60000);
			we.click();
		}
		
		

		
		we = (QAFExtendedWebElement) driver.findElement("messages.deleteAll.deleteAllButton");
		we.waitForPresent(60000);
		we.click();
		
		we = (QAFExtendedWebElement) driver.findElement("messages.move2trashConfirm");
		we.waitForPresent(60000);
		we.click();
		
		}
		
		
		try {
			PerfectoApplicationSteps.closeAppByName("Messages");
			PerfectoApplicationSteps.closeAppByName("Messages");
		} catch (Exception ex) {

		}

	}
	
	@Then("^I delete 922 messages")
	public void iDelete922Messages() throws Exception {
		
		
		

		we = (QAFExtendedWebElement) driver.findElement("messages.menu");
		we.waitForPresent(60000);
		we.click();
		
		we = (QAFExtendedWebElement) driver.findElement("messages.deleteMessages");
		we.waitForPresent(60000);
		we.click();
		
		we = (QAFExtendedWebElement) driver.findElement("messages.selectAll2Delete");
		we.waitForPresent(60000);
		we.click();
		
		
		pgs.textClick("Delete", "20", "100");
		
		we = (QAFExtendedWebElement) driver.findElement("messages.move2trashConfirm");
		we.waitForPresent(60000);
		we.click();
		
		
		/*
		 * Map<String, Object> params6 = new HashMap<>(); params6.put("source",
		 * "Primary"); params6.put("key", "PUBLIC:screenshotTest.jpg");
		 * params6.put("format", "jpg"); params6.put("report.resolution", "High");
		 * //params5.put("screen.left", "0%"); //params5.put("screen.width", "100%");
		 * Object result6 = getDriver().executeScript("mobile:screen:image", params6);
		 */
		

	}

}