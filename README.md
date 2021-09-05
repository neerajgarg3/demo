# Demo

Demo application

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/au/java/technologies/javase-jdk11-downloads.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

Clone the repo to download the code locally

```shell
git clone https://github.com/neerajgarg3/demo.git
```

Build the code using:
```shell

mvn clean package
```

Run the app using:

```shell
java -jar ./target/demo-0.0.1-SNAPSHOT.jar
```
By default the app will start on port 8080, to run the application on a custom port please use following command:

```shell
java -jar ./target/demo-0.0.1-SNAPSHOT.jar --server.port=<port>

```

## APIs

Healthcheck:
```shell
http://localhost:8080/demo/actuator/health

```


Get Users with posts:
```shell
http://localhost:8080/demo/api/users?includePosts=true

```

Get users without posts:

```shell
http://localhost:8080/demo/api/users?includePosts=false
or
http://localhost:8080/demo/api/users

```

## Swagger Documentation
TBD

