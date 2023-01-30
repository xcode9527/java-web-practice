# 安装Zookeeper

## 下载

[apache zookeeper 下载地址](https://zookeeper.apache.org/releases.html)

## 安装

~~~shell
# 解压
$ tar -zxf apache-zookeeper-3.7.1-bin.tar.gz
~~~

## 单机启动

~~~shell
# 新增文件zoo.cfg
$ touch ./zookeeper-3.7.1/conf/zoocfg

# 增加以下配置行
tickTime=2000
initLimit=10
syncLimit=5
clientPort=2181
dataDir=/opt/backend/zookeeper/manage/data/

# 会主动搜索zookeeper-3.7.1/conf/zoo.cfg去启动，若不是这个路径需要指定
# 启动 
$ zookeeper-3.7.1/bin/zkServer.sh start zookeeper-3.7.1/conf/zoo.cfg

# 重启
$ zookeeper-3.7.1/bin/zkServer.sh restart

# 停止
$ zookeeper-3.7.1/bin/zkServer.sh stop

~~~

## 集群启动

~~~shell
# 修改zoo.cfg文件
$ vim ./zookeeper-3.7.1/conf/zoocfg
# 全部替换为以下行
tickTime=2000
initLimit=10
syncLimit=5
clientPort=2181
dataDir=/opt/backend/zookeeper/manage/data/
server.1=192.168.11.104:2888:3888
server.2=192.168.11.105:2888:3888
server.3=192.168.11.106:2888:3888

# 在上述dataDir目录下创建myid文件
$ echo 1 > /opt/backend/zookeeper/manage/data/myid
$ cat /opt/backend/zookeeper/manage/data/myid
1

# 在三个节点上操作以上配置

# 使用默认路径配置文件/zookeeper-3.7.1/conf/zoo.cfg, 命令行可以省略不写
# 启动 / 重启 / 停止
$ zookeeper-3.7.1/bin/zkServer.sh start
$ zookeeper-3.7.1/bin/zkServer.sh restart
$ zookeeper-3.7.1/bin/zkServer.sh stop
~~~

