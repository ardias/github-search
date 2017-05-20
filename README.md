# Github search service

How to start the Github search service application
---

1. Clone this repo
2. Run `mvn clean install` to build your application
3. Start application with `java -jar target/github-search-1.0-SNAPSHOT.jar server config.yml`
4. To check that your application is running enter url `http://localhost:8080/healtcheck`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

Test the application
---

The server is "protected" by Http Basic Authentication. The user and password is "admin". 

The base url is http://localhost:8080/search. If no parameters are supplied, by default it will return the top 5 users, 
by amount of repositories, located in Barcelona.

There are 2 parameters supported:
  1. "top" : set the number of results to return. Supported values are 5, 10 and 50. Default is 5.
  2. "city": set the location of the users. Supported values are any city. Default is Barcelona.

To call the server with credentials, use the following (if using linux):
    curl -H "Accept:application/json" -H "Authorization: Basic YWRtaW46YWRtaW4=" "http://localhost:8080/search" -v

Or just enter the url in your browser. It will ask for the credentials.