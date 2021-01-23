FROM openjdk:11

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /app

COPY /target/*marketplace-frontend*.jar /app/marketplace-frontend.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 9099

CMD java ${ADDITIONAL_OPTS} -jar marketplace-frontend.jar --spring.profiles.active=${PROFILE}