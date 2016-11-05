#!/bin/bash -x

docker pull mkobit/nifi

HOST_PORTS=18080
# Run image and expose the default ports to the host.
# --rm : remove container on exit
# -i : interactive
# -t : allocate TTY
# -p : publish each container port to host port. format: ip:hostPort:containerPort | ip::containerPort | hostPort:containerPort | containerPort
#sudo docker run -it --rm -p 8080-8081:8080-8081 mkobit/nifi
docker run -d -p 18080-18081:8080-8081 mkobit/nifi
echo "Nifi Web URI: http://127.0.0.1:18080/nifi/ "
