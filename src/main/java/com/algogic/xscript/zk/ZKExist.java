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
 * 指定的路径是否存在
 * 
 * @author duanyy
 *
 */
public class ZKExist extends ZKOperation {

	protected Path path;

	public ZKExist(String tag, Logiclet p) {
		super(tag, p);
	}

	@Override
	public void configure(Properties p) {
		// TODO Auto-generated method stub
		super.configure(p);
		path = new Path(PropertiesConstants.getString(p, "path", "/", false));
	}

	@Override
	protected void onExecute(ZooKeeperConnector row, Map<String, Object> root, Map<String, Object> current,
			LogicletContext ctx, ExecuteWatcher watcher) {
		ctx.SetValue(id, Boolean.toString(row.existPath(path, this, false)));

	}

}
