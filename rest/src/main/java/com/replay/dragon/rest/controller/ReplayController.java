package com.replay.dragon.rest.controller;


import com.codegen.jet.core.exception.EngineException;
import com.replay.dragon.core.gen.XmlParser;
import com.replay.dragon.core.util.ReportIndexUtil;
import com.replay.dragon.core.velocity.VelocityTemplateEngine;
import com.replay.dragon.rest.entity.rp.Replay;
import com.replay.dragon.rest.entity.rp.StockDescribe;
import com.replay.dragon.rest.report.ReplayReportFactory;
import com.replay.dragon.rest.util.DateUtil;
import com.replay.dragon.core.util.PathUtil;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.*;

/**
 * Created by RoyChan on 2018/10/23.
 */
@RestController
public class ReplayController {

    @ResponseBody
    @GetMapping({"/replay/sympatheticStock"})
    public Map<String, Object> getSympatheticStock() throws ParseException {

        String dayString = DateUtil.addOrSubDay(-1);

        if (DateUtil.getWeekday() == Calendar.MONDAY){
            dayString = DateUtil.addOrSubDay(-3);
        }

        String year = dayString.substring(0, 4);
        String month = dayString.substring(4, 6);
        String day = dayString.substring(6);

        String dailyPath = String.format("%s\\%s\\%s\\%s.xml", year, month, day, dayString);

        XmlParser xmlParser = new XmlParser();
        Replay replay = (Replay) xmlParser.convertFromXMLToObject(Replay.class, PathUtil.REPLAY_PATH + dailyPath);

        Map<String, Object> map = new HashMap<>();
        map.put("replay", replay);
        return map;
    }

    @ResponseBody
    @PostMapping({"/replay/save"})
    public Map<String, Object> save(@RequestBody Replay replay) throws IOException {
        //取当前日期
        Date date = new Date();
        String year = String.valueOf(DateUtil.getYMD(date, Calendar.YEAR));
        String month = String.valueOf(DateUtil.getYMD(date, Calendar.MONTH) + 1);
        int dayInt = DateUtil.getYMD(date, Calendar.DAY_OF_MONTH);
        String day = dayInt > 10 ? String.valueOf(dayInt) : "0"+String.valueOf(dayInt);

        String dailyPath = String.format("%s\\%s\\%s", year, month, day);
        String dailyPathName = DateUtil.getDailyPathName();

        List<StockDescribe> breaktrading = new ArrayList<>();
        breaktrading.add(replay.getSympatheticstock().getMainbreaktrading().get(0));
        breaktrading.add(replay.getSympatheticstock().getNomainbreaktrading().get(0));
        replay.getSympatheticstock().setBreaktrading(breaktrading);

        //保存成xml的格式
        XmlParser xmlParser = new XmlParser();
        String fullPath = PathUtil.REPLAY_PATH + dailyPath + String.format("\\%s.xml", dailyPathName);
        File fileDir = new File(PathUtil.REPLAY_PATH + dailyPath);
        FileUtils.forceMkdir(fileDir);

        xmlParser.convertFromObjectToXML(replay, Replay.class, fullPath);

        //保存成dr的格式
        save_report(replay, dailyPathName, dailyPath);

        //写dr的index
        ReportIndexUtil.writeIndex(DateUtil.getDailyPathName());

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    /**
     * 保存成dr的格式
     * @param replay
     * @param dailyString
     * @param dailyPath
     */
    public void save_report(Replay replay, String dailyString, String dailyPath) throws IOException {

        //destFile
        File fileDir = new File(String.format(PathUtil.REPLAY_FILE_NAME + "\\%s\\", dailyPath));

        FileUtils.forceMkdir(fileDir);

        File destFile = new File(fileDir.getAbsolutePath() + String.format("\\%s.dr", dailyString));

        //用velocity来保存dr
        try{
            ReplayReportFactory replayReportFactory = new ReplayReportFactory(new VelocityTemplateEngine(""));
            replayReportFactory.setDailyString(DateUtil.getDailyString());
            replayReportFactory.getDataFromDomain(replay);
            replayReportFactory.generateSingleTemplates("report.dr", destFile.getAbsolutePath());
        } catch (EngineException e){
            System.out.println(e.getMessage());
        }
    }


    @ResponseBody
    @GetMapping({"/replay/report/{yearInt}/{monthInt}/{dayInt}"})
    public Map<String, Object> report(@PathVariable int yearInt, @PathVariable int monthInt, @PathVariable int dayInt) {

        String year = String.valueOf(yearInt);
        String month = String.valueOf(monthInt);
        String day = dayInt > 10 ? String.valueOf(dayInt) : "0"+String.valueOf(dayInt);

        String dailyPath = String.format("%s\\%s\\%s", year, month, day);
        String reportFile = String.format("%s%s%s.dr", year, month, day);
        Map<String, Object> map = new HashedMap();
        try {
            String content = new String(Files.readAllBytes(Paths.get(PathUtil.REPLAY_PATH + dailyPath + "\\" + reportFile)));
            map.put("report", content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @ResponseBody
    @PostMapping({"/replay/saveTest"})
    public Map<String, Object> saveTest(@RequestBody List<StockDescribe> pet) {
        Map<String, Object> map = new HashMap<>();
        map.put("pet", pet);
        return map;
    }
}
