FROM openjdk:11-jre-slim
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
#
#ARG version=latest
#LABEL authors="tersoman"
#
#WORKDIR /app
#COPY . /app
#RUN ./gradlew build
#
#ENTRYPOINT ["java","-jar", "application.jar"]

#CMD ["java", "-jar", "build/libs/core.jar"]

#FROM ubuntu:latest
#ENTRYPOINT ["top", "-b"]

#docker-compose up
#pause, down (remove) , ps (status), logs, exec