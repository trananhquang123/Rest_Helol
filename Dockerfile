FROM openjdk:8
ADD target/user-postgres.jar user-postgres.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","/user-postgres.jar"]
