#!/bin/bash -x

#ref: http://portainer.io/install.html

if [ $# -le 1 ]; then
    echo "Usage: $0 [<remote-host>:default localhost] [<windows_host>]"
    echo "e.g"
    echo "localhost docker management:"
    echo "$0"
    echo "Remote Unix docker management:"
    echo "$0 192.168.0.206"
    echo "Remote Windows docker management:"
    echo "$0 192.168.0.206 windows"
fi

remote_host=${1}
remote_windows=${2}

if [ "$remote_host" == "" ]; then
    # Manage local Linux host
    docker run -d -p 9000:9000 -v /var/run/docker.sock:/var/run/docker.sock portainer/portainer
else
    if [ "$remote_windows" == "" ]; then
        # Manage remote Linux host
        docker run -d -p 9000:9000 portainer/portainer -H tcp://mydockerhost.mydomain:2375
    else
        # Manage remote Window host
        docker run -d -p 9000:9000 portainer/portainer:windows -H tcp://mydockerhost.mydomain:2375
    fi
fi


