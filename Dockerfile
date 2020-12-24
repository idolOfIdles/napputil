FROM adoptopenjdk/openjdk11

ENV MONGO_HOST localhost
ENV MONGO_PORT 27017
ENV MONGO_DATABASE hr
ENV MONGO_USERNAME admin
ENV MONGO_PASSWORD admin

ARG JAR_FILE=build/libs/assignment-*.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT exec java \
-Dmongo.connection.host=${MONGO_HOST} \
-Dmongo.connection.port=${MONGO_PORT} \
-Dmongo.connection.database=${MONGO_DATABASE} \
-Dmongo.connection.username=${MONGO_USERNAME} \
-Dmongo.connection.password=${MONGO_PASSWORD} \
-jar /app.jar
