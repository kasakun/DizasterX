# API-Dev

This is the release edtion which is deployed at
http://czy-kasakun.com:8080/DizasterX/webapi/data/

## How to compile

```sh
mvn clean compile
```

## How to package

```sh
mvn clean package
```

Copy the `.war` package to the `$JETTY_BASE/webapps`

## Start service

Start mongodb and jetty services

```sh
nohup java -jar $JETTY_HOME/start.jar &
mongod -f $CONFIG_PATH/mongod.conf --fork
```
