package com.algogic.xscript.zk;

import java.util.Map;

import com.algogic.xscript.zk.util.Path;
import com.algogic.xscript.zk.util.ZooKeeperConnector;
import com.alogic.xscript.ExecuteWatcher;
import com.alogic.xscript.Logiclet;
import com.alogic.xscript.LogicletContext;
import com.anysoft.util.Properties;
import com.anysoft.util.PropertiesConstants;

/**
 * 获取指定路径的数据
 * 
 * @author duanyy
 *
 */
public class ZKGetData extends ZKOperation {

	protected String path = "";
	protected boolean ignoreException;

	public ZKGetData(String tag, Logiclet p) {
		super(tag, p);

	}

	@Override
	public void configure(Properties p) {
		// TODO Auto-generated method stub
		super.configure(p);

		path = PropertiesConstants.getString(p, "path", "/");
		ignoreException = PropertiesConstants.getBoolean(p, "ignoreException", false);
	}

	@Override
	protected void onExecute(ZooKeeperConnector row, Map<String, Object> root, Map<String, Object> current,
			LogicletContext ctx, ExecuteWatcher watcher) {

		ctx.SetValue(id, row.loadData(new Path(path), this, ignoreException));

	}

}
