FROM openjdk:8-alpine

COPY ./PadelVersus.jar /padelversus.jar
COPY DemoImages /DemoImages
RUN mkdir -p /pdf_temp

CMD ["java","-jar","padelversus.jar"]
