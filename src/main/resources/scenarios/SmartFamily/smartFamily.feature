@smartFamily
Feature: Smart Family

@smartFamilyTextLimit
Scenario: Smart_FamilyText_Limit
	Then I toggle wifi "disabled" on "DUT1"
	Then I toggle wifi "disabled" on "DUT2"
	Then I open Smart Family App on "DUT1"
	Then Transaction "1 Smart Family Launched?" description: "Opening Smart Family Parent App" SLA: "60000" - OCR Checkpoint: "Screen time today" Timeout: "60" Threshold: "90"
	Then I tap to view child "1" on "DUT1"
	Then I get device time on "DUT2" 
	Then I send a text on "DUT2"
	Then SF Transaction: "2 Text Allowed?" Description: "Text allowed during FreeTime?" SLA: "60000" - Image checkpoint: "PUBLIC:TextDeniedCircle.png" Timeout: "60" Threshold: "80"	
	Then I go to webpage: "google.com" on "DUT2"
	
@smartFamilyCallBlock
Scenario: Smart_FamilyCallLimit
	Then I toggle wifi "disabled" on "DUT1"
	Then I toggle wifi "disabled" on "DUT2"
	Then I get device time on "DUT2" 
	Then I open Smart Family App on "DUT1"
	Then Transaction "1 Smart Family Launched?" description: "Opening Smart Family Parent App" SLA: "60000" - OCR Checkpoint: "Screen time today" Timeout: "60" Threshold: "90"
	Then I tap to view child "1" on "DUT1"
	Then I call a friend on "DUT2"
	Then SF Transaction: "Check for completed or blocked call" Description: "Did call go through during school or sleep?" SLA: "6000" - Image checkpoint: "PUBLIC:TextDeniedCircle.png" Timeout: "60" Threshold: "80"
	
	@smartFamilyCheckScreenTime
Scenario: Smart_CheckScreenTime
	Then I toggle wifi "disabled" on "DUT1"
	Then I toggle wifi "disabled" on "DUT2"
	Then I get device time on "DUT2" 
	Then I open Smart Family App on "DUT1"
	Then Transaction "1 Smart Family Launched?" description: "Opening Smart Family Parent App" SLA: "60000" - OCR Checkpoint: "Screen time today" Timeout: "60" Threshold: "90"
	Then I tap to view child "1" on "DUT1"
	
@smartFamilyTrustedUntrustedNumbers 
Scenario: Trusted_and_untrusted_phone_numbers
	Then I toggle wifi "disabled" on "DUT1"
	Then I toggle wifi "disabled" on "DUT2"
	Then I get device time on "DUT2" 
	Then I open Smart Family App on "DUT1"
