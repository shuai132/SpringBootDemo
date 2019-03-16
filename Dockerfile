FROM openjdk:11-jre-slim

VOLUME /SpringBootDemo_DATA
EXPOSE 8080
ENV APP_ENV dev

WORKDIR /app
COPY build/libs/SpringBootDemo-*.jar /app/app.jar
CMD ["java", "-jar", "app.jar", "--spring.profiles.active=${APP_ENV}"]