# Stage 1: Build
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copier les fichiers de configuration Maven
COPY pom.xml .
COPY src ./src

# Construire l'application
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Créer le répertoire pour les logs
RUN mkdir -p /app/logs

# Créer un utilisateur non-root
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copier le JAR depuis le stage de build
COPY --from=build /app/target/*.jar app.jar

# Exposer le port
EXPOSE 8082

# Configuration JVM
ENV JAVA_OPTS="-Xms256m -Xmx512m -XX:+UseG1GC"

# Point d'entrée
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]

# Health check
HEALTHCHECK --interval=30s --timeout=3s --start-period=40s --retries=3 \
  CMD wget --quiet --tries=1 --spider http://localhost:8082/actuator/health || exit 1
