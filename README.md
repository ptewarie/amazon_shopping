## Amazon automation

This contains a test for purchasing an tv 65 screen.

### Overview on automation framework

#### Structure
This automation framework has been created using Cucumber as a BDD framework
You will find that the structure has been divided into three parts:

* Features : These contain the features and test scenario written in a Gherkin syntax

* Steps : These contain the glue code that are linked to the features. Also, a hook file where you will find before and after hooks that           enable reporting and a tear down hook. Finally, you will find a TestRunner. This test runner will allow you to use TestNG to             run specifically features and is also needed for providing the Report.

* PageObjects: These contain specific locators and page specific functions for specific screens


### Prereqs:

- Install Java 8 or later
- Appium 
- Maven

### Installation

Use the following command to install:

```
mvn install
```

### Running tests

To run the test please use the following command:

```
mvn test
```

### Reports
After a test run this automation framework will automatically create a report.
You can find that report under:

**target/site/cucumber-pretty/index.html**


