package com.quantum.listerners;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.HttpClient;
import org.apache.commons.collections.functors.SwitchTransformer;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.commons.io.IOUtils;

import com.google.gson.*;
import com.perfecto.reportium.client.ReportiumClient;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.core.TestBaseProvider;
import com.qmetry.qaf.automation.ui.UiDriver;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.quantum.steps.CommonSteps.PerfectoGenericSteps;

public class TestListener implements ISuiteListener, ITestListener {

	private static final String SECURITY_TOKEN = System.getProperty("security-token");
	private static final String CQL_NAME = System.getProperty("CQL_NAME", "vzw"); // TODO put your Continuous Quality
																					// Lab name here
	private static final String REPORTING_SERVER_URL = "https://" + CQL_NAME + ".reporting.perfectomobile.com";

	@Override
	public void onTestSuccess(ITestResult testResult) {

		setDetails("Pass", testResult);

	}

	@Override
	public void onTestFailure(ITestResult testResult) {

		setDetails("Fail", testResult);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		setDetails("Skip", result);
	}

	public void setDetails(String result, ITestResult testResult) {

		// TO DO Find a better way to understand what driver we are using.

		// QAFTestBase qtb = QAFTestBase();
		// String cDriver = TestBaseProvider.instance().get().getBrowser();
		String currentDriver = TestBaseProvider.instance().get().getBrowser();
		String executionID = (String) SplunkHelper.getQAFDriver().getCapabilities().getCapability("executionId");
		String executionID2 = "";
		String devicePhNum = "";
		String devicePhNum2 = "";
		String deviceID1 = (String) SplunkHelper.getQAFDriver().getCapabilities().getCapability("deviceName");
		String deviceID2 = "";

		System.out.println("########@@@@@@--DRIVER!!!!!!!!!!!!!!" + currentDriver);

		if (currentDriver.contains("perfecto2")) {
			executionID2 = executionID;
			deviceID2 = deviceID1;
			PerfectoGenericSteps.storePhNumber("perfecto2");
			PerfectoGenericSteps.storeDeviceID("perfecto2");
			PerfectoGenericSteps.switchToDriver("perfecto");

			PerfectoGenericSteps.storePhNumber("perfecto");
			PerfectoGenericSteps.storeDeviceID("perfecto");
			executionID = (String) SplunkHelper.getQAFDriver().getCapabilities().getCapability("executionId");

		} else {

			PerfectoGenericSteps.storePhNumber("perfecto");
			PerfectoGenericSteps.storeDeviceID("perfecto");
			if (ConfigurationManager.getBundle().getString("deviceCount").equals("2")) {

				PerfectoGenericSteps.switchToDriver("perfecto2");
				PerfectoGenericSteps.storeDeviceID("perfecto2");
				executionID2 = (String) SplunkHelper.getQAFDriver().getCapabilities().getCapability("executionId");
			}
		}

		SplunkHelper.getCollector().reporting.put("testStatus", result);

		SplunkHelper.getCollector().reporting.put("className",
				testResult.getMethod().getInstance().getClass().getName());

		try {
			SplunkHelper.getCollector().reporting.put("hostName", InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!result.equalsIgnoreCase("Skip")) {

			SplunkHelper.getCollector().reporting.put("model", (String) SplunkHelper.getDeviceInfo("model"));
			SplunkHelper.getCollector().reporting.put("device", (String) SplunkHelper.getDeviceInfo("deviceID"));
			SplunkHelper.getCollector().reporting.put("os", (String) SplunkHelper.getDeviceInfo("os"));
			SplunkHelper.getCollector().reporting.put("location", (String) SplunkHelper.getDeviceInfo("location"));
			SplunkHelper.getCollector().reporting.put("description",
					(String) SplunkHelper.getDeviceInfo("description"));
			SplunkHelper.getCollector().reporting.put("vzwTeam", ConfigurationManager.getBundle().getString("vzwTeam"));
			SplunkHelper.getCollector().reporting.put("Device1PhNum",
					ConfigurationManager.getBundle().getString("phNum1"));
			SplunkHelper.getCollector().reporting.put("Device2PhNum",
					ConfigurationManager.getBundle().getString("phNum2"));
			SplunkHelper.getCollector().reporting.put("DeviceCount",
					ConfigurationManager.getBundle().getString("deviceCount"));
			SplunkHelper.getCollector().reporting.put("deviceID1",
					ConfigurationManager.getBundle().getString("deviceID1"));
			SplunkHelper.getCollector().reporting.put("deviceID2",
					ConfigurationManager.getBundle().getString("deviceID2"));
			try {
				SplunkHelper.getCollector().reporting.put("monitorTag", (String) SplunkHelper.getMonitorTag());
			} catch (Exception ex) {

			}
		}

	

		if (!result.equalsIgnoreCase("Skip")) {
			// Sets the end time of the test
			// Divides the start and end time to create a test duration in
			// seconds
			// and finally converts the start/end time to real date formats
			SplunkHelper.getCollector().testExecutionEnd();
		}

		SplunkHelper.getCollector().reporting.put("testName", testResult.getTestContext().getName());
		SplunkHelper.getCollector().reporting.put("methodName", testResult.getMethod().getMethodName());

		SplunkHelper.getCollector().reporting.put("executionID", executionID);
		SplunkHelper.getCollector().reporting.put("executionID2", executionID2);

		// (String)
		// SplunkHelper.getQAFDriver().getCapabilities().getCapability("executionId"));
		SplunkHelper.getCollector().reporting.put("reportKey",
				(String) SplunkHelper.getQAFDriver().getCapabilities().getCapability("reportKey"));
		SplunkHelper.getCollector().reporting.put("perfectoReport",
				"https://" + getBundle().getPropertyValue("host")
						+ "/nexperience/Report.html?reportId=SYSTEM%3Adesigns%2Freport&key="
						+ (String) SplunkHelper.getQAFDriver().getCapabilities().getCapability("reportKey").toString()
								.replace(".xml", "")
						+ "%2Exml&liveUrl=rtmp%3A%2F%2F" + getBundle().getPropertyValue("host").replace(".", "%2E")
						+ "%2Fengine&appUrl=https%3A%2F%2F" + getBundle().getPropertyValue("host").replace(".", "%2E")
						+ "%2Fnexperience");
		/*
		 * SplunkHelper.getCollector().reporting.put("windTunnelReport", (String)
		 * SplunkHelper.getQAFDriver().getCapabilities().getCapability(
		 * "windTunnelReportUrl"));
		 */

		ReportiumClient rc = (ReportiumClient) ConfigurationManager.getBundle().getObject("perfecto.report.client");
		SplunkHelper.getCollector().reporting.put("reportiumReport", rc.getReportUrl());
		// PerfectoGenericSteps.

		SplunkHelper.getCollector().submitReporting(testResult.getMethod().getMethodName());

	}

	public void setGroupName() {
		String[] vzwTeamMapArray = ConfigurationManager.getBundle().getString("vzw.group.map").split("\\|");

		String vzwTeam = "";
		for (int i = 0; i < vzwTeamMapArray.length; i++) {

			String[] vzwTeamMap = vzwTeamMapArray[i].split("\\:");
			String team = ConfigurationManager.getBundle().getPropertyValue("app");
			String currentTeam = vzwTeamMap[0].toString();

			if (currentTeam.equalsIgnoreCase(team)) {
				vzwTeam = vzwTeamMap[1];
				ConfigurationManager.getBundle().setProperty("vzwTeam", vzwTeam);
				break;
			}

		}
	}

	@Override
	public void onFinish(ISuite arg0) {
		try {
			System.out.println(SplunkHelper.getCollector().commitSplunk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onStart(ISuite arg0) {
		SplunkHelper.setSplunk();
		ConfigurationManager.getBundle().addProperty("dut1", "12345");
		ConfigurationManager.getBundle().addProperty("dut2", "56789");
		ConfigurationManager.getBundle().addProperty("contactName1", "12345");
		ConfigurationManager.getBundle().addProperty("contactName2", "56789");
		ConfigurationManager.getBundle().addProperty("phNum1", "1111111111");
		ConfigurationManager.getBundle().addProperty("phNum2", "No second device used");
		ConfigurationManager.getBundle().addProperty("deviceCount", "1");
		ConfigurationManager.getBundle().addProperty("deviceID1", "none");
		ConfigurationManager.getBundle().addProperty("deviceID2", "none");
		ConfigurationManager.getBundle().addProperty("contactDesc1", "none");
		ConfigurationManager.getBundle().addProperty("contactDesc2", "none");
		ConfigurationManager.getBundle().addProperty("reportURL2", "none");

		setGroupName();

	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		SplunkHelper.getCollector().testExecutionStart();

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		SplunkHelper.setSplunk();
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		JsonObject executions1 = null;
		JsonObject executions2 = null;

		String executionID1 = (String) SplunkHelper.getCollector().reporting.get("executionID");
		String executionID2 = (String) SplunkHelper.getCollector().reporting.get("executionID2");

		List<JsonObject> executions = new ArrayList<>();

		System.out.println(executionID1);
		System.out.println(executionID2);
		try {

			executions1 = retrieveTestExecutions(executionID1);
			if (!executionID2.equals("")) {
				executions2 = retrieveTestExecutions(executionID2);

			}

			executions.add(executions1);

			if (!executionID2.equals("")) {

				executions.add(executions2);
			}

		} catch (InterruptedException | URISyntaxException | IOException e) {
			// TODO Auto-generated catch block
		}

		String errorMessage = "";
		for (int i = 0; i < executions.size(); i++) {

			JsonArray resources = executions.get(i).getAsJsonArray("resources");
			if (resources.size() == 0) {
				System.out.println("there are no test executions for that period of time");
			} else {
				// loop to check for available
				JsonObject testExecution = resources.get(0).getAsJsonObject();

				// Retrieves a list of commands of a single test (as a json)
				// retrieveTestCommands(testExecution);

				// Download video
				
				
				String videoLink = "";
				String videoLinks = "";
				String reportURL = "";
				
				
				try {
					videoLinks = downloadVideos(testExecution);
					reportURL = getReportURL(testExecution);
					errorMessage = (errorMessage.isEmpty()||errorMessage.equalsIgnoreCase("Test Passed!"))?getErrorMessage(testExecution):errorMessage;
					SplunkHelper.getCollector().reporting.put("errorDetails", errorMessage);
					/* errorMessage = getErrorMessage(testExecution);
					  
					if (i == 0) {
						SplunkHelper.getCollector().reporting.put("errorDetails", errorMessage);
						
					} else if (i==1) {
						if (getErrorMessage(testExecution).equalsIgnoreCase("Test Passed!")) {
						errorMessage = getErrorMessage(testExecution);
						SplunkHelper.getCollector().reporting.put("errorDetails", errorMessage);
						} else {
							
						}
					}*/
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}

				String videoName = "";
				String reportName = "";

				String[] videoNames = videoLinks.split("\\|");
				
				
				for (int j=0; j< videoNames.length; j++) {
					videoName = (j == 1) ? "video2" : ("video");
					//reportName = (j == 1) ? "reportURL2" : ("reportURL");
					//errorMessage = (i == 1) ? ""

					System.out.println("index: " + j + "Video: " + videoName);
					
					SplunkHelper.getCollector().reporting.put(videoName, videoLinks.split("\\|")[j]);
				}
			
				SplunkHelper.getCollector().reporting.put("reportURL", reportURL);
				
			}
		}

	}

	/*
	 * JsonArray resources = executions.getAsJsonArray("resources"); if
	 * (resources.size() == 0) {
	 * System.out.println("there are no test executions for that period of time"); }
	 * else { //loop to check for available JsonObject testExecution =
	 * resources.get(0).getAsJsonObject();
	 * 
	 * // Retrieves a list of commands of a single test (as a json) //
	 * retrieveTestCommands(testExecution);
	 * 
	 * // Download video downloadVideo(testExecution);
	 */

	private static JsonObject retrieveTestExecutions(String executionID)
			throws URISyntaxException, IOException, InterruptedException {
		URIBuilder uriBuilder = new URIBuilder(REPORTING_SERVER_URL + "/export/api/v1/test-executions");

		// Optional: Filter by range. In this example: retrieve test executions of the
		// past month (result may contain tests of multiple driver executions)
		/*
		 * uriBuilder.addParameter("startExecutionTime[0]",
		 * Long.toString(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(12)));
		 * uriBuilder.addParameter("endExecutionTime[0]",
		 * Long.toString(System.currentTimeMillis()));
		 */

		uriBuilder.addParameter("externalId[0]", executionID);

		// Optional: Filter by a specific driver execution ID that you can obtain at
		// script execution
		// uriBuilder.addParameter("externalId[0]", "SOME_DRIVER_EXECUTION_ID");
		// uriBuilder.addParameter("tags[0]", tags);

		HttpGet getExecutions = new HttpGet(uriBuilder.build());
		addDefaultRequestHeaders(getExecutions);
		HttpClient httpClient = HttpClientBuilder.create().build();
		
		System.out.println(getExecutions.getURI().toString());

		JsonObject executions = null;
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		for (int i = 0; i < 20; i++) {
			HttpResponse getExecutionsResponse = httpClient.execute(getExecutions);

			try (InputStreamReader inputStreamReader = new InputStreamReader(
					getExecutionsResponse.getEntity().getContent())) {

				String response = IOUtils.toString(inputStreamReader);
				try {
					executions = gson.fromJson(response, JsonObject.class);
					JsonObject metadata = executions.getAsJsonObject("metadata");
					String status = metadata.get("processingStatus").getAsString();
					if (status.equalsIgnoreCase("Processing_complete")) {

						break;

					} else {
						Thread.sleep(3000);
						continue;
					}

				} catch (JsonSyntaxException e) {
					throw new RuntimeException("Unable to parse response: " + response);
				}
			}

		}
		System.out.println("\nList of test executions response:\n" + gson.toJson(executions));

		return executions;
	}

	private static void retrieveTestCommands(JsonObject testExecution) throws URISyntaxException, IOException {
		String testId = testExecution.get("id").getAsString();
		HttpGet getCommands = new HttpGet(
				new URI(REPORTING_SERVER_URL + "/export/api/v1/test-executions/" + testId + "/commands"));
		addDefaultRequestHeaders(getCommands);
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpResponse getCommandsResponse = httpClient.execute(getCommands);
		try (InputStreamReader inputStreamReader = new InputStreamReader(
				getCommandsResponse.getEntity().getContent())) {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			JsonObject commands = gson.fromJson(IOUtils.toString(inputStreamReader), JsonObject.class);
			System.out.println("\nList of commands response:\n" + gson.toJson(commands));
		}
	}

	// add
	private static String downloadVideo(JsonObject testExecution) throws IOException, URISyntaxException {
		JsonArray videos = testExecution.getAsJsonArray("videos");
		String downloadVideoUrl = "";
		if (videos.size() > 0) {
			JsonObject video = videos.get(0).getAsJsonObject();
			downloadVideoUrl = video.get("downloadUrl").getAsString();
			String format = "." + video.get("format").getAsString();
			String testId = testExecution.get("id").getAsString();
			// downloadFile(testId, URI.create(downloadVideoUrl), format, "video");
		} else {
			System.out.println("\nNo videos found for test execution");
			downloadVideoUrl = "No videos found for test execution";
		}
		return downloadVideoUrl;
	}
	
	private static String downloadVideos(JsonObject testExecution) throws IOException, URISyntaxException {
		JsonArray videos = testExecution.getAsJsonArray("videos");
		
		String downloadVideoUrl = "";
		if (videos.size() > 0) {
			
			for(int i = 0; i< videos.size(); i++) {
				
			
				JsonObject video = videos.get(i).getAsJsonObject();
				if (!downloadVideoUrl.isEmpty()) {
					downloadVideoUrl = downloadVideoUrl + "|";
				}
				downloadVideoUrl = downloadVideoUrl + video.get("downloadUrl").getAsString();
				String format = "." + video.get("format").getAsString();
				String testId = testExecution.get("id").getAsString();
				// downloadFile(testId, URI.create(downloadVideoUrl), format, "video");
			}
		} else {
			System.out.println("\nNo videos found for test execution");
			downloadVideoUrl = "No videos found for test execution";
		}
		return downloadVideoUrl;
	}

	private static String getErrorMessage(JsonObject testExecution) throws IOException, URISyntaxException {
		// String resourcesJSon = testExecution.getAsJsonObject("message");
		String errorMessage = "";

		if (testExecution.has("message")) {
			errorMessage = testExecution.get("message").getAsString();
			errorMessage = errorMessage.split("Exception:")[1];
			//errorMessage = errorMessage.split("\\\n")[0];
			String errorPoint = testExecution.get("message").getAsString();
			System.out.println("Point: " + errorPoint);
			System.out.println("error: " + errorMessage);
			errorPoint = errorPoint.split("\\\n")[0];
			
			

			
			//errorMessage = errorPoint + " ~ " + errorMessage;
			errorMessage = errorPoint;
			
			
			System.out.println("full error message: " + errorMessage);

		} else {
			if(testExecution.has("status")) {
				String status = testExecution.get("status").getAsString();
				if(status.equalsIgnoreCase("FAILED") || status.equalsIgnoreCase("UNKNOWN")) {
					errorMessage = "Error unknown.";
				} else {
					errorMessage = "Test Passed!";
				}
			}
			
		}

		/*
		 * if (resourcesJSon.size() > 0) { JsonObject message =
		 * resourcesJSon.get(0).getAsJsonObject(); errorMessage =
		 * message.get("message").getAsString(); String format = "." +
		 * message.get("format").getAsString(); String testId =
		 * testExecution.get("id").getAsString(); // downloadFile(testId,
		 * URI.create(downloadVideoUrl), format, "video"); } else {
		 * System.out.println("\nNo data found for test execution"); errorMessage =
		 * "No data found for test execution"; }
		 */
		return errorMessage;
	}

	private static String getReportURL(JsonObject testExecution) throws IOException, URISyntaxException {
		String reportURL = "No report found for test execution";
		if (testExecution.has("reportURL")) {
			reportURL = testExecution.get("reportURL").getAsString();
		} else {
			System.out.println("\nNo report found for test execution");
		}

		return reportURL;
	}

	private static void downloadAttachments(JsonObject testExecution) throws IOException, URISyntaxException {
		// Example for downloading device logs
		JsonArray artifacts = testExecution.getAsJsonArray("artifacts");
		for (JsonElement artifactElement : artifacts) {
			JsonObject artifact = artifactElement.getAsJsonObject();
			String artifactType = artifact.get("type").getAsString();
			if (artifactType.equals("NETWORK")) {
				// if (artifactType.equals("DEVICE_LOGS")) {
				String testId = testExecution.get("id").getAsString();
				String path = artifact.get("path").getAsString();
				URIBuilder uriBuilder = new URIBuilder(path);
				downloadFile(testId, uriBuilder.build(), ".zip", "network files");
			}
		}
	}

	// Utils

	private static void downloadFile(String fileName, URI uri, String suffix, String description) throws IOException {
		downloadFileToFS(new HttpGet(uri), fileName, suffix, description);
	}

	private static void downloadFileToFS(HttpGet httpGet, String fileName, String suffix, String description)
			throws IOException {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpResponse response = httpClient.execute(httpGet);
		FileOutputStream fileOutputStream = null;
		try {
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
				Path file = Files.createTempFile(fileName, suffix);
				fileOutputStream = new FileOutputStream(file.toFile());
				IOUtils.copy(response.getEntity().getContent(), fileOutputStream);
				System.out.println("\nSaved " + description + " to: " + file.toFile().getAbsolutePath());
			} else {
				String errorMsg = IOUtils.toString(response.getEntity().getContent(), Charset.defaultCharset());
				System.err.println(
						"Error downloading file. Status: " + response.getStatusLine() + ".\nInfo: " + errorMsg);
			}
		} finally {
			EntityUtils.consumeQuietly(response.getEntity());
			IOUtils.closeQuietly(fileOutputStream);
		}
	}

	private static void addDefaultRequestHeaders(HttpRequestBase request) {
		
		System.out.println(SECURITY_TOKEN);
		if (SECURITY_TOKEN == null || SECURITY_TOKEN.equals("MY_CONTINUOUS_QUALITY_LAB_SECURITY_TOKEN")) {
			throw new RuntimeException("Invalid security token '" + SECURITY_TOKEN + "'. Please set a security token");
		}
		request.addHeader("PERFECTO_AUTHORIZATION", SECURITY_TOKEN);
	}
}
