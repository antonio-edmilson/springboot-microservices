FROM openjdk:11

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /app

COPY /target/customer-microservice*.jar /app/customer-microservice.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 9093
EXPOSE 5005

CMD java ${ADDITIONAL_OPTS} -jar customer-microservice.jar --spring.profiles.active=${PROFILE}