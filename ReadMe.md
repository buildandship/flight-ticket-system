# Flight Ticket System


Design patterns I will be used in this app
1. Decomposition
    1. Decompose by Subdomain -> Implemented by identifying the core domains like Planes, Passengers, Flights and implemented business functionality using microservices like Planes, Passengers and Flight Microservices.
    2. Details about the DDD, identified the domains and their core services and implemented them. Project Code structure followed the domain driven design approach
    3. domain     - Show this via intellij Code base and github https://github.com/buildandship/flight-ticket-system
       configuration
       dto
       exception
       model
       repository
       resource
       service
       infra
       web
       interfaces    
       https://github.com/buildandship/flight-ticket-system


2. Integration
    1. API gateway -> Implemented API gateway using Spring Cloud Gateway -> show via hints the API through service and through the API gateway show demo and then show code
        1. http://localhost:8080/planes-service/api/planes    -> http://localhost:5002/api/planes
        2. http://localhost:8080/passengers-service/api/passengers -> http://localhost:5001/api/passengers
        3. http://localhost:8080/flights-service/api/flights -> http://localhost:5003/api/flights

    2. Gateway Routing Patterns -> Implemented using Routes in yml in Gateway microservice. Show application.yml in routes section and explain about it. Hit http://localhost:8080/actuator/gateway/routes
    3. Chained Microservice -> Implemented this pattern using WebClient for calling flights microservices -> This is used to call planes microservice to create the flight. Flight must have plane information like Plane number,plane model, No of seats in plane. How does create will invoke the planes service via id and get planes by ID API and then populate the planes information to flight and create flight.
3. Database
    1. Database per service -> Created separate databases for each service. Show tables in Robo3T and show the db related configuration in application.yml for planes, passengers etc. Why did you choose NoSQL and future to move to ReactiveCrudRepository and Reactive microserivce via Mono and Flux
4. Observability
    1. Distributed tracing -> Explain about distributed tracing concepts like Service Name, Trace Id, Span Id and export flag via logs. Explain about the integration zipkin and how does it get configured. Open the zipkin server url via http://localhost:9411/zipkin/ search service name then hit API and then search again show the details. Hit different API and show the dependencies between different microservice via http://localhost:9411/zipkin/dependency explain how does this is helpful while investigating the issues across microservice architecture.
    2. Health Check ->  Implemented using Spring Boot Admin server with the help of Spring Boot Actuator. What is Admin server and open the at http://localhost:5004/ . Show the wallboard, show running multiple instances of same service by making changes in application.properties of planes service and spawn two instances. Show the actutator endpoints and data via http://localhost:5002/actuator and show various endpoints and metrices under this.
5. Cross-cutting concern
    1. External Configuration -> Explain about the use of spring cloud config server. Store config in the environment for different profiles like test-config.yml, test-config-dev.yml and test-config-prod.yml via endpoints used in config server like http://localhost:8888/config/test-config/default http://localhost:8888/config/test-config/dev http://localhost:8888/config/test-config/prod . Then explain the Dependencies Explicitly declare and isolate dependencies concept of 12 Factor app. Show how does configuration can be updated at run time if configuration properties are stored outside the codebase. Show practical via hitting the endpoints and explain these in details the concept of RefreshScope. http://localhost:8888/config/planes-service/default -> make changes in planes-service.yml and commit  http://localhost:5002/api/refresh -> updated changes show here but not http://localhost:8888/config/planes-service/default -> hit post call via actutator http://localhost:5002/actuator/refresh and updated value reflected.
    2. Service Discovery -> How is eureka service discovey works and how we have registered all the service via spring cloud eureka netflix client. Show the configuration and show the URL http://localhost:8761/


API documentation via Swagger
http://localhost:8080/planes-service/swagger-ui
http://localhost:8080/planes-service/v2/api-docs

http://localhost:8080/passengers-service/swagger-ui
http://localhost:8080/passengers-service/v2/api-docs

http://localhost:8080/flights-service/swagger-ui
http://localhost:8080/flights-service/v2/api-docs