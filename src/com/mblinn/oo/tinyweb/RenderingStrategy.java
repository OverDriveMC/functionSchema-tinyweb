package com.mblinn.oo.tinyweb;

import java.util.List;
import java.util.Map;

/*
 * RenderingStrategy负责完成实际的视图渲染工作，
 * 它将由框架的用户来进行实现
 */
public interface RenderingStrategy {
	public String renderView(Map<String,List<String>>model);
}
