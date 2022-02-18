@push2talk
Feature: Push 2 Talk Feature 
#Sample Test Scenario Description

@push2talkTurboToDuraForce
Scenario: Push_to_Talk_Turbo2Duraforce
	Then I toggle wifi "disabled" on "DUT1"
	Then I toggle wifi "disabled" on "DUT2"
	Then I open Push2Talk on "DUT1"
	Then Transaction "1 PTT opened DUT1?" description: "Did PTT App open DUT1?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I open Push2Talk on "DUT2"	
	Then Transaction "2 PTT opened DUT2?" description: "Did PTT App open DUT2?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I search for PTT contact on "DUT1"
	Then Transaction "3 DUT2 Available?" search for PTT Contact, "DUT2" timeout, "60" threshold, "90" haystack: x: "0%" , y: "20%" , height: "15%" , width: "100%" , SLA: "60000" 
	Then I click on phone contact on "DUT1" Turbo
	Then I click to call on "DUT1"
	Then Transaction "4 Call Received?" call received on "DUT2" SLA: "60000"
	Then I increase to max volume
	Then I send audio on "DUT1"	
	Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT1"
	Then Transaction: "5 Audio Received?" on PTT Device: "DUT2" Description: "Audio Checkpoint" SLA: "60000" Volume: "-140" Timeout: "30" Duration: "9"
	Then I stop sending audio on "DUT1"
	Then I click to call on "DUT2"
	Then Transaction "6 Call Received?" call received on "DUT1" SLA: "60000"
	Then I increase to max volume
	Then I inject audio file "PUBLIC:Prod/VVM/VM2TXT3.mp3" on "DUT2"
	Then I send audio on "DUT2"	
	Then Transaction: "7 Audio Received?" on PTT Device: "DUT1" Description: "Audio Checkpoint" SLA: "60000" Volume: "-140" Timeout: "30" Duration: "9"
	Then I stop sending audio on "DUT2"
	Then I click to end call on "DUT2"
	
	
	@push2talkDuraForcePro2toSonim
	Scenario: Push_to_Talk_DuraForcePro2_2Sonim
	Then I toggle wifi "disabled" on "DUT1"
	Then I open Push2Talk on "DUT1"
	Then Transaction "1 PTT opened DUT1?" description: "Did PTT App open DUT1?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I open Push2Talk on "DUT2"
	Then Transaction "2 PTT opened DUT2?" description: "Did PTT App open DUT2?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I search for PTT contact on "DUT1"
	Then Transaction "3 DUT2 Available?" search for PTT Contact, "DUT2" timeout, "60" threshold, "90" haystack: x: "0%" , y: "20%" , height: "15%" , width: "100%" , SLA: "60000" 
	Then I click on phone contact on "DUT1" Turbo
	Then I click to call on "DUT1"
	Then Transaction "4 Call Received?" call received on "DUT2" SLA: "60000"
	Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT1"
	Then I send audio on "DUT1"	
	Then I click to call on "DUT2"
	Then Transaction "6 Call Received?" call received on "DUT1" SLA: "60000"
	#Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT2"
	#Then I send audio on "DUT2"	
	#Then I stop sending audio on "DUT2"
	Then I click to end call on "DUT2"
	
	@push2talkSonimToGalaxyA12
Scenario: Push_to_Talk_Sonim2GalaxyA12
	Then I toggle wifi "disabled" on "DUT1"
	Then I toggle wifi "disabled" on "DUT2"
	Then I open Push2Talk on "DUT1"
	Then Transaction "1 PTT opened DUT1?" description: "Did PTT App open DUT1?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I open Push2Talk on "DUT2"	
	Then Transaction "2 PTT opened DUT2?" description: "Did PTT App open DUT2?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I search for PTT contact on "DUT1"
	Then Transaction "3 DUT2 Available?" search for PTT Contact, "DUT2" timeout, "60" threshold, "90" haystack: x: "0%" , y: "20%" , height: "15%" , width: "100%" , SLA: "60000" 
	Then I click on phone contact on "DUT1" Turbo
	Then I click to call on "DUT1"
	Then Transaction "4 Call Received?" call received on "DUT2" SLA: "60000"
	Then I increase to max volume
	Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT1"
	Then I send audio on "DUT1"	
	#Then Transaction: "5 Audio Received?" on PTT Device: "DUT2" Description: "Audio Checkpoint" SLA: "60000" Volume: "-140" Timeout: "30" Duration: "9"
	Then I stop sending audio on "DUT1"
	Then I click to call on "DUT2"
	Then Transaction "6 Call Received?" call received on "DUT1" SLA: "60000"
	Then I stop sending audio on "DUT2"
	Then I click to end call on "DUT2"
	
	
	
	@push2talkDuraForceToGalaxyA12
