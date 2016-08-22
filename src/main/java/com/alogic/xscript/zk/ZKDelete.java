package com.alogic.xscript.zk;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alogic.xscript.zk.util.Path;
import com.alogic.xscript.zk.util.ZooKeeperConnector;
import com.alogic.xscript.ExecuteWatcher;
import com.alogic.xscript.Logiclet;
import com.alogic.xscript.LogicletContext;
import com.anysoft.util.Properties;
import com.anysoft.util.PropertiesConstants;

/**
 * 删除指定的路径
 * 
 * @author duanyy
 *
 */
public class ZKDelete extends ZKOperation {

	protected String path;
	protected boolean ignoreException;

	public ZKDelete(String tag, Logiclet p) {
		super(tag, p);
	}

	@Override
	public void configure(Properties p) {
		// TODO Auto-generated method stub
		super.configure(p);

		path = PropertiesConstants.getRaw(p, "path", "");
		ignoreException = PropertiesConstants.getBoolean(p, "ignoreException", false);
	}

	@Override
	protected void onExecute(ZooKeeperConnector row, Map<String, Object> root, Map<String, Object> current,
			LogicletContext ctx, ExecuteWatcher watcher) {

		String pathValue = ctx.transform(path);
		
		if (StringUtils.isNotBlank(pathValue)) {
			row.deletePath(new Path(pathValue), ignoreException);
		}

	}

}
