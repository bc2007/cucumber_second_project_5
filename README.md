# cucumber_second_project_5
TEST AUTOMATION FRAMEWORK

The purpose of this framework is validation "Smart bear software" functionality

This is Java-Maven-Cucumber TDD Framework. We are using Java as core programming language and Maven as a build tool. The Maven brings us good folder structure and centralize our dependencies in pom.xml file. It is also allowed us to execute a group of test cases with a Maven command. Our framework implemented JUnit for annotation and reports, Selenium as automation tool and bonigarcia WebDriverManager.

There is poddibility to run @Smoke and @Regression suites with using Maven command (mvn test -DCucumber.options="--tags @Regression" or mvn test -DCucumber.options="--tags @Smoke"). After one of this command runs, the execution of test cases starts from pom.xml file and then move to the Runner class. Runner class will be updated with given configuration. Depends of the Tag it gets, it will go to feature files and execute all the scenarios which have the same Tag annotation. Scenario steps will be executed with their linked implementation in the “steps” package. Finally, when the execution is complete, the reports specified in the Runner plugin will be generated, surefire reports will be generated under the target folder

In our framework we implemented Page object model, so we have created separate package for storing all locators and different classes for each application page. To be able to handle different types of the WebElements we have our utils class, where we created a lot of useful method, that make our work with assertion easier.

In the Utils package: PaymentHandler class: implements the method for test our payment input with different Test Data. DropdownHandler class: implements the method for felling out order information Waiter class: implements the method for handling synchronization issues

<img width="950" alt="1" src="https://user-images.githubusercontent.com/116987895/221960625-aeef157c-6272-4995-9142-05d3606b5c8c.png">

<img width="948" alt="2" src="https://user-images.githubusercontent.com/116987895/221960641-852e80eb-7b24-4c14-8848-c2b363c7d9a2.png">

<img width="952" alt="3" src="https://user-images.githubusercontent.com/116987895/221960656-0b45ac9d-7a11-42c6-8b33-6cb172ba2cfb.png">