Scenario: Push_to_Talk_DuraForce2GalaxyA12
	Then I toggle wifi "disabled" on "DUT1"
	Then I toggle wifi "disabled" on "DUT2"
	Then I open Push2Talk on "DUT1"
	Then Transaction "1 PTT opened DUT1?" description: "Did PTT App open DUT1?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I open Push2Talk on "DUT2"	
	Then Transaction "2 PTT opened DUT2?" description: "Did PTT App open DUT2?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I search for PTT contact on "DUT1"
	Then Transaction "3 DUT2 Available?" search for PTT Contact, "DUT2" timeout, "60" threshold, "90" haystack: x: "0%" , y: "20%" , height: "15%" , width: "100%" , SLA: "60000" 
	Then I click on phone contact on "DUT1" Turbo
	Then I click to call on "DUT1"
	Then Transaction "4 Call Received?" call received on "DUT2" SLA: "60000"
	Then I increase to max volume
	Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT1"
	Then I send audio on "DUT1"	
	#Then Transaction: "5 Audio Received?" on PTT Device: "DUT2" Description: "Audio Checkpoint" SLA: "60000" Volume: "-140" Timeout: "30" Duration: "9"
	Then I stop sending audio on "DUT1"
	Then I click to call on "DUT2"
	Then Transaction "6 Call Received?" call received on "DUT1" SLA: "60000"
	Then I stop sending audio on "DUT2"
	Then I click to end call on "DUT2"

	
	@push2talkGalaxyS8ToDuraForce
Scenario: Push_to_Talk_GalaxyS82DuraForce
	Then I toggle wifi "disabled" on "DUT1"
	Then I toggle wifi "disabled" on "DUT2"
	Then I open Push2Talk on "DUT1"
	Then Transaction "1 PTT opened DUT1?" description: "Did PTT App open DUT1?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I open Push2Talk on "DUT2"	
	Then Transaction "2 PTT opened DUT2?" description: "Did PTT App open DUT2?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I search for PTT contact on "DUT1"
	Then Transaction "3 DUT2 Available?" search for PTT Contact, "DUT2" timeout, "60" threshold, "90" haystack: x: "0%" , y: "20%" , height: "15%" , width: "100%" , SLA: "60000" 
	Then I click on phone contact on "DUT1" Turbo
	Then I click to call on "DUT1"
	Then Transaction "4 Call Received?" call received on "DUT2" SLA: "60000"
	Then I increase to max volume
	Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT1"
	#DUT2 Start Recording
	Then I send audio on "DUT1"	
	#Then Transaction: "5 Audio Received?" on PTT Device: "DUT2" Description: "Audio Checkpoint" SLA: "60000" Volume: "-140" Timeout: "30" Duration: "9"
	Then I stop sending audio on "DUT1"
	#Stop recording DUT2
	Then Transaction: "5 Audio Received?" on PTT Device: "DUT2" Description: "Audio Checkpoint" SLA: "60000" Volume: "-140" Timeout: "30" Duration: "9"
	#Validate recording
	Then I click to call on "DUT2"
	Then Transaction "6 Call Received?" call received on "DUT1" SLA: "60000"
	Then I stop sending audio on "DUT2"
	
	
	@push2talkGalaxy2Galaxy
