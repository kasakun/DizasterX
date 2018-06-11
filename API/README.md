# API
The api service is a RESTful service based on jersey and Grizzly. Use Maven to manage libs.

## How to compile

```
mvn clean compile
```

## Server Start
```
mvn exec:java
```

## Query
List bunch of sample link.

### Disaster Title
http://localhost:8080/DizasterX/data/title?value=TORNADO

### Hash
http://localhost:8080/DizasterX/data/hash?value=e6f77c3a97c63d478bf14c9a58f60a0d