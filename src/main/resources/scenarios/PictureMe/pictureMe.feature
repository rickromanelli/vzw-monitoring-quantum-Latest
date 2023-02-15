@pictureMe
Feature: PictureMe Feature 
#Sample Test Scenario Description
@callerID
Scenario: Caller_ID
	#Then I toggle wifi "disabled" on "DUT1"
	Then I open phone App on "DUT1"
	#Then I open phone App on "DUT2"
	#Then I toggle wifi "disabled" on "DUT2"
	#Then I toggle power button on "DUT2"
	Then I call "DUT2" from "DUT1"
	
	Then Transaction: "Did PictureMe image appear?" on "DUT2" Description: "Checking to see if Image was shown on DUT2" SLA: "60000" - Image checkpoint: "PUBLIC:historyBtnA12.png" Timeout: "60" Threshold: "85"
	
	#Then Transaction: "Did PictureMe image appear?" on "DUT2" Description: "Checking to see if Image was shown on DUT2" SLA: "60000" - Image checkpoint: "PUBLIC:CallerID-A12.png" Timeout: "60" Threshold: "85"
	Then I end call on "DUT1"
	Then I go to home screen on "DUT2"