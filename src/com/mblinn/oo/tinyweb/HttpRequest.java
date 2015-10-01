package com.mblinn.oo.tinyweb;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
	private final Map<String,String> header;
	private final String body;
	private final String path;
	
	private HttpRequest(Builder builder){
		this.header=builder.header;
		this.body=builder.body;
		this.path=builder.path;
	}
	public Map<String,String> getHeader() {
		return header;
	}
	public String getBody() {
		return body;
	}
	public String getPath() {
		return path;
	}
	public static class Builder{
		private  Map<String,String> header;
		private  String body;
		private  String path;
		
		private Builder(){
			header=new HashMap<String,String>();
		}
		public void addHeader(String headName,String headValue){
			header.put(headName, headValue);
		}
		public Builder body(String body){
			this.body=body;
			return this;
		}
		public Builder path(String path){
			this.path=path;
			return this;
		}
		public HttpRequest build(){
			return new HttpRequest(this);
		}
		public static Builder newBuilder(){
			return new Builder();
		}
		
		public static Builder builderFrom(HttpRequest request){
			Builder builder=new Builder();
			builder.path(request.getPath());
			builder.body(request.getBody());
			
			Map<String,String>headers=request.getHeader();
			for(String headName : headers.keySet()){
				builder.addHeader(headName, headers.get(headName));
			}
			return builder;
		}
	}
}
