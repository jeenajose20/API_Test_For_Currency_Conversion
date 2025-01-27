# Currency API Testing

This project is for testing the [Fixer API](http://data.fixer.io/api/latest), which provides currency conversion data of currencies for a base currency(EUR). The following guide explains how to set up, run, and test this project.

## Prerequisites

1. **Java JDK** (version 8 or higher)
2. **Maven** (build tool)
3. **IDE** (e.g., IntelliJ IDEA or Eclipse)
4. **Test NG** (framework)
5. **Cucumber Plugin** (optional, for better Gherkin experience in IDE)
6. **Generate API access key** (Free subscription from https://fixer.io/login)

## Usage

Open the TestRunner class in the path "src\test\java\runner"
Running the class(by default it runs as a Test NG application) will result in running all the features under the Features folder

## Test Results

The test results are created as .html file under "reports folder"(Extent Report),"target"(cucumber Report)and "test-output"(Default Report) folder.(please refresh the project if the folder is not shown after successful run.

## Note

Kindly update the apiKey if it is not working
You can also generate your own API key by following steps:
1.	Go to https://fixer.io/login
2.	Sign up and go to Free subscription
3.	Generate the API Key

## Project Structure

The project follows a standard Maven structure:
    
+---src
ª   +---main
ª   ª   +---java
ª   ª   ª   +---testCases
ª   ª   ª   ª       FixerAPITests.java
ª   ª   ª   ª       
ª   ª   ª   +---utils
ª   ª   ª           ConfigUtil.java
ª   ª   ª           ExtentReportManager.java
ª   ª   ª           
ª   ª   +---resources
ª   +---test
ª       +---java
ª       ª   +---hooks
ª       ª   ª       Hooks.java
ª       ª   ª       
ª       ª   +---runner
ª       ª   ª       TestRunner.java
ª       ª   ª       
ª       ª   +---stepDefinitions
ª       ª           FixerCurrencyAPIsteps.java
ª       ª           
ª       +---resources
ª           ª   Config.properties
ª           ª   Testng.xml
ª           ª   
ª           +---features
ª                   FixerCurrencyAPI.feature
ª                   
+---target
ª   ª   cucumber-reports.html
ª   ª  
+---reports
ª       ExtentReport.html
ª    
      