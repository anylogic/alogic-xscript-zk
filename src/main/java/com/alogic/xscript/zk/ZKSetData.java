package com.alogic.xscript.zk;

import java.util.Map;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;

import com.alogic.xscript.zk.util.Path;
import com.alogic.xscript.zk.util.ZooKeeperConnector;
import com.alogic.xscript.ExecuteWatcher;
import com.alogic.xscript.Logiclet;
import com.alogic.xscript.LogicletContext;
import com.alogic.xscript.util.MapProperties;
import com.anysoft.util.Properties;
import com.anysoft.util.PropertiesConstants;


/**
 * 设置指定路径的数据
 * 
 * @author duanyy
 *
 */
public class ZKSetData extends ZKOperation{
	
	protected String path;
	protected int mode;
	protected String data;
	protected boolean ignoreException;

	public ZKSetData(String tag, Logiclet p) {
		super(tag, p);
	}
	
	@Override
	public void configure(Properties p) {
		// TODO Auto-generated method stub
		super.configure(p);
		path = PropertiesConstants.getRaw(p, "path", "");
		mode = PropertiesConstants.getInt(p, "mode", 0, false);
		data = PropertiesConstants.getString(p, "data", "", false);
		ignoreException = PropertiesConstants.getBoolean(p, "ignoreException", false);
	}

	@Override
	protected void onExecute(ZooKeeperConnector row, Map<String, Object> root, Map<String, Object> current,
			LogicletContext ctx, ExecuteWatcher watcher) {
		
		String pathValue = ctx.transform(path);

		try {
			row.createOrUpdate(new Path(pathValue), data, ZooKeeperConnector.DEFAULT_ACL, CreateMode.fromFlag(mode), null, ignoreException);
		} catch (KeeperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
