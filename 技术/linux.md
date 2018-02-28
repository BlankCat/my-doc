##查看tomcat启动脚本
* /etc/init.d/tomcat2 restart
* tail -f /usr/local/tomcat2/logs/catalina-daemon.out

##查询redis
* ps -ef |grep redis
* cd /usr/local/redis/bin
* ls
##启动客户端软件
* ./redis-cli
##选择库
* select 3 选择3号库
  ok
* get |lstangrongzhi  查询出对应的值
* key *
* key 


##查看web监听服务
* 步骤1
    * 进入tomcat的conf执行命令
    * cat server.xml
    * 查看工程部署目录 /dada0/www/

* 步骤2
    * 查看tomcat的环境变量
    * cat /etc/profile
    * 查看tomcat环境变量
* 步骤3
    * 进入/etc/init.d目录下查看有没有tomcat的启动脚本
    * 执行命令(在tomcat的脚本上面检索环境变量)
    * grep "CATALINA_HOME" /etc/init.d/tomcat

启动服务器
/etc/init.d/tomcat2 restart
tail -f /usr/local/tomcat1/logs/catalina-daemon.out

##查看zookeeper注册中心注册的服务
* 进入zookeeper的安装目录，进入bin 目录 cd /usr/local/zookeeper/bin
* ./zkCli.sh
* ls /dubbo/com.blank.service.servicename