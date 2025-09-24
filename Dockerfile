# ---------- build ----------
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Télécharge les deps en cache
COPY pom.xml .
RUN mvn -q -B -DskipTests dependency:go-offline

# Build
COPY src ./src
RUN mvn -q -B -DskipTests package

# ---------- runtime ----------
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Optionnel: tuning mémoire/GC via JAVA_OPTS
ENV JAVA_OPTS=""

# Les propriétés Spring viennent de variables d'env (cf. compose)
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar"]