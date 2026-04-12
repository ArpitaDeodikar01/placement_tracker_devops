FROM eclipse-temurin:17
WORKDIR /app
COPY target/placement-tracker-0.0.2-SNAPSHOT.jar app.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","app.jar"]