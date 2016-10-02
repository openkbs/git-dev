#!/bin/bash -x

# This Dockerfile deletes a number of unit files which might cause issues. From here, you are ready to build your base image.

sudo docker build --rm -t local/c7-systemd .
