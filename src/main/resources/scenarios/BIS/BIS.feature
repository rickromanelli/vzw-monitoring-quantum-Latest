@BIS
Feature: BIS Feature 
#Sample Test Scenario Description

@BISYahoo2Gmail
Scenario: BIS Yahoo2Gmail
	#Given I use default driver	
	Then I open "MESSAGE" App
	Then I delete all BIS emails
	Then I send BIS Email BB7
	Then Transaction: "1: Email Received" Description: "Did the email arrive?" SLA: "60000" - Image checkpoint: "PUBLIC:Prod\BIS\BB_New_Email_Icon.png" Timeout: "200" Threshold: "90"
	Then Transaction: "2: Timestamp in Subject" Description: BIS Timestamp "subject check" SLA: "60000" Timeout: "60" Threshold: "85"
	Then I delete all BIS emails
	
@BISBrowser
Scenario: BB Browser
	#Given I use default driver	
	Then I clear Cache BB7
	Then I open "browser" App
	Then Transaction "1 Browser Open?" description: "Has the browser opened to the search page" SLA: "60000" - OCR Checkpoint: "Type search" Timeout: "30" Threshold: "90"
	Then I browse to "google.com"
	Then Transaction "2 webpage opened" description: "Success connecting to webpage" SLA: "60000" - OCR Checkpoint: "Images" Timeout: "60" Threshold: "90"
	#Then I close the current tab