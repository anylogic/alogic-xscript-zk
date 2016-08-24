zk-getAsJson
=======

zk-getAsJason用于将取得的数据以Json字符串形式输出到当前节点。


### 实现类

com.alogic.xscript.zk.ZKGetAsJson

### 配置参数

支持下列参数：

| 编号 | 代码 | 说明 |
| ---- | ---- | ---- |
| 1 | tag | 节点名称，缺省为data |
| 2 | content | 数据内容，格式为Json字符串，可计算的 |
| 2 | extend | 是否展开，否的话数据将存在$tag节点下 |


### 案例

参考[ZooKeeper操作案例](Example.md)