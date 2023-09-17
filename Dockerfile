FROM openjdk:11-jdk
WORKDIR /usr/src/app
COPY ./drawJava.java .
RUN javac drawJava.java
CMD ["java", "drawJava"]
