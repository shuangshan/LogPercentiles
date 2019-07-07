The tools for calculate certain log file time cost percentiles.

### Usage
log format :
10.2.3.4 [2018/13/10:14:02:39] "GET /api/playeritems?playerId=3" 200 1230
### How to build
1. install jdk1.8, git, idea, gradle
2. git clone https://github.com/shuangshan/LogPercentiles.git
3. build application : ./gradlew clean build
4. cd build/lib
5. java -jar LogPercentiles-1.0.0.jar build/resources/test/2018-13-10.log build/resources/test/2018-12-10.log 60,95,98
6. output of application:
>98% of requests return a response within 21226 ms

>60% of requests return a response within 1310 ms

>95% of requests return a response within 12310 ms


### Sort algorithm compare
test case use 11 int array for sorting
* bubble sort need 27 ms 
* quick sort only need 1 ms 
* stream sort need 14 ms
-----------------
obviously ***quick sort*** is a good choice.

### Support version
Develop/test on JDK8.