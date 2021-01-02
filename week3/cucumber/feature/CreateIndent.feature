Feature: Incident Mgmt


Background:
Given setUp the endpoint
And set authentication with valid credential

Scenario: pleace a post Request without body

When user post the request
Then verify the status code as 201
And verify the content type

Scenario Outline: pleace a post Request with body

When user post the request with body as <fileName>
Then verify the status code as 201
And verify the content type

Examples:
# |Column Name1|Column Name2|......
|fileName|
# |Data1|....
|incident1|
# |Data2|..
|incident2|