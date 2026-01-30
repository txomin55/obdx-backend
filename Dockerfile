#
# Build stage
#
FROM eclipse-temurin:25-jdk AS build
WORKDIR /home/t-manager-obdx-backend
COPY gradlew gradlew
COPY gradle/ gradle/
COPY settings.gradle.kts build.gradle.kts ./
COPY obdx-backend-domain/ obdx-backend-domain/
COPY obdx-backend-application/ obdx-backend-application/
COPY obdx-backend-infrastructure/ obdx-backend-infrastructure/
COPY obdx-backend-loader/ obdx-backend-loader/

RUN ./gradlew :obdx-backend-loader:bootJar -PspringProfilesActive=production -x test

#
# Package stage
#
FROM eclipse-temurin:25-jre
LABEL maintainer="txomin.sirera@gmail.com"
LABEL version="1.0"
VOLUME /tmp/t-manager-obdx-backend
COPY --from=build /home/t-manager-obdx-backend/obdx-backend-loader/build/libs/*.jar /usr/local/lib/t-manager-obdx-backend.jar
EXPOSE 4001
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=production", "/usr/local/lib/t-manager-obdx-backend.jar"]
