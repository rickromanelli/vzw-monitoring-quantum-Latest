@vzNav 
Feature: VZ Nav Feature 
#Sample Test Scenario Description

@vzNavCheckGasFeedPhone
Scenario: VZ_Nav_Check_Gas_Feed_Android
	#Given I use default driver 
	Then I toggle wifi "disabled"
	Then I set device location to "42.6285206,-71.306298"
	Then I open VZNav app phone
	Then Transaction "1 VZ Nav Launched?" description: "Opening VZ Nav App" SLA: "60000" - OCR Checkpoint: "Gas Stations" Timeout: "60" Threshold: "90"
	Then I open Gas Stations phone
	Then Transaction "2 Gas Stations Loaded?" description: "Verifying gas stations loaded" SLA: "60000" - OCR Checkpoint: "miles away" Timeout: "60" Threshold: "90"
	
@vzNavCheckGasFeediPhone
	Scenario: VZ_Nav_Check_Gas_Feed_iPhone 
	#Given I use default driver 
	Then I toggle wifi "disabled"
	Then I open VZNav app phone
	Then Transaction "1 VZ Nav Launched?" description: "Opening VZ Nav App" SLA: "60000" - OCR Checkpoint: "Gas Stations" Timeout: "60" Threshold: "90"
	Then I open Gas Stations iOSphone
	Then Transaction "2 Gas Stations Loaded?" description: "Verifying gas stations loaded" SLA: "60000" - OCR Checkpoint: "Haffner's" Timeout: "60" Threshold: "90"
	
@vzNavRouteAddressPhone 
Scenario: VZ_Nav_Route_Address_Android
	#Given I use default driver 
	Then I toggle wifi "disabled"
	#Then I set device location to "42.6285206,-71.306298"
	Then I open VZNav app phone
	Then Transaction "1 VZ Nav Launched?" description: "Opening VZ Nav App" SLA: "60000" - OCR Checkpoint: "Gas Stations" Timeout: "60" Threshold: "90"
	Then I search for address "165 Massachusetts Ave " phone 
	Then I perform an Image click "PUBLIC:Prod/VZNav/LocationMailboxIcon.png" with a timeout of "20" and a threshold of "85"
	Then Transaction "2 Find Address?" description: "Checking if found on map" SLA: "60000" - OCR Checkpoint: "share" Timeout: "60" Threshold: "85"
	Then I click go on route phone
	Then Transaction "3 Navigate?" description: "Navigation Steps Displayed" SLA: "60000" - OCR Checkpoint: "Lawrence St" Timeout: "70" Threshold: "100"
	
	@vzNavRouteAddressiPhone 
Scenario: VZ_Nav_Route_Address_iPhone 
	#Given I use default driver 
	Then I toggle wifi "disabled"
	#Then I set device location to "42.6285206,-71.306298"
	Then I open VZNav app phone
	Then Transaction "1 VZ Nav Launched?" description: "Opening VZ Nav App" SLA: "60000" - OCR Checkpoint: "Gas Stations" Timeout: "60" Threshold: "90"
	Then I search for address "66 Plain St, Lowell MA " phone
	Then I select dialog "66 Plain St " with a haystack defined by x: "0%" , y: "15%" , height: "40%" , width: "100%"
	Then Transaction "2 Find Address?" description: "Checking if found on map" SLA: "60000" - OCR Checkpoint: "mi. away" Timeout: "60" Threshold: "90"
	Then I click on map address "Lowell MA" phone
	Then I click go on route iOSphone
	Then Transaction "3 Navigate?" description: "Navigation Steps Displayed" SLA: "60000" - OCR Checkpoint: "Prince" Timeout: "60" Threshold: "100"
	
	
@vzNavRoutePOIPhone 
Scenario: VZ_Nav_Route_POI_Android 
	#Given I use default driver 
	Then I toggle wifi "disabled"
	Then I set device location to "42.6285206,-71.306298"
	Then I open VZNav app phone
	Then Transaction "1 VZ Nav Launched?" description: "Opening VZ Nav App" SLA: "60000" - OCR Checkpoint: "Gas Stations" Timeout: "60" Threshold: "90"
	Then I search for POI "Mcdonalds" phone
	Then Transaction "2 Find Place?" description: "Checking if found on map" SLA: "60000" - OCR Checkpoint: "Mcdonalds" Timeout: "60" Threshold: "90"
	Then I select dialog "Plain St" with a haystack defined by x: "0%" , y: "15%" , height: "40%" , width: "100%"
	#Then I perform an Image click "PUBLIC:VZ Navigator/GoDetails_GPad.png" with a timeout of "10" and a threshold of "89"
	Then Transaction "3 Place Details?" description: "Destination Details" SLA: "60000" - OCR Checkpoint: "01851" Timeout: "60" Threshold: "100"
	Then I click go on route phone
	Then Transaction "4 Navigate?" description: "Navigation Steps Displayed" SLA: "60000" - OCR Checkpoint: "Gorham St" Timeout: "60" Threshold: "100"
	
	
	@vzNavRoutePOIiPhone 
Scenario: VZ_Nav_Route_POI_iPhone 
	#Given I use default driver 
	Then I toggle wifi "disabled"
	Then I set device location to "42.6285206,-71.306298"
	Then I open VZNav app phone
	Then Transaction "1 VZ Nav Launched?" description: "Opening VZ Nav App" SLA: "60000" - OCR Checkpoint: "Gas Stations" Timeout: "60" Threshold: "90"
	Then I search for POI "Mcdonalds " phone
	Then Transaction "2 Find Place?" description: "Checking if found on map" SLA: "60000" - OCR Checkpoint: "McDonalds" Timeout: "60" Threshold: "90"
	Then I select dialog "66 Plain St " with a haystack defined by x: "0%" , y: "15%" , height: "40%" , width: "100%"
	Then Transaction "3 Place Details?" description: "Navigation Steps Displayed" SLA: "60000" - OCR Checkpoint: "mi away" Timeout: "60" Threshold: "90"
	Then I click go on route iOSphone
	Then Transaction "4 Navigate?" description: "Navigation Steps Displayed?" SLA: "60000" - OCR Checkpoint: "Prince" Timeout: "90" Threshold: "90"
