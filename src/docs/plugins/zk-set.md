zk-set
=======

zk-set用于设置指定路径的数据，即创建或更新指定节点数据。

>若指定路径存在，本指令对应ZooKeeper中的	setData(final String path, byte data[], int version)接口；
>若指定路径不存在，本指令对应ZooKeeper中的  create(final String path, byte data[], List<ACL> acl, CreateMode createMode)接口;

### 实现类

com.alogic.xscript.zk.ZKSetData

### 配置参数

支持下列参数：

| 编号 | 代码 | 说明 |
| ---- | ---- | ---- |
| 1 | path | 指定的路径 |
| 2 | mode | 创建模式，接收数值0~3，对应关系为：0:PERSISTENT; 1:EPHEMERAL; 2:PERSISTENT_SEQUENTIAL, 3:EPHEMERAL_SEQUENTIAL|
| 3 | data | 设置的数据，String类型 |
| 4 | ignoreException | 是否忽略异常，缺省值为false |

### 案例

参考[ZooKeeper操作案例](Example.md)