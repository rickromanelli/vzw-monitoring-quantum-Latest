/**
 * 
 */
package com.quantum.steps.SmartFamily;

import java.text.SimpleDateFormat;
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
public class SmartFamilySteps extends WebDriverTestCase {
	QAFExtendedWebDriver driver = new WebDriverTestBase().getDriver();
	QAFExtendedWebElement we;
	PerfectoGenericSteps pgs = new PerfectoGenericSteps();

	@Given("^I tap to view child \"([^\"]*)\" on \"([^\"]*)\"$")
	public void TapToViewChild(String child, String device) throws Exception {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		if (child.equalsIgnoreCase("1")) {
			we = (QAFExtendedWebElement) driver.findElement("home.child1");
			we.waitForPresent(60000);
			we.click();
			
		} else if (child.equalsIgnoreCase("2")) {
			we = (QAFExtendedWebElement) driver.findElement("home.child2");
			we.waitForPresent(60000);
			we.click();
		} else {
			
		}
		
		
		PerfectoGenericSteps.switchToDriver(driverName);

		
			}
	
	
	
	
	@Given("^I remain on webpage on \"([^\"]*)\"$")
	public void RemainOnWebpage(String device) throws Exception {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		
		PerfectoApplicationSteps.waitFor(60);
			}

	
	
	
	@Given("^I open Smart Family App on \"([^\"]*)\"$")
	public void StartSmartFamily(String device) throws Exception {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		try {
			PerfectoApplicationSteps.closeAppByName("Smart Family");
			PerfectoApplicationSteps.closeAppByName("Smart Family");
		} catch (Exception ex) {

		}
		PerfectoApplicationSteps.startAppByName("Smart Family");
		
		if(pgs.textFind("Aren't working at the moment.", "10", "80")) {
			//fixConnection1();
			throw new Exception("Child device disconnected!");
		}
	}
	
	public void fixConnection1() {
		
		we = (QAFExtendedWebElement) driver.findElement("home.fixbutton");
		we.waitForPresent(20000);
		we.click();
		
		we = (QAFExtendedWebElement) driver.findElement("home.fixConnection");
		we.waitForPresent(20000);
		we.click();
		
		we = (QAFExtendedWebElement) driver.findElement("home.fix.sendText");
		we.waitForPresent(20000);
		we.click();
		
		
	}
	
