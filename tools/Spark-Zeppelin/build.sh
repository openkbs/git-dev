#/bin/bash -x

# (good)
#mvn clean package -Pbuild-distr -DskipTests -Pspark-1.6 -Phadoop-2.4 -Pyarn -Ppyspark -Pr

#### ---------------------------------------
# (try scala 2.11)
# update all pom.xml to use scala 2.11
./dev/change_scala_version.sh 2.11
# build zeppelin with all interpreters and include latest version of Apache spark support for local mode.
mvn clean package -Pbuild-distr -DskipTests -Pspark-1.6 -Phadoop-2.4 -Pyarn -Ppyspark -Psparkr -Pr -Pscala-2.11

#### ---------------------------------------
# (try scala 2.10)
# update all pom.xml to use scala 2.11
./dev/change_scala_version.sh 2.10
# build zeppelin with all interpreters and include latest version of Apache spark support for local mode.
mvn clean package -Pbuild-distr -DskipTests -Pspark-1.6 -Phadoop-2.4 -Pyarn -Ppyspark -Psparkr -Pr -Pscala-2.10
