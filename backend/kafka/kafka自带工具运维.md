# kafka自带工具运维

## topic管理

### 创建topic

~~~shell
$ bin/kafka-topics.sh --bootstrap-server 192.168.11.104:9092 --create --topic topic-1 --partitions 4 --replication-factor 2
~~~

### 查看topic

~~~shell
$ bin/kafka-topics.sh --bootstrap-server 192.168.11.104:9092 --describe --topic topic-1
~~~

### leader重平衡

~~~shell
# 指定分区重平衡选举
$ bin/kafka-leader-election.sh --bootstrap-server 192.168.11.104:9092 --topic topic-partitions --election-type PREFERRED --partition 1

# 全主题全分区重平衡选举
$ bin/kafka-leader-election.sh --bootstrap-server 192.168.11.104:9092 --election-type preferred  --all-topic-partitions

# 使用配置文件重平衡选举
$ bin/kafka-leader-election.sh --bootstrap-server 192.168.11.104:9092 --election-type preferred  --path-to-json-file config/leader-election.json
# 配置文件如下
$ touch leader-election.json
​~~~
{
  "partitions": [
    {
      "topic": "topic-partitions",
      "partition": 0
    },
    {
      "topic": "topic-partitions",
      "partition": 1
    },
    {
      "topic": "topic-partitions",
      "partition": 2
    }
  ]
}
​~~~

~~~

### 分区重分配

~~~shell
# 1.创建topic-2,分区4,副本2
Topic: topic-2  TopicId: 9yc1RrZUQ-qLalYITb0K7g PartitionCount: 4       ReplicationFactor: 2    Configs:
        Topic: topic-2  Partition: 0    Leader: 3       Replicas: 3,2   Isr: 3,2
        Topic: topic-2  Partition: 1    Leader: 1       Replicas: 1,3   Isr: 1,3
        Topic: topic-2  Partition: 2    Leader: 2       Replicas: 2,1   Isr: 2,1
        Topic: topic-2  Partition: 3    Leader: 3       Replicas: 3,1   Isr: 3,1

# 2.生成分配计划
$ bin/kafka-reassign-partitions.sh --bootstrap-server 192.168.11.104:9092 --generate --topics-to-move-json-file config/topic-reassign.json --broker-list 1,3
Current partition replica assignment
{"version":1,"partitions":[{"topic":"topic-2","partition":0,"replicas":[3,2],"log_dirs":["any","any"]},{"topic":"topic-2","partition":1,"replicas":[1,3],"log_dirs":["any","any"]},{"topic":"topic-2","partition":2,"replicas":[2,1],"log_dirs":["any","any"]},{"topic":"topic-2","partition":3,"replicas":[3,1],"log_dirs":["any","any"]}]}

Proposed partition reassignment configuration
{"version":1,"partitions":[{"topic":"topic-2","partition":0,"replicas":[3,1],"log_dirs":["any","any"]},{"topic":"topic-2","partition":1,"replicas":[1,3],"log_dirs":["any","any"]},{"topic":"topic-2","partition":2,"replicas":[3,1],"log_dirs":["any","any"]},{"topic":"topic-2","partition":3,"replicas":[1,3],"log_dirs":["any","any"]}]}

# 3.将分配计划json写入文件new-reassign.json

# 4.使用分配计划json执行
$ bin/kafka-reassign-partitions.sh --bootstrap-server 192.168.11.104:9092 --execute --reassignment-json-file config/new-reassign.json

Topic: topic-2  TopicId: 9yc1RrZUQ-qLalYITb0K7g PartitionCount: 4       ReplicationFactor: 2    Configs:
        Topic: topic-2  Partition: 0    Leader: 3       Replicas: 3,1   Isr: 3,1
        Topic: topic-2  Partition: 1    Leader: 1       Replicas: 1,3   Isr: 1,3
        Topic: topic-2  Partition: 2    Leader: 3       Replicas: 3,1   Isr: 1,3
        Topic: topic-2  Partition: 3    Leader: 3       Replicas: 1,3   Isr: 3,1

# 5.leader重平衡
$ bin/kafka-leader-election.sh --bootstrap-server 192.168.11.104:9092 --topic topic-2 --election-type PREFERRED --partition 3

Topic: topic-2  TopicId: 9yc1RrZUQ-qLalYITb0K7g PartitionCount: 4       ReplicationFactor: 2    Configs:
        Topic: topic-2  Partition: 0    Leader: 3       Replicas: 3,1   Isr: 3,1
        Topic: topic-2  Partition: 1    Leader: 1       Replicas: 1,3   Isr: 1,3
        Topic: topic-2  Partition: 2    Leader: 3       Replicas: 3,1   Isr: 1,3
        Topic: topic-2  Partition: 3    Leader: 1       Replicas: 1,3   Isr: 3,1

~~~

