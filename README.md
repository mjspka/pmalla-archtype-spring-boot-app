# pmalla-archtype-spring-boot-app

# Synopsis

This project is created to as a custom archtype for maven. With this custom archtype, it is easy to create multiple 
spring-boot applications with a predefined maven and swagger configuration.

# Environment setup

### Install Java
* Make sure that java executables are in the PATH. This project requires Java 8.

### Install Maven
* Make sure that maven executables are in the PATH.
* Make sure that settings.xml is properly configured with proxy if any.

### Install Git

##### Git global setup

 git config --global user.name "firstName lastName"

 git config --global user.email "user@domain.com"


##### Clone the repository
cd <your-word-directory>
git clone https://github.com/mjspka/pmalla-archtype-spring-boot-app.git
cd pmalla-archtype-spring-boot-app

# Run the application
* cd pmalla-archtype-spring-boot-app
* mvn clean install

Now this custom archtype is available in the local catalog of maven.

# How to create spring-app application with this custom arch type
* cd <your-work-directory>
* mvn archetype:generate -DarchetypeGroupId=com.pmalla  -DarchetypeArtifactId=pmalla-archtype-spring-boot-app  \
  -DarchetypeVersion=1.0 -DgroupId=<new group id> -DartifactId=<new artifact id>
  
This should create new maven project

# API Reference
### Prerequisites
* Start the application either locally on your laptop/desktop or in a remote server.
### How to access the api?
If you are running the application locally. Please refer the API from the [URL](http://localhost:8080/swagger-ui.html). 

FYI: The actual API for fetching hospital data is http://localhost:8080/env

# Features
### Swagger
Swagger is added to the project. All the api's that are part of this micro-service can be viewed from URL, <server-ip/host-name>:8080/swagger-ui.html

###jUnits
All the code is covered with jUnits. I have an example of integration test and also with Mock objects. The jUnit on service layer is integration test. The jUnit on controller is based of Mock objects.


# Contributors

Praveen Malla

# License

TBD

# How to make changes to this file?
[Click me to learn about markup](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)
