
# Maven
FROM maven:3.8.1-openjdk-11-slim as Builder



WORKDIR /app/
COPY pom.xml .
COPY src/ ./src
RUN mvn clean && \
    mvn package
RUN ls -l target/
FROM openjdk:11-jre-slim-buster

WORKDIR /app/


COPY --from=Builder /app/target/*.jar .

ENV DB_HOST=exam_db

#CMD ["sh", "-c", "/usr/local/openjdk-11/bin/java -jar /*.jar"]
CMD ["sh", "-c", "/usr/local/openjdk-11/bin/java -jar examapp-0.0.1-SNAPSHOT.jar"]
