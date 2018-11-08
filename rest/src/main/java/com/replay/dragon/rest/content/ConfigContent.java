package com.replay.dragon.rest.content;

import com.fasterxml.jackson.core.type.TypeReference;
import com.replay.dragon.rest.entity.ServerConfigInfo;

import java.io.File;

/**
 * Created by RoyChan on 2018/10/15.
 */
public class ConfigContent extends PersistenceContent<ServerConfigInfo, ConfigContent> {
    private static final ConfigContent INSTANCE = new ConfigContent();

    public ConfigContent() {
    }

    public static ConfigContent getInstance() {
        return INSTANCE;
    }

    protected TypeReference type() {
        return new TypeReference<ServerConfigInfo>() {
        };
    }

    protected String savePath() {
        return ServerConfigInfo.baseDir + File.separator + "rest-server.cfg";
    }

    protected ServerConfigInfo defaultValue() {
        ServerConfigInfo serverConfigInfo = new ServerConfigInfo();
        serverConfigInfo.setPort(26339);
//        serverConfigInfo.setTimeout(30);
        return serverConfigInfo;
    }
}
