#FROM frolvlad/alpine-oraclejdk7:slim
#FROM dockerfile/java:openjdk-7-jdk
#FROM dockerfile/java:oracle-java7
FROM frolvlad/alpine-openjdk7
VOLUME /tmp
ADD target/springbootredis-0.1.0.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
