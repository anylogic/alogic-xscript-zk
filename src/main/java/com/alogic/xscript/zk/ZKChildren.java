package com.alogic.xscript.zk;

import java.util.Map;

import com.alogic.xscript.zk.util.Path;
import com.alogic.xscript.zk.util.ZooKeeperConnector;
import com.alogic.xscript.ExecuteWatcher;
import com.alogic.xscript.Logiclet;
import com.alogic.xscript.LogicletContext;
import com.anysoft.util.Properties;
import com.anysoft.util.PropertiesConstants;

/**
 * 查询指定路径下子节点
 * 
 * @author duanyy
 *
 */
public class ZKChildren extends ZKOperation {

	protected String path;
	protected boolean ignoreException;
	protected String tag;

	public ZKChildren(String tag, Logiclet p) {
		super(tag, p);
	}

	@Override
	public void configure(Properties p) {
		// TODO Auto-generated method stub
		super.configure(p);

		path = PropertiesConstants.getString(p, "path", "");
		ignoreException = PropertiesConstants.getBoolean(p, "ignoreException", false);
		tag = PropertiesConstants.getString(p, "tag", "data");
	}

	@Override
	protected void onExecute(ZooKeeperConnector row, Map<String, Object> root, Map<String, Object> current,
			LogicletContext ctx, ExecuteWatcher watcher) {

		String tagValue = ctx.transform(tag);
		String[] children = row.loadChildren(new Path(path), this, ignoreException);

		current.put(tagValue, children);

	}

}
