FROM adoptopenjdk/openjdk15
COPY ./target/simple-gateway-0.0.1-SNAPSHOT.jar simple-gateway-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "simple-gateway-0.0.1-SNAPSHOT.jar"]