
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author shuangshan
 * @create 2019-07-0711:08
 * @email 13690578@qq.com
 * @description Log percentiles for log file,
 */
public class Main {
    private static Pattern pattern = Pattern.compile("\\,");

    final private static Integer ARGS_NUMBER = 2;

    public static void main(String[] args) {
        if (args.length < ARGS_NUMBER) {
            System.out.println("USAGE: java -jar LogPercentiles-1.0.0.jar LogFilePath PercentagesToCal \n" +
                    "LogFilePath: /var/log/httpd/2018-13-10.log,/var/log/httpd/2018-12-10.log,/var/log/httpd/2018-11-10.log\n" +
                    "PercentagesToCal: 90,95,99\n\n" +
                    "java -jar LogPercentiles-1.0.0.jar /var/log/httpd/2018-13-10.log,/var/log/httpd/2018-12-10.log,/var/log/httpd/2018-11-10.log 90,95,99");
            return;
        }

        // check args correct
        // 1. file exist
        String[] splitFiles = pattern.split(args[1]);
        for (String fileName : splitFiles) {
            Path path = Paths.get(fileName);
            if (Files.notExists(path)) {
                System.out.println(path + " do not exists");
                break;
            }
        }

        // 2. percentage between 0-100 and all is integer.
        String[] percentages = pattern.split(args[2]);
        for (String pert : percentages) {
            Integer pertInt = Integer.valueOf(pert);
            if (pertInt > 100 || pertInt < 0) {
                System.out.println(pertInt + " do not between 0 and 100");
                return;
            }
        }

        TimePercentilesFromLogFile timePercentilesFromLogFile = new TimePercentilesFromLogFile();
        Map<Integer, Integer> pertMap = timePercentilesFromLogFile.timePercentiles(splitFiles, Arrays.stream(percentages).map(Integer::parseInt).toArray(Integer[]::new));
        for (Map.Entry<Integer, Integer> entry : pertMap.entrySet()) {
            System.out.println(entry.getKey() + "% of requests return a response within " + entry.getValue() + "ms\n");
        }

    }
}
