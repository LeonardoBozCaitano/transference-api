# syntax = docker/dockerfile:experimental
FROM eclipse-temurin:17-jre-alpine
LABEL maintainer="Leonardo Boz Caitano <leonardoboz@gmail.com>"

ENV JAVA_OPTS=""
ENV SPRING_OPTS=""

WORKDIR /app

#SET TIMEZONE (UTC)
RUN apk add --no-cache tzdata
ENV TZ 	Etc/UTC
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

#ADD USER
RUN addgroup -S appgroup && adduser -S appuser -G appgroup && chown -R appuser:appgroup /app

#SET DEFAULT USER
USER appuser

COPY --chown=appuser:appgroup build/libs/*.jar /app/transference.jar

EXPOSE 8080

ENTRYPOINT exec java $JAVA_OPTS -jar transference.jar $0 $@
