FROM openjdk:11

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /app

COPY /target/product-notes-microservice-0.0.1-SNAPSHOT.jar /app/product-notes-microservice.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 9094

CMD java ${ADDITIONAL_OPTS} -jar product-notes-microservice.jar --spring.profiles.active=${PROFILE}