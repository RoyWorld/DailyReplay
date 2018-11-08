package com.replay.dragon.rest.content;

import com.replay.dragon.rest.entity.ServerConfigInfo;
import com.replay.dragon.core.util.PathUtil;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by RoyChan on 2018/10/15.
 */
@Component
public class RestWebServerFactoryCustomizer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
    public RestWebServerFactoryCustomizer() {
    }


    public static void init(String... args) {
        String baseDir = args != null && args.length > 0?args[0]:null;
        String rootPath = PathUtil.ROOT_PATH;
        if(baseDir != null) {
            File dir = new File(baseDir);
            if(!dir.exists() || dir.isFile()) {
                dir.mkdir();
            }

            ServerConfigInfo.baseDir = dir.getPath();
        } else {
            ServerConfigInfo.baseDir = rootPath;
        }

        ConfigContent.getInstance().load();
//        HttpDownContent.getInstance().load();
    }

    public void customize(ConfigurableServletWebServerFactory factory) {
        factory.setPort(((ServerConfigInfo)ConfigContent.getInstance().get()).getPort());
    }

}
