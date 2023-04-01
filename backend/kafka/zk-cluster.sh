#!/bin/bash
case $1 in
"start"){
for i in node04 node05 node06
do
echo ********** zookeeper $i 启动 **********
sshpass -p $2 ssh -o StrictHostKeyChecking=no $i "/opt/backend/zookeeper/zookeeper-3.7.1/bin/zkServer.sh start"
done
}
;;
"stop"){
for i in node04 node05 node06
do
echo ********** zookeeper $i 启动 **********
sshpass -p $2 ssh -o StrictHostKeyChecking=no $i "/opt/backend/zookeeper/zookeeper-3.7.1/bin/zkServer.sh stop"
done
}
;;
esac