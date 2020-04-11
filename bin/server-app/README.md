# employee-springboot-microservice
This is a spring boot microservice that expose REST APIs to create new Employee, get all employees list, get a employee by ID, delete, and update an existing employee. Oracle XE is used as database. 

# DAO INFO
This microservice has implemented core Hibernate, Standard Java JPA, and Spring Data JPA separately for Data Access Object layer 

FYI Hibernate and Spring Data JPA both follows Standard Java JPA implementations and both use ORM (Object Relational Mapping) 

# Spring AOP(Aspect Oriented Programming)
AOP uses aspect(which is a common feature like Exception Handling, Application logging, Security, Transaction etc. that can be used at different locations in our application). 

This microservice is using @ControllerAdvice for Exception Handling which is a type of Advice(what action is taken and when it should be applied) in AOP. 

# swagger
http://localhost:8081/swagger-ui.html#/




