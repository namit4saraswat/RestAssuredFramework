Feature: Validating Place API

@AddPlaceAPI
Scenario Outline: Verify if place is added successfully using addPlace API
	Given Add place payload with "<name>" "<language>" "<address>"
	When user calls "AddPlaceAPI" with "Post" http request
	Then the API returns 200 status code
	And "status" in reponse is "OK"
	And "scope" in reponse is "APP"
	
Examples:
	|name     | language |address     |
	|The House| English  | Maholi Road|
	 