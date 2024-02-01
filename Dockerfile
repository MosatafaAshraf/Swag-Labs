FROM maven:3.6.3-jdk-11
LABEL authors="Mostafa_Ashraf"

WORKDIR /usr/src/app
COPY . /usr/src/app

RUN apt-get update && apt-get install -y chromium-driver
ENV CHROME_DRIVER_PATH=/usr/lib/chromium-browser/chromedriver

CMD["mvn", "test"]