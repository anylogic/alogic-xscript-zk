package com.alogic.xscript.zk;

import java.util.List;
import java.util.Map;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.w3c.dom.Element;

import com.alogic.xscript.ExecuteWatcher;
import com.alogic.xscript.Logiclet;
import com.alogic.xscript.LogicletContext;
import com.alogic.xscript.plugins.Segment;
import com.alogic.xscript.zk.util.Path;
import com.alogic.xscript.zk.util.ZooKeeperConnector;
import com.anysoft.util.BaseException;
import com.anysoft.util.Properties;
import com.anysoft.util.PropertiesConstants;

public class ZKChildren extends Segment implements Watcher {

	protected String path;
	protected boolean ignoreException;
	protected String tag;
	protected int offset;
	protected int limit;

	public ZKChildren(String tag, Logiclet p) {
		super(tag, p);
		// TODO Auto-generated constructor stub

	}

	@Override
	public void process(WatchedEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configure(Properties p) {
		// TODO Auto-generated method stub
		super.configure(p);

		path = PropertiesConstants.getString(p, "path", "");
		ignoreException = PropertiesConstants.getBoolean(p, "ignoreException", false);
		tag = PropertiesConstants.getString(p, "tag", "item");
		offset = PropertiesConstants.getInt(p, "offset", 0);
		limit = PropertiesConstants.getInt(p, "limit", 15);
	}

	@Override
	protected void onExecute(Map<String, Object> root, Map<String, Object> current, LogicletContext ctx,
			ExecuteWatcher watcher) {
		// TODO Auto-generated method stub

		ZooKeeperConnector conn = ctx.getObject("$zk-conn");
		List<String> childrenList = conn.getChildren(new Path(path), this, ignoreException);

		if (offset < childrenList.size() && offset >= 0){
			// 根据偏移量计算截取的子节点段
			int startIndex = offset;
			int endIndex = (offset + limit > childrenList.size()) ? childrenList.size() : (offset + limit);
			// 截出指定的子节点段
			List<String> result = childrenList.subList(startIndex, endIndex);

			// 遍历子节点
			if (result.size() > 0) {
				for (String value : result) {
					ctx.SetValue(tag, path + value);
					super.onExecute(root, current, ctx, watcher);
				}
			}
		}else {
			throw new BaseException("zk-children", "illegal argument  offset");
		}

		
	}

}
