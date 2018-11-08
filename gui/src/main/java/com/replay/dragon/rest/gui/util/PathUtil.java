//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.replay.dragon.rest.gui.util;


import com.replay.dragon.core.util.OsUtil;

import java.io.File;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class PathUtil {
    public static String ROOT_PATH;

    public PathUtil() {
    }

    static {
        URL url = PathUtil.class.getResource("/");
        ROOT_PATH = url.getPath();

        try {
            URLConnection connection = url.openConnection();
            if(connection instanceof JarURLConnection) {
                File userDir = new File(System.getProperty("user.dir"));
                File classPathDir = (new File(System.getProperty("java.class.path"))).getAbsoluteFile().getParentFile();
                ROOT_PATH = userDir.getAbsolutePath().length() > classPathDir.getAbsolutePath().length()?userDir.getAbsolutePath():classPathDir.getAbsolutePath();
            }
        } catch (Exception var4) {
            ;
        }

        if(OsUtil.isWindows() && ROOT_PATH.matches("^/.*$")) {
            ROOT_PATH = ROOT_PATH.substring(1);
        }

        if(ROOT_PATH.matches("^.*[\\\\/]$")) {
            ROOT_PATH = ROOT_PATH.substring(0, ROOT_PATH.length() - 1);
        }

    }
}
