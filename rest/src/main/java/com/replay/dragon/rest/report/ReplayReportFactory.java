package com.replay.dragon.rest.report;

import com.codegen.jet.core.BaseDomain;
import com.codegen.jet.core.BaseEngine;
import com.codegen.jet.core.BaseFactory;
import com.codegen.jet.core.exception.EngineException;
import com.replay.dragon.core.gen.XmlParser;
import com.replay.dragon.core.util.PathUtil;
import com.replay.dragon.core.velocity.VelocityTemplateEngine;
import com.replay.dragon.rest.entity.rp.Replay;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * Created by RoyChan on 2018/10/25.
 */
public class ReplayReportFactory extends BaseFactory {

    private String dailyString = "";

    public ReplayReportFactory(BaseEngine baseEngine) {
        super(baseEngine);
    }

    @Override
    public void getDataFromDomain(BaseDomain... baseDomain) {
        data = new HashMap();
        data.put("time", dailyString);
        data.put("replay", baseDomain[0]);
    }

    public void setDailyString(String dailyString) {
        this.dailyString = dailyString;
    }

    public static void main(String[] args) throws IOException {
        XmlParser xmlParser = new XmlParser();
        Replay replay = (Replay) xmlParser.convertFromXMLToObject(Replay.class, PathUtil.REPLAY_PATH + "2018\\10\\23\\20181023.xml");

        //destFile
        File fileDir = new File("rp_replay\\2018\\10\\23\\");

        if (!fileDir.exists()){
            fileDir.mkdir();
        }

        File destFile = new File(fileDir.getAbsolutePath() + "\\20181023.dr");

        try{
            ReplayReportFactory petFactory = new ReplayReportFactory(new VelocityTemplateEngine(""));
            petFactory.setDailyString("20181023 星期二");
            petFactory.getDataFromDomain(replay);
            petFactory.generateSingleTemplates("report.dr", destFile.getAbsolutePath());

        } catch (EngineException e){
            System.out.println(e.getMessage());
        }

        String content = new String(Files.readAllBytes(Paths.get(PathUtil.REPLAY_PATH + "2018\\10\\23\\20181023.dr")));

        System.out.println(content);
    }
}