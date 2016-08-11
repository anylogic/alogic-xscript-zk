zk-mkpath
=======

zk-mkpath用于判断指定的路径是否存在。

>本指令对应ZooKeeper中的	create(String path, byte[] data, List<ACL> acl, CreateMode createMode)接口

### 实现类

com.alogic.xscript.zk.ZKMakePath

### 配置参数

支持下列参数：

| 编号 | 代码 | 说明 |
| ---- | ---- | ---- |
| 1 | path | 指定的路径 |
| 2 | mode | 创建模式，接收数值0~3，对应关系为：0:PERSISTENT; 1:EPHEMERAL; 2:PERSISTENT_SEQUENTIAL, 3:EPHEMERAL_SEQUENTIAL|


### 案例

参考[ZooKeeper操作案例](Example.md)