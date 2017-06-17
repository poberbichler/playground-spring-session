#!/bin/bash

#mvn package
nohup java -jar target/spring-session-0.0.1-SNAPSHOT.jar --server.port=8051 > app-8051.log &
nohup java -jar target/spring-session-0.0.1-SNAPSHOT.jar --server.port=8052 > app-8082.log &

docker start session-nginx