package com.replay.dragon.rest.entity;

import java.io.Serializable;

/**
 * Created by RoyChan on 2018/10/15.
 */
public class ServerConfigInfo implements Serializable {
    private static final long serialVersionUID = 8851967460594279184L;
    private String filePath;
    public static transient String baseDir;
    private int port;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public static String getBaseDir() {
        return baseDir;
    }

    public static void setBaseDir(String baseDir) {
        ServerConfigInfo.baseDir = baseDir;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
