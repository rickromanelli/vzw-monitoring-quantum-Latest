package com.quantum.listerners;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.IMethodSelector;
import org.testng.IMethodSelectorContext;
import org.testng.ITestNGMethod;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.client.TestNGScenario;


public class ScenarioSelector implements IMethodSelector{
	Log logger = LogFactory.getLog(ScenarioSelector.class);
	@Override
	public boolean includeMethod(IMethodSelectorContext context, ITestNGMethod method, boolean isTestMethod) {
		// TODO Auto-generated method stub
		// reference scenario name and remove unwanted
		
		logger.debug("Applying Method Filter:" + method.getMethodName() + " is Testngscenario " + (method instanceof TestNGScenario));
        if (method instanceof TestNGScenario) {
            String[] scenarios = method.getGroups();
        
            for(int i = 0; i < scenarios.length; i++) {
            	
            	if(!scenarios[i].equalsIgnoreCase(ConfigurationManager.getBundle().getString("monitorTag"))) {
            		
            		 context.setStopped(true);
                     return false;
            	} else {
            		logger.info("********** Adding "+ method.getMethodName() + " to test suite.");
            		return true;
            	}
            }
        } 
        return true;
	}

	@Override
	public void setTestMethods(List<ITestNGMethod> arg0) {
		// TODO Auto-generated method stub
		
	}

}
