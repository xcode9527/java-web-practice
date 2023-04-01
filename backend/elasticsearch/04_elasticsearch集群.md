# 集群

## 集群启动脚本

~~~shell
#!/bin/bash
# A script of elasticsearch cluster.

nodeConf=node04,node05,node06
nodes=(${nodeConf//,/ })

ES_HOME=/opt/backend/elasticsearch/elasticsearch-7.17.8

case $1 in
"start") {
  for node in ${nodes[@]}
  do
    sshpass -p $2 ssh -o StrictHostKeyChecking=no es@$node "${ES_HOME}/bin/elasticsearch > /dev/null 2>&1 &"
    if [ $? != 0 ]
    then
      echo "es server start fail ob host $node !"
      exit 1
    else
      echo "es server start success on host $node !"
    fi
  done
}
;;
"stop") {
  for node in ${nodes[@]}
  do
    sshpass -p $2 ssh -o StrictHostKeyChecking=no es@$node "ps -ef|grep ${ES_HOME} |grep -v grep|awk '{print \$2}'|xargs kill" >/dev/null 2>&1
    if [ $? != 0 ]
    then
      echo "es server stop fail ob host $node !"
      exit 1
    else
      echo "es server stop success on host $node !"
    fi
  done
}
;;
esac

~~~

