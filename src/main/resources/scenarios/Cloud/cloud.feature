@cloud
Feature: Cloud Feature 
#Sample Test Scenario Description

@contactSyncDroidTurbo
Scenario: VZCloud_Sync_Android
	#Given I use default driver	
	Then I toggle wifi "disabled"
	Then I open Contacts Android Phone
	Then I delete contact "VZCloud Test"
	Then I open VZCloud app phone
	Then I open cloud menu phone
	Then I go to cloud home phone
	Then I open backup screen phone
	Then I backup phone
	Then I confirm backup phone
	Then I open Contacts Android Phone 
	Then I add contact "VZCloud Test" Droid Turbo
	Then I open VZCloud app phone
	#Then I perform a Splunk transaction using the name "1 Cloud Started?" and description of "Opening cloud app" with an SLA of "60000" - I'm also utilizing an OCR checkpoint for the word "Verizon Cloud" with a timeout of "30" and threshold of "100"
	Then Transaction: "1 Cloud Started?" Description: "Opening cloud app" SLA: "60000" - OCR checkpoint: "Verizon Cloud" Timeout: "30" Threshold: "100"
	Then I open backup screen phone
	Then I backup phone	
	Then Transaction: "2 Contact backup success?" Description: "Confirm backup success" SLA: "60000" - OCR checkpoint: "Everything is backed up" Timeout: "200" Threshold: "100"
	
@contactSyncAndroidPhoneDC3
Scenario: VZCloud_Sync_Android_DC3
	Then I toggle wifi "disabled"
	Then I open Contacts Android Phone
	Then I delete contact "VZCloud Test" 
	Then I open VZCloud app phone
	Then I open cloud menu phone
	Then I go to cloud home phone
	Then I open backup screen phone
	Then I backup phone
	Then I confirm backup phone	
	Then I open Contacts Android Phone
	Then I add contact "VZCloud Test" Droid Turbo	
	Then I open VZCloud app phone	
	Then Transaction: "1 Cloud Started?" Description: "Opening cloud app" SLA: "60000" - OCR checkpoint: "Verizon Cloud" Timeout: "30" Threshold: "100"
	Then I open cloud menu phone
	Then I go to cloud home phone
	Then I open backup screen phone
	Then I backup phone	
	Then Transaction: "2 Contact backup success?" Description: "Confirm backup success" SLA: "60000" - OCR checkpoint: "Everything is backed up" Timeout: "200" Threshold: "100"

	
	
	
	
	
	
	
	
	