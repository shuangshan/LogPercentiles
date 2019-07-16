The tools for calculate certain log file time cost percentiles.

### Usage
calculate the time cost percentiles from log files with format:  
10.2.3.4 [2018/13/10:14:02:39] "GET /api/playeritems?playerId=3" 200 1230

### Time-complexity and space-complexity
Using stream sort algorithm in JDK8, it use Timsort algorithm.  
Timsort is a hybrid stable sorting algorithm, derived from merge sort and insertion sort, designed to perform well on many kinds of real-world data.  
Average time complexity O(n logn), space complexity O(n)

### How to build
1. install jdk1.8, git, idea, gradle
2. git clone https://github.com/shuangshan/LogPercentiles.git
3. build application : ./gradlew clean build
4. cd build/lib
5. java -jar LogPercentiles-1.0.0.jar build/resources/test/2018-13-10.log,build/resources/test/2018-12-10.log 60,95,98
6. output of application:
>98% of requests return a response within 21226 ms

>60% of requests return a response within 1310 ms

>95% of requests return a response within 12310 ms


### Sort algorithm time cost compare
-------------------------
* 10,000 int number  

algorithm | time cost 
--------- | ------------- 
bucket sort| 184ms 
quick sort | 5ms
Timsort    | 25ms
bubble sort| 261ms

* 100,000 int number

algorithm | time cost 
--------- | ------------- 
bucket sort| 306ms 
quick sort | 22ms
Timsort| 95ms
bubble sort| 22s 432ms

* 1,000,000 int number

algorithm | time cost 
--------- | ------------- 
bucket sort| 1s 67ms 
quick sort | 193ms
Timsort    | 562ms
bubble sort| much longer  


* 10,000,000 int number

algorithm | time cost 
--------- | ------------- 
bucket sort| 6s 321ms 
quick sort | 1s 479ms
Timsort    | 990ms
bubble sort| much longer  

* 100,000,000 int number

algorithm | time cost 
--------- | ------------- 
bucket sort| 59s 276ms 
quick sort | 14s 912ms
Timsort    | 12s 992ms
bubble sort| much longer  


-----------------
from test result ***stream(Timsort) sort*** is a better choice, especially for big array.

### Support version
Develop/test on JDK8.