# Use imagem oficial do Java
FROM openjdk:17-jdk-slim

# Diretório de trabalho no container
WORKDIR /app

# Copia o arquivo jar compilado (mude o nome conforme o seu projeto gerado)
COPY target/*.jar app.jar

# Comando para rodar o jar
ENTRYPOINT ["java", "-jar", "app.jar"]
