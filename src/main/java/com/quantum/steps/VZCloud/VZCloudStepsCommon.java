/**
 * 
 */
package com.quantum.steps.VZCloud;

import java.util.HashMap;
import java.util.Map;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.steps.PerfectoApplicationSteps;
import com.quantum.steps.CommonSteps.PerfectoGenericSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

@QAFTestStepProvider
public class VZCloudStepsCommon extends WebDriverTestCase {
	QAFExtendedWebDriver driver = new WebDriverTestBase().getDriver();
	PerfectoGenericSteps pgs = new PerfectoGenericSteps();
	PerfectoApplicationSteps pas = new PerfectoApplicationSteps();
	QAFExtendedWebElement we;

	public void cleanAndStartApp(boolean clean) {

		if (clean) {
			PerfectoApplicationSteps.cleanAppByName("Cloud");
		}

		try {
			PerfectoApplicationSteps.closeAppById("com.vcast.mediamanager");
			PerfectoApplicationSteps.closeAppById("com.vcast.mediamanager");
		} catch (Exception ex) {

		}
		PerfectoApplicationSteps.startAppByName("com.vcast.mediamanager");
	}

	@Given("^I open VZCloud app phone$")
	public void iOpenCloudAppPhone() throws Exception {

		cleanAndStartApp(false);

		we = (QAFExtendedWebElement) driver.findElement("home.home");
		we.waitForPresent(20000);
		we.click();

	}

