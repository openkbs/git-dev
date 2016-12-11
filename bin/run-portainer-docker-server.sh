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

#######################################################
#### ---- Change this base port number as you like ----
#######################################################
port_base=19100


#######################################################
#######################################################
#### ---- Mostly, you don't want to change below:  ----
#######################################################
#######################################################

#### ---- clean up old/dead Portainer containers ----
cleanupOld() {
    ports_to_clean="`docker ps|grep portainer|grep "Exit"|awk '{print $1}'`"
    if [ "$ports_to_clean" != "" ]; then
        docker rm -f "$ports_to_clean"
    fi
}
#cleanupOld

#### ---- Find available Portainer containers ----
port_use=19100
findNextPort() {
    ports_occupied=`docker ps|grep portainer|grep -v "Exit"|cut -d':' -f2|cut -d'-' -f1 | sort -u`
    echo "... Min. base port: $port_base"
    max=$port_base
    for v in $ports_occupied; do
        if (( $v > $max )); then max=$v; fi; 
    done
    port_use=$((max++))
    echo "port_use=$port_use"
}
findNextPort

if [ "$remote_host" == "" ]; then
    # Manage local Linux host
    docker run -d -p ${port_use}:9000 -v /var/run/docker.sock:/var/run/docker.sock portainer/portainer
else
    if [ "$remote_windows" == "" ]; then
        # Manage remote Linux host
        docker run -d -p ${port_use}:9000 portainer/portainer -H tcp://mydockerhost.mydomain:2375
    else
        # Manage remote Window host
        docker run -d -p ${port_use}:9000 portainer/portainer:windows -H tcp://mydockerhost.mydomain:2375
    fi
fi

