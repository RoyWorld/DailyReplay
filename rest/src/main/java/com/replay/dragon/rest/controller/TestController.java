package com.replay.dragon.rest.controller;

import com.replay.dragon.core.gen.XmlParser;
import com.replay.dragon.rest.entity.Principle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by RoyChan on 2018/10/12.
 */
@RestController
public class TestController {

    @RequestMapping({"test/{id}"})
    public ResponseEntity detail(@PathVariable String id, HttpServletResponse httpServletResponse) {
        return ResponseEntity.ok(String.format("id : %s", id + 1));
    }

    @ResponseBody
    @RequestMapping({"test/principle"})
    public ResponseEntity list(HttpServletResponse httpServletResponse) {
        XmlParser xmlParser = new XmlParser();
        Principle principle = (Principle) xmlParser.convertFromXMLToObject(Principle.class, "/principle.xml");
        Map<String, Object> map = new HashMap<>();
        map.put("principle", principle);
        return ResponseEntity.ok(map);
    }

//    @PostMapping({"tasks"})
//    public ResponseEntity create(HttpServletRequest request) throws Exception {
//
//    }

}
