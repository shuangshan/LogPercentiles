package com.css.test;

import com.css.TimePercentilesFromLogFile;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TimePercentilesFromLogFileTest {
    String rootPath = this.getClass().getResource("").getPath().toString();

    TimePercentilesFromLogFile timePercentilesFromLogFile = new TimePercentilesFromLogFile();

    @Test
    void timePercentilesTest() {
        System.out.println(rootPath);
        String[] logFileNames = new String[]{rootPath + "/resources/2018-13-10.log", rootPath + "/resources/2018-12-10.log", rootPath + "/resources/2018-11-10.log"};
        Integer[] pecentages = new Integer[]{90, 95, 100};
        Map<Integer, Integer> result = timePercentilesFromLogFile.timePercentiles(logFileNames, pecentages);
        assertEquals(result.get(90).intValue(), 4630);
        assertEquals(result.get(95).intValue(), 12310);
        assertEquals(result.get(100).intValue(), 31330);
    }

    @Test
    void getTimeCostFromLineTest() {
        String logLine = "10.2.3.4 [2018/13/10:14:02:39] \"GET /api/playeritems?playerId=3\" 200 12360";
        int timeCost = timePercentilesFromLogFile.getTimeCostFromLine(logLine);
        assertEquals(12360, timeCost);
        assertEquals(-1, timePercentilesFromLogFile.getTimeCostFromLine(""));
        assertEquals(-1, timePercentilesFromLogFile.getTimeCostFromLine(null));

    }
}