zk-conn
=======

zk-conn用于创建一个ZooKeeper连接。

>本指令对应ZooKeeper中的connect()接口

### 实现类

com.alogic.xscript.zk.ZKConn

### 配置参数

支持下列参数：

| 编号 | 代码 | 说明 |
| ---- | ---- | ---- |
| 1 | cid | connector的上下文对象id，缺省值为$zk-conn |
| 2 | connectString | ZooKeeper的连接地址：[ip:port]，缺省值为${zookeeper.connectString} |


### 案例
```

	<?xml version="1.0"?>
	<script>
		<using xmlTag="zk-conn" module="com.alogic.xscript.zk.ZKConn" />
		
		<!-- 创建一个连接到本地ZooKeeper -->
		<zk-conn connectString="127.0.0.1:2181">
		
		<!-- 下面是对基于这一连接的操作 -->
		
	</script>