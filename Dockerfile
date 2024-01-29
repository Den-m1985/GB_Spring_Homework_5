FROM adoptopenjdk/openjdk17:alpine
VOLUME /tmp
ARG JAR_FILE=target/example_2_seminar_5-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
