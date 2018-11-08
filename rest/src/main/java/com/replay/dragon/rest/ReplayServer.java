package com.replay.dragon.rest;

import com.replay.dragon.rest.content.RestWebServerFactoryCustomizer;
import com.replay.dragon.core.util.PathUtil;
import org.apache.commons.cli.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by RoyChan on 2018/10/12.
 */
@SpringBootApplication
public class ReplayServer {

    static {
        System.setProperty("ROOT_PATH", PathUtil.ROOT_PATH);
    }

    public static void start(String baseDir) throws Exception {
//        String[] args = baseDir == null?new String[0]:new String[]{baseDir};
        RestWebServerFactoryCustomizer.init(null);
        SpringApplication.run(ReplayServer.class);
    }

    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("h", "help", false, "See the help.");
        options.addOption("b", "baseDir", false, "The basic path of the org.pdown.rest.test.server operation");
        String tips = "ReplayServer [-b/--baseDir][-h/--help]";
        HelpFormatter formatter = new HelpFormatter();
        DefaultParser parser = new DefaultParser();

        try {
            CommandLine e = parser.parse(options, args);
            if(e.hasOption("h")) {
                formatter.printHelp(tips, options);
                return;
            }

            start(e.getOptionValue("b"));
        } catch (ParseException var6) {
            formatter.printHelp("Unrecognized option", options);
        } catch (Exception var7) {
            var7.printStackTrace();
        }

    }
}
