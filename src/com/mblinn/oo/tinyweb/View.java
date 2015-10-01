package com.mblinn.oo.tinyweb;

import java.util.List;
import java.util.Map;

/*
 * 首先将需要一个View接口，他拥有唯一的方法render()
 * render()方法以类型为Map<String,List<String>>的
 * model作为入参，该model代表了模型的属性和值。
 * 单个属性可以拥有多个值
 * 该方法返回一个代表已渲染视图的字符串
 */
public interface View {
	public String render(Map<String,List<String>>model);
}
