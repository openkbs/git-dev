#!/bin/bash -x

#RELEASE_VER=2.7.1
RELEASE_VER=latest
docker run -it sequenceiq/hadoop-docker:$RELEASE_VER /etc/bootstrap.sh -bash

