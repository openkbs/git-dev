# java
#
# VERSION       Java 8

FROM local/c7-systemd
MAINTAINER "DrSnowbird" <DrSnowbird@openkbs.org>

#http://download.oracle.com/otn-pub/java/jdk/8u102-b14/jdk-8u102-linux-x64.rpm
#http://download.oracle.com/otn-pub/java/jdk/8u102-b14/jre-8u102-linux-x64.rpm
ENV JAVA_VERSION 8u102
ENV BUILD_VERSION b14

# Upgrading system
RUN yum -y upgrade
RUN yum -y install wget

# Downloading Java
#RUN wget --no-cookies --no-check-certificate --header "Cookie: oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/$JAVA_VERSION-$BUILD_VERSION/jdk-$JAVA_VERSION-linux-x64.rpm" -O /tmp/jdk-8-linux-x64.rpm
RUN wget --no-cookies --no-check-certificate --header "Cookie: oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/$JAVA_VERSION-$BUILD_VERSION/jre-$JAVA_VERSION-linux-x64.rpm" -O /tmp/jre-8-linux-x64.rpm

#RUN yum -y install /tmp/jdk-8-linux-x64.rpm
RUN yum -y install /tmp/jre-8-linux-x64.rpm

RUN alternatives --install /usr/bin/java jar /usr/java/latest/bin/java 200000
RUN alternatives --install /usr/bin/javaws javaws /usr/java/latest/bin/javaws 200000
#RUN alternatives --install /usr/bin/javac javac /usr/java/latest/bin/javac 200000

ENV JAVA_HOME /usr/java/latest

ENTRYPOINT ["/bin/bash"]
