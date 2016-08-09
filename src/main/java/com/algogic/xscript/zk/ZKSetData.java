package com.algogic.xscript.zk;

import java.util.Map;

import com.algogic.xscript.zk.util.ZooKeeperConnector;
import com.alogic.xscript.ExecuteWatcher;
import com.alogic.xscript.Logiclet;
import com.alogic.xscript.LogicletContext;


/**
 * 设置指定路径的数据
 * 
 * @author duanyy
 *
 */
public class ZKSetData extends ZKOperation{

	public ZKSetData(String tag, Logiclet p) {
		super(tag, p);
	}

	@Override
	protected void onExecute(ZooKeeperConnector row, Map<String, Object> root, Map<String, Object> current,
			LogicletContext ctx, ExecuteWatcher watcher) {
		// to do
	}

}
