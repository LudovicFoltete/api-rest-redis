FROM hirokimatsumoto/alpine-openjdk-11
VOLUME /tmp
LABEL version="1.0" maintainer="Ludovic Foltete <ludovicflb@gmail.com>" 
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
