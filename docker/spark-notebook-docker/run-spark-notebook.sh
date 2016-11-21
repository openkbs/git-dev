#!/bin/bash -x

#Spark generator distro availability
#
#    notebook: 0.7.0
#    scala: 2.11.8
#    spark: 2.0.1
#    nightly: false
#    hadoop: 2.7.2
#    with hive: true
#    with parquet: true
#    package: docker
#

docker pull andypetrella/spark-notebook:0.7.0-scala-2.11.8-spark-2.0.1-hadoop-2.7.2-with-hive

docker run -d -p 9000:9000 andypetrella/spark-notebook:0.7.0-scala-2.11.8-spark-2.0.1-hadoop-2.7.2-with-hive


