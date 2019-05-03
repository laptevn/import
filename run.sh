#!/bin/bash

mvn clean install

docker-compose up -d

while docker-compose ps import | grep -cq "Up"
do
sleep 1s;
done

docker-compose logs import | grep "com.laptevn.ImportCompletionListener"

docker-compose down