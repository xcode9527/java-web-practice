# 虚拟机

## 用户/密码
~~~shell
root / zdw321
zdw / 123456

~~~

## 系统参数调整
### 文件句柄数
~~~shell
# 查看 open files
$ ulimit -a

# 临时修改
$ ulimit -n 65536

# 永久修改
$ vim /etc/security/limits.conf 
# 添加以下行(*代表所有用户)
* soft nofile 65536
* hard nofile 65536
~~~

### 最大用户进程数
~~~shell
# 查看 max user processes
$ ulimit -a 

# 临时修改
$ ulimit -u 65536

# 永久修改
$ vim /etc/security/limits.conf
# 添加以下行(*代表所有用户)
* soft nproc 65536
* hard nproc 65536
~~~

### vm.max_map_count
~~~sh
# 查看
$ sysctl -a|grep vm.max_map_count

# 临时修改
$ sysctl -w vm.max_map_count=262144

# 永久修改
$ vim /etc/sysctl.conf
# 添加以下行
vm.max_map_count=262144
~~~

### stack size
~~~shell
# 查看 stack size
$ ulimit -a
 
# 临时修改
$ ulimit -s 1024

# 永久修改
$ vim /etc/security/limits.conf
# 添加以下行(*代表所有用户)
* soft stack 1024
* hard stack 1024
~~~

### sshpass

~~~shell
# 安装sshpass, ssh免密交互
$ yum install sshpass
~~~

### swap

~~~
# elasticsearch 禁用swap
$ vim /etc/fstab


~~~



