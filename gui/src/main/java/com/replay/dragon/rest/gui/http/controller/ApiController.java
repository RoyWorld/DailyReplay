package com.replay.dragon.rest.gui.http.controller;

import com.replay.dragon.rest.StartApplication;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("api")
public class ApiController {

  @RequestMapping("createTask")
  public FullHttpResponse createTask(Channel channel, FullHttpRequest request) throws Exception {
    Map<String, String> map = getQueryParams(request);
    StartApplication.INSTANCE.loadUri("/#/tasks?request=" + map.get("request") + "&response=" + map.get("response"), false);
    FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
    response.headers().set("Access-Control-Allow-Origin", "*");
    return response;
  }

  private Map<String, String> getQueryParams(FullHttpRequest request) throws IOException {
    Map<String, String> map = new HashMap<>();
    String uri = request.uri();
    int index = uri.lastIndexOf("?");
    if (index != -1 && index != uri.length() - 1) {
      String[] params = uri.substring(index + 1).split("&");
      for (String param : params) {
        String[] kv = param.split("=");
        if (kv.length == 2) {
          map.put(kv[0], kv[1]);
        }
      }
    }
    return map;
  }
}
