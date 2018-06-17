# MongoDB Setting

## Import csv file
## Run DB
Run db 
```
mongod --dbpath=$DB_PATH/
```

Import csv file
```
mongoimport --db DizasterX --collection data --type csv --headerline 
--ignoreBlanks --file $SOURCE_PATH/DisasterDeclarationsSummaries.csv
```

## Login DB locally

```
mongo
```