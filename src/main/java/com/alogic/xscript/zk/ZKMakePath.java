package com.alogic.xscript.zk;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;

import com.alogic.xscript.zk.util.Path;
import com.alogic.xscript.zk.util.ZooKeeperConnector;
import com.alogic.xscript.ExecuteWatcher;
import com.alogic.xscript.Logiclet;
import com.alogic.xscript.LogicletContext;
import com.anysoft.util.Properties;
import com.anysoft.util.PropertiesConstants;


/**
 * 创建指定路径
 * 
 * @author duanyy
 *
 */
public class ZKMakePath extends ZKOperation{

	protected String path;
	protected String mode = CreateMode.PERSISTENT.name();
	
	public ZKMakePath(String tag, Logiclet p) {
		super(tag, p);
	}
	
	@Override
	public void configure(Properties p) {
		super.configure(p);
		
		path = PropertiesConstants.getRaw(p, "path", "");
		mode = PropertiesConstants.getString(p, "mode", mode, true);
	}

	@Override
	protected void onExecute(ZooKeeperConnector row, Map<String, Object> root, Map<String, Object> current,
			LogicletContext ctx, ExecuteWatcher watcher) {
		String pathValue = ctx.transform(path);

		if (StringUtils.isNotEmpty(pathValue)) {
			row.makePath(new Path(pathValue), ZooKeeperConnector.DEFAULT_ACL, getCreateMode(mode));
		}
	}
}
