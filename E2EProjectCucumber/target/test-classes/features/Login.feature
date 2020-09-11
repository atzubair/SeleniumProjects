Feature: Log in to Application

Scenario Outline: Positive test validating login
 
Given Initialize the browser with firefox
And Navigate to "http://www.qaclickacademy.com/" sito
And Click on the login link in homepage to land on secure sign in page 
When User eneters <username> and <password> and logs in
Then verify that the user successfully logged in
And close browser


Examples:

|username				|password	|
|tomcruise@gmail.com	|1234		|
|nicolekidman@gmai.com	|4321		|
