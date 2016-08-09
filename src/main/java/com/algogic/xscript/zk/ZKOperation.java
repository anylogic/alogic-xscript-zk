package com.algogic.xscript.zk;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import com.algogic.xscript.zk.util.ZooKeeperConnector;
import com.alogic.xscript.AbstractLogiclet;
import com.alogic.xscript.ExecuteWatcher;
import com.alogic.xscript.Logiclet;
import com.alogic.xscript.LogicletContext;
import com.anysoft.util.BaseException;
import com.anysoft.util.Properties;
import com.anysoft.util.PropertiesConstants;

/**
 * ZK操作基类
 * 
 * @author duanyy
 *
 */
public abstract class ZKOperation extends AbstractLogiclet implements Watcher{

	private String pid = "$zk-conn";
	
	/**
	 * 返回结果的id
	 */
	protected String id;
	
	public ZKOperation(String tag, Logiclet p) {
		super(tag, p);
	}
	
	public void configure(Properties p){
		super.configure(p);
		pid = PropertiesConstants.getString(p,"pid", pid,true);
		id = PropertiesConstants.getString(p,"id", "$" + getXmlTag(),true);
	}

	@Override
	protected void onExecute(Map<String, Object> root,
			Map<String, Object> current, LogicletContext ctx,
			ExecuteWatcher watcher) {
		ZooKeeperConnector conn = ctx.getObject(pid);
		if (conn == null){
			throw new BaseException("core.no_zkconn","It must be in a zk-conn context,check your script.");
		}
		
		if (StringUtils.isNotEmpty(id)){
			onExecute(conn,root,current,ctx,watcher);
		}
	}

	protected abstract void onExecute(ZooKeeperConnector row, Map<String, Object> root,
			Map<String, Object> current, LogicletContext ctx,
			ExecuteWatcher watcher);
		
	public void process(WatchedEvent event) {

	}		
}