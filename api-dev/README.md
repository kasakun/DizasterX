# API-Dev

This is the develop edtion which can run locally.

## How to compile

```sh
mvn clean compile
```

## Server Start

```sh
mvn exec:java
```
The default address is http://localhost:8080/DizasterX/data/

## Query

Supported quries are placed below:

```java
 * @ Date   : declaration    String
 *            fyDeclared     int
 *            begin          String
 *            end            String
 *            closeout       String
 *            lastrefresh    String
 * @ Place  : state          String
 *            county         String   not all
 *            palceCode      int      not all
 * 
 * @ Type   : incident       String
 *            disaster       String
 * 
 * @ Program: IH             int
 *            IA             int
 *            PA             int
 *            HM             int
 * 
 * @ Title                   String
 * @ Hash                    String
 ```
