package com.quantum.listerners;

import java.util.Map.Entry;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.webdriver.CommandTracker;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriverCommandAdapter;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriverCommandListener;
import com.quantum.utils.ConsoleUtils;

public class WebDriverListener extends QAFWebDriverCommandAdapter {

	@Override
	public void beforeCommand(QAFExtendedWebDriver driver, CommandTracker commandHandler) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCommand(QAFExtendedWebDriver driver, CommandTracker commandHandler) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFailure(QAFExtendedWebDriver driver, CommandTracker commandHandler) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeInitialize(Capabilities desiredCapabilities) {
		// TODO Auto-generated method stub
		
		((DesiredCapabilities) desiredCapabilities).setCapability("autoLaunch", false);
        ((DesiredCapabilities) desiredCapabilities).setCapability("fullReset", false);
        ((DesiredCapabilities) desiredCapabilities).setCapability("noReset", false);
        // ((DesiredCapabilities)
        // desiredCapabilities).setCapability(MobileCapabilityType.APP,
        // ConfigurationManager.getBundle().getString("perfecto.capabilities.app.fixed"));
        ConsoleUtils.surroundWithSquare("Starting driver with following Capabilites");
        for (Entry<String, ?> entry : desiredCapabilities.asMap().entrySet()) {
            ConsoleUtils.logInfoBlocks(entry.getKey() + " = " + entry.getValue(), 20);
        }
        //ConfigurationManager.getBundle().addProperty("model", parseModel());
        super.beforeInitialize(desiredCapabilities);

	}

	private Object parseModel() {
		String description = ConfigurationManager.getBundle().getString("perfecto.capabilities.description");
		// TODO Auto-generated method stub - Figure out how to parse
		return null;
	}

	@Override
	public void onInitialize(QAFExtendedWebDriver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onInitializationFailure(Capabilities desiredCapabilities, Throwable t) {
		// TODO Auto-generated method stub

	}

}
