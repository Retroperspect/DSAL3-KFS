# DSAL3-KFS
> by Kristian Flejsborg Sørensen (cph-kf96)

## Graph Assignment
assignment goes as follows.   
```
The figure of a project graph below is from Wikipedia “Critical path method”. (One of the number
is the diagram is not correct – find it).   

Write a program with your own algorithms to find the values of the project graph. The algorithms
need not to be fancy or optimal.   

Make a representation of the tasks with connections and durations.   
Calculate the earliest start and finish for each task.   
Calculate the latest start and finish for each task.   
Find the critical path.   
Calculate the total floats.   

For extra challenge : Calculate the drags.
```

## Code
Code can be found in [this github repository](https://github.com/Retroperspect/DSAL3-KFS)

## Results
first data is a navigation test of the code, note it's not pretty as it doesn't mark and remmeber nodes it's been to previously
```
start node: A, TargetNode: B
start node: B, TargetNode: C
start node: C, TargetNode: D
FOUND IT from E
start node: C, TargetNode: G
FOUND IT from E
start node: A, TargetNode: F
start node: F, TargetNode: G
FOUND IT from E
start node: A, TargetNode: H
FOUND IT from E
```
Calculating the critical path gives the following output
```
A
B
C
D
E
```
if I change the duration of D to 4 the following output comes instead since D gets total floats which redirect the critical path through G
```
A
B
C
G
E
```
Running all calculations and printing out thier respective information gives the following results, note the nodes where initially made with only name/duration/connected nodes. all other values have been calculated with the use of algorithem.
```
Name: A. Duration: 10. Earliest Start: 1. Earliest Finish: 10. Latest Start: 1. Latest Finish: 10. Connected nodes Size: 3. Total Floats: 0
Name: B. Duration: 20. Earliest Start: 11. Earliest Finish: 30. Latest Start: 11. Latest Finish: 30. Connected nodes Size: 1. Total Floats: 0
Name: C. Duration: 5. Earliest Start: 31. Earliest Finish: 35. Latest Start: 31. Latest Finish: 35. Connected nodes Size: 2. Total Floats: 0
Name: D. Duration: 10. Earliest Start: 36. Earliest Finish: 45. Latest Start: 36. Latest Finish: 45. Connected nodes Size: 1. Total Floats: 0
Name: E. Duration: 20. Earliest Start: 46. Earliest Finish: 65. Latest Start: 46. Latest Finish: 65. Connected nodes Size: 0. Total Floats: 0
Name: F. Duration: 15. Earliest Start: 11. Earliest Finish: 25. Latest Start: 26. Latest Finish: 40. Connected nodes Size: 1. Total Floats: 15
Name: G. Duration: 5. Earliest Start: 36. Earliest Finish: 40. Latest Start: 41. Latest Finish: 45. Connected nodes Size: 1. Total Floats: 5
Name: H. Duration: 15. Earliest Start: 11. Earliest Finish: 25. Latest Start: 31. Latest Finish: 45. Connected nodes Size: 1. Total Floats: 20
```

