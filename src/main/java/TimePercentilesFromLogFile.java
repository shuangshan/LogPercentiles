
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author chang shuangshan
 * @create 2019-07-0716:10
 * @email
 * @description Calculate time percentiles from given log file path
 */
public class TimePercentilesFromLogFile {

    //pattern for match log format
    //get 1230 from ---10.2.3.4 [2018/13/10:14:02:39] "GET /api/playeritems?playerId=3" 200 1230---
    private static Pattern pattern = Pattern.compile("\\s+");

    /**
     * predicate to filter the blank row
     */
    final Predicate<String> valueNotNullOrEmpty
            = e -> e != null && !e.isEmpty();

    public TimePercentilesFromLogFile() {
    }


    public Map<Integer, Integer> timePercentiles(String[] logFileNames, Integer[] percentage) {

        Map<Integer, Integer> returnMap = new HashMap<Integer, Integer>();
        // get unsorted time cost list
        List<Integer> resultList = readTimeCosts(Arrays.asList(logFileNames));

        // sort array
        int[] sortedTimeCost = SortAlgorithm.quickSort(resultList.stream().mapToInt(i -> i).toArray());

        //generate the final map result
        for (Integer perc : percentage) {
            // locate the position of array
            Integer index = Math.round(Float.valueOf(resultList.size()) / 100 * Float.valueOf(perc));
            if (index > 1) {
                //-1 avoid ArrayIndexOutOfBoundsException
                returnMap.put(perc, sortedTimeCost[index - 1]);
            } else {
                returnMap.put(perc, -1);
            }
        }
        return returnMap;
    }

    private List<Integer> readTimeCosts(List<String> logFileNames) {
        //stream to get the last field of log file
        return logFileNames.stream()
                .map(Paths::get)
                .flatMap(ThrowingFunction.wrap(Files::lines))
                .filter(valueNotNullOrEmpty)
                .map(x -> getTimeCostFromLine(x))
                .collect(Collectors.toList());
    }

    /**
     * use regex to get the last element (time cost) of log message
     *
     * @Param {@link String} one line log message read from log file
     * @Return {@link int} the time cost of log message
     */
    public int getTimeCostFromLine(String logLine) {
        if (null == logLine || logLine.isEmpty()) {
            return -1;
        }
        String[] splitString = pattern.split(logLine);
        //time cost is the last element of log message
        //10.2.3.4 [2018/13/10:14:02:39] "GET /api/playeritems?playerId=3" 200 1230
        return Integer.valueOf(splitString[splitString.length - 1]).intValue();
    }

}
