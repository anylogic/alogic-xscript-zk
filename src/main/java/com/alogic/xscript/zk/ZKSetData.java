package com.alogic.xscript.zk;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.zookeeper.CreateMode;
import com.alogic.xscript.zk.util.Path;
import com.alogic.xscript.zk.util.ZooKeeperConnector;
import com.alogic.xscript.ExecuteWatcher;
import com.alogic.xscript.Logiclet;
import com.alogic.xscript.LogicletContext;
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
	protected String mode = CreateMode.PERSISTENT.name();
	protected String data;
	protected boolean ignoreException;

	public ZKSetData(String tag, Logiclet p) {
		super(tag, p);
	}
	
	@Override
	public void configure(Properties p) {
		super.configure(p);
		path = PropertiesConstants.getRaw(p, "path", "");
		mode = PropertiesConstants.getString(p, "mode", mode, true);
		data = PropertiesConstants.getRaw(p, "data", "");
		ignoreException = PropertiesConstants.getBoolean(p, "ignoreException", true);
	}

	@Override
	protected void onExecute(ZooKeeperConnector row, Map<String, Object> root, Map<String, Object> current,
			LogicletContext ctx, ExecuteWatcher watcher) {
		String pathValue = ctx.transform(path).trim();
		String dataValue = ctx.transform(data);
		
		if (StringUtils.isNotEmpty(pathValue)){
			row.createOrUpdate(new Path(pathValue), dataValue, ZooKeeperConnector.DEFAULT_ACL, getCreateMode(mode), null, ignoreException);
		}
	}

}
