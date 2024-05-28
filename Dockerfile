# Dockerfile

# Base image olarak resmi bir Java imajını kullanıyoruz
FROM openjdk:11-jre-slim

# Çalışma dizini oluştur
WORKDIR /app

# JAR dosyasını container'a kopyala
COPY target/wallet-demo.jar /app/wallet-demo.jar

# Uygulamayı çalıştır
ENTRYPOINT ["java", "-jar", "wallet-demo.jar"]
