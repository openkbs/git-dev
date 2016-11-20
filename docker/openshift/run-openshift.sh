#!/bin/bash -x

sudo docker run -d --name "origin" \
	--privileged --pid=host --net=host \
        -v /:/rootfs:ro -v /var/run:/var/run:rw -v /sys:/sys -v /var/lib/docker:/var/lib/docker:rw \
        -v /var/lib/origin/openshift.local.volumes:/var/lib/origin/openshift.local.volumes \
        openshift/origin start

echo "This command:"

echo "starts OpenShift Origin listening on all interfaces on your host (0.0.0.0:8443),"

echo "starts the web console listening on all interfaces at /console (0.0.0.0:8443),"

echo "launches an etcd server to store persistent data, and"

echo "launches the Kubernetes system components."

sudo docker exec -it origin bash

