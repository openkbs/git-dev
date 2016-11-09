#!/bin/bash -x

#docker run -p 8529:8529 arangodb/arangodb:3.1.0

DATA_DIR=/tmp/arangodb
ROOT_PASSWORD=password123
HOST_PORT=8529
mkdir -p $DATA_DIR
#docker -e ARANGO_ROOT_PASSWORD=$ROOT_PASSWORD run -p $HOST_PORT:8529 -d \
docker run -e ARANGO_NO_AUTH=1 -p $HOST_PORT:8529 -d \
	-v $DATA_DIR:/var/lib/arangodb3 \
	arangodb
