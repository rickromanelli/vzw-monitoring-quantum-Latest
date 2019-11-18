@push2talk
Feature: Push 2 Talk Feature 
#Sample Test Scenario Description

@push2talkTurboToDuraForce
Scenario: Push_to_Talk_Turbo2Duraforce
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
	#Then I click to end call on "DUT1"
	Then I send audio on "DUT1"	
	Then I inject audio file "PUBLIC:Prod/VVM/VM2TXT3.mp3" on "DUT1"
	Then Transaction: "5 Audio Received?" on PTT Device: "DUT2" Description: "Audio Checkpoint" SLA: "60000" Volume: "-140" Timeout: "30" Duration: "9"
	
	Then I stop sending audio on "DUT1"
	#Then I click to end call on "DUT1"
	Then I click to call on "DUT2"
	Then Transaction "6 Call Received?" call received on "DUT1" SLA: "60000"
	Then I increase to max volume
	Then I inject audio file "PUBLIC:Prod/VVM/VM2TXT3.mp3" on "DUT2"
	Then I send audio on "DUT2"	
	Then Transaction: "7 Audio Received?" on PTT Device: "DUT1" Description: "Audio Checkpoint" SLA: "60000" Volume: "-140" Timeout: "30" Duration: "9"
	Then I stop sending audio on "DUT2"
	Then I click to end call on "DUT2"
	#Then I close application by name "Push To Talk"
	
	@push2talkGalaxyS8ToDuraForce
Scenario: Push_to_Talk_Turbo2Duraforce
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
	#Then I click to end call on "DUT1"
	Then I send audio on "DUT1"	
	Then I inject audio file "PUBLIC:Prod/VVM/VM2TXT3.mp3" on "DUT1"
	Then Transaction: "5 Audio Received?" on PTT Device: "DUT2" Description: "Audio Checkpoint" SLA: "60000" Volume: "-140" Timeout: "30" Duration: "9"
	
	Then I stop sending audio on "DUT1"
	#Then I click to end call on "DUT1"
	Then I click to call on "DUT2"
	Then Transaction "6 Call Received?" call received on "DUT1" SLA: "60000"
	Then I increase to max volume
	Then I inject audio file "PUBLIC:Prod/VVM/VM2TXT3.mp3" on "DUT2"
	Then I send audio on "DUT2"	
	Then Transaction: "7 Audio Received?" on PTT Device: "DUT1" Description: "Audio Checkpoint" SLA: "60000" Volume: "-140" Timeout: "30" Duration: "9"
	Then I stop sending audio on "DUT2"
	Then I click to end call on "DUT2"
	#Then I close application by name "Push To Talk"
	
	@push2talkDuraForcetoBrigadier
Scenario: Push_to_Talk_Turbo2Duraforce
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
	#Then I click to end call on "DUT1"
	Then I send audio on "DUT1"	
	Then I inject audio file "PUBLIC:Prod/VVM/VM2TXT3.mp3" on "DUT1"
	Then Transaction: "5 Audio Received?" on PTT Device: "DUT2" Description: "Audio Checkpoint" SLA: "60000" Volume: "-140" Timeout: "30" Duration: "9"
	
	Then I stop sending audio on "DUT1"
	#Then I click to end call on "DUT1"
	Then I click to call on "DUT2"
	Then Transaction "6 Call Received?" call received on "DUT1" SLA: "60000"
	Then I increase to max volume
	Then I inject audio file "PUBLIC:Prod/VVM/VM2TXT3.mp3" on "DUT2"
	Then I send audio on "DUT2"	
	Then Transaction: "7 Audio Received?" on PTT Device: "DUT1" Description: "Audio Checkpoint" SLA: "60000" Volume: "-140" Timeout: "30" Duration: "9"
	Then I stop sending audio on "DUT2"
	Then I click to end call on "DUT2"
	#Then I close application by name "Push To Talk"
	
	@push2talkiPhoneToDuraForce
