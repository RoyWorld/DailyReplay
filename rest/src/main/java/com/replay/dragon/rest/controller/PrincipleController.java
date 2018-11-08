package com.replay.dragon.rest.controller;

import com.replay.dragon.core.gen.XmlParser;
import com.replay.dragon.core.util.PathUtil;
import com.replay.dragon.rest.entity.Principle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RoyChan on 2018/10/19.
 */
@RestController
public class PrincipleController {

    @ResponseBody
    @GetMapping({"/principle"})
    public ResponseEntity list() {
        XmlParser xmlParser = new XmlParser();
        Principle principle = (Principle) xmlParser.convertFromXMLToObject(Principle.class, PathUtil.CORE_SRC_RESOURCES_PATH + "principle.xml");
        Map<String, Object> map = new HashMap<>();
        map.put("principle", principle);
        return ResponseEntity.ok(map);
    }

    @ResponseBody
    @PutMapping({"/principle/add/{principleType}/{principleContent}"})
    public ResponseEntity add(@PathVariable String principleType, @PathVariable String principleContent) {
        XmlParser xmlParser = new XmlParser();
        Principle principle = (Principle) xmlParser.convertFromXMLToObject(Principle.class, PathUtil.CORE_SRC_RESOURCES_PATH + "principle.xml");

        if ("select".equals(principleType)){
            principle.getSelects().add(principleContent);
        }else if ("buy".equals(principleType)){
            principle.getBuys().add(principleContent);
        }else if ("sell".equals(principleType)){
            principle.getSells().add(principleContent);
        }

        xmlParser.convertFromObjectToXML(principle, Principle.class, "principle.xml");

        return ResponseEntity.ok(null);
    }

    @ResponseBody
    @DeleteMapping({"/principle/del/{principleType}/{id}"})
    public ResponseEntity del(@PathVariable String principleType, @PathVariable int id) {
        XmlParser xmlParser = new XmlParser();
        Principle principle = (Principle) xmlParser.convertFromXMLToObject(Principle.class, PathUtil.CORE_SRC_RESOURCES_PATH + "principle.xml");

        Principle trashP = new Principle();

        List<String> list = new ArrayList<>();
        if ("select".equals(principleType)){
            list.add(principle.getSelects().get(id));
            trashP.setSelects(list);
            principle.getSelects().remove(id);
        }else if ("buy".equals(principleType)){
            list.add(principle.getBuys().get(id));
            trashP.setBuys(list);
            principle.getBuys().remove(id);
        }else if ("sell".equals(principleType)){
            list.add(principle.getSells().get(id));
            trashP.setSelects(list);
            principle.getSells().remove(id);
        }

        xmlParser.convertFromObjectToXML(principle, Principle.class, PathUtil.CORE_SRC_RESOURCES_PATH + "principle.xml");
        xmlParser.convertFromObjectToXML(trashP, Principle.class, PathUtil.CORE_SRC_RESOURCES_PATH + "trashP.xml");

        return ResponseEntity.ok(null);
    }

}
