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

In this lab, we use white-box testing on the SUT from assignment 2. We also utilize code-coverage tools to help us understand the strength of our previously written test suite. The code-coverage tools will help us understand coverage metrics such as statement, branch, and condition coverage. In addition, we will also do maunal analysis of data-flow coverage in the system.

# 2 Manual data-flow coverage calculations for X and Y methods
![SENG438A3CalculateColumnTotalDataFlow drawio](https://user-images.githubusercontent.com/65249093/156266967-d6727308-f539-4154-9898-d11d72c7b668.png)
![SENG438A3ContainsDataFlow drawio](https://user-images.githubusercontent.com/65249093/156267037-5b40ae5d-cf3d-4f7a-a5cd-4096c3481798.png)

# 3 A detailed description of the testing strategy for the new unit test

For writing our new unit tests, we analysed the code for each method and determined all the possible paths through it. We would then write one test at a time, and then run it to make sure it covered the desired path. This process was repeated until the method being worked on was fully covered. It would then be repeated for each method until the code was sufficiently covered by the test suite.

# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage

Text…

# 5 A detailed report of the coverage achieved of each class and method (a screen shot from the code cover results in green and red color would suffice)

![Screenshot 2022-02-24 180554](https://user-images.githubusercontent.com/82078868/156259433-4406b7f5-4c42-4c57-95e8-bc1866deb330.png)
![image](https://user-images.githubusercontent.com/82078868/156261503-24a87060-9f1c-4428-b3db-85b7dc9d0e77.png)


# 6 Pros and Cons of coverage tools used and Metrics you report

We used EclEmma as our coverage tool.

| Pros |  Cons   |
| ---- | ---- |
| Easy to Run | Doesn't have condition coverage |
| Easy Installation | Hard to find report details |
|  |  |
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

