# Kafka



## 下载

[apache kafka 下载地址](https://kafka.apache.org/downloads)

## 前置条件

需要安装jdk和zookeeper(kraft模式不需要)

## 安装

~~~shell
# 解压
$ tar -zxf kafka_2.13-3.3.2.tgz
~~~

##  配置文件

~~~shell
# 三台虚拟机搭建集群
# 192.168.11.104 192.168.11.105 192.168.11.106

# 为 192.168.11.104 更改配置
$ vim kafka_2.13-3.3.2/config/server.properties
# 替换以下行的值
# kfk-group为给kafka集群创建的目录，方便隔离于其他kafka集群
broker.id=1
listeners=PLAINTEXT://192.168.11.104:9092
log.dirs=/opt/backend/kafka/manage/logs
zookeeper.connect=192.168.11.104:2181,192.168.11.105:2181,192.168.11.106:2181/kfk-group

#为 192.168.11.105/106 更换上述配置
~~~

## 启动

~~~shell
# 依次启动三个节点
$ kafka_2.13-3.3.2/bin/kafka-server-start.sh kafka_2.13-3.3.2/config/server.properties
~~~

## 基础测试

~~~shell
# 创建topic
$ bin/kafka-topics.sh --create --topic basic-test --bootstrap-server 192.168.11.104:9092

# 查看topic
$ bin/kafka-topics.sh --describe --topic basic-test --bootstrap-server 192.169.11.104:9092
Topic: basic-test       TopicId: UocMVmv4QsCWEpduk_sTeQ PartitionCount: 1       ReplicationFactor: 1    Configs:
        Topic: basic-test       Partition: 0    Leader: 1       Replicas: 1     Isr: 1
  
# 发送消息
$ bin/kafka-console-producer.sh --topic basic-test --bootstrap-server 192.168.11.104:9092

# 接收消息
$ bin/kafka-console-consumer.sh --topic basic-test --from-beginning --bootstrap-server 192.168.11.104:9092
~~~

## 集群启动脚本

~~~shell
#!/bin/bash
# a shell script for kafka cluster.
nodeConf=node04,node05,node06
nodes=(${nodeConf//,/ })

KFK_HOME=/opt/backend/kafka/kafka_2.13-3.3.2


case $1 in
"start") {
  for node in ${nodes[@]}
  do
    sshpass -p $2 ssh -o StrictHostKeyChecking=no $node "JMX_PORT=9999 ${KFK_HOME}/bin/kafka-server-start.sh -daemon ${KFK_HOME}/config/server.properties &"
    if [ $? != 0 ]
    then
      echo "Kafka server start fail on host $node !"
      exit 1
    else
      echo "Kafka server start success on host $node !"
    fi
  done
}
;;
"stop") {
  for node in ${nodes[@]}
  do
    sshpass -p $2 ssh -o StrictHostKeyChecking=no $node "${KFK_HOME}/bin/kafka-server-stop.sh"
    if [ $? != 0 ];
    then
      echo "Kafka server stop fail on host $node !"
      exit 1
    else
      echo "Kafka server stop success on host $node !"
    fi
  done
}
;;
esac
~~~



