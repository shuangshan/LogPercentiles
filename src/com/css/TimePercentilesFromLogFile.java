package com.css;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author
 * @create 2019-07-0716:10
 * @email
 * @description Calculate time percentiles from given log file path
 */
public class TimePercentilesFromLogFile {

    public TimePercentilesFromLogFile() {
    }


    public void timePercentiles(String[] logFileNames) {
        String logFileName = new String();

        readTimeCosts(Arrays.asList(logFileNames));
        return;
    }

    private List<Integer> readTimeCosts(List<String> logFileNames) {
        logFileNames.stream().map(Paths::get).flatMap(ThrowingFunction.wrap(Files::lines)).forEach(System.out::println);
        return new ArrayList<>();
    }

}
