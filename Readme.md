Execute de program:
- gradlew bootRun

Create a jar :
- gradlew build
Execute it:
- java -jar build/libs/Task-0.0.1-SNAPSHOT.jar


Swagger:
http://localhost:8080/swagger-ui/index.html#/

Docker:
- Build the image: docker build -t task:0.0.1 .
- Run the image: docker run -d -p 8080:8080 --name my-task-app task:0.0.1
- Stop the cotainer: docker stop my-task-app
- Delete it: docker rm my-task-app
- Compose: 
    - docker-compose up -d
    - docker-compose down
