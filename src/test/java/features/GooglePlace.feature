Feature: Google place funtionlity

Scenario: create new place on the google map
Given user prepare a request with Payload
When  user send the "POST" request
Then user get status code is "200"
Then validate "status " value is "OK"
Then validate "scope " value is "APP"