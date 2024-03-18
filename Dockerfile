FROM openjdk:21
ADD build/libs/*.jar app.jar
CMD ["java", "-jar", "app.jar"]