package com.mblinn.oo.tinyweb;
 
import java.util.List;
import java.util.Map;
/*
 * 该类会对控制器生成的问候语列表进行逐个遍历
 * 然后将每一段问候语都放入<h2>标记中，最后在这些
 * <h2>标记前加上一个包含"Friendly Greetings："的<h1>标记
 */
public class GreetingRenderingStrategy implements RenderingStrategy {
 
    @Override
    public String renderView(Map<String, List<String>> model) {
        List<String>greetings=model.get("greetings");
        StringBuffer responseBody=new StringBuffer();
        responseBody.append("<h1>Friendly Greetings:</h1>\n");
        for(String greeting : greetings){
            responseBody.append(String.format("<h2>%s</h2>\n",greeting));
        }
        return responseBody.toString();
    }
 
}