	@Then("^I verify backup$")
	public void iVerifyBackup() {
		PerfectoGenericSteps pgs = new PerfectoGenericSteps();
		try {
			pgs.textCheckpoint("All your files are uploaded", "400", "100");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^I backup phone from cloud app$")
	public void ibackupPhone() throws Exception {

		PerfectoGenericSteps pgs = new PerfectoGenericSteps();

		if (pgs.textFind("Upload now", "10", "100")) {

			we = (QAFExtendedWebElement) driver.findElement("menu.backupNow");
			we.waitForPresent(20000);
			we.click();

			PerfectoApplicationSteps.waitFor(5);

			if (pgs.textFind("Just so you know", "10", "80")) {

				we = (QAFExtendedWebElement) driver.findElement("menu.wifiWarning.yes");
				we.waitForPresent(20000);
				we.click();
			}
		}


	}

	@Given("^I delete photos in VZCloud$")
	public void iDeletePhotosCloud() throws Exception {

		we = (QAFExtendedWebElement) driver.findElement("home.library");
		we.waitForPresent(20);
		we.click();

		we = (QAFExtendedWebElement) driver.findElement("library.photosnVideos");
		we.waitForPresent(20);
		we.click();

		// pgs.textClick("Photos & Videos", "30", "90");
		if (!pgs.textFind("No Photos", "8", "80")) {

			// pas.wait(5);
			pgs.textFind("Flashbacks", "30", "90");

			while (pgs.textFind("2022", "8", "70")) {

				we = (QAFExtendedWebElement) driver.findElement("photos.menu");
				we.waitForPresent(20);
				we.click();

				we = (QAFExtendedWebElement) driver.findElement("photos.select");
				we.waitForPresent(20);
				we.click();

				we = (QAFExtendedWebElement) driver.findElement("photos.photo1");
				we.waitForPresent(20);
				we.click();

				/*
				 * Map<String, Object> params1 = new HashMap<>(); params1.put("location",
				 * "221,1016"); Object result1 = driver.executeScript("mobile:touch:tap",
				 * params1);
				 */
				/*
				 * try { we = (QAFExtendedWebElement) driver.findElement("photos.selectmenu");
				 * we.waitForPresent(20); we.click(); } catch (Exception e) { // TODO
				 * Auto-generated catch block e.printStackTrace(); }
				 */

				we = (QAFExtendedWebElement) driver.findElement("photos.trashcan");
				we.waitForPresent(20);
				we.click();

				pgs.textFind("MOVE TO TRASH", "30", "70");
				pgs.textClick("MOVE TO TRASH", "30", "70");

				pas.waitFor(8);

			}

			we = (QAFExtendedWebElement) driver.findElement("photos.back");
			we.waitForPresent(20);
			we.click();

			pgs.textClick("Trash", "30", "70");

			pas.waitFor(4);

			if (!pgs.textFind("Trash is Empty", "10", "80")) {
				we = (QAFExtendedWebElement) driver.findElement("photos.menu");
				we.waitForPresent(20);
				we.click();

				pgs.textClick("Empty Trash", "30", "70");
				pgs.textFind("DELETE ALL", "30", "70");
				pgs.textClick("DELETE ALL", "30", "70");
			}

		}

		/*
		 * we = (QAFExtendedWebElement) driver.findElement("home.menu");
		 * we.waitForPresent(20); we.click();
		 * 
		 * we = (QAFExtendedWebElement) driver.findElement("home.home");
		 * we.waitForPresent(20); we.click();
		 */

	}

	@Given("^I backup photos from Cloud$")
	public void backupPhotosCloud() throws Exception {

		pas.closeAppByIdIgnoreExceptions("com.vcast.mediamanager");
		pas.closeAppByIdIgnoreExceptions("com.vcast.mediamanager");

		pas.startAppById("com.vcast.mediamanager");

		we = (QAFExtendedWebElement) driver.findElement("menu.btn");
		we.waitForPresent(30000);
		we.click();

		we = (QAFExtendedWebElement) driver.findElement("menu.home");
		we.waitForPresent(30000);
		we.click();

		we = (QAFExtendedWebElement) driver.findElement("menu.backupScreen");
		we.waitForPresent(30000);
		we.click();

		we = (QAFExtendedWebElement) driver.findElement("menu.backupNow");
		we.waitForPresent(30000);
		we.click();

		/*
		 * pgs.textClickHaystack("Pictures", "20", "80", "0%", "70%", "30%", "100%");
		 * 
		 * if (!pgs.textFind("No pictures", "8", "95")) {
		 * 
		 * we = (QAFExtendedWebElement) driver.findElement("gallery.menu");
		 * we.waitForPresent(20); we.click();
		 * 
		 * we = (QAFExtendedWebElement) driver.findElement("photos.menu.cloud");
		 * we.waitForPresent(20); we.click();
		 * 
		 * we = (QAFExtendedWebElement) driver.findElement("menu.btn");
		 * we.waitForPresent(30000); we.click();
		 * 
		 * we = (QAFExtendedWebElement) driver.findElement("menu.home");
		 * we.waitForPresent(30000); we.click();
		 * 
		 * we = (QAFExtendedWebElement) driver.findElement("home.title");
		 * we.waitForPresent(30000);
		 * 
		 * 
		 * we = (QAFExtendedWebElement) driver.findElement("menu.backupScreen");
		 * we.waitForPresent(30000); we.click();
		 * 
		 * we = (QAFExtendedWebElement) driver.findElement("menu.backupNow");
		 * we.waitForPresent(30000); we.click();
		 * 
		 * 
		 * 
		 * 
		 * 
		 * }
		 * 
		 */

	}

	@Given("^I take photos in Camera$")
	public void iTakePhotosCamera() throws Exception {
		pas.closeAppByIdIgnoreExceptions("com.sec.android.app.camera");
		pas.closeAppByIdIgnoreExceptions("com.sec.android.app.camera");

		pas.startAppById("com.sec.android.app.camera");
		pas.waitFor(3);
		pgs.textCheckpoint("Portrait", "20", "80");
		pas.waitFor(3);
		Map<String, Object> params2 = new HashMap<>();
		params2.put("keySequence", "VOL_DOWN");
		Object result2 = driver.executeScript("mobile:presskey", params2);
		result2 = driver.executeScript("mobile:presskey", params2);

	}

	@Given("^I delete photos in Gallery$")
	public void iDeletePhotosGallery() throws Exception {

		/*
		 * pas.closeAppById("com.sec.android.gallery3d");
		 * pas.closeAppById("com.sec.android.gallery3d");
		 * pas.startAppById("com.sec.android.gallery3d");
		 */

		PerfectoApplicationSteps.closeAppByName("Gallery");
		PerfectoApplicationSteps.closeAppByName("Gallery");
		PerfectoApplicationSteps.startAppByName("Gallery");

		PerfectoApplicationSteps.waitFor(4);

		pgs.textClickHaystack("Pictures", "20", "80", "0%", "70%", "30%", "100%");

		if (!pgs.textFind("No pictures", "8", "95")) {

			we = (QAFExtendedWebElement) driver.findElement("gallery.menu");
			we.waitForPresent(20);
			we.click();

			/*
			 * pgs.textClick("Photos & Videos", "30", "90"); // pas.wait(5);
			 * pgs.textFind("Flashbacks", "30", "90");
			 * 
			 * while (!pgs.textFind("No Photos", "8", "80")) {
			 * 
			 * we = (QAFExtendedWebElement) driver.findElement("gallery.menu.edit");
			 * we.waitForPresent(20); we.click();
			 * 
			 */
			// if
			// (!pgs.imageFindHaystack("PUBLIC:Prod/Cloud/AllPhotosSelectedGallery-S10.png",
			// "10", "90", "0", "0", "100%", "100%")) {
			we = (QAFExtendedWebElement) driver.findElement("gallery.select.all");
			we.waitForPresent(20);
			we.click();
			// }

			we = (QAFExtendedWebElement) driver.findElement("gallery.edit.delete");
			we.waitForPresent(20);
			we.click();

			pgs.textFind("Move to Trash", "30", "90");
			pgs.textClick("Move to Trash", "30", "90");

			pas.waitFor(6);

		}

		we = (QAFExtendedWebElement) driver.findElement("gallery.menuLower");
		we.waitForPresent(20);
		we.click();

		pgs.textClick("Trash", "30", "70");

		pas.waitFor(4);

		if (pgs.textFind("Empty", "10", "70")) {
			pgs.textClick("Empty", "10", "70");
		}
		if (pgs.textFind("Empty Trash", "10", "70")) {
			pgs.textClick("Empty Trash", "10", "70");

		}

		pas.waitFor(4);

		we = (QAFExtendedWebElement) driver.findElement("gallery.trash.back");
		we.waitForPresent(20);
		we.click();

	}
	/*
	 * we = (QAFExtendedWebElement) driver.findElement("home.menu");
	 * we.waitForPresent(20); we.click();
	 * 
	 * we = (QAFExtendedWebElement) driver.findElement("home.home");
	 * we.waitForPresent(20); we.click();
	 */

}