Scenario: Push_to_Talk_GalaxyS8_2_GalaxyS8
	Then I toggle wifi "disabled" on "DUT1"
	Then I toggle wifi "disabled" on "DUT2"
	Then I open Push2Talk on "DUT1"
	Then Transaction "1 PTT opened DUT1?" description: "Did PTT App open DUT1?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I open Push2Talk on "DUT2"	
	Then Transaction "2 PTT opened DUT2?" description: "Did PTT App open DUT2?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I search for PTT contact on "DUT1"
	Then Transaction "3 DUT2 Available?" search for PTT Contact, "DUT2" timeout, "60" threshold, "90" haystack: x: "0%" , y: "20%" , height: "15%" , width: "100%" , SLA: "60000" 
	Then I click on phone contact on "DUT1" Turbo
	Then I click to call on "DUT1"
	Then Transaction "4 Call Received?" call received on "DUT2" SLA: "60000"
	Then I increase to max volume
Then I send audio on "DUT1"	
	Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT1"
	Then Transaction: "7 Audio Received?" on PTT Device: "DUT1" Description: "Audio Checkpoint" SLA: "60000" Volume: "-140" Timeout: "30" Duration: "9"
	
	Then I stop sending audio on "DUT1"
	Then I click to call on "DUT2"
	Then Transaction "6 Call Received?" call received on "DUT1" SLA: "60000"
	Then I increase to max volume
	Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT2"
	Then I send audio on "DUT2"	
	Then I stop sending audio on "DUT2"
	Then I click to end call on "DUT2"
	
	
	@push2talkiPhoneToDuraForce1
Scenario: Push_to_Talk_iPhone2Duraforce
	Then I open Push2Talk on "DUT1"
	
	@push2talkiPhoneToDuraForce
