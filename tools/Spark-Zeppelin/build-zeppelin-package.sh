#!/bin/bash -x

sudo apt-get update -y
sudo apt-get install -y git
##sudo apt-get install openjdk-7-jdk
sudo apt-get install -y npm
sudo npm install -g minimatch@3.0.2

NPM_VER=`npm -v|sed -- "s/\.//g"`
echo $NPM_VER
if [ "NPM_VER" -lt "3105" ]; then
    sudo npm install -g npm
else
    echo "NPM version latest already: `npm -v`"
fi
sudo apt-get install -y libfontconfig1

# install maven
MAVEN=`which mvn`
if [ $? -eq 1 ]; then
    echo "*********** Maven Not found"
    wget -c http://www.eu.apache.org/dist/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz
    sudo tar -zxf apache-maven-3.3.9-bin.tar.gz -C /usr/local/
    sudo ln -s /usr/local/apache-maven-3.3.9/bin/mvn /usr/local/bin/mvn
else
    echo "----------- mvn existing: version `mvn -v`"
fi

# GIT clone Zeppelin
ZEPPELIN_DIR=zeppelin
if [ ! -e $ZEPPELIN_DIR ]; then
    git clone git@github.com:apache/zeppelin.git
else
    cd $ZEPPELIN_DIR
    git pull
fi

# Confirm before building Zeppelin
read -r -p "Are you sure to build Zeppelin? [y/N] " response
case $response in
    [yY][eE][sS]|[yY]) 
        echo "..... Start Building Zeppelin now"
        ;;
    *)cd ..
        echo "..... Abort Building Zeppelin now"
        exit 1
        ;;
esac

# Build Zeppelin
cd $ZEPPELIN_DIR

#### ----- Custom build different combination of versions of dependent components

#### ---------------------------------------
# (try scala 2.10)
# update all pom.xml to use scala 2.11
SCALA_VER=2.10
SPARK_VER=1.6
HADOOP_VER=2.4
IGNITE_VER=1.6.0
## -- prepare Scala version envionment --
./dev/change_scala_version.sh ${SCALA_VER}
# build zeppelin with all interpreters and include latest version of Apache spark support for local mode.
#mvn clean package -Pbuild-distr -DskipTests -Pspark-1.6 -Phadoop-2.4 -Pyarn -Ppyspark -Psparkr -Pr -Pscala-2.10 -Dignite.version=1.6.0 -Pexamples
#mvn clean package -Pbuild-distr -DskipTests -Pspark-1.6 -Phadoop-2.4 -Dhadoop.version=2.4.0 -Pyarn -Ppyspark -Pr -Psparkr -Pscala-2.11 -Dignite.version=1.6.0 -Pexamples
mvn clean package -Pbuild-distr -DskipTests -Pspark-${SPARK_VER} -Phadoop-${HADOOP_VER} -Pyarn -Ppyspark -Psparkr -Pr -Pscala-${SCALA_VER} Dignite.version=${IGNITE_VER} -Pexamples


