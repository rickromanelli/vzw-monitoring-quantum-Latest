@vzTones
Feature: VZ Tones Feature 
#Sample Test Scenario Description

@vzTonesSearchAndroid
Scenario: VZ_Tones_Search_Android
	Given I use default driver
	Then I toggle wifi "disabled" 
	Then I initialize VZTones app 	
	Then Transaction: "1 Tones Opened?" Description: "Opening VZ Tones App" SLA: "60000" - OCR checkpoint: "Ring" Timeout: "30" Threshold: "90"
	Then I search for "Jurassic 5" phone
	Then I perform an Image click "PUBLIC:Prod/VZTones/Play_Button_S7.png" with a timeout of "20" and a threshold of "90"
	Then Transaction: "2 Audio Played?" Description: "Verifying audio loaded" SLA: "60000" - Image checkpoint: "PUBLIC:Prod/VZTones/Stop_Button_S5.png" Timeout: "60" Threshold: "50"
	Then I perform an Image click "PUBLIC:Prod/VZTones/Play_Button_S7.png" with a timeout of "30" and a threshold of "90"
	Then Transaction: "3 Check Audio" Description: "Checking if audio was played" SLA: "60000" Volume: "-120" Timeout: "16" Duration: "7"
	
@vzTonesWhatsNew
Scenario: VZ_Tones_Whats_New_Android
	Then I toggle wifi "disabled"
	Then I initialize VZTones app 	
	Then Transaction "1 Tones Opened?" description: "Opening VZ Tones App" SLA: "60000" - OCR Checkpoint: "Ring" Timeout: "60" Threshold: "100"
	Then I perform a text click "What's New" with a timeout of "20" and a threshold of "90"
	Then I perform an Image click "PUBLIC:Prod/VZTones/Play_Button_Turbo2.png" with a timeout of "20" and a threshold of "90"
	Then I perform an Image checkpoint for the Image "PUBLIC:Prod/VZTones/Play_Button_Turbo2.png" with a timeout of "60" and a threshold of "90" and status is "false" 
	Then I perform an Image click "PUBLIC:Prod/VZTones/Play_Button_Turbo2.png" with a timeout of "20" and a threshold of "90"
	Then Transaction: "3 Check Audio" Description: "Checking if audio was played" SLA: "60000" Volume: "-120" Timeout: "16" Duration: "7"
	Then I navigate to buy phone
	Then Transaction: "4 Buy Button" Description: "Buy Button present?" SLA: "60000" - Image checkpoint: "PUBLIC:Prod/VZTones/Buy_Button_S8.png" Timeout: "60" Threshold: "90"
	
	@vzTonesValidateCurrentRBT
Scenario: VZ_Tones_Validate_Current_RBT_Android
	#Given I use default driver
	Then I toggle wifi "disabled"
	Then I initialize VZTones app 	
	Then Transaction "1 Tones Opened?" description: "Opening VZ Tones App" SLA: "60000" - OCR Checkpoint: "Ring" Timeout: "60" Threshold: "100"
	Then I perform a text click "Manage Ringback Tones" with a timeout of "20" and a threshold of "90"
	Then I perform a text click "My Ringback Tones" with a timeout of "20" and a threshold of "90"
	Then Transaction "2 My Tones Opened?" description: "Did My RBT Page open?" SLA: "6000" - OCR Checkpoint: "My RBTs" Timeout: "60" Threshold: "90"
	Then I perform an Image checkpoint for the Image "PUBLIC:Prod/VZTones/Play_Button_Turbo2.png" with a timeout of "60" and a threshold of "90" and status is "false" 
	#Then I perform a Splunk transaction using the name "Play Button" and description of "Looking for the play button" with an SLA of "6000" - I'm also utilizing an Image checkpoint for the image "PUBLIC:VZTones/Play_Button_GS4.png" with a timeout of "60" and threshold of "50"
	#Then I perform an Image click "PUBLIC:Prod/VZTones/Play_Button_Turbo2.png" with a timeout of "20" and a threshold of "90"
	Then I perform an Image click "PUBLIC:Prod/VZTones/Play_Button_Turbo2.png" with a timeout of "20" and a threshold of "90" haystack x: "0%" , y: "0%" , height: "34%" , width: "100%"
	Then Transaction: "3 Check Audio" Description: "Checking if audio was played" SLA: "60000" Volume: "-120" Timeout: "16" Duration: "7"
	Then I navigate to jukeboxes phone
	Then Transaction: "4 Jukebox Exists?" Description: "Checking for Juke Perfecto" SLA: "60000" - OCR Checkpoint: "jukePerfecto" Timeout: "60" Threshold: "90"
	
