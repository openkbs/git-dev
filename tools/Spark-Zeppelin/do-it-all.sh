#!/bin/bash -x

MY_PATH=$0
cd $(dirname $MY_PATH)
CURR_DIR=`pwd`

exit 0

./prepare.sh
./install_R_tools.sh
./install_R_Latest.sh
./build-zeppelin-package.sh