Scenario: Push_to_Talk_iPhone2Duraforce
	
	#Then I toggle wifi "disabled" on "DUT2"
	Then I open Push2Talk on "DUT1"
	Then Transaction "1 PTT opened DUT1?" description: "Did PTT App open DUT1?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I open Push2Talk on "DUT2"
	Then Transaction "2 PTT opened DUT2?" description: "Did PTT App open DUT2?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I search for PTT contact on "DUT1"
	Then Transaction "3 DUT2 Available?" search for PTT Contact, "DUT2" timeout, "60" threshold, "90" haystack: x: "0%" , y: "20%" , height: "15%" , width: "100%" , SLA: "60000" 
	Then I click on phone contact on "DUT1" Turbo
	Then I click to call on "DUT1"
	Then Transaction "4 Call Received?" call received on "DUT2" SLA: "60000"
	Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT1"
	Then I send audio on "DUT1"	
	Then I click to call on "DUT2"
	Then Transaction "6 Call Received?" call received on "DUT1" SLA: "60000"
	Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT2"
	Then I send audio on "DUT2"	
	Then I stop sending audio on "DUT2"
	Then I click to end call on "DUT2"
	
	@push2talkiPhoneToGalaxy
	Scenario: Push_to_Talk_iPhone2Galaxy
	Then I toggle wifi "disabled" on "DUT2"
	Then I open Push2Talk on "DUT1"
	Then Transaction "1 PTT opened DUT1?" description: "Did PTT App open DUT1?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I open Push2Talk on "DUT2"
	Then Transaction "2 PTT opened DUT2?" description: "Did PTT App open DUT2?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I search for PTT contact on "DUT1"
	Then Transaction "3 DUT2 Available?" search for PTT Contact, "DUT2" timeout, "60" threshold, "90" haystack: x: "0%" , y: "20%" , height: "15%" , width: "100%" , SLA: "60000" 
	Then I click on phone contact on "DUT1" Turbo
	Then I click to call on "DUT1"
	Then Transaction "4 Call Received?" call received on "DUT2" SLA: "60000"
	Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT1"
	Then I send audio on "DUT1"	
	Then I click to call on "DUT2"
	Then Transaction "6 Call Received?" call received on "DUT1" SLA: "60000"
	Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT2"
	Then I send audio on "DUT2"	
	Then I stop sending audio on "DUT2"
	Then I click to end call on "DUT2"
	
	@push2talkGalaxyS10toiPhone
	Scenario: Push_to_Talk_Galaxy_S102iPhone
	#Then I toggle wifi "disabled" on "DUT1"
	Then I open Push2Talk on "DUT1"
	Then Transaction "1 PTT opened DUT1?" description: "Did PTT App open DUT1?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I open Push2Talk on "DUT2"
	Then Transaction "2 PTT opened DUT2?" description: "Did PTT App open DUT2?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I search for PTT contact on "DUT1"
	Then Transaction "3 DUT2 Available?" search for PTT Contact, "DUT2" timeout, "60" threshold, "90" haystack: x: "0%" , y: "20%" , height: "15%" , width: "100%" , SLA: "60000" 
	Then I click on phone contact on "DUT1" Turbo
	Then I click to call on "DUT1"
	Then Transaction "4 Call Received?" call received on "DUT2" SLA: "60000"
	Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT1"
	Then I send audio on "DUT1"	
	Then I click to call on "DUT2"
	Then Transaction "6 Call Received?" call received on "DUT1" SLA: "60000"
	Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT2"
	Then I send audio on "DUT2"	
	Then I stop sending audio on "DUT2"
	Then I click to end call on "DUT2"
	
	@push2talkGalaxyA12toiPhone
	Scenario: Push_to_Talk_GalaxyA12_2_iPhone
	#Then I toggle wifi "disabled" on "DUT1"
	Then I open Push2Talk on "DUT1"
	Then Transaction "1 PTT opened DUT1?" description: "Did PTT App open DUT1?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I open Push2Talk on "DUT2"
	Then Transaction "2 PTT opened DUT2?" description: "Did PTT App open DUT2?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I search for PTT contact on "DUT1"
	Then Transaction "3 DUT2 Available?" search for PTT Contact, "DUT2" timeout, "60" threshold, "90" haystack: x: "0%" , y: "20%" , height: "15%" , width: "100%" , SLA: "60000" 
	Then I click on phone contact on "DUT1" Turbo
	Then I click to call on "DUT1"
	Then Transaction "4 Call Received?" call received on "DUT2" SLA: "60000"
	#Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT1"
	#Then I send audio on "DUT1"	
	#Then I click to call on "DUT2"
	#Then Transaction "6 Call Received?" call received on "DUT1" SLA: "60000"
	#Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT2"
	#Then I send audio on "DUT2"	
	#Then I stop sending audio on "DUT2"
	#Then I click to end call on "DUT2"
	
		@push2talkDuraForcePro2toiPhone
	Scenario: Push_to_Talk_DuraForcePro2_2iPhone
	#Then I toggle wifi "disabled" on "DUT1"
	Then I open Push2Talk on "DUT1"
	Then Transaction "1 PTT opened DUT1?" description: "Did PTT App open DUT1?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I open Push2Talk on "DUT2"
	Then Transaction "2 PTT opened DUT2?" description: "Did PTT App open DUT2?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I search for PTT contact on "DUT1"
	Then Transaction "3 DUT2 Available?" search for PTT Contact, "DUT2" timeout, "60" threshold, "90" haystack: x: "0%" , y: "20%" , height: "15%" , width: "100%" , SLA: "60000" 
	Then I click on phone contact on "DUT1" Turbo
	Then I click to call on "DUT1"
	Then Transaction "4 Call Received?" call received on "DUT2" SLA: "60000"
	Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT1"
	Then I send audio on "DUT1"	
	Then I click to call on "DUT2"
	Then Transaction "6 Call Received?" call received on "DUT1" SLA: "60000"
	#Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT2"
	#Then I send audio on "DUT2"	
	#Then I stop sending audio on "DUT2"
	Then I click to end call on "DUT2"
	
	
	
	
	@push2talkDuraForceToiPhone
Scenario: Push_to_Talk_Duraforce2iPhone
	#Then I toggle wifi "disabled" on "DUT1"
	Then I open Push2Talk on "DUT1"
	Then Transaction "1 PTT opened DUT1?" description: "Did PTT App open DUT1?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I open Push2Talk on "DUT2"
	Then Transaction "2 PTT opened DUT2?" description: "Did PTT App open DUT2?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I search for PTT contact on "DUT1"
	Then Transaction "3 DUT2 Available?" search for PTT Contact, "DUT2" timeout, "60" threshold, "90" haystack: x: "0%" , y: "20%" , height: "15%" , width: "100%" , SLA: "60000" 
	Then I click on phone contact on "DUT1" Turbo
	Then I click to call on "DUT1"
	Then Transaction "4 Call Received?" call received on "DUT2" SLA: "60000"
	Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT1"
	Then I send audio on "DUT1"	
	Then I click to call on "DUT2"
	Then Transaction "6 Call Received?" call received on "DUT1" SLA: "60000"
	Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT2"
	Then I send audio on "DUT2"	
	Then I stop sending audio on "DUT2"
	Then I click to end call on "DUT2"
	
	@push2talkSonimToiPhone
