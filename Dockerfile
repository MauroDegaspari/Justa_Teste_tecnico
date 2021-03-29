FROM openjdk

RUN mkdir -p /app/TesteJusta

ENV APP_NAME=JustaTesteTecnico.jar

COPY ${APP_NOME} /app/TesteJusta

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/TesteJusta/JustaTesteTecnico.jar" ]