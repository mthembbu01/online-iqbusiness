FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
ARG JAR_FILE=target/online-iqbusiness.jar
COPY ${JAR_FILE} iq-app.jar
ENTRYPOINT ["java","-jar","iq-app.jar"]
