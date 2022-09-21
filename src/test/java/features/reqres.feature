Feature: Validate reqres API's

@listUser
Scenario: Verify if List User api is working fine
	Given request with queryParam key "page" and value "2"
	When user calls "listUsers" with "get" http request
	Then the API returns 200 status code
	And "page" in reponse is "2"
	
@Createuser
Scenario Outline: Verify if create User Post API is working fine
	Given createUser payload with "<name>" and "<job>"
	When user calls "createuser" with "Post" http request
	Then the API returns 201 status code
	And "name" in reponse is "<name>"
	And "job" in reponse is "<job>"
Examples:
	|name | job|
	|Namit| QA|
	
@UpdateUser
Scenario Outline: Verify if update User put API is working fine
	Given createUser payload with "<name>" and "<job>"
	When user calls "updateUser" with "Put" http request
	Then the API returns 200 status code
	And "name" in reponse is "<name>"
	And "job" in reponse is "<job>"
	
Examples:
	|name | job|
	|Namit| QA|
	