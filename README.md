# Github search service

How to start the Github search service application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/github-search-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`


---
How to call into the server

http://localhost:8080/search/50 -X POST -H "Accept:application/json" -v
