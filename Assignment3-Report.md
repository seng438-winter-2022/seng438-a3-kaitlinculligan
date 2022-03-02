**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report #3 – Code Coverage, Adequacy Criteria and Test Case Correlation**

| Group \#:      |  8   |
| -------------- | --- |
| Student Names: |  Kaitlin Culligan   |
|                |  Kunal Dhawan   |
|                |  Chloe Bouchard   |
|                |  Jacob Lansang   |

(Note that some labs require individual reports while others require one report
for each group. Please see each lab document for details.)

# 1 Introduction

In this lab, we use white-box testing on the SUT from assignment 2. We also utilize code-coverage tools to help us understand the strength of our previously written test suite. The code-coverage tools will help us understand coverage metrics such as statement, branch, and condition coverage. In addition, we will also do maunal analysis of data-flow coverage in the system. Finally, this lab will allow us to practice creating data flow diagrams.

# 2 Manual data-flow coverage calculations for X and Y methods
The following image illustrates a data flow diagram for the calculateColumnTotal() method:
![SENG438A3CalculateColumnTotalDataFlow drawio](https://user-images.githubusercontent.com/65249093/156267593-b8921df2-3116-4d4e-a159-46acb9aa3297.png)

DU-pair sets for calculateColumnTotal:
du(1, 2, data) = {[1, 2]}

du(1, 7, column) = {[1, 2, 3, 4, 5, 7]}

du(3, 6, total) = {[1, 2, 3, 4, 5, 6], [1, 2, 3, 4, 5, 7, 8, 5, 6]}

du(3, 9, total) = {[1, 2, 3, 4, 5, 7, 9]}

du(4, 5, rowCount) = {[4, 5]}

du(5, 5, r) = {[5]}

du(5, 7, r) = {[5, 7]}

du(7, 7, n) = {[7]}

du(7, 9, n) = {[7, 9]} 

/////////////////////////////////

du-pair calculations:

C-use: Variable data, {2, 4}
    Variable column, {7}
    Variable total, defined at 3, {}
    Variable total, defined at 10, {}
    Variable r, {7}
    Variable rowCount, {}
    Variable n, {10}
    dcu = 5
    
DPU: 
    Variable data, {}
    Variable column, {}
    Variable total, {}
    Variable r, {[5, 6],[5, 7]}
    Variable rowCount, {[5, 6],[5, 7]}
    Variable n, {[8, 9], [8, 10]}
    dpu = 6
    
Pair Coverage per Test:
    calcualteColumnTotalForTwoValues: du(1, 2, data), du(1, 7, column), du(3, 6, total), du(3, 9, total), du(4, 5, rowCount), du(5, 5, r), du(5, 7, r), du(7, 7, n), du(7, 9, n)
    
   calculateNullColumn: du(1, 2, data)
    
DU-Pair Coverage:
    
The following image represents a data flow diagram for the contains() method: 

![SENG438A3ContainsDataFlow drawio](https://user-images.githubusercontent.com/65249093/156267760-9617d59c-4f1c-4d5d-9674-de5695ad5c03.png)

DU-pair sets for contains:
du(1, 2, value) = {[1, 2]}

C-use: 
    Variable value, {2}
    dcu = 1

DPU: 
    Variable data, {}
    dpu = 0
    
 Pair Coverage per Test:
    containsTestLowerBoundary: du(1, 2, value)
    
   containsTestUpperBoundary: du(1, 2, value)
    
   containsTestAboveUpperBoundary: du(1, 2, value)
    
   containsTestBelowLowerBoundary: du(1, 2, value)
    
   containsTestMiddleValue: du(1, 2, value)
    
   containsTestWithDouble: du(1, 2, value)
    
   containsTestBelowLowerBoundaryWithDoubles: du(1, 2, value)
   
   containsTestWithNull: du(1, 2, value)

DU-Pair Coverage:

# 3 A detailed description of the testing strategy for the new unit test

For writing our new unit tests, we analysed the code for each method and determined all the possible paths through it. We would then write one test at a time, and then run it to make sure it covered the desired path. This process was repeated until the method being worked on was fully covered. It would then be repeated for each method until the code was sufficiently covered by the test suite.

# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage

DataUtilitiesTests:

calculateRowTotalElseCoverageTest(): Before this coverage test, we were unable to reach full branch coverage for calculateRowTotal() due to an if-else statement within this method not being covered. To cover this, we called the method by first making a mock object of Values2D with a value of null that would avoid the if(n != null) statement. Therefore, our test would cover this else statement. 

cloneCoverageTestElse(): Before implementing this test, our test did not cover the else statement of clone(double[][] source). Therefore, we made an object where source[i] == null, so that the if(source[i] != null) would not be entered, and the else statement would be covered instead. 

equalsCoverageTestA(): Before implementing this test, we did not cover the statement within if(a == null) in the method equals. Therefore we made a test with double[][] a = null and double[][] b == {{1,2}}. Therefore, the if(a == null) is covered. 

RangeTests:

intersectsConverageTest2(): Before implementing this test, the first if statement in intersects was not covered. Therefore, the first value in the function call of intersects(double b0, double b1) was set to 3 to make sure that b0 == this.lower. Therefore, the statement within if(b0 <= this.lower) is covered.

shiftThreeParamsCoverageTest2(): Before implementing this test, there were no statements covered in the shiftWithNoZeroCrossing method. To at least cover if(val > 0) within the shift method, we called shift(exampleRange, 5, true), where exampleRange = new Range (3,5). Therefore, this test covers the statement if(value > 0.0) within shiftWithNoZeroCrossing, which increases coverage by 1 line. 

# 5 A detailed report of the coverage achieved of each class and method (a screen shot from the code cover results in green and red color would suffice)

![Screenshot 2022-02-24 180554](https://user-images.githubusercontent.com/82078868/156259433-4406b7f5-4c42-4c57-95e8-bc1866deb330.png)
![image](https://user-images.githubusercontent.com/82078868/156261503-24a87060-9f1c-4428-b3db-85b7dc9d0e77.png)


# 6 Pros and Cons of coverage tools used and Metrics you report

We used EclEmma as our coverage tool.

| Pros |  Cons   |
| ---- | ---- |
| Easy to Run | Doesn't have condition coverage |
| Easy Installation | Hard to find report details |
| Has branch and statement coverage |  |
|  |  |

# 7 A comparison on the advantages and disadvantages of requirements-based test generation and coverage-based test generation.

Requirements-based test generation allows for easier testing of scenarios that the system is supposed to be able to handle. It provides testing of the intended uses of the system. As a tradeoff, it does not allow for testing sections of the code which may not be accessed by the program during it's standard functionality. Coverage-based test generation, on the other hand, ensures that as many aspects of the code as possible is covered. As a result, there is no guaruntee that the intended functional requirements of the system will actually function. This is due to coverage-based test generation focusing on the code itself, rather than real world scenarios.

# 8 A discussion on how the team work/effort was divided and managed

In order to complete the work, we all joined together on a call and one team member shared their screen. All together, we then went through the work together. We collectively decided what to write for our tests, and the person sharing their screen was in charge of writing down our suggesions. This method was effective for detecting typos quickly. It was also very effective, since 4 people were tackling a problem at the same time. 

# 9 Any difficulties encountered, challenges overcome, and lessons learned from performing the lab

Installing EclEmma was somewhat difficult to install and run when using Eclipse. However, this setback was easily overcome. Some code statements located in some classes were tough to reach when making test cases because they needed us to construct mock objects to simply reach some parts of the code. 

# 10 Comments/feedback on the lab itself

Text…

# X Notes

DU-pair sets for calculateColumnTotal:
du(1, 2, data) = {[1, 2]}

du(1, 7, column) = {[1, 2, 3, 4, 5, 7]}

du(3, 6, total) = {[1, 2, 3, 4, 5, 6], [1, 2, 3, 4, 5, 7, 8, 5, 6]}

du(3, 9, total) = {[1, 2, 3, 4, 5, 7, 9]}

du(4, 5, rowCount) = {[4, 5]}

du(5, 5, r) = {[5]}

du(5, 7, r) = {[5, 7]}

du(7, 7, n) = {[7]}

du(7, 9, n) = {[7, 9]} 

/////////////////////////////////

du-pair calculations:

C-use: Variable data, {2, 4}
    Variable column, {7}
    Variable total, defined at 3, {}
    Variable total, defined at 10, {}
    Variable r, {7}
    Variable rowCount, {}
    Variable n, {10}
    
    dcu = 5
    
DPU: 
    Variable data, {}
    Variable column, {}
    Variable total, {}
    Variable r, {[5, 6],[5, 7]}
    Variable rowCount, {[5, 6],[5, 7]}
    Variable n, {[8, 9], [8, 10]}
    
    dpu = 6

DU-pair sets for contains:
du(1, 2, value) = {[1, 2]}

