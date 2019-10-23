@indy
Feature: IndyCar Feature 
#Sample Test Scenario Description
@indyVodPhone
Scenario: IndyCar VOD Android Phone
	#Given I use default driver
	Then I initialize IndyCar app 
	Then I navigate to videos phone
	Then Transaction "1 Videos Open?" description: "Opening video window" SLA: "60000" - OCR Checkpoint: "Latest Videos" Timeout: "30" Threshold: "100"
	Then Transaction: "2 Videos Loaded?" Description: "Verifying video loaded" SLA: "60000" - Image checkpoint: "PUBLIC:script/Samsung_Galaxy Note III SM-N900V_150519_125147.png" Timeout: "30" Threshold: "50" 
	Then I play first video phone
	Then Transaction: "3 Did Video Play?" Description: Verify Video SLA: "60000" threshold: "100"
	Then I navigate back phone
	Then I navigate to other videos "Team Videos" phone
	Then Transaction: "4 Alternate Video Category Opened?" Description: "Did alternate video filter work?" SLA: "60000" - OCR checkpoint: "Teams Videos" Timeout: "30" Threshold: "100"
	Then I swipe down to show more phone
	Then Transaction: "5 Show More Link Visible?" Description: "Show more appears at end of video list" SLA: "60000" - OCR checkpoint: "Show More" Timeout: "30" Threshold: "100"
	
