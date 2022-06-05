FROM openjdk:12-jdk-alpine
COPY exchange-rate-0.1.0.jar exchange-rate-0.1.0.jar
CMD ["java","-jar","exchange-rate-0.1.0.jar"]