Scenario: Push_to_Talk_Sonim2iPhone
	Then I toggle wifi "disabled" on "DUT1"
	Then I open Push2Talk on "DUT1"
	Then Transaction "1 PTT opened DUT1?" description: "Did PTT App open DUT1?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I open Push2Talk on "DUT2"
	Then Transaction "2 PTT opened DUT2?" description: "Did PTT App open DUT2?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I search for PTT contact on "DUT1"
	Then Transaction "3 DUT2 Available?" search for PTT Contact, "DUT2" timeout, "60" threshold, "90" haystack: x: "0%" , y: "20%" , height: "15%" , width: "100%" , SLA: "60000" 
	Then I click on phone contact on "DUT1" Turbo
	Then I click to call on "DUT1"
	Then Transaction "4 Call Received?" call received on "DUT2" SLA: "60000"
	Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT1"
	Then I send audio on "DUT1"	
	Then I click to call on "DUT2"
	Then Transaction "6 Call Received?" call received on "DUT1" SLA: "60000"
	Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT2"
	Then I send audio on "DUT2"	
	Then I stop sending audio on "DUT2"
	Then I click to end call on "DUT2"
	
	@push2talkSonimToGalaxyS8
Scenario: Push_to_Talk_Sonim2GalaxyS8
	Then I toggle wifi "disabled" on "DUT1"
	Then I open Push2Talk on "DUT1"
	Then Transaction "1 PTT opened DUT1?" description: "Did PTT App open DUT1?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I open Push2Talk on "DUT2"
	Then Transaction "2 PTT opened DUT2?" description: "Did PTT App open DUT2?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I search for PTT contact on "DUT1"
	Then Transaction "3 DUT2 Available?" search for PTT Contact, "DUT2" timeout, "60" threshold, "90" haystack: x: "0%" , y: "20%" , height: "15%" , width: "100%" , SLA: "60000" 
	Then I click on phone contact on "DUT1" Turbo
	Then I click to call on "DUT1"
	Then Transaction "4 Call Received?" call received on "DUT2" SLA: "60000"
	Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT1"
	Then I send audio on "DUT1"	
	Then I click to call on "DUT2"
	Then Transaction "6 Call Received?" call received on "DUT1" SLA: "60000"
	Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT2"
	Then I send audio on "DUT2"	
	Then I stop sending audio on "DUT2"
	Then I click to end call on "DUT2"
	
	@push2talk3Device
Scenario: Push_to_Talk_3Device
	Then I toggle wifi "disabled" on "DUT1"
	Then I toggle wifi "disabled" on "DUT2"
	Then I toggle wifi "disabled" on "DUT3"
	#Then I open Push2Talk on "DUT1"
	#Then Transaction "1 PTT opened DUT1?" description: "Did PTT App open DUT1?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	#Then I open Push2Talk on "DUT2"
	#Then Transaction "2 PTT opened DUT2?" description: "Did PTT App open DUT2?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	#Then I search for PTT contact on "DUT1"
	#Then Transaction "3 DUT2 Available?" search for PTT Contact, "DUT2" timeout, "60" threshold, "90" haystack: x: "0%" , y: "20%" , height: "15%" , width: "100%" , SLA: "60000" 
	#Then I click on phone contact on "DUT1" Turbo
	#Then I click to call on "DUT1"
	#Then Transaction "4 Call Received?" call received on "DUT2" SLA: "60000"
	#Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT1"
	#Then I send audio on "DUT1"	
	#Then I click to call on "DUT2"
	#Then Transaction "6 Call Received?" call received on "DUT1" SLA: "60000"
	#Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT2"
	#Then I send audio on "DUT2"	
	#Then I stop sending audio on "DUT2"
	#Then I click to end call on "DUT2"
	
	@push2talkiPhoneToiPhone
