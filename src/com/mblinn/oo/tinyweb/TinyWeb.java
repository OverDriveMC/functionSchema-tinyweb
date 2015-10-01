package com.mblinn.oo.tinyweb;

import java.util.List;
import java.util.Map;

public class TinyWeb {
	private Map<String,Controller>controllers;
	private List<Filter>filters;
	/**
	 * 该类的构造器拥有两个参数，
	 * 第一个参数是Map,该Map的键是用于表示请求路径的字符串，而值是对应的Controller对象。
	 * 第二个参数是一个过滤器的列表，这些过滤器会在每个请求被传入合适的控制器之前得到运行
	 */
	public TinyWeb(Map<String, Controller> controllers, List<Filter> filters) {
		super();
		this.controllers = controllers;
		this.filters = filters;
	}
	
	/**
	 * 拥有一个公共方法：handlerRequest()。该方法以HttpRequest作为入参，然后将
	 * 每个传入的请求都经过过滤器的运行，完成过滤后为每个请求找到合适的控制器来对其进行处理
	 * 最后返回生成的HttpResponse
	 */
	public HttpResponse handlerRequest(HttpRequest httpRequest){
		HttpRequest currentRequest=httpRequest;
		for(Filter filter : filters ){
			currentRequest=filter.doFilter(currentRequest);
		}
		Controller controller=controllers.get(currentRequest.getPath());
		if(null==controller){
			return null;
		}
		return controller.handlerRequest(httpRequest);
	}
}
