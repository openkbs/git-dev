FROM local/c7-java8

VOLUME /usr/hdp/2.4.0.0-169
VOLUME /usr/hdp/current
VOLUME /etc/hadoop
VOLUME /usr/hdp/bin

#### Copy hdp-select from /usr/bin
#COPY /usr/bin/hdp-select /usr/bin/
#COPY hdp-select /usr/bin/

#### ---- HDFS ----
ENV HADOOP_CONF_DIR /etc/hadoop/conf 
ENV HDFS_HOST hdfs://hdfs:9000
ENV SPARK_HOME /usr/hdp/current/spark-client
ENV PATH /usr/java/default/bin:/usr/java/default/bin:/usr/java/default/bin:/usr/local/bin:/usr/bin:/bin:/usr/local/sbin:/usr/sbin:/usr/hdp/bin
ENV HDP_VERSION 2.4.0.0-169
ENV JAVA_HOME /usr/java/default

#### fake out /usr/jdk64/jdk1.8.0_60/bin/java
RUN mkdir -p /usr/jdk64/jdk1.8.0_60/bin
RUN ln -s /usr/java/default/bin/java /usr/jdk64/jdk1.8.0_60/bin/java

#### Install needed shell commands:
RUN yum install which -y

ENTRYPOINT ["/bin/bash"]

