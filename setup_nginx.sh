#!/bin/bash

HOST_IP=$(ifconfig | grep -E "([0-9]{1,3}\.){3}[0-9]{1,3}" | grep -v 127.0.0.1 | awk '{ print $2 }')
echo "host ip is: [$HOST_IP]"

docker run --add-host dockerhost:$HOST_IP  --name session-nginx -d -p 8050:80 -v $PWD/nginx.conf:/etc/nginx/nginx.conf:ro nginx:alpine
