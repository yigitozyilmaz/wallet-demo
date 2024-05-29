# Base image olarak resmi bir Eclipse Temurin Java 17 imajını kullanıyoruz
FROM eclipse-temurin:17-jre

# Çalışma dizini oluştur
WORKDIR /app

# JAR dosyasını container'a kopyala
COPY target/odev-0.0.1-SNAPSHOT.jar /app/wallet-demo.jar

# Uygulamayı çalıştır
ENTRYPOINT ["java", "-jar", "wallet-demo.jar"]
