@gizmo
Feature: Gizmo Feature 

@gizmopalAndroid
Scenario: GizmoPal_Android_Phone
Given I go to the device home screen
Then I toggle wifi "disabled"
Then I initialize Gizmo app
Then Transaction "1 App Started?" description: "Can we see the word messaging on the home screen" SLA: "60000" - OCR Checkpoint: "SouthLake" Timeout: "60" Threshold: "90"
Then I click to show location Phone
Then Transaction "2 Child Located?" description: "Did Child show correct location?" SLA: "60000" - OCR Checkpoint: "Shadybrook Dr" or "Keller Hicks" Timeout: "200" Threshold: "90"

@gizmopaliPhone
Scenario: GizmoPal_iPhone
Then I toggle wifi "disabled"
Given I go to the device home screen
Then I initialize Gizmo app
Then Transaction "1 App Started?" description: "Can we see the word SouthLake on the home screen" SLA: "60000" - OCR Checkpoint: "SouthLake" Timeout: "60" Threshold: "90"
Then I click to show location iPhone
Then Transaction "2 Child Located?" description: "Did Child show correct location?" SLA: "60000" - OCR Checkpoint: "Shadybrook Dr" or "Carrotwood Dr" Timeout: "60" Threshold: "90"
