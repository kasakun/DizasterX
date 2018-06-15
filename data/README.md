# Mongo DB Setting

## Import csv file
Import csv file
```
mongoimport --db DizasterX --collection data --type csv --headerline 
--ignoreBlanks --file $SOURCE_PATH/DisasterDeclarationsSummaries.csv
```

## Run DB
Run db 
```
mongod --dbpath=$DB_PATH/
```

## Login DB locally

```
mongo
```