@roaming
Feature: International Roaming
#Sample Test Scenario Description

@roamingiPhoneCH
Scenario: Roaming_iPhone_China
	Then I open phone App on "DUT2"
	Then I open phone App on "DUT1"
	Then I call "DUT2" from "DUT1"
	Then Transaction: "1 Call succeeded?" on Device: "DUT2" Description: "Did DUT2 receive the call?" SLA: "60000" - OCR checkpoint: "incoming call" Timeout: "60" Threshold: "90"
	Then I click to end call on "DUT1"
	Then I go to webpage: "google.com" on "DUT1"
	Then Transaction "2 Did Webpage open?" description: "Google webpage opened" SLA: "90000" - OCR Checkpoint: "IMAGES" Timeout: "60" Threshold: "90"
	
	@roamingiPhoneUK
Scenario: Roaming_iPhone_UK
	Then I open phone App on "DUT2"
	Then I open phone App on "DUT1"
	Then I call "DUT2" from "DUT1"
	Then Transaction: "1 Call succeeded?" on Device: "DUT2" Description: "Did DUT2 receive the call?" SLA: "60000" - OCR checkpoint: "incoming call" Timeout: "60" Threshold: "90"
	Then I click to end call on "DUT1"
	Then I go to webpage: "google.com" on "DUT1"
	Then Transaction "2 Did Webpage open?" description: "Google webpage opened" SLA: "90000" - OCR Checkpoint: "IMAGES" Timeout: "60" Threshold: "90"
	
	@roamingiPhoneseCA
Scenario: Roaming_iPhoneSE_CA
	Then I open phone App on "DUT2"
	Then I open phone App on "DUT1"
	Then I call "DUT2" from "DUT1"
	Then Transaction: "1 Call succeeded?" on Device: "DUT2" Description: "Did DUT2 receive the call?" SLA: "60000" - OCR checkpoint: "incoming call" Timeout: "60" Threshold: "90"
	Then I click to end call on "DUT1"
	Then I go to webpage: "google.com" on "DUT1"
	Then Transaction "2 Did Webpage open?" description: "Google webpage opened" SLA: "90000" - OCR Checkpoint: "IMAGES" Timeout: "60" Threshold: "90"
	
@roamingZ30CH
Scenario: Roaming_V20_China
	Then I open phone App on "DUT2"
	Then I open phone App on "DUT1"
	Then I call "DUT2" from "DUT1"
	Then Transaction: "1 Call succeeded?" on Device: "DUT2" Description: "Did DUT2 receive the call?" SLA: "60000" - OCR checkpoint: "incoming call" Timeout: "60" Threshold: "90"
	Then I click to end call on "DUT1"
	Then I go to webpage: "google.com" on "DUT1"
	Then Transaction "2 Did Webpage open?" description: "Google webpage opened" SLA: "60000" - OCR Checkpoint: "IMAGES" Timeout: "60" Threshold: "90"
	
	
	@roamingiPhoneCA
Scenario: Roaming_iPhone_Canada
	Then I open phone App on "DUT2"
	Then I open phone App on "DUT1"
	Then I call "DUT2" from "DUT1"
	Then Transaction: "1 Call succeeded?" on Device: "DUT2" Description: "Did DUT2 receive the call?" SLA: "60000" - OCR checkpoint: "incoming call" Timeout: "60" Threshold: "90"
	Then I click to end roaming call on "DUT1"
	Then I go to webpage: "google.com" on "DUT1"
	Then Transaction "2 Did Webpage open?" description: "Google webpage opened" SLA: "60000" - OCR Checkpoint: "offered in" Timeout: "60" Threshold: "90"

@roamingMotoZCA
Scenario: Roaming_Moto_Z_Canada
	#Then I go to the device home screen
	Then I open phone App on "DUT2"
	Then I open phone App on "DUT1"
	Then I call "DUT2" from "DUT1"
	Then Transaction: "1 Call succeeded?" on Device: "DUT2" Description: "Did DUT2 receive the call?" SLA: "60000" - OCR checkpoint: "incoming call" Timeout: "60" Threshold: "90"
	Then I click to end call on "DUT1"
	Then I go to webpage: "google.com" on "DUT1"
	Then Transaction "2 Did Webpage open?" description: "Google webpage opened" SLA: "60000" - OCR Checkpoint: "offered in" Timeout: "60" Threshold: "90"
	
	
	@roamingBB7_BR
Scenario: Roaming_9930_BR
	#Then I open contacts App on "DUT1"
	Then I open phone App on "DUT1"
	Then I open phone App on "DUT2"
	Then I call "DUT2" from "DUT1"
	#Then Transaction: "1 Call succeeded?" on Device: "DUT2" Description: "Did DUT2 receive the call?" SLA: "60000" - OCR checkpoint: "incoming call" Timeout: "30" Threshold: "90"
	#Then I click to end call on "DUT1"
	#Then I clear cache on "DUT1"
	#Then I go to webpage: "google.com" on "DUT1"
	#Then Transaction "2 Did Webpage open?" description: "Google webpage opened" SLA: "60000" - OCR Checkpoint: "IMAGES" Timeout: "60" Threshold: "90"
	
	
	@roamingBBZ30
