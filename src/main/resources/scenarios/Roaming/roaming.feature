@roaming
Feature: International Roaming
#Sample Test Scenario Description

@roamingiPhoneCH
Scenario: Roaming_iPhone_China
	Then I open phone App on "DUT2"
	Then I open phone App on "DUT1"
	Then I call "DUT2" from "DUT1"
	Then Transaction: "1 Call succeeded?" on Device: "DUT2" Description: "Did DUT2 receive the call?" SLA: "60000" - OCR checkpoint: "Incoming Call" Timeout: "60" Threshold: "90"
	Then I click to end call on "DUT1"
	Then I go to webpage: "google.com" on "DUT1"
	Then Transaction "2 Did Webpage open?" description: "Google webpage opened" SLA: "90000" - OCR Checkpoint: "IMAGES" Timeout: "60" Threshold: "90"
	
	@roamingiPhoneUK
Scenario: Roaming_iPhone_UK
	Then I open phone App on "DUT2"
	Then I close application by name "Contacts"
	Then I open phone App on "DUT1"
	Then I call "DUT2" from "DUT1"
	Then Transaction: "1 Call succeeded?" on Device: "DUT2" Description: "Did DUT2 receive the call?" SLA: "60000" - OCR checkpoint: "Incoming Call" Timeout: "60" Threshold: "90"
	Then I click to end call on "DUT1"
	Then I go to webpage: "google.com" on "DUT1"
	Then Transaction "2 Did Webpage open?" description: "Google webpage opened" SLA: "90000" - OCR Checkpoint: "IMAGE" Timeout: "60" Threshold: "90"
	
	@roamingiPhoneseCA
Scenario: Roaming_iPhoneSE_CA
	Then I open phone App on "DUT2"
	Then I close application by name "Contacts"
	Then I open phone App on "DUT1"
	Then I call "DUT2" from "DUT1"
	Then Transaction: "1 Call succeeded?" on Device: "DUT2" Description: "Did DUT2 receive the call?" SLA: "60000" - OCR checkpoint: "Incoming Call" Timeout: "60" Threshold: "90"
	Then I click to end call on "DUT1"
	Then I go to webpage: "google.com" on "DUT1"
	Then Transaction "2 Did Webpage open?" description: "Google webpage opened" SLA: "90000" - OCR Checkpoint: "IMAGES" Timeout: "60" Threshold: "90"
	
	@roamingiPhoneseMX
Scenario: Roaming_iPhoneSE_MX
	Then I open phone App on "DUT2"
	Then I close application by name "Contacts"
	Then I open phone App on "DUT1"
	Then I call "DUT2" from "DUT1"
	Then Transaction: "1 Call succeeded?" on Device: "DUT2" Description: "Did DUT2 receive the call?" SLA: "60000" - OCR checkpoint: "Incoming Call" Timeout: "60" Threshold: "90"
	Then I click to end call on "DUT1"
	Then I go to webpage: "google.com" on "DUT1"
	Then Transaction "2 Did Webpage open?" description: "Google webpage opened" SLA: "90000" - OCR Checkpoint: "IMAGES" Timeout: "60" Threshold: "90"
	
	@roamingiPhoneCA
Scenario: Roaming_iPhone_Canada
	Then I open phone App on "DUT2"
	Then I close application by name "Contacts"
	Then I open phone App on "DUT1"
	Then I call "DUT2" from "DUT1"
	Then Transaction: "1 Call succeeded?" on Device: "DUT2" Description: "Did DUT2 receive the call?" SLA: "60000" - OCR checkpoint: "Incoming Call" Timeout: "60" Threshold: "90"
	Then I click to end roaming call on "DUT1"
	Then I go to webpage: "google.com" on "DUT1"
	Then Transaction "2 Did Webpage open?" description: "Google webpage opened" SLA: "60000" - OCR Checkpoint: "IMAGES" Timeout: "60" Threshold: "90"

@roamingiPhoneMX
Scenario: Roaming_iPhone_Mexico
	Then I open phone App on "DUT2"
	Then I open phone App on "DUT1"
	Then I call "DUT2" from "DUT1"
	Then Transaction: "1 Call succeeded?" on Device: "DUT2" Description: "Did DUT2 receive the call?" SLA: "60000" - OCR checkpoint: "Incoming Call" Timeout: "30" Threshold: "90"
	Then I click to end call on "DUT1"
	Then I go to webpage: "google.com" on "DUT1"
	Then Transaction "2 Did Webpage open?" description: "Google webpage opened" SLA: "60000" - OCR Checkpoint: "IMAGES" Timeout: "60" Threshold: "90"
	
	
	@roamingGalaxyS10UK
Scenario: Roaming_Galaxy_S10_UK
	Then I toggle wifi "disabled" on "DUT1"
	Then I toggle wifi "disabled" on "DUT2"
	Then I open phone App on "DUT2"
	Then I close application by name "Contacts"
	Then I open phone App on "DUT1"
	Then I call "DUT2" from "DUT1"
	Then Transaction: "1 Call succeeded?" on Device: "DUT2" Description: "Did DUT2 receive the call?" SLA: "60000" - OCR checkpoint: "Incoming Call" Timeout: "30" Threshold: "90"
	Then I click to end call on "DUT1"
	Then I go to webpage: "google.com" on "DUT1"
	Then Transaction "2 Did Webpage open?" description: "Google webpage opened" SLA: "60000" - OCR Checkpoint: "IMAGES" Timeout: "60" Threshold: "90"
	

	@roamingGalaxyS8MX
Scenario: Roaming_Galaxy_S8_Mexico
	Then I toggle wifi "disabled" on "DUT1"
	Then I toggle wifi "disabled" on "DUT2"
	Then I open phone App on "DUT2"
	Then I open phone App on "DUT1"
	Then I call "DUT2" from "DUT1"
	Then Transaction: "1 Call succeeded?" on Device: "DUT2" Description: "Did DUT2 receive the call?" SLA: "60000" - OCR checkpoint: "Incoming Call" Timeout: "30" Threshold: "90"
	Then I click to end call on "DUT1"
	Then I go to webpage: "google.com" on "DUT1"
	Then Transaction "2 Did Webpage open?" description: "Google webpage opened" SLA: "60000" - OCR Checkpoint: "IMAGES" Timeout: "60" Threshold: "90"