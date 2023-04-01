# 安装Kibana

## 安装
~~~shell
# 版本号 7.17.8
$ wget https://artifacts.elastic.co/downloads/kibana/kibana-7.17.8-linux-x86_64.tar.gz

# 解压
$ tar -zxf kibana-7.17.8-linux-x86_64.tar.gz

# 更改解压包归属
$ chown -R es:es kibana-7.17.8
~~~

## 修改配置
~~~shell
# 修改启动配置文件
$ vim ./kibana-7.17.8/config/kibana.yml
# 添加以下行
server.host: "0.0.0.0"
server.port: 5601
elasticsearch.hosts: ["http://192.168.11.104:9200"]
i18n.locale: "zh-CN"
~~~