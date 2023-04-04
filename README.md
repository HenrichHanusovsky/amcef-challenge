
## AMCEF project

Amcef project is Java application used to showcase the skills in Java development. It is containerized using Docker.


### Technologies Used

- Java 20
- Spring Boot
- Docker
- Maven
- Lombok

### Running application

For running application, `run.sh` script was prepared, which can be simply executed from CLI:

```shell
./run.sh
```

It consists of following steps:
1. Runs maven install
2. Creates docker image from Amcef application
3. Runs docker-compose, where Amcef application is running together with PostgreSQL database.


After running application, Amcef app is exposed at `localhost:8080`, 
for more information about endpoints, see Swagger documentation at http://localhost:8080/swagger-ui.html