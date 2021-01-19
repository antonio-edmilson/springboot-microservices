FROM openjdk:11

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /app

COPY /target/product-microservice*.jar /app/product-microservice.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 9090

CMD java ${ADDITIONAL_OPTS} -jar product-microservice.jar --spring.profiles.active=${PROFILE}