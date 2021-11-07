# Giant Machines take home project
[![GitHub issues](https://img.shields.io/github/issues/mike2flee/takeHomeService)](https://github.com/mike2flee/takeHomeService/issues)

**Version 0.0.1**

The purpose of this project is to act as the api for [gmTakeHomeClient](https://github.com/mike2flee/gmTakeHomeClient/)

## Key Features
- Extract and maintain data in-memory from a CSV data set
- An endpoint that returns all the data
- An endpoint for fetching data based on a provided 'client name' criteria
- An endpoint to create new data in-memory

## Prerequisite
Install Java and Maven
- [Java](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/install.html)

## Installation

### Install and Start through IDE
1. clone project from github

```bash
git clone https://github.com/mike2flee/takeHomeService
```
2. Import the project into respective IDE as a Maven project
3. Pull in dependencies 
4. Start project

### Install and Start through terminal
1. clone project from github

```bash
git clone https://github.com/mike2flee/takeHomeService
```

2. go to the project root directory

```bash
cd takeHomeService
```

4. package the application 

```bash
./mvnw package
```
4. start the application 

```bash
java -jar target/*.jar
```


## Contributors

- Michael Baggie <micjj78@gmail.com>



