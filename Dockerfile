FROM openjdk:17-jdk-slim
ADD target/localization-0.0.1-SNAPSHOT.jar /usr/share/localization-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["/usr/local/openjdk-17/bin/java", "-jar", "/usr/share/localization-0.0.1-SNAPSHOT.jar"]
