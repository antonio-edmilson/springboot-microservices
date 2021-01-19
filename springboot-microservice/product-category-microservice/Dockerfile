FROM openjdk:11

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /app

COPY /target/product-category-microservice*.jar /app/product-category-microservice.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 9094

CMD java ${ADDITIONAL_OPTS} -jar product-category-microservice.jar --spring.profiles.active=${PROFILE}