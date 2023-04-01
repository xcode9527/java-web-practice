# ElasticSearch

## 安装
~~~shell
# 版本号 7.17.8
$ wget https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-7.17.8-linux-x86_64.tar.gz

# 解压
$ tar -zxf elasticsearch-7.17.8-linux-x86_64.tar.gz
~~~

## es用户组
~~~shell
# 添加用户组
$ groupadd es

# 添加用户
$ useradd es -g es

# 设置用户密码
$ passwd es

# 更改解压包归属
$ chown -R es:es elasticsearch-7.17.8
~~~

## es前置配置
~~~shell
$ vim /etc/security/limits.conf

# 添加以下四行配置
nofile 65536
memlock unlimited
es hard nofile 65536
es soft nofile 65536
~~~

## 修改配置文件
~~~shell
# 修改启动配置文件
$ vim ./elasticsearch-7.17.8/config/elasticsearch.yml
# 添加以下行
cluster.name: es-group
node.name: es-node-01
http.port: 9200
network.host: 0.0.0.0
cluster.initial_master_nodes: ["192.168.11.104"]

# 如果设备内存不够大，建议修改jvm参数堆大小为1g或者更小
$ vim ./elasticsearch-7.17.8/config/jvm.options
-Xms1g
-Xmx1g


cluster.name: es-group
node.name: es-node-01
node.master: true
cluster.initial_master_nodes: ["192.168.11.104:9300"]
node.data: true
network.host: 192.168.11.104
http.port: 9200
transport.tcp.port: 9300
discovery.zen.ping.unicast.hosts: ["192.168.11.104:9300","192.168.11.105:9300","192.168.11.106:9300"]
http.cors.enabled: true
http.cors.allow-origin: "*"



~~~