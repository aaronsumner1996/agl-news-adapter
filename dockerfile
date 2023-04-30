FROM eclipse-temurin

COPY build/libs/*all.jar agl-news-adapter-0.1.jar

CMD ["java","-jar","agl-news-adapter-0.1.jar"]