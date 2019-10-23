@gizmo
Feature: Gizmo Feature 

@gizmopal
Scenario: GizmoPal Android Phone
Given I use default driver
Then I toggle wifi "disabled"
Then I initialize Gizmo app
Then Transaction "1 App Started?" description: "Can we see the word messaging on the home screen" SLA: "60000" - OCR Checkpoint: "Messaging" Timeout: "60" Threshold: "90"
Then I navigate to Maps Phone
Then I search for Child Phone
Then Transaction "2 Child Located?" description: "Did Child show correct location?" SLA: "60000" - OCR Checkpoint: "Matt's House" Timeout: "200" Threshold: "90"

@gizmopaliPhone
Scenario: GizmoPal iPhone
#Then I toggle wifi "disabled"
Given I go to the device home screen
Then I initialize Gizmo app
Then Transaction "1 App Started?" description: "Can we see the word messaging on the home screen" SLA: "60000" - OCR Checkpoint: "Messaging" Timeout: "60" Threshold: "90"
Then I navigate to Maps Phone
Then I search for Child Phone
Then Transaction "2 Child Located?" description: "Did Child show correct location?" SLA: "60000" - OCR Checkpoint: "Matt's House" Timeout: "200" Threshold: "90"
