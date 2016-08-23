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
 * 指定的路径是否存在
 * 
 * @author duanyy
 *
 */
public class ZKExist extends ZKOperation {

	protected String path;

	public ZKExist(String tag, Logiclet p) {
		super(tag, p);
	}

	@Override
	public void configure(Properties p) {
		super.configure(p);
		path = PropertiesConstants.getRaw(p, "path", "");
	}

	@Override
	protected void onExecute(ZooKeeperConnector row, Map<String, Object> root, Map<String, Object> current,
			LogicletContext ctx, ExecuteWatcher watcher) {		
		String pathValue = ctx.transform(path);
		
		if (StringUtils.isNotEmpty(pathValue)) {
			ctx.SetValue(id, Boolean.toString(row.existPath(new Path(pathValue), this, false)));
		}
	}

}
