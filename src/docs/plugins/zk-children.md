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
| 2 | tag | 遍历子节点的循环变量 |
| 3 | ignoreException | 是否忽略异常，缺省值为false |
| 4 | offset | 设置偏移量 |
| 5 | limt | 遍历数量 |


### 案例
```

参考[ZooKeeper操作案例](Example.md)