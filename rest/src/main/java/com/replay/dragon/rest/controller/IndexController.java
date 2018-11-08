package com.replay.dragon.rest.controller;

import com.replay.dragon.core.gen.XmlParser;
import com.replay.dragon.core.util.PathUtil;
import com.replay.dragon.core.util.ReportIndexUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RoyChan on 2018/10/29.
 */
@RestController
public class IndexController {

    @ResponseBody
    @GetMapping({"/completeDate/{year}/{month}"})
    public ResponseEntity list(@PathVariable String year, @PathVariable String month) {
        //把缺少的0补上
        if (Integer.parseInt(month) < 10){
            month = "0" + month;
        }
        String regex = year + month + "**";
        ReportIndexUtil.filter(regex);
        List<String> completeDate = ReportIndexUtil.getDailyIndex();
        Map<String, Object> map = new HashMap<>();
        map.put("completeDate", completeDate);
        return ResponseEntity.ok(map);
    }


}
