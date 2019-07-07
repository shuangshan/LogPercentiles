The tools for calculate certain log file time cost percentiles.

### Usage
log format :
10.2.3.4 [2018/13/10:14:02:39] "GET /api/playeritems?playerId=3" 200 1230

### sort algorithm choose
test case use 11 int array for sorting
* bubble sort need 27ms 
* quick sort only need 1ms 
* stream sort need 14ms
-----------------
obviously [quick sort] is a good choice.

### Support version
Develop/test on JDK8.