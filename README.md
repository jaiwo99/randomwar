# randomwar 

![Build Status](https://travis-ci.org/jaiwo99/randomwar.svg?branch=master)

Interview Code testing from 'a company'



## (Technical) Overview

### Get started

#### Start a game with source code
    mvn clean compile exec:java
#### Start with a jar
    // replace ${project.version} with the project version
    mvn clean package && java -jar target/randomwar-1.0-${project.version}.jar

### Features

* Character can be created
* Character can explore the map
* Character can going into a fight
* Character will either win a fight (gain score) or lose a fight (lose health)
* If character lose all the health, then the character will be reset.
* Character can be healed
* Character will be saved and can be load again.

### Data store
Data stored in file, there are 2 kinds of data model:

* warriors.txt, which stores information of a character, for example:

| id | name |
|---|---|
| d853e24d-5a56-4160-b9b6-f42286753e7b | Oliver |
| db247249-eb93-4243-bdce-19cfbe0afc74 | Emily |

* *(id), this kind of store will save all the events in order for certain character, the name of the store is id of the character. All the events will be loaded again when the character is selected before game started. for example

| Event |
|---|
| EXPLORE;23;16 |
| EXPLORE;22;3 |
| WIN_FIGHT |
| EXPLORE;67;81 |
| LOSE_FIGHT |
| GAME_OVER |

