zk-exist
=======

zk-exist用于判断指定的路径是否存在。

>本指令对应ZooKeeper中的stat exists(String path, Watcher watcher)接口

### 实现类

com.alogic.xscript.zk.ZKExist

### 配置参数

支持下列参数：

| 编号 | 代码 | 说明 |
| ---- | ---- | ---- |
| 1 | path | 指定的路径 |
| 2 | id | 操作返回变量id,缺省为$zk-exist |


### 案例

参考[ZooKeeper操作案例](Example.md)