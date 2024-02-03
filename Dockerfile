FROM ubuntu:latest
LABEL authors="Mostafa_Ashraf"

RUN apt-get update && apt-get install -y openjdk-11-jdk

ENV JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64

WORKDIR /usr/src/app
COPY . .

RUN apt-get update && apt-get install -y chromium-driver && \
    apt-get update &&apt-get install -y maven

ENV CHROME_DRIVER_PATH=/usr/lib/chromium-browser/chromedriver

CMD ["mvn", "test"]