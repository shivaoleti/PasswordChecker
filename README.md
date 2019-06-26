
Pre-Requisities to run the project
1. Java 1.8
2. Maven
3. JUnit
4. Eclipse ( To import the project and easy to run)
5. TestNG
6. Add org.apache.commons dependency to your maven for using Jaro–Winkler distance libray

This is a Sample project to check the Change Password with respect to System Password.
System password will be stroed in properties file. Test cases ran againest with password stored in properties file.

Key Highlights
---------------- 
1. Added Dashboard using some open source code
2. Implemeted both TestNG and Junit test cases
3. Added few Test Cases using TestNG dataprovider
4. Demonstrated few test cases and results will be logged into the Dashboard
5. Implemeted basic logger
6. Added Jaro–Winkler distance libray to check password similarity (https://commons.apache.org/proper/commons-text/apidocs/src-html/org/apache/commons/text/similarity/JaroWinklerDistance.html#line.42)


Note: Please look into the attached screen shot DashBoardResults.png

How to import the project
----------------------------
1. clone or download the project
2. File -->Import--> Existing maven projects
3. Browse for the project
4. Select Finish
5. After Successful import -->Right Click on Project
6. Run as Maven clean
7. Right click on Project -->Maven --> Update Project

How to Run Project
--------------------

1. Select testng.xml file 
2. Right Click --> select Run As -->TestNG Suite

How to view the results
------------------------
A simple dash board is developed using open source utils 
1. Open <Location>\PasswordChecker\TestNg_Metrics_Reports\<Run_Date>\<fileName.html>
example:
D:\javaProjects\PasswordChecker\PasswordChecker\TestNg_Metrics_Reports\Results_26_Jun_19_06_02_32\Metrics-2019Jun26-0602.html

