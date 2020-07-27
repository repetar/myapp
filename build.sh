#!/bin/bash


function main() {

  mvn clean package

  docker build -t my.project.app.requesthandler:1.0.0 source/request-handler/ --no-cache

  docker build -t fe-app:0.0.1 source/front-end/fe-app/

}

main $@
