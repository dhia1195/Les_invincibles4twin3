FROM openjdk:17
EXPOSE 8070
ADD target/UniversiteMicroService-0.0.1-SNAPSHOT.jar UniversiteMS-docker.jar
ENTRYPOINT ["java","-jar","UniversiteMS-docker.jar"]