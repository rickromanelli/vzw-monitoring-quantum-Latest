@Emergency
Feature: Emergency
#Sample Test Scenario Description

@Emergency
Scenario: Emergency_922_SMS
	Then I send a text to NineTwoTwo 
	Then Transaction "922 call success" description: "code exists" SLA: "6000" - OCR Checkpoint: "RC=0" or "RC=-9" Timeout: "60" Threshold: "100"
	Then I delete 922 messages 