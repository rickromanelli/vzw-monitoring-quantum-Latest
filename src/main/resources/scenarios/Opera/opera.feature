@opera
Feature: Opera Feature 
#Sample Test Scenario Description

	@operaESPN
	Scenario: Opera_ESPN
	Then I go to Casio Home
	Then I open Opera App
	Then Transaction "1 Opera App opened?" description: "Checking to see if Opera app opened." SLA: "60000" - OCR Checkpoint: "my web" Timeout: "60" Threshold: "90"
	Then I open ESPN App
	Then Transaction "2 ESPN available?" description: "Checking to see if Opera ESPN opens" SLA: "60000" - OCR Checkpoint: "Scores" Timeout: "60" Threshold: "80"
	Then I go to Casio Home
		
	@operaMobileWeb3
	Scenario: Opera_Mobile_Web3
	Then I go to Casio Home
	Then I open Opera App
	Then Transaction "1 Opera App opened?" description: "Checking to see if Opera app opened." SLA: "60000" - OCR Checkpoint: "my web" Timeout: "60" Threshold: "90"
	Then I open My Web 3 App
	Then Transaction "1 My Web available?" description: "Checking to see if Opera ESPN opens" SLA: "60000" - OCR Checkpoint: "VZW Today" Timeout: "60" Threshold: "90"
	
	@brew
	Scenario: Brew
	Then I go to Casio Home
	Then I open Brew App
	Then Transaction "Brew app opened?" description: "Checking to see if Opera Brew opens" SLA: "60000" - OCR Checkpoint: "Mobile IM" Timeout: "30" Threshold: "80"
	Then I load Brew App Catalog	
	Then Transaction "Brew app loaded?" description: "Checking to see if Opera Brew Loaded" SLA: "60000" - OCR Checkpoint: "SHOP APPS" Timeout: "30" Threshold: "80"
	Then I open Tools and Applications
	Then Transaction "Tools and Applications opened?" description: "Checking to see if Tools and Applications loaded " SLA: "60000" - OCR Checkpoint: "Just For You" Timeout: "30" Threshold: "80"
	Then I go to Casio Home
		