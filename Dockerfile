FROM adoptopenjdk:11-jre-hotspot

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
CMD java -Dspring.profiles.active=prod -jar -server -Duser.timezone=GMT-3 app.jar