	@Then("^I click on Friend on \"([^\"]*)\"$")
	public void iClickOnFriend(String device) {
		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);


		
	
	}

	
	@Given("^I send a text on \"([^\"]*)\"$")
	public void sendText(String device) throws Exception {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		try {
			PerfectoApplicationSteps.closeAppByName("Messages");
			PerfectoApplicationSteps.closeAppByName("Messages");
		} catch (Exception ex) {

		}
		PerfectoApplicationSteps.startAppByName("Messages");
		
		pgs.textCheckpoint("Conversations", "30", "90");
		
		we = (QAFExtendedWebElement) driver.findElement("messages.searchButton");
		we.waitForPresent(20000);
		we.click();
		
		System.out.println((QAFExtendedWebElement) getDriver().findElement("messages.searchField"));
		we = (QAFExtendedWebElement) getDriver().findElement("messages.searchField");
		we.waitForPresent(20000);

	
		
			we.sendKeys("Pete");
			
			we = (QAFExtendedWebElement) driver.findElement("messages.pete");
			we.waitForPresent(60000);
			we.click();
			
			
			if (pgs.textFind("Hello", "10", "100")) {
			
			
			
			we = (QAFExtendedWebElement) driver.findElement("messages.menu");
			we.waitForPresent(60000);
			we.click();
			
			////*[@resource-id="com.samsung.android.messaging:id/bubble_list_view"]/android.widget.LinearLayout[2]
			
			
			we = (QAFExtendedWebElement) driver.findElement("messages.deleteMessages");
			we.waitForPresent(60000);
			we.click();
			
			we = (QAFExtendedWebElement) driver.findElement("messages.2ndMessage");
			we.waitForPresent(60000);
			
			
			if (!pgs.textFind("1 Selected", "30", "80")) {
			
			we = (QAFExtendedWebElement) driver.findElement("messages.selectAllToDelete");
			we.waitForPresent(60000);
			we.click();
			
			}
			
			we = (QAFExtendedWebElement) driver.findElement("messages.deleteButton");
			we.waitForPresent(60000);
			we.click();
			

			we = (QAFExtendedWebElement) driver.findElement("messages.moveToTrash");
			we.waitForPresent(60000);
			we.click();
			

			we = (QAFExtendedWebElement) driver.findElement("messages.pete");
			we.waitForPresent(60000);
			we.click();
			
			}
			
			we = (QAFExtendedWebElement) driver.findElement("messages.textField");
			we.waitForPresent(60000);
			
			we.sendKeys("hello, pete");
		
			we = (QAFExtendedWebElement) driver.findElement("messages.sendMessage");
			we.waitForPresent(60000);
			we.click();
			
			we = (QAFExtendedWebElement) driver.findElement("messages.textField");
			we.waitForPresent(60000);
			
			we.sendKeys("hello, pete");
		
			we = (QAFExtendedWebElement) driver.findElement("messages.sendMessage");
			we.waitForPresent(60000);
			we.click();
			
		//PUBLIC:TextDeniedCircle.png

	}

	@Given("^I call a friend on \"([^\"]*)\"$")
	public void callaFriend(String device) throws Exception {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		String phoneApp = "Phone";
		
		try {
			PerfectoApplicationSteps.closeAppByName(phoneApp);
			PerfectoApplicationSteps.closeAppByName(phoneApp);
		} catch (Exception ex) {

		}
		
		PerfectoApplicationSteps.startAppByName(phoneApp);
		
		we = (QAFExtendedWebElement) driver.findElement("call.contacts");
		PerfectoApplicationSteps.waitFor(10);
		if (we.isPresent()) {
			we.click();	
		}
		
		

			
			String contactName = "Pete";
			
			

			we = (QAFExtendedWebElement) driver.findElement("call.contacts.search");
			we.waitForPresent(20000);
			we.click();	
			
			Map<String, Object> params5 = new HashMap<>();
			params5.put("label", "Search");
			params5.put("text", contactName);
			params5.put("screen.top", "0%");
			params5.put("screen.height", "34%");
			params5.put("screen.left", "0%");
			params5.put("screen.width", "100%");
			Object result5 = getDriver().executeScript("mobile:edit-text:set", params5);
			
			we = (QAFExtendedWebElement) driver.findElement("call.contactsResult");
			we.waitForPresent(20000);
			we.click();
			
			PerfectoApplicationSteps.waitFor(3);
			
			
			we = (QAFExtendedWebElement) driver.findElement("call.callButton");
			we.waitForPresent(20000);
			we.click();
		
			



	}

	
	@Given("^I call a forbidden friend on \"([^\"]*)\"$")
	public void callaForbiddenFriend(String device) throws Exception {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		String phoneApp = "Phone";
		
		try {
			PerfectoApplicationSteps.closeAppByName(phoneApp);
			PerfectoApplicationSteps.closeAppByName(phoneApp);
		} catch (Exception ex) {

		}
		
		PerfectoApplicationSteps.startAppByName(phoneApp);
		
		we = (QAFExtendedWebElement) driver.findElement("call.contacts");
		PerfectoApplicationSteps.waitFor(10);
		if (we.isPresent()) {
			we.click();	
		}
		
		

			
			String contactName = "Ted";
			
			

			we = (QAFExtendedWebElement) driver.findElement("call.contacts.search");
			we.waitForPresent(20000);
			we.click();	
			
			Map<String, Object> params5 = new HashMap<>();
			params5.put("label", "Search");
			params5.put("text", contactName);
			params5.put("screen.top", "0%");
			params5.put("screen.height", "34%");
			params5.put("screen.left", "0%");
			params5.put("screen.width", "100%");
			Object result5 = getDriver().executeScript("mobile:edit-text:set", params5);
			
			we = (QAFExtendedWebElement) driver.findElement("call.contactsResult");
			we.waitForPresent(20000);
			we.click();
			
			PerfectoApplicationSteps.waitFor(3);
			
			
			we = (QAFExtendedWebElement) driver.findElement("call.callButton");
			we.waitForPresent(20000);
			we.click();
		
			



	}

	@Given("^I get device time on \"([^\"]*)\"$")
	public void GetDeviceTime(String device) throws Exception {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);

		
		
		LocalTime phoneTime = LocalTime.now();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
       
		
		int currentHour = phoneTime.getHour();
		
		if((currentHour > 14) && (currentHour < 2)) {
			System.out.println("Ok to use phone");
			ConfigurationManager.getBundle().setProperty("freePhoneTime", "YES");
		}
		
	}
	
	

	
	@Then("^I log in to Smart Family on \"([^\"]*)\"$")
	public void iLogInSmartFamily(String device) {

		String driverName = "perfecto";
		if (device.equalsIgnoreCase("dut2")) {
			driverName = "perfecto2";
		}

		PerfectoGenericSteps.switchToDriver(driverName);
		String model = DeviceUtils.getDeviceProperty("model");

		System.out.println((QAFExtendedWebElement) driver.findElement("login.password"));
		we = (QAFExtendedWebElement) driver.findElement("login.password");
		we.waitForPresent(20000);

		we.sendKeys("vzw@$P01");

		if (model.equalsIgnoreCase("Galaxy S5 SM-G900A")) {
			Map<String, Object> params1 = new HashMap<>();
			params1.put("content", "PUBLIC:Prod/SmartFamily/PasswordCompletedS5.png");
			params1.put("timeout", "20");
			params1.put("threshold", "90");
			Object result1 = driver.executeScript("mobile:image:find", params1);

		} else {
			we = (QAFExtendedWebElement) driver.findElement("login.passwordCompleted");
			we.waitForPresent(20000);
		}

		we = (QAFExtendedWebElement) driver.findElement("login.signInButton");
		we.waitForPresent(20000);
		we.click();

	}

}