Scenario: Roaming_Z30_Canada
	Then I open contacts App on "DUT1"
	#Then I open phone App on "DUT2"
	#Then I call "DUT2" from "DUT1"
	#Then Transaction: "1 Call succeeded?" on Device: "DUT2" Description: "Did DUT2 receive the call?" SLA: "60000" - OCR checkpoint: "incoming call" Timeout: "30" Threshold: "90"
	#Then I click to end call on "DUT1"
	Then I clear cache on "DUT1"
	Then I go to webpage: "google.com" on "DUT1"
	Then Transaction "2 Did Webpage open?" description: "Google webpage opened" SLA: "60000" - OCR Checkpoint: "IMAGES" Timeout: "60" Threshold: "90"
	
	@roamingiPhoneChina
Scenario: Roaming_iPhone_China
	Then I open phone App on "DUT2"
	Then I open phone App on "DUT1"
	Then I call "DUT2" from "DUT1"
	Then Transaction: "1 Call succeeded?" on Device: "DUT2" Description: "Did DUT2 receive the call?" SLA: "60000" - OCR checkpoint: "incoming call" Timeout: "60" Threshold: "90"
	Then I click to end call on "DUT1"
	Then I go to webpage: "google.com" on "DUT1"
	Then Transaction "2 Did Webpage open?" description: "Google webpage opened" SLA: "60000" - OCR Checkpoint: "English" Timeout: "60" Threshold: "90"
	
	
@roamingiPhoneMX
Scenario: Roaming_iPhone_Mexico
	Then I open phone App on "DUT2"
	Then I open phone App on "DUT1"
	Then I call "DUT2" from "DUT1"
	Then Transaction: "1 Call succeeded?" on Device: "DUT2" Description: "Did DUT2 receive the call?" SLA: "60000" - OCR checkpoint: "incoming call" Timeout: "30" Threshold: "90"
	Then I click to end call on "DUT1"
	Then I go to webpage: "google.com" on "DUT1"
	Then Transaction "2 Did Webpage open?" description: "Google webpage opened" SLA: "60000" - OCR Checkpoint: "IMAGES" Timeout: "60" Threshold: "90"
	
	@roamingiPhoneBr
	Scenario: Roaming_iPhone_Brazil
	Then I open phone App on "DUT2"
	Then I open phone App on "DUT1"
	Then I call "DUT2" from "DUT1"
	Then Transaction: "1 Call succeeded?" on Device: "DUT2" Description: "Did DUT2 receive the call?" SLA: "60000" - OCR checkpoint: "incoming call" Timeout: "30" Threshold: "90"
	Then I click to end roaming call on "DUT1"
	Then I go to webpage: "google.com" on "DUT1"
	Then Transaction "2 Did Webpage open?" description: "Google webpage opened" SLA: "60000" - OCR Checkpoint: "IMAGES" Timeout: "60" Threshold: "90"
	
	@roamingGalaxyS10UK
Scenario: Roaming_Galaxy_S10_UK
	Then I toggle wifi "disabled" on "DUT1"
	Then I toggle wifi "disabled" on "DUT2"
	Then I open phone App on "DUT2"
	Then I open phone App on "DUT1"
	Then I call "DUT2" from "DUT1"
	Then Transaction: "1 Call succeeded?" on Device: "DUT2" Description: "Did DUT2 receive the call?" SLA: "60000" - OCR checkpoint: "incoming call" Timeout: "30" Threshold: "90"
	Then I click to end call on "DUT1"
	Then I go to webpage: "google.com" on "DUT1"
	Then Transaction "2 Did Webpage open?" description: "Google webpage opened" SLA: "60000" - OCR Checkpoint: "IMAGES" Timeout: "60" Threshold: "90"
	
	@roamingGalaxyS10Brazil
Scenario: Roaming_Galaxy_S10_Brazil
	Then I toggle wifi "disabled" on "DUT1"
	Then I toggle wifi "disabled" on "DUT2"
	Then I open phone App on "DUT2"
	Then I open phone App on "DUT1"
	Then I call "DUT2" from "DUT1"
	Then Transaction: "1 Call succeeded?" on Device: "DUT2" Description: "Did DUT2 receive the call?" SLA: "60000" - OCR checkpoint: "incoming call" Timeout: "30" Threshold: "90"
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
	Then Transaction: "1 Call succeeded?" on Device: "DUT2" Description: "Did DUT2 receive the call?" SLA: "60000" - OCR checkpoint: "incoming call" Timeout: "30" Threshold: "90"
	Then I click to end call on "DUT1"
	Then I go to webpage: "google.com" on "DUT1"
	Then Transaction "2 Did Webpage open?" description: "Google webpage opened" SLA: "60000" - OCR Checkpoint: "IMAGES" Timeout: "60" Threshold: "90"