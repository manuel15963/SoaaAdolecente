FROM openjdk:17

COPY Adolescente.jar /appclient.jar

CMD ["java", "-jar", "/appclient.jar"]

EXPOSE 8080