package com.css.test;

import com.css.TimePercentilesFromLogFile;

import org.junit.jupiter.api.Test;

class TimePercentilesFromLogFileTest {
    String rootPath = this.getClass().getResource("").getPath().toString();

    @Test
    void timePercentiles() {
        System.out.println(rootPath);
        String[] logFileNames = new String[]{rootPath + "/resources/2018-13-10.log", rootPath + "/resources/2018-12-10.log", rootPath + "/resources/2018-11-10.log"};
        TimePercentilesFromLogFile timePercentilesFromLogFile = new TimePercentilesFromLogFile();
        timePercentilesFromLogFile.timePercentiles(logFileNames);
    }
}