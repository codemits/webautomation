# Java-TestNG: Web Test Automation Framework
Purpose: Project used in backend and frontend automation. This framework is hybrid and available utility helps UI and   
Backend automation with Page Object Model, along with BDD. BDD - Gherkin/Cucumber is used for better understanding the
Business feature

# Technologies used
* Programming language - Java, Gherkins
* Automation tool - WebDriver
* IDE - IntelliJ
* Assertion framework - TestNG

# Coding guid lines
* Follow the correct naming convention
* Please don't forget to add method signature
* Please add appropriate comments
* Don't forget tp clean the unnecessary logs statements

# Application Under Test
We are using following environments.
1. QA - <Environment URL to add>

# Installation
Install the dependencies and devDependencies to run the test.

* Clone (OR) Download this repo as zip folder on to your local machine

Top - Level Directory Layout

```sh
.
├── WEBAUTOMATION-FRAMEWORK                   # Here you can find the entire project.
|    ├── src                                  # This folder contains all the framework structure
│           ├── base                          # This folder contains test base class
|                   ├── TestBase.java         # This is the Test Base Class, which contains all the initial setup 
│           ├── config                        # This folder contains all the environment configs 
|                   ├── config.prop           # qa environment related config goes here 
│           ├── Cucumber                      # Not Added yet - Need to update this Cucumber Capabilities
|           ├── pages                         # All the page level Objects goes here
|           ├── Utils                         # All the utility goes here
|           ├── extentReport                  # Report related artifacts 
|   ├── test
|           ├── *test                         # All the test class goes here 
|   └── README.md
```