@indyVodiOSPhone
Scenario: IndyCar VOD iPhone
	#Given I use default driver
	Then I initialize IndyCar app 
	Then I navigate to videos phone
	Then Transaction: "1 Videos Open?" Description: "Opening video window" SLA: "60000" - OCR checkpoint: "Latest Videos" Timeout: "30" Threshold: "100"
	#Then Transaction "1 Videos Open?" description: "Opening video window" SLA: "60000" - OCR Checkpoint: "Latest Videos" Timeout: "30" Threshold: "100"
	Then Transaction: "2 Videos Loaded?" Description: "Verifying video loaded" SLA: "60000" - Image checkpoint: "PUBLIC:script/Samsung_Galaxy Note III SM-N900V_150519_125147.png" Timeout: "30" Threshold: "50" 
	Then I play first video phone
	Then Transaction: "3 Did Video Play?" Description: Verify Video SLA: "60000" threshold: "100"
	Then I navigate back phone
	Then I navigate to other videos "Team Videos" phone
	Then Transaction: "4 Alternate Video Category Opened?" Description: "Ensure alternatve video filter worked" SLA: "60000" - OCR checkpoint: "Teams Videos" Timeout: "30" Threshold: "100"
	Then I swipe down to show more phone
	Then Transaction: "5 Show More Link Visible?" Description: "Show more at end of video list" SLA: "60000" - OCR checkpoint: "SHOW MORE" Timeout: "30" Threshold: "100"
	
	@indyVodiPad
	Scenario: IndyCar VOD iPad
	#Given I use default driver
	Then I rotate the device to portrait
	Then I rotate the device to landscape
	Then I initialize IndyCar app 
	Then I navigate to videos iPad
	Then Transaction: "1 Videos Open?" Description: "Opening video window" SLA: "60000" - OCR checkpoint: "Latest Videos" Timeout: "30" Threshold: "100" 
	Then Transaction: "2 Videos Loaded?" Description: "Verifying video loaded" SLA: "60000" - Image checkpoint: "PUBLIC:script/Samsung_Galaxy Note III SM-N900V_150519_125147.png" Timeout: "30" Threshold: "50"
	Then I play first video iPad
	#Then Transaction: "3 Did Video Play?" Description: Verify Video SLA: "60000"  threshold: "90"
	Then Transaction: "3 Did Video Play?" Description: Verify Video SLA: "60000" threshold: "96"
	Then I navigate to other videos "Team Videos" phone
	Then Transaction: "4 Alternate Video Category Opened?" Description: "Ensure alternate video filter worked" SLA: "60000" - OCR checkpoint: "Teams Videos" Timeout: "30" Threshold: "100"
	Then I swipe down to show more iPad
	Then Transaction: "5 Show More Link Visible?" Description: "Ensuring show more appears at end of video list" SLA: "60000" - OCR checkpoint: "SHOW MORE" Timeout: "30" Threshold: "100"
	
	@indySocialiOSPhone
	Scenario: IndyCar Social iPhone
	#Given I use default driver
	Then I initialize IndyCar app 
	Then I navigate to social phone
	Then Transaction: "1 Social Open?" Description: "Verifying social page" SLA: "60000" - Image checkpoint: "PUBLIC:Prod/Indycar/Indycar-TweetIcon-iPhone.png" Timeout: "60" Threshold: "90"
	Then Transaction: "2 Tweets loaded?" Description: "Ensure social page is active" SLA: "60000" - OCR checkpoint: "RETWEETS" Timeout: "60" Threshold: "100"
	
	@indySocialAndroidPhone
	Scenario: IndyCar Social Android Phone
	#Given I use default driver
	Then I initialize IndyCar app 
	Then I navigate to social phone
	Then Transaction: "1 Social Open?" Description: "Verifying social page" SLA: "60000" - Image checkpoint: "PUBLIC:Prod/Indycar/Indycar-TweetIcon-Turbo.png" Timeout: "60" Threshold: "90" 
	Then Transaction: "2 Tweets loaded?" Description: "Ensure social page is active" SLA: "60000" - OCR checkpoint: "RETWEETS" Timeout: "60" Threshold: "100"
	
	@indySocialiPad
	Scenario: IndyCar Social iPad
	#Given I use default driver
	Then I initialize IndyCar app 
	Then I navigate to social iPad
	Then Transaction: "1 Social Open?" Description: "Verifying social page" SLA: "60000" - Image checkpoint: "PUBLIC:Prod/Indycar/Indycar-TweetIcon-iPhone.png" Timeout: "60" Threshold: "90" 
	Then Transaction: "2 Tweets loaded?" Description: "Ensure social page is active" SLA: "60000" - OCR checkpoint: "RETWEETS" Timeout: "60" Threshold: "100"
	
	@indyNewsArticlesiOSPhone
	Scenario: IndyCar News iPhone
	Then I initialize IndyCar app
	Then I navigate to news phone
	Then Transaction: "1 News Opened" Description: "Did News Open?" SLA: "60000" - Image checkpoint: "PUBLIC:Prod/Indycar/NewsBanner-iPhone7.png" Timeout: "30" Threshold: "85"
	Then I navigate to Exclusive news phone 
	Then Transaction: "2 Exclusive News open?" Description: "Did Exclusive News open?" SLA: "60000" - OCR checkpoint: "Exclusive News" Timeout: "60" Threshold: "80"
	Then I navigate to second news story phone
	Then Transaction: "3 News Story Opened?" Description: "Story Opened?" SLA: "60000" - Image checkpoint: "PUBLIC:Prod/Indycar/VideoShareButtoniphone.png" Timeout: "60" Threshold: "90"
	
	@indyNewsArticlesAndroidPhone
	Scenario: IndyCar News Android Phone
	Then I initialize IndyCar app
	Then I navigate to news phone
	Then Transaction: "1 News Opened" Description: "Did News Open?" SLA: "60000" - OCR checkpoint: "Latest News" Timeout: "30" Threshold: "90"
	Then I navigate to Exclusive news phone 
	Then Transaction: "2 Exclusive News open?" Description: "Did Exclusive News open?" SLA: "60000" - OCR checkpoint: "Exclusive News" Timeout: "60" Threshold: "100"
	Then I navigate to second news story phone
	Then Transaction: "3 News Story Opened?" Description: "Story Opened?" SLA: "60000" - Image checkpoint: "PUBLIC:Prod/Indycar/VideoShareButton-Turbo.png" Timeout: "60" Threshold: "90"
	
	@indyNewsArticlesiPad
	Scenario: IndyCar News iPad
	Then I rotate the device to portrait
	Then I rotate the device to landscape
	Then I initialize IndyCar app
	Then I navigate to news iPad
	Then Transaction: "1 News Open?" Description: "Opening video window" SLA: "60000" - OCR checkpoint: "Latest News" Timeout: "30" Threshold: "80" 
	Then I navigate to Exclusive news iPad 
	Then Transaction: "2 Exclusive News open?" Description: "Did Exclusive News open?" SLA: "60000" - OCR checkpoint: "Exclusive News" Timeout: "60" Threshold: "100"
	Then I navigate to second news story phone
	Then Transaction: "3 News Story Opened?" Description: "Story Opened?" SLA: "60000" - Image checkpoint: "PUBLIC:Prod/Indycar/VideoShareButtoniPad.png" Timeout: "60" Threshold: "90"
	
	@indyPhotosiPad
	Scenario: IndyCar Photos iPad
	#Given I use default driver
	Then I rotate the device to portrait
	Then I rotate the device to landscape
	Then I initialize IndyCar app 
	Then I navigate to photos iPad
	Then Transaction: "1 Photos Open?" Description: "Opening Photos window" SLA: "60000" - OCR checkpoint: "Latest Photos" Timeout: "30" Threshold: "100"
	Then Transaction: "2 Photos Loaded?" Description: Photos Loaded SLA: "60000" threshold: "90"
	Then I open first photo iPad
	Then Transaction: "Photo opened?" Description: "Did photo open?" SLA: "60000" - Image checkpoint: "PUBLIC:Prod/Indycar/PhotoShareButton-iPad.png" Timeout: "30" Threshold: "90"
	Then I click back
	Then I navigate to other photos iPad
	Then Transaction: "4 Alternate Photo Category Opened?" Description: "Ensure alternate video filter worked" SLA: "60000" - OCR checkpoint: "sits on pit lane" Timeout: "40" Threshold: "90"
	#Then I swipe down to show more iPad
	#Then Transaction: "5 Show More Link Visible?" Description: "Ensuring show more appears at end of video list" SLA: "60000" - OCR checkpoint: "SHOW MORE" Timeout: "30" Threshold: "100"
	
	@indyPhotosiPhone
	Scenario: IndyCar Photos iPhone
	Then I initialize IndyCar app 
	Then I navigate to photos phone
	Then Transaction: "1 Photos Open?" Description: "Opening Photos window" SLA: "60000" - OCR checkpoint: "Latest Photos" Timeout: "30" Threshold: "100"
	Then Transaction: "2 Photos Loaded?" Description: Photos Loaded SLA: "60000" threshold: "90"
	Then I open first photo iPhone
	Then Transaction: "Photo opened?" Description: "Did photo open?" SLA: "60000" - Image checkpoint: "PUBLIC:Prod/Indycar/photosShareButton.png" Timeout: "30" Threshold: "90"
	Then I click back
	Then I navigate to other photos iPhone
	#Then Transaction "4 Alternate Photo Category Opened?" description: Alternate Photos opened SLA: "60000" OCR Checkpoint: Category Name Timeout: "60" Threshold: "90"
	
