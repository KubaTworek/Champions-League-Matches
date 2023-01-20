# Champions-League-Matches
> The application presents an API that allows you to retrieve data from a JSON file. We have the ability to return matches based on specific parameters. In addition, we return the names of the teams participating in these matches.


## Table of Contents
* [General Info](#general-information)
* [Technologies Used](#technologies-used)
* [Run and Test](#run-and-test)
* [Endpoints](#endpoints)


## General Information
- The application provides us with two endpoints. One returns a personalized response about the matches in which the probability of achieving a certain result is the highest. The other returns to us alphabetically the teams participating in these matches.

- The project is a recruitment task to demonstrate knowledge of Java tools, object-oriented programming and understanding of basic algorithms and data structures.


## Technologies Used
- Java 17
- Spring Boot
- JUnit, Mockito


## Run and Test

To run the application type

```
mvn spring-boot:run
```

To execute tests

```
mvn test
```


## Endpoints

* Get matches with the highest probability of result: `GET/matches/{amountOfMatches}`
* Get teams alphabetically: `GET/teams/{competitionName}`