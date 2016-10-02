#!/bin/bash -x

#sudo docker run -ti -v /usr/hdp/2.4.0.0-169:/usr/hdp/2.4.0.0-169:rw -v /etc/hadoop:/etc/hadoop:rw -P local/c7-hdpclient:latest
#sudo docker run -d \
DNS_SVR=`cat /etc/resolv.conf|cut -d' ' -f2-`
sudo docker run -it \
        -v /usr/hdp/2.4.0.0-169:/usr/hdp/2.4.0.0-169:ro \
        -v /usr/hdp/current:/usr/hdp/current:ro \
        -v /etc/hadoop:/etc/hadoop:ro \
        -v /usr/bin:/usr/hdp/bin/:ro \
        --dns="${DNS_SVR}" \
        --network="host" \
	-P local/c7-neo4j-hdpclient

