FROM maven:3.8.6-openjdk-21
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 9192
ENTRYPOINT ["java","-jar","demo.jar"]