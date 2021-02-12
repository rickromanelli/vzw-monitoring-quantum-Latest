@VVM
Feature: VVM Feature 
#Sample Test Scenario Description

@VM2Text
Scenario: VM2Text_Android
	Then I toggle wifi "disabled" on "DUT1"
	Then I toggle wifi "disabled" on "DUT2"
	Then I open Voicemail App on "DUT1"
	Then I delete all voicemails on "DUT1" 
	#Then I open Voicemail App on "DUT2"
	#Then I delete all voicemails on "DUT2"
	#Then I open phone App on "DUT2"
	Then I call "DUT1" from "DUT2"
	Then I ignore call on "DUT1"
	Then I inject audio message "PUBLIC:VM2TXT3.mp3" on "DUT2"
	Then I end call on "DUT2"
	Then I open Voicemail App on "DUT1"
	Then Transaction: "1: Was message received?" Description: "Check for message with text" SLA: "30000" - Image checkpoint: "PUBLIC:Prod/VVM/LG_v20_MWI_With_Text.png" Timeout: "60" Threshold: "90"
	Then I click on voicemail message on "DUT1"
	Then Transaction: "2: Message text accurate?" Description: "check text for accuracy" SLA: "30000" - OCR checkpoint: "test voicemail 12345678" Timeout: "50" Threshold: "90"
	