Scenario: Push_to_Talk_iPhone2iPhone
	Then I open Push2Talk on "DUT1"
	Then Transaction "1 PTT opened DUT1?" description: "Did PTT App open DUT1?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I open Push2Talk on "DUT2"
	Then Transaction "2 PTT opened DUT2?" description: "Did PTT App open DUT2?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I search for PTT contact on "DUT1"
	Then Transaction "3 DUT2 Available?" search for PTT Contact, "DUT2" timeout, "60" threshold, "90" haystack: x: "0%" , y: "20%" , height: "15%" , width: "100%" , SLA: "60000" 
	Then I click on phone contact on "DUT1" Turbo
	Then I click to call on "DUT1"
	Then Transaction "4 Call Received?" call received on "DUT2" SLA: "60000"
	Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT1"
	Then I send audio on "DUT1"	
	Then I click to call on "DUT2"
	Then Transaction "6 Call Received?" call received on "DUT1" SLA: "100000"
	Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT2"
	Then I send audio on "DUT2"	
	Then I stop sending audio on "DUT2"
	
	@pttimageS8toiPhone
Scenario: Push_to_Talk_image_Galaxy2iPhone
	Then I toggle wifi "disabled" on "DUT1"
	Then I open Push2Talk on "DUT1"
	Then Transaction "1 PTT opened DUT1?" description: "Did PTT App open DUT1?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I open Push2Talk on "DUT2"
	Then Transaction "2 PTT opened DUT2?" description: "Did PTT App open DUT2?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I search for PTT contact on "DUT1"
	Then I click on phone contact on "DUT1" Turbo
	Then I send Photo to DUT2
	Then Transaction: "3 Image Received" on Device: "DUT2" Description: "Checking was image sent?" SLA: "20000" - OCR checkpoint: "(Image)" Timeout: "80" Threshold: "90"
	#Then I search for PTT contact on "DUT2"
	#Then I click on phone contact on "DUT2" Turbo
	Then I delete messages on "DUT2"
	
	@push2talkDuraForce2GalaxyGroup1
	Scenario: Push_to_Talk_DuraForce_2_Galaxy_Group1
	Then I open Push2Talk on "DUT1"
	Then Transaction "1 PTT opened?" description: "Did PTT App open DUT1?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I open Push2Talk on "DUT2"	
	Then Transaction "2 PTT opened?" description: "Did PTT App open DUT2?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I click PTTPlus "ASP-ONE" on "DUT1"
	Then Transaction "3 Group visible?" description: "Did PTT group 1 show DUT2?" SLA: "60000" - OCR Checkpoint: "ASP-ONE" Timeout: "30" Threshold: "90"
	Then I click to call on "DUT1"
	Then Transaction "4 Call Received?" call received on "DUT2" SLA: "60000"
	Then I click to call on "DUT2"
	Then Transaction "6 Call Received?" call received on "DUT1" SLA: "100000"
	Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT2"
	Then I send audio on "DUT2"	
	Then I stop sending audio on "DUT2"
	Then I click to end call on "DUT2"
	
	
	
	@push2talkDuraForce2GalaxyGroup2
	Scenario: Push_to_Talk_DuraForce_2_Galaxy_Group2
	Then I open Push2Talk on "DUT1"
	Then Transaction "1 PTT opened?" description: "Did PTT App open DUT1?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I open Push2Talk on "DUT2"	
	Then Transaction "2 PTT opened?" description: "Did PTT App open DUT2?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I click PTTPlus "ASP-TWO" on "DUT1"
	Then Transaction "3 Group visible?" description: "Did PTT group 2 show DUT2?" SLA: "60000" - OCR Checkpoint: "ASP-TWO" Timeout: "30" Threshold: "90"
	Then I click to call on "DUT1"
	Then Transaction "4 Call Received?" call received on "DUT2" SLA: "60000"
	Then I click to call on "DUT2"
	Then Transaction "6 Call Received?" call received on "DUT1" SLA: "100000"
	Then I inject audio file "PUBLIC:VM2TXT3.mp3" on "DUT2"
	Then I send audio on "DUT2"	
	Then I stop sending audio on "DUT2"
	Then I click to end call on "DUT2"
	