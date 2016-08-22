alogic-xscript-zk
=================

alogic-xscript-zk是基于xscript2.0的zookeeper插件，提供了使用zk所需的相关指令，无缝对接zookeeper。

### 案例

下面的案例是对本地ZooKeeper的基本操作。

	<?xml version="1.0"?>
	<script>
		<using xmlTag="zk-conn" module="com.alogic.xscript.zk.ZKConn" />
	
		<!-- 创建一个连接到本地ZooKeeper -->
		<zk-conn connectString="127.0.0.1:2181">
				
			<!-- 创建路径/app1，并前后查看路径存在情况 -->
			<zk-exist path = "/app1" />
			<zk-mkpath path = "/app1" />
			<zk-exist path = "/app1" />
			
			<!-- 设置指定路径数据 -->
			<zk-set path = "/app1" data = "app1-data" />
			<!-- 获取指定路径数据 -->
			<zk-get path = "/app1" />
			
			<!-- 删除指定路径 -->
			<zk-delete path = "/app1" />
			<zk-exist path = "/app1"/>
			
			
			<zk-mkpath path = "/APP1" />
			<zk-mkpath path = "/APP2" />
			<zk-mkpath path = "/APP3" />
			<zk-mkpath path = "/APP1/SAPP1" />
			<zk-mkpath path = "/APP1/SAPP2" />
			
			<!-- 遍历子节点，可设置偏移量，循环变量由tag设置 -->
			<zk-children tag = "item" path = "/" offset = "0" limit = "10" >
				<zk-exist path = "${item}" />
				
				<!-- 设置子节点数据 -->
				<zk-set path = "${item}" data = "new-data"/>
			</zk-children>
			
			<zk-children tag = "item" path = "/" offset = "0" limit = "10" >
				<zk-get path = "${item}" />
			</zk-children>
			
			<!-- 删除子节点 -->
			<zk-children tag = "item" path = "/" offset = "0" limit = "10" >
				<zk-delete path = "${item}" />
			</zk-children>
			
		</zk-conn>
	
	</script>


### 如何开始？

为正确执行上述指令，需要在本地安装好ZooKeeper并启动。

ZooKeeper启动后，就可以运行[demo](src/test/java/Demo.java)来测试xscript脚本。

### 指令参考

参见[alogic-xscript-zk参考](src/docs/reference.md)。

### 版本历史
    
- 3.4.6 [20160809 duanyy]
	+ 初次发布
- 3.4.6 [20160811 lijun]
	+ 补充了包com.alogic.xscript.zk内的ZooKeeper基本操作，并完成相关文档编写
	
