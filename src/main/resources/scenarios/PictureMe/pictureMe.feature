@pictureMe
Feature: PictureMe Feature 
#Sample Test Scenario Description
@pictureMeCallerID
Scenario: Picture_Me_Caller ID
	Then I open phone App on "DUT1"
	Then I open phone App on "DUT2"
	Then I toggle power button on "DUT2"
	Then I call "DUT2" from "DUT1"
	Then Transaction: "Did PictureMe image appear?" on "DUT2" Description: "Checking to see if Image was shown on DUT2" SLA: "60000" - Image checkpoint: "PUBLIC:Prod/CallerNameID/PhoneButton-G2.png" Timeout: "60" Threshold: "85"
	Then I end call on "DUT1"
	