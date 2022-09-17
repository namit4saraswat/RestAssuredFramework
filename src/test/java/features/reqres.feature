Feature: Validate reqres API's

Scenario: Verify is List User api is working fine
	Given listUsers payload with queryParam key "page" and value "2"
	When user calls "listUsers" with "get" http request
	Then the API returns 200 status code
	And "page" in reponse is "2"
	And "last_name" in reponse is "Ferguson"