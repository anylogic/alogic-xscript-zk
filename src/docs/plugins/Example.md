ZooKeeper操作案例
==============

下面是一个ZooKeeper的操作案例。

> 您可以在工程代码目录下找到本案例代码
> ```
> 		/src/test/resources/xscript/Example.xml
> ```

下面是案例内容：

```

	<?xml version="1.0"?>
	<script>
		<using xmlTag = "zk-conn" module = "com.alogic.xscript.zk.ZKConn" />
		
		<!-- 创建一个连接到本地ZooKeeper -->
		<zk-conn connectString = "127.0.0.1:2181">
	
			<!-- 获得路径 / 下的子节点信息 -->
			<zk-children path = "/" tag = "data"/>
		
			<!-- 获得/APP1/节点数据 -->
			<zk-get path = "/APP1" id = "app1data"/> 
		
			<!-- 查看/APP2/节点是否存在 -->
			<zk-exist path = "/APP2/" />
			
			<!-- 创建/APP2/节点 -->
			<zk-mkpath path = "/APP2/" mode = "0" />
			
			<!-- 查看/APP2/节点是否存在 -->
			<zk-exist path = "/APP2/"/>
			
			<!-- 给/APP2/节点设置数据 -->
			<zk-set path = "/APP2/" mode = "0" data = "this-is-app2-data" />
			
			<!-- 查看/APP2/节点数据 -->
			<zk-get path = "/APP2/" id = "app2data" />
				
			<!-- 删除/APP2/节点 -->
			<zk-delete path = "/APP2/" />
			
			<!-- 查看/APP2/节点是否存在 -->
			<zk-exist path = "/APP2/" />
		
		</zk-conn>
	
	</script>

```