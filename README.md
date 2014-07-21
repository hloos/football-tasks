football-tasks
==============
# Application - 2 tasks : URL call to solve a problem and analysis of a bet situation

* *Author* : [Hugo Loos](hloos@outlook.com)
* *Technologies* : Java 8 / Spring 4.x / Slf4j / LogBack / Lombok / JUnit / Mockito
* *Compilation* : Maven 3.2.1
* *Application Type* : Executable (JAR packaging)
* *Summary* : Solve of an URL problem and analysis of bets.

[Download the code from GitHub](https://github.com/hloos/football-tasks)

## Purpose of this application

This application contains 2 parts: treatment of data from an Url call and analysis of data in a cvs. It is a n-tiers application focused on the back-end part.

## Architecture explanation

The application is divided in 3 main layers (view, business and persistence) and 2 cross-project layers (model and technical).
The use of the IOC design pattern emphasises this decoupling making the architecture more maintainable, more extensible 
and more scalable. The internalization is fulfilled by the RessourceBundle of the Spring framework.


## Compile and package

Being Maven centric, you can compile and package it with `mvn clean compile`, `mvn clean package` or 
`mvn clean install`. The `package` and `install` phase will automatically trigger the unit tests. 

## Execute the application

Once packaged, the application can be executed in commandline with 'java -jar tasks-1.0.0.jar'
The necessary java version to be able to run the application is java 8.

## Third Party Tools & Frameworks

### Spring : IOC and internationalization

The DI (dependency injection) allows to decouple the different layers (view, business - service and persistence layer} 
making the code more extensible, maintainable and scalable. 
Even if several frameworks can fulfill the DI task (CDI / Weld, Guice), I have decided to use the newest version of Spring. 

### Slf4j and LogBack

For the logs, Slf4j API and its implementation LogBack have been used. 
LogBack implements the Slf4j API natively, has a faster implementation (than Log4j for example), ...

### Lombok

Framework with some useful annotations to redefine automatically methods like toString() / hashCode() and equals(),
to provide instances of logger of different frameworks and to perform the input parameter validation in order to make the code 
more readable and more maintainable.  

### Spring-test, JUnit and Mockito

For the unit tests, Spring-test, JUnit 4 and Mockito are the used frameworks.

### Spark

Spark has been used to simulate the server behavior in the testing part.

## Bugs & Workaround


## Licensing

<a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/"><img alt="Creative Commons License" style="border-width:0" src="http://i.creativecommons.org/l/by-sa/3.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/">Creative Commons Attribution-ShareAlike 3.0 Unported License</a>.

<div class="footer">
    <span class="footerTitle"><span class="uc">h</span>ugo <span class="uc">l</span>oos</span>
</div>
=======
football-tasks
==============
>>>>>>> branch 'master' of https://github.com/hloos/football-tasks
