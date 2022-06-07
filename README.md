# Fibonacci
Simple REST API example with Java (Spring Boot, Postgres).

## Task
[x] 1- Conduct an api Rest en java (you can use a framework such as spring or quarkus) implement an algorithm that produces the following Fibonacci number.
[x] 2- Save the intermediate results in a related database with an orm and to be used as a cache to improve work times.
[x] 3- Conduct automated tests covered 80% by code.
[x] 4- Save the statistics in the database regarding which numbers were requested most. (option 1)
[x] 5- Publish the solution on a cloud (Option 2): It is deployed on https://javaproject022.herokuapp.com

## How can you run this project on local?

### Configuration
> [Install Maven](https://maven.apache.org/install.html)
> [Install Postgres on your local laptop.](https://www.postgresqltutorial.com/postgresql-getting-started/install-postgresql/)
> You should add following variables in application.properties.
```
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.datasource.url=jdbc:postgresql://localhost:5432/testdb
```

### Run the Project
> mvnw spring-boot:run

### Test the Project
> mvnw test

### Test REST API
> Open shell and type below command.
> curl localhost:8081/fibonicci/10
> curl localhost:8081/list

## How can you run this project on heroku?

### Configuration
> [Deploy on Heroku](https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku)
> [Add on postgres to heroku](https://elements.heroku.com/addons/heroku-postgresql)
> You should be careful in target java version(Heroku currently uses OpenJDK 8 to run your application by default.)
> You should add following variables in application.properties.
```
spring.datasource.url=postgres://slqcxtcrozwfxw:c4f2ba3892155ab0d9db393402497f328ba7f6fbe5cbbec4e7afe9f1fe2ad714@ec2-3-229-161-70.compute-1.amazonaws.com:5432/d3cnaj4mvnfued
spring.datasource.username=slqcxtcrozwfxw
spring.datasource.password=c4f2ba3892155ab0d9db393402497f328ba7f6fbe5cbbec4e7afe9f1fe2ad714
```

### Test REST API
> Open shell and type below command.
> curl https://javaproject022.herokuapp.com/fibonicci/10
> curl https://javaproject022.herokuapp.com/list