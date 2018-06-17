# DizasterX

[![progress](http://progressed.io/bar/30?title=done)](https://github.com/kasakun/DizasterX)
[![jetty](https://img.shields.io/badge/jetty-v9.4.11-blue.svg)](https://www.eclipse.org/jetty/)
[![jersey](https://img.shields.io/badge/jersey-v2.27-yellow.svg)](https://jersey.github.io/)
[![MongoDb](https://img.shields.io/badge/mongodb-v3.0.6-green.svg)](https://fastdl.mongodb.org/linux/mongodb-linux-x86_64-3.0.6.tgz)
[![license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/kasakun/DizasterX/blob/master/LICENSE)
[![API](https://img.shields.io/badge/API-available-green.svg)](http://czy-kasakun.com:8080/DizasterX/webapi/data/)

A web app for historical disaster analysis

Contributor: Zeyu Chen(chenzy@gatech.edu), Xibei Zhang(xb_zhang@gatech.edu)

## Goal

Provide an efficient solution for history disaster study and research.

## Stack

### Front End Repo

Front: react+redux, ant-design,d3(it denpends on xibei)

### Back End Repo

`api-dev` is the directory for local development and local test.
`api-dev` structure:

```
api-dev/
├── src/
│   ├── main/
|   |   └── java/
|   │       └── com.DizasterX
|   │           ├── Main.java
|   │           └── MyResource.java
|   │
|   └── test/
|       └── java/
|               └── com.DizasterX
|                   └── MyResourceTest.java
|
├── target/
|   ├── classes/
|   ├── generated-sources/
|   └── test-classes/
|
├── pom.xml
└── README.md
```

The main API is located in `MyResource.java`.
The default address to request is `localhost:8080/DizasterX/api/data/`.

`api` is the release verison which has the similar structure,
which can be requeted by `czy-kasakun.com:8080/DizasterX/webapi/data/`.

Currently, the query size cannot be too large due to the limited memory of the server.

## RoadMap

| Goals                    | Description                              | Priority | Contributor |   Status  |
| ------------------------ |:----------------------------------------:| --------:| -----------:|----------:|
| ~~db build~~             | ~~mongodb setup~~                        | ~~High~~ | Zeyu Chen   |  Done     |
| front end(react + redux) | design app structure                     | High     | Xibei Zhang |  To Do    |
| data virtulization       | d3 or opengl for js is recommended       | Low      | Xibei Zhang |  To Do    |
| ~~RESTful api~~          | ~~java+jersey, build and deploy~~        | ~~High~~ | Zeyu Chen   |  Done     |
| RESTful api test         | Test API                                 | Low      | TBA         |  To Do    |
| API Misc                 | API doc, site construct and SSL          | Low      | TBA         |  To Do    |

## Data

Data is from FEMA dataset. Downloaded on May 11th 2018.

## Ref

Wow, found previous work
https://github.com/jdungan/disasters
