# Dockers setup files: git-dev

## Docker projects
- centos7-docker
- java8-centos7-docker
- neo4j-docker
- jdp-client-docker

## Tree view

```
.
├── bin
│   └── run-portainer-docker-server.sh
├── docker
│   ├── anaconda2-docker
│   ├── anaconda3-docker
│   │   ├── docker-images
│   │   └── run-JupyterNotebook-from-Anaconda3-Docker.sh
│   ├── ArangoDB
│   │   ├── docker-compose.yml
│   │   └── run-arangoDB-docker.sh
│   ├── centos7-docker
│   │   ├── build-centos7-docker.sh
│   │   └── Dockerfile
│   ├── docker-hadoop-spark-workbench
│   │   ├── data
│   │   ├── docker-compose-hive.yml
│   │   ├── docker-compose.yml
│   │   ├── git
│   │   ├── hadoop.env
│   │   ├── README.md
│   │   ├── README.md.orig
│   │   ├── run-hadoop-spark-workbench.sh
│   │   └── spawn-spark-worker.sh
│   ├── hadoop-docker
│   │   └── run-hadoop-docker.sh
│   ├── hdp-client-docker
│   │   ├── build-centos7-hdpclient.sh
│   │   ├── Dockerfile
│   │   ├── Dockerfile.SAVE
│   │   ├── hdp-select
│   │   ├── hdp-version-gen.sh
│   │   └── run-centos7-hdpclient.sh
│   ├── java8-centos7-docker
│   │   ├── build-centos7-java8.sh
│   │   └── Dockerfile
│   ├── neo4j-docker
│   │   ├── build-c7-neo4j-hdpclient.sh
│   │   ├── conf
│   │   ├── docker-compose.yml
│   │   ├── Dockerfile
│   │   ├── Dockerfile.SAVE
│   │   ├── LICENSE
│   │   ├── plugins
│   │   ├── README.md
│   │   ├── run-c7-neo4j-hdpclient.sh
│   │   └── sbin
│   ├── nifi-docker
│   │   ├── nifi-templates
│   │   └── run-nifi-docker.sh
│   ├── openshift
│   │   └── run-openshift.sh
│   ├── README.md
│   └── spark-notebook-docker
│       └── run-spark-notebook.sh
├── LICENSE
├── README.md
├── tools
│   └── Spark-Zeppelin
│       ├── build.sh
│       ├── build-zeppelin-package.sh
│       ├── do-it-all.sh
│       ├── install_R_Latest.sh
│       ├── install_R_tools.sh
│       └── prepare.sh
└── workspace
    ├── examples
    │   ├── cask
    │   ├── cast
    │   ├── confluent
    │   ├── couchbase
    │   ├── dataprocessing
    │   ├── go
    │   ├── influxdb
    │   ├── java
    │   ├── mesos-dns-crawler
    │   ├── mesos-sampler
    │   ├── nifi
    │   ├── pubnub
    │   ├── py
    │   ├── rb
    │   ├── README.md
    │   ├── scala
    │   ├── sh
    │   └── spark
    ├── templates
    │   └── eclipse-spark-templates
    └── workspace-spark
        ├── ScalaDemo
        └── spark

47 directories, 42 files

```
