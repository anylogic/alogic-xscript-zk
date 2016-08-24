alogic-xscript-zk
=================

alogic-xscript-zk是基于xscript2.0的zookeeper插件，提供了使用zk所需的相关指令，无缝对接zookeeper。

### 案例

下面的案例是对本地ZooKeeper的基本操作。

首先为方便事例，先进行测试数据准备，代码如下：

	<?xml version="1.0"?>
	<script>
		<using xmlTag="zk-conn" module="com.alogic.xscript.zk.ZKConn" />
	
		<!-- 创建一个连接到本地ZooKeeper -->
		<zk-conn >
			
			<!-- 指定路径是否存在 -->
			<zk-exist path = "/test/global/app-1" />
			<log msg = "/test/global/app-1 exist? : ${$zk-exist} " />
			<!-- 创建路径 -->
			<zk-mkpath path = "/test/global/app-1" />
			<log msg = "make path : /test/global/app-1 ...... " />
			<zk-mkpath path = "/test/global/app-2" />
			<log msg = "make path : /test/global/app-2 ...... " />
			<zk-mkpath path = "/test/global/app-3" />
			<log msg = "make path : /test/global/app-3 ...... " />
			
			<!-- 看下创建结果 -->
			<zk-exist path = "/test/global/app-1" />
			<log msg = "/test/global/app-1 exist? : ${$zk-exist} " />
			
			<!-- 分别为每个子路径设置数据 -->
			<zk-children path = "/test/global">
				<!-- 组建Json数据 -->
				<obj tag="data">
					<get id="id" value="alogic"/>
					<get id="name" value="ketty"/>
					<get id="znode" value="${$value}" />
					<!-- 当前节点数据转为Json字符串存入指定变量 -->
					<zk-setAsJson id="jsonData"/>
					<!-- 设置指定路径数据 -->
					<zk-set path = "/test/global/${$value}" data = "${jsonData}" />			
				</obj>
			</zk-children>
			
			
			
		</zk-conn>
	
	</script>
	
在本地拥有测试数据后，执行的操作如下：

	<?xml version="1.0"?>
	<script>
		<using xmlTag="zk-conn" module="com.alogic.xscript.zk.ZKConn" />
	
		<!-- 创建一个连接到本地ZooKeeper -->
		<zk-conn >
			
			<!-- 遍历指定路径的子路径输出到当前文档 -->
			<array tag="instance">
				<zk-children path="/test/global">
		               <array-item>
		               		<get id="id" value="${$value}"/>
		               		<zk-get id="data" path="/test/global/${$value}"/>
		               		<zk-getAsJson tag="data" content="${data}" extend="true"/>
		               </array-item>
				</zk-children>
			 </array>
			
			<!-- 删除指定路径 -->
			<zk-delete path = "/test" />
	
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
- 3.4.7 [20160811 lijun]
	+ 补充了包com.alogic.xscript.zk内的ZooKeeper基本操作，并完成相关文档编写
- 3.4.8 [20160823 duanyy]
	+ 修正代码，增加zk-setAsJson,zk-getAsJson
- 3.4.9 [20160824 lijun]
	+ 修改测试脚本，修改相应文档
	
