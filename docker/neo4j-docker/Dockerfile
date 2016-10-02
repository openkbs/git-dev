#
# Dockerizing Neo4j graph database (http://www.github.com/kbastani/docker-neo4j)
#

FROM	local/c7-hdpclient

MAINTAINER "DrSnowbird" <DrSnowbird@openkbs.org>

#### ---- HDFS ----
ENV HDFS_HOST hdfs://hdfs:9000

#### ---- NEO4j, GSON ----
#ENV NEO4j_VER enterprise-2.2.3
#ENV NEO4j_VER community-2.2.3
ENV NEO4j_VER community-3.0.6
ENV GSON_VER 2.6.2

RUN yum -y update && yum install -y wget
RUN wget -q -O /tmp/neo4j-$NEO4j_VER-unix.tar.gz http://dist.neo4j.org/neo4j-$NEO4j_VER-unix.tar.gz && \
    tar -zxf /tmp/neo4j-$NEO4j_VER-unix.tar.gz -C /var/lib && \
    ln -s /var/lib/neo4j-$NEO4j_VER /var/lib/neo4j && \
    #wget -q -O /var/lib/neo4j/lib/gson-2.2.4.jar http://search.maven.org/remotecontent?filepath=com/google/code/gson/gson/2.2.4/gson-2.2.4.jar
    wget -q -O /var/lib/neo4j/lib/gson-$GSON_VER.jar http://search.maven.org/remotecontent?filepath=com/google/code/gson/gson/$GSON_VER/gson-$GSON_VER.jar

WORKDIR /var/lib/neo4j

# Copy graph analytics plugin
COPY plugins /var/lib/neo4j/plugins

# Copy configurations
COPY conf/neo4j /var/lib/neo4j/conf

# Copy the bootstrap shell script and set permissions
COPY sbin/bootstrap.sh /etc/bootstrap.sh
RUN chown root:root /etc/bootstrap.sh && \
    chmod 700 /etc/bootstrap.sh

# Customize configurations
#RUN yum -y clean all && \
RUN sed -i "s|data/graph.db|/opt/data/graph.db|g" /var/lib/neo4j/conf/neo4j-server.properties && \
    sed -i "s|dbms.security.auth_enabled=true|dbms.security.auth_enabled=false|g" /var/lib/neo4j/conf/neo4j-server.properties && \
    sed -i "s|#org.neo4j.server.webserver.address|org.neo4j.server.webserver.address|g" /var/lib/neo4j/conf/neo4j-server.properties && \
    sed -i "s|#org.neo4j.server.thirdparty_jaxrs_classes=org.neo4j.examples.server.unmanaged=/examples/unmanaged|org.neo4j.server.thirdparty_jaxrs_classes=extension=/service|g" /var/lib/neo4j/conf/neo4j-server.properties

# Expose the Neo4j browser to the host OS on port 7474 and 1337
EXPOSE 7473
EXPOSE 7474
EXPOSE 1337

# Mount a volume for persistent data
VOLUME /opt/data

# Set the bootstrap script on container run
ENV BOOTSTRAP /etc/bootstrap.sh
CMD ["/etc/bootstrap.sh", "-d"]
