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
The server is "protected" by Http Basic Authentication. The user and passowrd is "admin"

To call the server with credentials, use the following (if using linux):
curl -H "Accept:application/json" -H "Authorization: Basic YWRtaW46YWRtaW4=" "http://localhost:8080/search?top=5" -v
