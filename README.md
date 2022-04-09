Selenium-cucumber-java selenium-cucumber : BookingFlight Automation Testing Using Java

Pre-requisites • Java • Maven • Intellij o Maven o Cucumber

Setting up selenium-cucumber-java • Install Java and set path. • Install Maven and set path. • Clone respective repository or download zip. o How to run the Project

Go to your project directory from terminal and hit following commands • mvn clean install
• mvn test

Running features • Goto project directory. • Use "mvn test" command to run features. • Use mvn test -Dcucumber.options="classpath:features/searchNSW.feature" to run specific feature if you have multiple feature files. • Use mvn test -Dcucumber.options="–-plugin html:target/result-html" to generate a HTML report. • Use mvn test -Dcucumber.options="–-plugin json:target/result-json" to generate a JSON report. •

Test source files are in src\test\java folder Page objects available in src\test\java\OnlinePages Feature files are available in src\test\java\resources\features Runner file is available in src\test\java\runner StepDefinitions are available in src\test\java\stepDefinitions.

Generated reports are available in the project directory under Target folder : serviceNSW/serviceNSW-Project/target/cucumber-reports/