Scenario: Push_to_Talk_iPhone2Duraforce
	Then I open Push2Talk on "DUT1"
	Then Transaction "1 PTT opened DUT1?" description: "Did PTT App open DUT1?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I open Push2Talk on "DUT2"
	Then Transaction "2 PTT opened DUT2?" description: "Did PTT App open DUT2?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I search for PTT contact on "DUT1"
	Then Transaction "3 DUT2 Available?" search for PTT Contact, "DUT2" timeout, "60" threshold, "90" haystack: x: "0%" , y: "20%" , height: "15%" , width: "100%" , SLA: "60000" 
	Then I click on phone contact on "DUT1" Turbo
	Then I click to call on "DUT1"
	Then Transaction "4 Call Received?" call received on "DUT2" SLA: "60000"
	#Then I increase to max volume
	Then I inject audio file "PUBLIC:Prod/PTTPlus/AdeleChorus.mp3" on "DUT1"
	Then I send audio on "DUT1"	
	#Then Transaction: "5 Audio Received?" on PTT Device: "DUT2" Description: "Audio Checkpoint" SLA: "60000" Volume: "-120" Timeout: "25" Duration: "18"
	#Then I stop sending audio on "DUT1"
	Then I click to call on "DUT2"
	Then Transaction "6 Call Received?" call received on "DUT1" SLA: "60000"
	#Then I increase to max volume
	Then I inject audio file "PUBLIC:Prod/VVM/VM2TXT3.mp3" on "DUT2"
	Then I send audio on "DUT2"	
	Then Transaction: "7 Audio Received?" on PTT Device: "DUT1" Description: "Audio Checkpoint" SLA: "60000" Volume: "-140" Timeout: "30" Duration: "3"
	Then I stop sending audio on "DUT2"
	Then I click to end call on "DUT2"
	
	
	
	@push2talkBrigadier
	Scenario: Push_to_Talk_Plus_Brigadier
	Then I open Push2Talk on "DUT1"
	Then Transaction "1 PTT opened?" description: "Did PTT App open DUT1?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I open Push2Talk on "DUT2"	
	Then Transaction "2 PTT opened?" description: "Did PTT App open DUT2?" SLA: "60000" - OCR Checkpoint: "Available" Timeout: "30" Threshold: "90"
	Then I search for PTT contact on "DUT1"
	Then Transaction "3 DUT2 Available?" search for PTT Contact, "DUT2" timeout, "60" threshold, "85" haystack: x: "0%" , y: "0%" , height: "60%" , width: "100%" , SLA: "60000" 
	Then I click on phone contact on "DUT1"
		#Then I press button down on "DUT1"
	Then I click to call on "DUT1"
	Then Transaction "4 Call Received?" call received on "DUT2" SLA: "60000"
	#Then I increase to max volume
	#Then I send audio on "DUT1"	
	#Then I inject audio file "PUBLIC:Prod/PTTPlus/AdeleChorus.mp3" on "DUT1"
		#Then Transaction: "5 Audio Received?" on PTT Device: "DUT2" Description: "Audio Checkpoint" SLA: "60000" Volume: "-140" Timeout: "30" Duration: "3"
	#Then I stop sending audio on "DUT1"
	#Then I click to end call on "DUT1"
	Then I click on phone contact on "DUT2"
	Then I click to call on "DUT2"
	Then Transaction "6 Call Received?" call received on "DUT1" SLA: "60000"
	#Then I increase to max volume
		#Then I inject audio file "PUBLIC:Prod/PTTPlus/AdeleChorus.mp3" on "DUT2"
		#Then I send audio on "DUT2"	
		#Then Transaction: "7 Audio Received?" on PTT Device: "DUT1" Description: "Audio Checkpoint" SLA: "60000" Volume: "-120" Timeout: "30" Duration: "3"
		#Then I stop sending audio on "DUT2"
	Then I click to end call on "DUT2"
	