FROM java:openjdk-8-alpine
RUN apk add --no-cache curl
RUN curl -LO "https://github.com/tweakers-dev/MockMock/blob/master/release/MockMock.jar?raw=true"
CMD ["java","-jar","MockMock.jar"]
