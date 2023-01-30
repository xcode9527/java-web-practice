# JDK环境变量

## 下载地址

[oracle jdk 下载地址](https://www.oracle.com/java/technologies/downloads/)

## jdk8安装实例

~~~shell
# 解压安装包
$ tar -zxf jdk-8u361-linux-x64.tar.gz

# 编辑/etc/profile，配置环境变量
$ vim /etc/profile
# 添加以下行
export JAVA_HOME=/opt/backend/env/java/jdk1.8.0_361
export PATH=$PATH:$JAVA_HOME/bin
export CLASSPATH=.:$JAVA_HOME/jre/lib/rt.jar:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar

# 使配置生效
$ source /etc/profile
~~~

