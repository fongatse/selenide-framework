# selenide-framework
Selenide automation framework Page Object pattern

## About 

This repository was created for the purpose of showcasing my test automation skills as well as practice of the new Selenide
test framework. The framework is quick to learn and is powered by Selenium Webdriver. I consider it's main advantage to be it's
quick and easy configuration and ease of use of the different selectors. This project is designed to run tests through Maven on Jenkins.

## Project Structure 

This project follows the Page Object pattern, which adds a decoupling layer to the tests, making the tests less fragile to UI changes.
The idea is that, changes can be made in a single place in my case it will usually be in the components package. This in practice 
makes it easier to change and add elements, you should be able to directly know where exactly the change or additional feature should 
be implemented. 

This project tests the functionality of the novel reading web application https://wuxiaworld.com. The tests are data driven, data about the
user are parsed from a JSON format and used in different tests.

*The tests are organised in the following structure:*

* resources
  * _components_ - this package has individual components that can be found on a specifici page, components are divided into packages based
                 on the page they're on.
  * _data_ - this package contains JSON user data and the JSON Parser class
  * _pages_ - this package contains page objects
  * _tests_ - this package contains test suites 
  

## Maven Dependencies Used

* Maven Surefire
* JUnit
* Selenide
* JSON Simple

*For the description of the individual methods and classes a JAVADOC file is part of this project*
