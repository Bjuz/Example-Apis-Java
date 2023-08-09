# Usar la imagen base de OpenJDK
FROM openjdk:17

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo JAR compilado a la imagen
COPY build/libs/Task-0.0.1-SNAPSHOT.jar app.jar

# Comando para ejecutar la aplicación al iniciar el contenedor
CMD ["java", "-jar", "app.jar"]
