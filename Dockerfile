FROM registry.cn-shenzhen.aliyuncs.com/aa1435889856/dota2:base
COPY target/managerapp.jar /usr/managerapp.jar
#¹«²¼tomcatµÄ¶Ë¿Ú

ENV JAVA_HOME=/javasdk
ENV JRE_HOME=/javasdk/jre
ENV PATH $JAVA_HOME/bin:$PATH
  EXPOSE 8001

ENTRYPOINT ["java","-jar","/usr/dota2.jar"]
