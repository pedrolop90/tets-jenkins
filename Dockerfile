ARG BUILD_IMAGE=maven:3.5-jdk-11
ARG RUNTIME_IMAGE=openjdk:11-jdk-slim

FROM ${BUILD_IMAGE} as dependencies
COPY pom.xml ./
COPY src ./src
RUN mvn -B -U clean package

FROM ${RUNTIME_IMAGE}
COPY --from=dependencies /target/usuario-*.jar /app/service.jar
CMD ["java", "-jar", "/app/service.jar"]