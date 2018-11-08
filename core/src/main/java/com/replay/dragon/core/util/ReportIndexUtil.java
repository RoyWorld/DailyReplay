package com.replay.dragon.core.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by RoyChan on 2018/10/29.
 */
public class ReportIndexUtil {

    private static final String indexFile = PathUtil.REPLAY_PATH + "\\rp_index.txt";

    private static List<String> dailyIndex = new ArrayList<>();

    private static void init(){
        try (Stream<String> stream = Files.lines(Paths.get(indexFile))) {
            dailyIndex = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static {
        init();
    }

    public static void writeIndex(String dailyString){
        try {
            dailyString += "\n";
            Files.write(Paths.get(indexFile), dailyString.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getDailyIndex() {
        return dailyIndex;
    }

    /**
     * 过滤
     * 年：2018****
     * 月：201810**
     * @return
     */
    public static void filter(String s){
        final String regex = s.substring(0, s.indexOf("*"));
        try (Stream<String> stream = Files.lines(Paths.get(indexFile))) {
            dailyIndex = stream.filter(line -> line.startsWith(regex))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String regex = "201810**";
//        ReportIndexUtil.filter(regex);
        List list = ReportIndexUtil.getDailyIndex();
        list.stream().forEach(System.out::println);
    }
}
