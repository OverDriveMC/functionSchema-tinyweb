package com.mblinn.oo.tinyweb.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.mblinn.oo.tinyweb.Controller;
import com.mblinn.oo.tinyweb.Filter;
import com.mblinn.oo.tinyweb.GreetingController;
import com.mblinn.oo.tinyweb.GreetingRenderingStrategy;
import com.mblinn.oo.tinyweb.HttpRequest;
import com.mblinn.oo.tinyweb.HttpResponse;
import com.mblinn.oo.tinyweb.LoggingFilter;
import com.mblinn.oo.tinyweb.StrategyView;
import com.mblinn.oo.tinyweb.TinyWeb;


public class TestTinyWeb {

	@Test
	public void test() {
		HttpRequest request=HttpRequest.Builder.newBuilder()
				.body("Mike,Joe,John,Steve")
				.path("greeting").build();
		/*
		 * 装配过滤器
		 */
		Filter filter=new LoggingFilter();
		List<Filter>filters=new ArrayList<Filter>();
		filters.add(filter);
		/*
		 * 配置控制器
		 */
		Controller controller=new GreetingController(new StrategyView(new GreetingRenderingStrategy()));
		Map<String,Controller>controllerMap=new HashMap<String,Controller>();
		controllerMap.put("greeting", controller);
		TinyWeb tinyweb=new TinyWeb(controllerMap,filters);
		HttpResponse response=tinyweb.handlerRequest(request);
		System.out.println("responseCode:"+response.getResponseCode());
		System.out.println("responseBody:\n"+response.getBody());
	}

}
