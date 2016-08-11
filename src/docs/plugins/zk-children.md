zk-children
=======

zk-children用于查询指定路径下子节点。

>本指令对应ZooKeeper中的List<String> getChildren(Path path,Watcher watcher,boolean ignoreException)接口

### 实现类

com.alogic.xscript.zk.ZKChildren

### 配置参数

支持下列参数：

| 编号 | 代码 | 说明 |
| ---- | ---- | ---- |
| 1 | path | 指定的路径 |
| 2 | tag | 插入文档的tag，缺省为data |
| 3 | ignoreException | 是否忽略异常，缺省值为false |


### 案例
```

	<?xml version="1.0"?>
	<script>
		<using xmlTag="zk-conn" module="com.alogic.xscript.zk.ZKConn" />
		
		<!-- 创建一个连接到本地ZooKeeper -->
		<zk-conn connectString="127.0.0.1:2181">
		
		<!-- 下面是对基于这一连接的操作 -->
		
	</script>