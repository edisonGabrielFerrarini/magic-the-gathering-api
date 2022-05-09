FROM adoptopenjdk:11-jre-hotspot

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
CMD java $JAVA_OPTS -Dspring.profiles.active=prod -Xmx256m -server -Dserver-port=8080 -jar -server app.jar