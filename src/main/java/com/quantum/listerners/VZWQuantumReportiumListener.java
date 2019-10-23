//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.quantum.listerners;

import com.perfecto.reportium.WebDriverProvider;
import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.model.CustomField;
import com.perfecto.reportium.model.Job;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.model.Project;
import com.perfecto.reportium.model.PerfectoExecutionContext.PerfectoExecutionContextBuilder;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResultFactory;
import com.perfecto.reportium.testng.ReportiumTestNgListener;
import com.qmetry.qaf.automation.core.CheckpointResultBean;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.core.TestBaseProvider;
import com.qmetry.qaf.automation.keys.ApplicationProperties;
import com.qmetry.qaf.automation.step.QAFTestStepListener;
import com.qmetry.qaf.automation.step.StepExecutionTracker;
import com.qmetry.qaf.automation.step.client.TestNGScenario;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.quantum.listeners.PerfectoDriverListener;
import com.quantum.utils.ConsoleUtils;
import com.quantum.utils.ReportUtils;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.RuntimeOptionsFactory;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class VZWQuantumReportiumListener extends ReportiumTestNgListener implements QAFTestStepListener, ITestListener {
	public static final String PERFECTO_REPORT_CLIENT = "perfecto.report.client";

	public VZWQuantumReportiumListener() {
	}

	public static ReportiumClient getReportClient() {
		return (ReportiumClient) ConfigurationManager.getBundle().getObject("perfecto.report.client");
	}

	public void onStart(ITestContext context) {
		if (ConfigurationManager.getBundle().getString("remote.server", "").contains("perfecto")) {
			List<String> stepListeners = ConfigurationManager.getBundle()
					.getList(ApplicationProperties.TESTSTEP_LISTENERS.key);
			if (!stepListeners.contains(this.getClass().getName())) {
				stepListeners.add(this.getClass().getName());
				ConfigurationManager.getBundle().setProperty(ApplicationProperties.TESTSTEP_LISTENERS.key,
						stepListeners);
			}

			if (ConfigurationManager.getBundle().getBoolean("perfecto.default.driver.listener", true)) {
				List<String> driverListeners = ConfigurationManager.getBundle()
						.getList(ApplicationProperties.WEBDRIVER_COMMAND_LISTENERS.key);
				if (!driverListeners.contains(PerfectoDriverListener.class.getName())) {
					driverListeners.add(PerfectoDriverListener.class.getName());
					ConfigurationManager.getBundle().setProperty(ApplicationProperties.WEBDRIVER_COMMAND_LISTENERS.key,
							driverListeners);
				}
			}
		}

	}

	public void onTestStart(ITestResult testResult) {
		if (ConfigurationManager.getBundle().getString("remote.server", "").contains("perfecto")) {
			this.createReportiumClient(testResult).testStart(testResult.getMethod().getMethodName(),
					new TestContext(testResult.getMethod().getGroups()));
		}

	}

	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		if (method.isTestMethod()) {
			ConsoleUtils.surroundWithSquare("TEST STARTED: " + this.getTestName(testResult)
					+ (testResult.getParameters().length > 0 ? " [" + testResult.getParameters()[0] + "]" : ""));
		}

	}

	public void beforExecute(StepExecutionTracker stepExecutionTracker) {
		String msg = "BEGIN STEP: " + stepExecutionTracker.getStep().getDescription();
		ConsoleUtils.logInfoBlocks(msg, ConsoleUtils.lower_block + " ", 10);
		logStepStart(stepExecutionTracker.getStep().getDescription());
	}

	public void afterExecute(StepExecutionTracker stepExecutionTracker) {
		logStepEnd();
		String msg = "END STEP: " + stepExecutionTracker.getStep().getDescription();
		ConsoleUtils.logInfoBlocks(msg, ConsoleUtils.upper_block + " ", 10);
	}

	public void onFailure(StepExecutionTracker stepExecutionTracker) {
	}

	public void onTestSuccess(ITestResult testResult) {
		ReportiumClient client = getReportClient();

		// String testStopTag = "Failure reason test";
		CustomField testStopCustomField = new CustomField("reportURL2",
				ConfigurationManager.getBundle().getString("reportURL2"));

		// Code for the test end checking
		// stopping the test - failure
		TestContext testContextEnd = new TestContext.Builder().withCustomFields(testStopCustomField).build();
		// client.testStop(TestResultFactory.createFailure(expectedFailureMessage, new
		// RuntimeException(eMessage), failReason), testContextEnd);

		if (null != client) {
			// client.testStop(TestResultFactory.createSuccess());
			client.testStop(TestResultFactory.createSuccess(), testContextEnd);
			this.logTestEnd(testResult);
		}

	}

	public void onTestFailure(ITestResult testResult) {
		ReportiumClient client = getReportClient();

		CustomField testStopCustomField = new CustomField("reportURL2",
				ConfigurationManager.getBundle().getString("reportURL2"));

		// Code for the test end checking
		// stopping the test - failure
		TestContext testContextEnd = new TestContext.Builder().withCustomFields(testStopCustomField).build();

		if (null != client) {
			String failMsg = "";
			List<CheckpointResultBean> checkpointsList = ((QAFTestBase) TestBaseProvider.instance().get())
					.getCheckPointResults();
			Iterator var5 = checkpointsList.iterator();

			while (var5.hasNext()) {
				CheckpointResultBean result = (CheckpointResultBean) var5.next();
				if (result.getType().equals(MessageTypes.TestStepFail.toString())) {
					failMsg = failMsg + "Step:" + result.getMessage() + " failed\n";
				}
			}

			

			// client.testStop(TestResultFactory.createFailure(failMsg.isEmpty() ? "An error
			// occurred" : failMsg, testResult.getThrowable()), testContextEnd);
			// Note: Adding the TestContext to the testStop is optional.

			client.testStop(TestResultFactory.createFailure(failMsg.isEmpty() ? "An error occurred" : failMsg,
					testResult.getThrowable()), testContextEnd);
			this.logTestEnd(testResult);
		}

	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onFinish(ITestContext context) {
	}

	public static void logTestStep(String message) {
		try {
			getReportClient().stepStart(message);
		} catch (Exception var2) {
			;
		}

	}

	public static void logStepStart(String message) {
		try {
			getReportClient().stepStart(message);
		} catch (Exception var2) {
			;
		}

	}

	public static void logStepEnd() {
		try {
			getReportClient().stepEnd();
		} catch (Exception var1) {
			;
		}

	}

	public static void logAssert(String message, boolean status) {
		try {
			getReportClient().reportiumAssert(message, status);
		} catch (Exception var3) {
			;
		}

	}

	private void logTestEnd(ITestResult testResult) {
		String endText = "TEST " + (testResult.isSuccess() ? "PASSED" : "FAILED") + ": ";
		this.addReportLink(testResult, getReportClient().getReportUrl());
		ConsoleUtils.logWarningBlocks(
				"REPORTIUM URL: " + getReportClient().getReportUrl().replace("[", "%5B").replace("]", "%5D"));
		ConsoleUtils.surroundWithSquare(endText + this.getTestName(testResult)
				+ (testResult.getParameters().length > 0 ? " [" + testResult.getParameters()[0] + "]" : ""));
	}

	protected String getTestName(ITestResult result) {
		return result.getTestName() == null ? result.getMethod().getMethodName() : result.getTestName();
	}

	protected ReportiumClient createReportiumClient(ITestResult testResult) {
		ReportiumClient reportiumClient = (new ReportiumClientFactory()).createLoggerClient();
		String suiteName = testResult.getTestContext().getSuite().getName();
		String prjName = ConfigurationManager.getBundle().getString("project.name", suiteName);
		String prjVer = ConfigurationManager.getBundle().getString("project.ver", "1.0");
		String xmlTestName = testResult.getTestContext().getName();
		String vzwGroup = ConfigurationManager.getBundle().getString("vzwGroup", "no group");
		String app = ConfigurationManager.getBundle().getString("app", "no app");
		String[] exTags = new String[] { suiteName, xmlTestName, vzwGroup, app };
		Object testInstance = testResult.getInstance();
		WebDriver driver = null;
		if (testInstance instanceof WebDriverTestCase) {
			driver = (WebDriver) ((WebDriverTestCase) testInstance).getDriver();
		} else if (testInstance instanceof WebDriverProvider) {
			driver = ((WebDriverProvider) testInstance).getWebDriver();
		}

		if (driver != null) {
			PerfectoExecutionContext perfectoExecutionContext = ((PerfectoExecutionContextBuilder) ((PerfectoExecutionContextBuilder) ((PerfectoExecutionContextBuilder) (new PerfectoExecutionContextBuilder())
					.withProject(new Project(prjName, prjVer))).withContextTags(exTags))
							.withJob(new Job(ConfigurationManager.getBundle().getString("JOB_NAME"),
									ConfigurationManager.getBundle().getInt("BUILD_NUMBER", 0)))).withWebDriver(driver)
											.build();
			reportiumClient = (new ReportiumClientFactory()).createPerfectoReportiumClient(perfectoExecutionContext);
		}

		ConfigurationManager.getBundle().setProperty("perfecto.report.client", reportiumClient);
		return reportiumClient;
	}

	protected String[] getTags(ITestResult testResult) {
		RuntimeOptions cucumberOptions = this.getCucumberOptions(testResult);
		List<String> optionsList = (List) cucumberOptions.getFilters().stream().map((object) -> {
			return Objects.toString(object, (String) null);
		}).collect(Collectors.toList());
		optionsList.addAll(cucumberOptions.getFeaturePaths());
		optionsList.addAll(cucumberOptions.getGlue());
		return (String[]) ArrayUtils.addAll(super.getTags(testResult),
				optionsList.toArray(new String[optionsList.size()]));
	}

	private RuntimeOptions getCucumberOptions(ITestResult testResult) {
		try {
			return (new RuntimeOptionsFactory(Class.forName(testResult.getTestClass().getName()))).create();
		} catch (ClassNotFoundException var3) {
			var3.printStackTrace();
			return null;
		}
	}

	private void addReportLink(ITestResult result, String url) {
		((TestNGScenario) result.getMethod()).getMetaData().put("Perfecto-report",
				"<a href=\"" + url + "\" target=\"_blank\">view</a>");
	}
}
