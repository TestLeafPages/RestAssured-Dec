Feature: Incident Mgmt

Scenario: pleace a post Request with body

Given setUp the endpoint
And set authentication with valid credential
When user post the request
Then verify the status code as 201
And verify the content type